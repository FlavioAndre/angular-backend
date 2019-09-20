package com.curso.angular.base.service.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.curso.angular.base.exception.ServiceException;


public interface IServiceCrudAbstract<ENTITY extends Serializable, PK> {

	ENTITY save(@Valid @NotNull ENTITY t) throws ServiceException;

	ENTITY update(@Valid ENTITY t) throws ServiceException;

	void delete(@NotNull PK pk) throws ServiceException;
	
	ENTITY detach(@Valid @NotNull ENTITY t) throws ServiceException;
	
	Optional<ENTITY> get(@NotNull PK id);
	
	List<ENTITY> findAll();
}
