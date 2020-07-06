package br.com.ais.filme.producer;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext()
	private EntityManager em;

	@Produces
	public EntityManager createEntityManager() {
		return em;
	}

	public void close(@Disposes EntityManager em) {
		if (em.isOpen()) {
			em.close();
		}
	}

}
