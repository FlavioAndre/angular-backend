package com.curso.angular.service.impl;

import org.springframework.stereotype.Service;

import com.curso.angular.base.service.ServiceCrudAbstractImpl;
import com.curso.angular.entity.Endereco;
import com.curso.angular.service.interfaces.IEnderecoService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class EnderecoService extends ServiceCrudAbstractImpl<Endereco, Long> implements IEnderecoService {

}
