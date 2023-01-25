package com.vetapp;

import java.util.Calendar;
import java.util.Date;

import com.vetapp.config.PropertiesConfig;
import com.vetapp.dao.*;
import com.vetapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    @Autowired
    private ParVetDAO parVetDAO;

    @Autowired
    private ParVetValueDAO parVetValueDAO;
    public static void main(String[] args) {
        System.setProperty(PropertiesConfig.SPRING_CONFIG_LOCATION, PropertiesConfig.PATH_DATABASE_CONNECTION);
        SpringApplication.run(VetappBackendApplication.class, args);
    }

    @PostConstruct
    protected void init() {
       /* createRoles("SUPERUSUARIO");
        createRoles("ADMINISTADOR");
        createRoles("SUPERVISOR");
        createRoles("VENDEDOR");
        createRoles("COMPRADOR");
        createRoles("REPORTEADOR");

        createUserAuth("admin", "admin@example.com", "admin", true);
        createUserAuth("admin2", "admin2@example.com", "admin2", false);

        createUserRole(1L, 1L);
        createUserRole(2L, 1L);
        createUserRole(2L, 2L);*/

        //Carga de parametros de veterinaria
        /*createParVet("CATEGORIA_FORMULA");
        createParVetValue("Ruta 1", 1L);
        createParVetValue("Ruta 2", 1L);
        createParVetValue("Ruta 3", 1L);
        createParVetValue("Ruta 4", 1L);
        createParVetValue("Pre Parto", 1L);
        createParVetValue("Secas", 1L);
        createParVetValue("Machos", 1L);
        createParVetValue("Cuna Destetado", 1L);
        createParVetValue("3 A 6 (M) SJ", 1L);
        createParVetValue("6 A 12 CH", 1L);
        createParVetValue("12 a Mas CH", 1L);
        createParVetValue("12 A Mas SJ", 1L);*/

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

    /*private void createParVet(String name) {
        ParVet parVet = new ParVet();
        parVet.setName(name);
        parVet.setActive(true);
        parVet.setUserCreation(0L);
        parVet.setCreatedAt(Calendar.getInstance().getTime());
        parVetDAO.insertar(parVet);
    }

    private void createParVetValue(String name, Long parVetId) {
        ParVetValue parVetValue = new ParVetValue();
        parVetValue.setName(name);
        parVetValue.setParvetId(parVetId);
        parVetValue.setActive(true);
        parVetValue.setUserCreation(0L);
        parVetValue.setCreatedAt(Calendar.getInstance().getTime());
        parVetValueDAO.insertar(parVetValue);
    }*/
}
