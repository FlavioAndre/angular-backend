package com.curso.angular.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "estado")
public class Estado implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@NotBlank(message = "O nome é obrigatória.")
	@Length(max = 100)
	@Column(name = "nome", length = 100)
	private String nome;

	@NotBlank(message = "O nome é obrigatória.")
	@Length(max = 2)
	@Column(name = "sigla", length = 2)
	private String sigla;

	@NotNull(message = "O código do IBGE é obrigatório.")
	@Column(name = "codigo_uf_ibge")
	private Integer codigoUfIbge;
}
