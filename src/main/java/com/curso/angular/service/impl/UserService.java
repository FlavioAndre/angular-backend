package com.curso.angular.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.curso.angular.dto.UserDetailsDTO;
import com.curso.angular.entity.User;
import com.curso.angular.repository.UserRepository;
import com.curso.angular.service.interfaces.UserServiceInterface;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class UserService implements UserServiceInterface, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
		return new UserDetailsDTO(user);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	public User save(User user) {
		return userRepository.saveAndFlush(user);
	}

}
