package com.curso.angular.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.angular.dto.UserDTO;
import com.curso.angular.entity.User;
import com.curso.angular.service.interfaces.UserServiceInterface;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Api(value="curso-angular-backend")
public class UserController {

	@Autowired
	private UserServiceInterface service;
	
	@GetMapping("/{email}")
	@ApiOperation(value = "Retorna dados do usuário pelo e-mail")
	public User findByEmail(@PathVariable String email) {
		return service.findByEmail(email).orElse(null);
	}

	@GetMapping
	@ApiOperation(value = "Retorna todos usuários")
	public List<User> listar() {
		return service.findAll();
	}

	@PostMapping
	@ApiOperation(value = "Salva usuário no banco de dados")
	public ResponseEntity<?> salvar(@RequestBody UserDTO usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(service.save(new User(usuario)));
	}

}
