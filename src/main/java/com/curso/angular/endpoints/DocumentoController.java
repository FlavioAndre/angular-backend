package com.curso.angular.endpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.angular.base.controller.ControllerCrudAbstractImpl;
import com.curso.angular.endpoints.interfaces.IDocumentoController;
import com.curso.angular.entity.Documento;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/documentos")
@Api(value="curso-angular-backend")
public class DocumentoController extends ControllerCrudAbstractImpl<Documento, Long> implements IDocumentoController {
	
}
