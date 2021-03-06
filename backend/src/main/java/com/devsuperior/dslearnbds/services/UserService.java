package com.devsuperior.dslearnbds.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.dto.UserDTO;
import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.RoleRepository;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import com.devsuperior.dslearnbds.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService{

	private static Logger Logger = LoggerFactory.getLogger(UserDetailsService.class);
	
	@Autowired
	private UserRepository repositoryUser;

	@Autowired
	private RoleRepository repositoryRole;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		authService.validateSelfOrAdmin(id);
		Optional<User> entity = repositoryUser.findById(id);
		return (new UserDTO(entity.orElseThrow(() -> new ResourceNotFoundException("Entity not found"))));
	}

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
