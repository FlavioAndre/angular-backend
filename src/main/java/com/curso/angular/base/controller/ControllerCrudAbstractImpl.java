package com.curso.angular.base.controller;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.curso.angular.base.exception.ServiceException;
import com.curso.angular.base.service.interfaces.IServiceCrudAbstract;


public abstract class ControllerCrudAbstractImpl<ENTITY  extends Serializable, PK> implements IControllerCrudAbstract<ENTITY, PK> {
	private final Class<ENTITY> entityClass;

	@Autowired
	private IServiceCrudAbstract<ENTITY, PK> service;

	@SuppressWarnings("unchecked")
	public ControllerCrudAbstractImpl() {
		super();
		Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
		this.entityClass = (Class<ENTITY>) types[1];
	}

	@Override
	@PostMapping
	public ENTITY save(@Valid @NotNull @RequestBody final ENTITY t) throws ServiceException {
		return this.service.save(t);
	}

	@Override
	@PutMapping
	public ENTITY update(@Valid @NotNull @RequestBody final ENTITY t) throws ServiceException {
		return this.service.update(t);
	}

	@Override
	@DeleteMapping(value = "/{id:.+}")
	public void delete(@NotNull @PathVariable("id") final PK id) throws ServiceException {
		try {
			this.service.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessException("Registro não encontrado, ID:"+ id.toString(), 1);
		}
	}
	

	@Override
	@GetMapping(value = "/{id:.+}")
	public ENTITY get(@NotNull @PathVariable("id") final PK id) throws ServiceException {
		final Optional<ENTITY> t = this.service.get(id);
		if (!t.isPresent()) {
			throw new EmptyResultDataAccessException("Registro não encontrado, ID: "+id.toString(), 1);
		}
		return t.get();
	}
	
	@Override
	@GetMapping
	public List<ENTITY> findAll() throws ServiceException {
		return this.service.findAll();
	}

}
