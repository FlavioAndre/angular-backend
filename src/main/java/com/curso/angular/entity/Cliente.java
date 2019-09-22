package com.curso.angular.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
@Table(name = "cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private Integer codigoTipoCliente;
	private String telefone;

	@NotBlank(message = "O logradouro é obrigatório.")
	@Length(max = 255)
	@Column(name = "rua", length = 255)
	private String rua;
	
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
	
	@NotBlank(message = "A cidade é obrigatório.")
	@Length(max = 255)
	@Column(name = "cidade", length = 255)
	private String cidade;
	
	@NotBlank(message = "o estado é obrigatório.")
	@Length(max = 2)
	@Column(name = "estado", length = 2)
	private String estado;
	
}