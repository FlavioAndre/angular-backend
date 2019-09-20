package com.curso.angular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.angular.entity.Municipio;

@Repository
public interface MunicipioRepository  extends JpaRepository<Municipio, Long>{

}
