package com.vetapp;

import java.util.Calendar;

import com.vetapp.config.PropertiesConfig;
import com.vetapp.dao.RoleRepository;
import com.vetapp.dao.UserRoleRepository;
import com.vetapp.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vetapp.dao.UserAuthRepository;
import com.vetapp.model.Role;
import com.vetapp.model.UserAuth;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class VetappBackendApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserAuthRepository userDetailsRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        System.setProperty(PropertiesConfig.SPRING_CONFIG_LOCATION, PropertiesConfig.PATH_DATABASE_CONNECTION);
        SpringApplication.run(VetappBackendApplication.class, args);
    }

    @PostConstruct
    protected void init() {
        createRoles("SUPERUSUARIO");
        createRoles("ADMINISTADOR");
        createRoles("SUPERVISOR");
        createRoles("VENDEDOR");
        createRoles("COMPRADOR");
        createRoles("REPORTEADOR");

        createUserAuth("admin", "admin@example.com", "admin", true);
        createUserAuth("admin2", "admin2@example.com", "admin2", false);

        createUserRole(1L, 1L);
        createUserRole(2L, 1L);
        createUserRole(2L, 2L);

    }

    private void createRoles(String roleCode) {
        Role authority = new Role();
        authority.setName(roleCode);
        authority.setActive(true);
        authority.setUserCreation(0L);
        authority.setCreatedAt(Calendar.getInstance().getTime());
        roleRepository.save(authority);
    }

    private void createUserAuth(String username, String email, String password, Boolean superuser) {
        UserAuth user = new UserAuth();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setActive(true);
        user.setSuperuser(superuser);
        user.setUserCreation(0L);
        user.setCreatedAt(Calendar.getInstance().getTime());
        userDetailsRepository.save(user);
    }

    private void createUserRole(Long rolId, Long userId) {
        UserRole userRole = new UserRole();
        userRole.setRoleId(rolId);
        userRole.setUserId(userId);
        userRole.setActive(true);
        userRole.setUserCreation(0L);
        userRole.setCreatedAt(Calendar.getInstance().getTime());
        userRoleRepository.save(userRole);
    }

}
