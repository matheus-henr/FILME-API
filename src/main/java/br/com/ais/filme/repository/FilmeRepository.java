package br.com.ais.filme.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import br.com.ais.filme.model.entity.Filme;
import br.com.ais.filme.util.Page;

public class FilmeRepository extends GenericRepository<Filme>{

	public Optional<Page<Filme>> obterPorCategoria(int categoriaCodigo, int page, int itensPorPagina) {
		String query = String.format("SELECT f FROM Filme f WHERE categoriaCodigo = %s", categoriaCodigo);
		
		TypedQuery<Filme> result = entityManager.createQuery(query, Filme.class);
		result.setFirstResult(page);
		result.setMaxResults(itensPorPagina);
		List<Filme> resultList = result.getResultList();
		Optional<Page<Filme>> optionalPage = Optional.of(new Page<Filme>(resultList, count(Filme.class), page, itensPorPagina));
		
		return optionalPage;
	}
	
	
}
