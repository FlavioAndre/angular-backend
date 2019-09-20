package com.curso.angular.entity.enums;

import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoLogradouro {
	AEROPORTO(1,"Aeroporto"),
	ALAMEDA(2,"Alameda"),
	AREA(3,"Área"),
	AVENIDA(4,"Avenida"),
	CAMPO(5,"Campo"),
	CHACARA(6,"Chácara"),
	COLONIA(7,"Colônia"),
	CONDOMINIO(8,"Condomínio"),
	CONJUNTO(9,"Conjunto"),
	DISTRITO(10,"Distrito"),
	ESPLANADA(11,"Esplanada"),
	ESTACAO(12,"Estação"),
	ESTRADA(13,"Estrada"),
	FAVELA(14,"Favela"),
	FEIRA(15,"Feira"),
	JARDIM(16,"Jardim"),
	LADEIRA(17,"Ladeira"),
	LAGO(18,"Lago"),
	LAGOA(19,"Lagoa"),
	LARGO(20,"Largo"),
	LOTEAMENTO(21,"Loteamento"),
	MORRO(22,"Morro"),
	NUCLEO(23,"Núcleo"),
	PARQUE(24,"Parque"),
	PASSARELA(25,"Passarela"),
	PATIO(26,"Pátio"),
	PRACA(27,"Praça"),
	QUADRA(28,"Quadra"),
	RECANTO(29,"Recanto"),
	RESIDENCIAL(30,"Residencial"),
	RODOVIA(31,"Rodovia"),
	RUA(32,"Rua"),
	SETOR(33,"Setor"),
	SITIO(34,"Sítio"),
	TRAVESSA(35,"Travessa"),
	TRECHO(36,"Trecho"),
	TREVO(37,"Trevo"),
	VALE(38,"Vale"),
	VEREDA(39,"Vereda"),
	VIA(40,"Via"),
	VIADUTO(41,"Viaduto"),
	VIELA(42,"Viela"),
	VILA(43,"Vila");
	
	private int codigo;
	private String descricao;
	
	private TipoLogradouro(int cod, String descricao) {
		this.codigo = cod;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static TipoLogradouro toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoLogradouro x : TipoLogradouro.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + cod);
	}
}

