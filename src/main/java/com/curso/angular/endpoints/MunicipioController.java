package com.curso.angular.endpoints;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.angular.base.controller.ControllerCrudAbstractImpl;
import com.curso.angular.endpoints.interfaces.IMunicipioController;
import com.curso.angular.entity.Municipio;
import com.curso.angular.service.impl.MunicipioService;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/municipios")
@Api(value = "curso-angular-backend")
public class MunicipioController extends ControllerCrudAbstractImpl<Municipio, Long> implements IMunicipioController {

	@Autowired
	MunicipioService service;

	@GetMapping("/muncipio-by-estado/{idEstado}")
	public List<Municipio> findAllByEstadoId(@NotNull @PathVariable("idEstado") Long idEstado) {
		return this.service.finAlldByEstadoId(idEstado);
	}
}
