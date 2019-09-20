package com.curso.angular.endpoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.angular.base.controller.ControllerCrudAbstractImpl;
import com.curso.angular.endpoints.interfaces.IEnderecoController;
import com.curso.angular.entity.Endereco;
import com.curso.angular.entity.enums.TipoLogradouro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/enderecos")
@Api(value="curso-angular-backend")
public class EnderecoController extends ControllerCrudAbstractImpl<Endereco, Long> implements IEnderecoController {

	@GetMapping(path = "/logradouro")
	@ApiOperation(value = "Retorna lista de logradouros")
	public ResponseEntity<?> logradouros() {
		return ResponseEntity.ok().body(TipoLogradouro.values());
	}

}
