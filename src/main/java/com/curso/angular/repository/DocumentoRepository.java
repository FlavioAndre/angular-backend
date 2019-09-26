package com.curso.angular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.curso.angular.dto.DocumentoDTO;
import com.curso.angular.entity.Documento;

@Repository
public interface DocumentoRepository  extends JpaRepository<Documento, Long>{
	@Transactional(readOnly=true)
	List<Documento> findAllByClienteId(@Param("idCliente") Long idCliente);
	
	@Transactional(readOnly=true)
	@Query("select new com.curso.angular.dto.DocumentoDTO(d.id, d.nome, d.contentType, d.cliente.id) from Documento d where d.cliente.id = :idCliente")
	List<DocumentoDTO> buscaDocumentosClienteId(@Param("idCliente") Integer idCliente);
}
