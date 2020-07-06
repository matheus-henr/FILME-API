package br.com.ais.filme.repository;

import java.util.Optional;

import javax.enterprise.context.Dependent;
import javax.persistence.TypedQuery;

import br.com.ais.filme.enums.Categoria;
import br.com.ais.filme.model.entity.Filme;
import br.com.ais.filme.util.Page;

@Dependent
public class FilmeRepository extends GenericRepository<Filme>{

	public Optional<Page<Filme>> obterPorCategoria(Categoria categoria, int page, int itensPorPagina) {
		String query = String.format("SELECT a FROM filme a WHERE categoria = %s", categoria);
		
		TypedQuery<Filme> result = entityManager.createQuery(query, Filme.class);
		result.setFirstResult(page);
		result.setMaxResults(itensPorPagina);
		
		Optional<Page<Filme>> optionalPage = Optional.of(new Page<Filme>(result.getResultList(), count(Filme.class), page, itensPorPagina));
		
		return optionalPage;
	}
	
	
}
