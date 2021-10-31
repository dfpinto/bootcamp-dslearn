package com.devsuperior.dslearnbds.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.RoleRepository;
import com.devsuperior.dslearnbds.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{

	private static Logger Logger = LoggerFactory.getLogger(UserDetailsService.class);
	
	@Autowired
	UserRepository repositoryUser;

	@Autowired
	RoleRepository repositoryRole;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repositoryUser.findByEmail(username);
		if(user == null) {
			Logger.error("User not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		
		Logger.info("User found: " + username);
		return user;
	}

}
