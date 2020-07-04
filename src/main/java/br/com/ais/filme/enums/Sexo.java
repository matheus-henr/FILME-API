package br.com.ais.filme.enums;

import lombok.Getter;

@Getter
public enum Sexo {

	M("Masculino"), F("Feminino");
	
	private String descricao;
	
	private Sexo(String descricao) {
		this.descricao = descricao;
	}
}
