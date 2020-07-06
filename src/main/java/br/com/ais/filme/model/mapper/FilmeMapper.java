package br.com.ais.filme.model.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import br.com.ais.filme.model.dto.FilmeDTO;
import br.com.ais.filme.model.entity.Filme;

public class FilmeMapper implements IMapper<Filme, FilmeDTO> {

	@Override
	public Filme toEntity(FilmeDTO dto) {
		Filme filme = new Filme();
		try {
			BeanUtils.copyProperties(filme, dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return filme;
	}

	@Override
	public FilmeDTO toDTO(Filme entidade) {
		FilmeDTO dto = new FilmeDTO();
		try {
			BeanUtils.copyProperties(dto, entidade);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<Filme> toEntity(List<FilmeDTO> dtos) {
		List<Filme> filmes = new ArrayList<>();
		try {
			BeanUtils.copyProperties(filmes, dtos);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return filmes;
	}

	@Override
	public List<FilmeDTO> toDTO(List<Filme> entidade) {
		List<FilmeDTO> dtos = new ArrayList<FilmeDTO>();
		try {
			BeanUtils.copyProperties(dtos, entidade);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return dtos;
	}
}
