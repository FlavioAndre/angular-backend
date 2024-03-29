package com.curso.angular.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "documento")
public class Documento  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@NotNull(message="O nome do documento é obrigatório.")
	@Column(name = "nome", length = 500)
	private String nome;
	
	@NotNull(message="O contentType do documento é obrigatório.")
	@Column(name = "contentType", length = 400)
	private String contentType;

	@Lob
	private byte[] arquivo;

	@JsonIgnore
	@NotNull(message = "O cliente é obrigatório.")
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	

	}