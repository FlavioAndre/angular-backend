package com.curso.angular.endpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.angular.base.controller.ControllerCrudAbstractImpl;
import com.curso.angular.endpoints.interfaces.IMunicipioController;
import com.curso.angular.entity.Municipio;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/municipios")
@Api(value="curso-angular-backend")
public class MunicipioController extends ControllerCrudAbstractImpl<Municipio, Long> implements IMunicipioController {
	
}
