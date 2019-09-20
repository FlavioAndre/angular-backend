package com.curso.angular.service.impl;

import org.springframework.stereotype.Service;

import com.curso.angular.base.service.ServiceCrudAbstractImpl;
import com.curso.angular.entity.Municipio;
import com.curso.angular.service.interfaces.IMunicipioService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class MunicipioService extends ServiceCrudAbstractImpl<Municipio, Long> implements IMunicipioService {

}
