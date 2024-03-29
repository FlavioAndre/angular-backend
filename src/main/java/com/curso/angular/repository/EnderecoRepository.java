package com.curso.angular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.angular.entity.Endereco;

@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco, Long>{

}
