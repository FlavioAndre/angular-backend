package com.curso.angular.service.interfaces;

import java.util.List;

import com.curso.angular.base.service.interfaces.IServiceCrudAbstract;
import com.curso.angular.entity.Municipio;

public interface IMunicipioService extends IServiceCrudAbstract<Municipio, Long>{
	List<Municipio> finAlldByEstadoId(Long idEstado);	
}
