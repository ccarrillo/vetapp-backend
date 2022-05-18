package com.vetapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vetapp.dao.UserDetailsRepository;
import com.vetapp.model.Authority;
import com.vetapp.model.User;

@SpringBootApplication
public class VetappBackendApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public static void main(String[] args) {
        SpringApplication.run(VetappBackendApplication.class, args);
    }

    @PostConstruct
    protected void init() {
        List<Authority> authorityList = new ArrayList<>();

        authorityList.add(createAuthority("SUPERUSUARIO"));
        //authorityList.add(createAuthority("ADMIN"));

        User user = new User();
        user.setUserName("admin@example.com");
        user.setEmail("admin@example.com");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setIs_active(true);
        user.setIs_superuser(true);
        user.setUser_creation(1);
        user.setCreated_at(Calendar.getInstance().getTime());
        user.setAuthorities(authorityList);

        userDetailsRepository.save(user);

    }

    private Authority createAuthority(String roleCode) {
        Authority authority = new Authority();
        authority.setName(roleCode);
        authority.setIs_active(true);
        authority.setUser_creation(1);
        authority.setCreated_at(Calendar.getInstance().getTime());
        return authority;
    }

}
