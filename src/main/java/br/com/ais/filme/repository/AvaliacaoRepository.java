package br.com.ais.filme.repository;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import br.com.ais.filme.model.entity.Avaliacao;

@RequestScoped
public class AvaliacaoRepository extends GenericRepository<Avaliacao>{

	public Optional<List<Avaliacao>> obterAvalicaoPorFilme(Long idFilme) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT avaliacao FROM Avaliacao avaliacao")
			 .append(" INNER JOIN avaliacao.filme filme ")
			 .append(" avaliacao.id = filme.id")
			 .append(" WHERE filme.id = :pIdFilme");
		
		TypedQuery<Avaliacao> query = entityManager.createQuery(sb.toString(), Avaliacao.class);
		query.setParameter("pIdFilme", idFilme);		
		return Optional.of(query.getResultList());
	}

}
