package com.curso.angular.endpoints;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.curso.angular.base.controller.ControllerCrudAbstractImpl;
import com.curso.angular.base.exception.ServiceException;
import com.curso.angular.dto.DocumentoDTO;
import com.curso.angular.endpoints.interfaces.IClienteController;
import com.curso.angular.entity.Cliente;
import com.curso.angular.entity.Documento;
import com.curso.angular.entity.enums.TipoCliente;
import com.curso.angular.service.interfaces.IClienteService;
import com.curso.angular.service.interfaces.IDocumentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
@Api(value = "curso-angular-backend")
public class ClienteController extends ControllerCrudAbstractImpl<Cliente, Integer> implements IClienteController {

	@Autowired
	private IDocumentoService documentoService;
	
	@Autowired
	private IClienteService clienteService;

	@GetMapping(path = "/tipo-pessoa")
	@ApiOperation(value = "Retorna lista de tipo pessoa")
	public ResponseEntity<?> tipoPessoas() {
		return ResponseEntity.ok().body(TipoCliente.values());
	}

	@PostMapping("/{idCliente}/documento-upload")
	public ResponseEntity<Documento> uploadFile(@NotNull @PathVariable("idCliente") Integer idCliente,
			@RequestParam("file") MultipartFile file) throws ServiceException {
		return ResponseEntity.ok().body(documentoService.salvarDocumentoCliente(idCliente, file));
	}
	

    @GetMapping("/{id}/documento-download")
    public ResponseEntity<Resource> downloadFile(@NotNull @PathVariable("id") Long id, HttpServletRequest request) {
        Optional<Documento> documento = documentoService.get(id);
        if (!documento.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(documento.get().getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + documento.get().getNome() + "\"")
                .body(new ByteArrayResource(documento.get().getArquivo()));
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<String> buscarCep(@NotNull @PathVariable("cep") String cep) {
    	return ResponseEntity.ok().body(clienteService.buscarCep(cep));
    }
    
    @GetMapping("/{id}/documento-cliente")
    public ResponseEntity<List<DocumentoDTO>> buscaDocumentosCliente(Integer idCliente) {
    	return ResponseEntity.ok().body(this.documentoService.buscaDocumentosClienteId(idCliente));
    }
}
