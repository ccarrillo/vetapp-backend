package com.vetapp.service;

import com.vetapp.dao.RoleRepository;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dao.UserRoleRepository;
import com.vetapp.model.Role;
import com.vetapp.model.UserAuth;
import com.vetapp.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsSService implements UserDetailsService {

    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        UserAuth user = userAuthRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado para: " + username);
        }
        List<UserRole> listTemp = userRoleRepository.findByUserId(user.getId());
        return new User(user.getEmail(), user.getPassword(), getAuthorities(listTemp));
    }

    private Set<SimpleGrantedAuthority> getAuthorities(List<UserRole> userRole) {
        Set<SimpleGrantedAuthority> list = new HashSet<>();
        for (UserRole uRole : userRole) {
            Role obj = roleRepository.findById(uRole.getRoleId()).orElse(null);
            if (obj != null) {
                list.add(new SimpleGrantedAuthority(obj.getName()));
            }
        }
        return list;
    }
}
