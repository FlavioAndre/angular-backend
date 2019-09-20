package com.curso.angular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curso.angular.entity.Documento;

@Repository
public interface DocumentoRepository  extends JpaRepository<Documento, Long>{
	@Transactional(readOnly=true)
	List<Documento> findAllByClienteId(@Param("idCliente") Long idCliente);
}
