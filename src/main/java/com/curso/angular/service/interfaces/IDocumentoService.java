package com.curso.angular.service.interfaces;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.curso.angular.base.exception.ServiceException;
import com.curso.angular.base.service.interfaces.IServiceCrudAbstract;
import com.curso.angular.entity.Documento;

public interface IDocumentoService extends IServiceCrudAbstract<Documento, Long>{
	Documento salvarDocumentoCliente(Integer idCliente, MultipartFile file) throws ServiceException;
	
	List<Documento> findAllByClienteId(Integer idCliente);
}
