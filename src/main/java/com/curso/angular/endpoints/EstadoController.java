package com.curso.angular.endpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.angular.base.controller.ControllerCrudAbstractImpl;
import com.curso.angular.endpoints.interfaces.IEstadoController;
import com.curso.angular.entity.Estado;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/estados")
@Api(value="curso-angular-backend")
public class EstadoController extends ControllerCrudAbstractImpl<Estado, Long> implements IEstadoController {
	
}
