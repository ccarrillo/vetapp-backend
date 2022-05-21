package com.vetapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vetapp.dao.UserAuthRepository;
import com.vetapp.model.Role;
import com.vetapp.model.UserAuth;

@SpringBootApplication
public class VetappBackendApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserAuthRepository userDetailsRepository;

    public static void main(String[] args) {
        SpringApplication.run(VetappBackendApplication.class, args);
    }

    @PostConstruct
    protected void init() {
        List<Role> roleList = new ArrayList<>();

        roleList.add(createRoles("SUPERUSUARIO"));
        //roleList.add(createAuthority("ADMIN"));

        UserAuth user = new UserAuth();
        user.setUsername("admin@example.com");
        user.setEmail("admin@example.com");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setActive(true);
        user.setSuperuser(true);
        user.setUserCreation(1);
        user.setCreatedAt(Calendar.getInstance().getTime());
        //user.setAuthorities(authorityList);

        userDetailsRepository.save(user);

    }

    private Role createRoles(String roleCode) {
        Role authority = new Role();
        authority.setName(roleCode);
        authority.setActive(true);
        authority.setUserCreation(1);
        authority.setCreatedAt(Calendar.getInstance().getTime());
        return authority;
    }

}
