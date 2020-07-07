package br.com.ais.filme.repository;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import br.com.ais.filme.util.Page;

public class GenericRepository<E> {
	
	
	public GenericRepository() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	protected EntityManager entityManager;

	@Transactional
	public E salvar(E entidade) {
		entityManager.persist(entidade);
		return entidade;
	}
	
	@Transactional
	public List<E> salvar(List<E> entidades) {
		for (E obj : entidades) {
			salvar(obj);
		}
		return entidades;
	}

	public Optional<E> obterPorId(Class<E> classe, long id) {
		Optional<E> obj = Optional.of(entityManager.find(classe, id));
		return obj;
	}

	public Optional<List<E>> obterTodos(Class<E> classe) {
		String query = String.format("select a from %s a", classe.getSimpleName());
		TypedQuery<E> result = entityManager.createQuery(query, classe);

		Optional<List<E>> list = Optional.of(result.getResultList());

		return list;
	}

	public Optional<Page<E>> obterPaginado(Class<E> classe, int pagina, int itensPorPagina) {
		String query = String.format("select a from %s a", classe.getSimpleName());
		TypedQuery<E> result = entityManager.createQuery(query, classe);
		result.setFirstResult(pagina);
		result.setMaxResults(itensPorPagina);

		Optional<Page<E>> page = Optional.of(new Page<E>(result.getResultList(), count(classe), pagina, itensPorPagina));
		return page;
	}
	public Long count(Class<E> classe) {
		String query = String.format("select count(a.id) from %s a", classe.getSimpleName());
		TypedQuery<Long> result = entityManager.createQuery(query, Long.class);

		return result.getSingleResult();

	}

	@Transactional
	public void deletar(E entidade) {
		entityManager.remove(entidade);
	}

}
