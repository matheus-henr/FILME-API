package br.com.ais.filme.model.mapper;

import java.util.List;

public interface IMapper<E, D> {

	E toEntity(D dto);
	D toDto(E entidade);
	
	List<E> toEntity(List<D> dto);
	List<D> toDto(List<E> entidade);
}
