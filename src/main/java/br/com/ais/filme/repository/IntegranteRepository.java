package br.com.ais.filme.repository;

import br.com.ais.filme.model.entity.Integrante;

public class IntegranteRepository extends GenericRepository<Integrante> {
	
	public IntegranteRepository() {
		super(Integrante.class);
	}

}
