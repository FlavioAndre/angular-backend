package com.curso.angular.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.curso.angular.base.exception.ServiceException;
import com.curso.angular.base.service.ServiceCrudAbstractImpl;
import com.curso.angular.dto.DocumentoDTO;
import com.curso.angular.entity.Cliente;
import com.curso.angular.entity.Documento;
import com.curso.angular.repository.DocumentoRepository;
import com.curso.angular.service.exceptions.ObjectNotFoundException;
import com.curso.angular.service.interfaces.IClienteService;
import com.curso.angular.service.interfaces.IDocumentoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DocumentoService extends ServiceCrudAbstractImpl<Documento, Long> implements IDocumentoService {

	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private DocumentoRepository repository;


	@Override
	public Documento salvarDocumentoCliente(Integer idCliente, MultipartFile file) throws ServiceException {
		Optional<Cliente> clienteOptional = clienteService.get(idCliente);

		if (!clienteOptional.isPresent()) {
			throw new ObjectNotFoundException("Cliente ID: " + idCliente + " não foi localizado!");
		}

		String contentType = file.getContentType();
		String fileNameOriginal = file.getOriginalFilename();

		try {
			Documento documento = new Documento(null, fileNameOriginal, contentType, file.getBytes(),
					clienteOptional.get());
			return this.save(documento);

		} catch (IOException ex) {
			throw new ServiceException("Não foi póssivel salvar o documento em anexo do arquivo " + fileNameOriginal,
					ex);
		} catch (ServiceException e) {
			throw e;
		}
	}

	@Override
	public List<Documento> findAllByClienteId(Integer idCliente) {
		return this.findAllByClienteId(idCliente);
	}
	
	@Override
	public List<DocumentoDTO> buscaDocumentosClienteId(Integer idCliente) {
		return this.repository.buscaDocumentosClienteId(idCliente);
	}
}
