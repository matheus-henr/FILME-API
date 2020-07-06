package br.com.ais.filme.util;

import java.util.List;

import lombok.Getter;


@Getter
public class Page<E> {
	
	private List<E> conteudo;
	private long totalElementos;
	private long totalPage;
	private int page;
	private int itensPorPagina;
	
	
	public Page(List<E> conteudo ,long totalElementos, int page, int itensPorPagina) {
		this.conteudo = conteudo;
		this.totalElementos = totalElementos;
		this.page = page;
		this.itensPorPagina = itensPorPagina;
		this.totalPage = totalElementos / itensPorPagina;
	}
	
	
}
