package com.curso.angular.service.impl;

import org.springframework.stereotype.Service;

import com.curso.angular.base.service.ServiceCrudAbstractImpl;
import com.curso.angular.entity.Estado;
import com.curso.angular.service.interfaces.IEstadoService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class EstadoService extends ServiceCrudAbstractImpl<Estado, Long> implements IEstadoService {

}
