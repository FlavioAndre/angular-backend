package com.curso.angular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.angular.entity.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long>{

}
