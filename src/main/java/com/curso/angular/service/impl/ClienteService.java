package com.curso.angular.service.impl;

import org.springframework.stereotype.Service;

import com.curso.angular.base.service.ServiceCrudAbstractImpl;
import com.curso.angular.entity.Cliente;
import com.curso.angular.service.interfaces.IClienteService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class ClienteService extends ServiceCrudAbstractImpl<Cliente, Long> implements IClienteService {

}
