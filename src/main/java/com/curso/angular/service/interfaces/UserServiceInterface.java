package com.curso.angular.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.curso.angular.entity.User;

public interface UserServiceInterface extends ServiceInterface<User>{
	Optional<User> findByEmail(String email);

	List<User> findAll();

	User save(User user);
}
