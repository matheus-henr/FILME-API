package br.com.ais.filme.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import br.com.ais.filme.model.entity.Avaliacao;


public class AvaliacaoRepository extends GenericRepository<Avaliacao>{
	

	public Optional<List<Avaliacao>> obterAvalicaoPorFilme(Long idFilme) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT avaliacao FROM Avaliacao avaliacao")
		  .append(" WHERE  FILME_ID = :pIdFilme ");
		
		TypedQuery<Avaliacao> query = entityManager.createQuery(sb.toString(), Avaliacao.class);
		query.setParameter("pIdFilme", idFilme);		
		return Optional.of(query.getResultList());
	}

}
