package com.curso.angular.base.messages;

public enum DefaultMessages {

	ID_NOT_FIND("id_not_found"),

	UNIQUE_EXCEPTION("unique_exception");

	private String keyValue;

	/**
	 * Construtor da Classe
	 *
	 * @param name Nome da Chave
	 */
	private DefaultMessages(final String name) {
		this.keyValue = name;
	}

	@Override
	public String toString() {
		return this.keyValue;
	}
}
