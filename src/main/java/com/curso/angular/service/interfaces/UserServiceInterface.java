package com.curso.angular.service.interfaces;

import java.util.Optional;

import com.curso.angular.base.service.interfaces.IServiceCrudAbstract;
import com.curso.angular.entity.User;

public interface UserServiceInterface extends IServiceCrudAbstract<User, Long>{
	Optional<User> findByEmail(String email);
}
