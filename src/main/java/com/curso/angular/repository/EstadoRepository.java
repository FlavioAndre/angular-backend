package com.curso.angular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.angular.entity.Estado;

@Repository
public interface EstadoRepository  extends JpaRepository<Estado, Long>{

}
