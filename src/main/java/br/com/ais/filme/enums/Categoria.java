package br.com.ais.filme.enums;

import lombok.Getter;

@Getter
public enum Categoria {

	ACAO(0), ANIMACAO(1), AVENTURA(2), COMEDIA(3), DOCUMENTARIO(4), FICCAO_CIENTIFICA(5);
	
	private int codigo;

	Categoria(int codigo) {
		this.codigo = codigo;
	}
	
  public static Categoria	obterCategoriaPorCodigo(int cod) {
	  for(Categoria x: Categoria.values()) {
		  if(x.getCodigo() == cod) return x;
	  }
	 return null;
  }
}
