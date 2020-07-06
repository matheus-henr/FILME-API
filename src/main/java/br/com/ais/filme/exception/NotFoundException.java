package br.com.ais.filme.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	public NotFoundException(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
