package com.curso.angular.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.angular.base.service.ServiceCrudAbstractImpl;
import com.curso.angular.entity.Municipio;
import com.curso.angular.repository.MunicipioRepository;
import com.curso.angular.service.interfaces.IMunicipioService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class MunicipioService extends ServiceCrudAbstractImpl<Municipio, Long> implements IMunicipioService {
	
	@Autowired MunicipioRepository repository;

	@Override
	public List<Municipio> finAlldByEstadoId(Long idEstado) {
		return this.repository.findAlldByEstadoId(idEstado);
	}

}
