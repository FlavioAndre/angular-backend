package com.curso.angular.base.controller;

import java.io.Serializable;
import java.util.List;

import com.curso.angular.base.exception.ServiceException;


public interface IControllerCrudAbstract<ENTITY extends Serializable, PK> {

	ENTITY save(ENTITY t) throws ServiceException;

	ENTITY update(ENTITY t) throws ServiceException;

	void delete(PK id) throws ServiceException;
	
	ENTITY get(PK id) throws ServiceException;
	
	List<ENTITY> findAll() throws ServiceException;
}
