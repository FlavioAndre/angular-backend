package com.curso.angular.base.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.curso.angular.base.exception.ServiceException;
import com.curso.angular.base.service.interfaces.IServiceCrudAbstract;

public abstract class ServiceCrudAbstractImpl<ENTITY extends Serializable, PK> implements IServiceCrudAbstract<ENTITY, PK> {

	@Autowired
	private JpaRepository<ENTITY, PK> repository;
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public ENTITY save(@Valid @NotNull final ENTITY t) throws ServiceException {
		return this.repository.save(t	);
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public ENTITY update(@Valid ENTITY t) throws ServiceException {
		return this.repository.save(t);
	}
	
	@Override
	public void delete(@NotNull final PK pk) throws ServiceException {
	
			Optional<ENTITY> optional = this.get(pk);
			if(optional.isPresent()) {
				this.repository.delete(optional.get());	
			}
	
	}
	
	@Override
	public Optional<ENTITY> get(@NotNull final PK id) {
		return this.repository.findById(id);
	}
	
	@Override
	public ENTITY detach(ENTITY t) throws ServiceException {
		this.em.detach(t);
		return t;
	}
	
	@Override
	public List<ENTITY> findAll() {
		return this.repository.findAll();
	}
}
