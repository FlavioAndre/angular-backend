package com.curso.angular.endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.curso.angular.entity.User;
import com.curso.angular.service.impl.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

	 private UserService service;
	 
	 @GetMapping("/user/{email}")
     public User findByEmail(@PathVariable String email) {
        return service.findByEmail(email).orElse(null);
    }

}
