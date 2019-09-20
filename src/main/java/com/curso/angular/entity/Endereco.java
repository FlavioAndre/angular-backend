package com.curso.angular.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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
@Table(name = "endereco")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final int MAX_CEP = 8;
	public static final int MAX_NUMERO = 10;
	public static final int MAX_COMPLEMENTO = 127;
	public static final int MAX_BAIRRO = 127;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O logradouro é obrigatório.")
	@Length(max = 255)
	@Column(name = "logradouro", length = 255)
	private String logradouro;

	@NotNull(message = "O código do tipo de logradouro é obrigatório.")
	@Column(name = "codigo_tipo_logradouro")
	private Integer codigoTipoLogradouro;
	
	@NotBlank(message = "O número é obrigatório.")
	@Length(max = 10)
	@Column(name = "numero", length = 10)
	private String numero;

	@Length(max = 255)
	@Column(name = "complemento", length = 255)
	private String complemento;
	
	@NotBlank(message = "O bairro é obrigatório.")
	@Length(max = 255)
	@Column(name = "bairro", length = 255)
	private String bairro;
	
	@NotBlank(message = "O cep é obrigatório.")
	@Length(max = 10)
	@Column(name = "cep", length = 10)
	private String cep;
	
	@NotNull(message = "O município é obrigatório.")
	@ManyToOne
	@JoinColumn(name="id_municipio")
	private Municipio municipio;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
}