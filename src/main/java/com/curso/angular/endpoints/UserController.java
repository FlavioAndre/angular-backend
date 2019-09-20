package com.curso.angular.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.angular.base.controller.ControllerCrudAbstractImpl;
import com.curso.angular.endpoints.interfaces.IUserController;
import com.curso.angular.entity.User;
import com.curso.angular.service.interfaces.UserServiceInterface;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@Api(value="curso-angular-backend")
public class UserController extends ControllerCrudAbstractImpl<User, Long> implements IUserController {

	@Autowired
	private UserServiceInterface service;
	
	@GetMapping("/email/{email}")
	@ApiOperation(value = "Retorna dados do usuário pelo e-mail")
	public User findByEmail(@PathVariable String email) {
		return service.findByEmail(email).orElse(null);
	}

}
