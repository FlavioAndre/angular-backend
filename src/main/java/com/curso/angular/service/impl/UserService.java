package com.curso.angular.service.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.curso.angular.base.exception.ServiceException;
import com.curso.angular.base.service.ServiceCrudAbstractImpl;
import com.curso.angular.dto.UserDetailsDTO;
import com.curso.angular.entity.User;
import com.curso.angular.repository.UserRepository;
import com.curso.angular.service.exceptions.AuthorizationException;
import com.curso.angular.service.interfaces.UserServiceInterface;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class UserService extends ServiceCrudAbstractImpl<User, Long> implements UserServiceInterface, UserDetailsService {

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
	public void delete(@NotNull Long pk) throws ServiceException {
		if(pk.equals(1L)) {
			throw new AuthorizationException("Não é permitido excluir o ID número 1");
		}
		super.delete(pk);
	}

	
}
