package com.vetapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vetapp.dao.UserAuthRepository;
import com.vetapp.model.UserAuth;

import java.util.ArrayList;

@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
	UserAuthRepository userAuthepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserAuth user=userAuthepository.findByUsername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("User Not Found with username "+username);
		}
		return new User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
}
