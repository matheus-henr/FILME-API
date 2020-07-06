package br.com.ais.filme.model.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.beanutils.BeanUtils;

import br.com.ais.filme.model.dto.FilmePreviewDTO;
import br.com.ais.filme.model.entity.Filme;

@ApplicationScoped
public class FilmePreviewMapper implements IMapper<Filme, FilmePreviewDTO> {

	@Override
	public Filme toEntity(FilmePreviewDTO dto) {
		Filme filme = new Filme();
		try {
			BeanUtils.copyProperties(filme, dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return filme;
	}

	@Override
	public FilmePreviewDTO toDTO(Filme entidade) {
		FilmePreviewDTO dto = new FilmePreviewDTO();
		try {
			BeanUtils.copyProperties(dto, entidade);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<Filme> toEntity(List<FilmePreviewDTO> dtos) {
		List<Filme> filmes = new ArrayList<>();
		try {
			BeanUtils.copyProperties(filmes, dtos);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return filmes;
	}

	@Override
	public List<FilmePreviewDTO> toDTO(List<Filme> entidade) {
		List<FilmePreviewDTO> dtos = new ArrayList<FilmePreviewDTO>();
		try {
			BeanUtils.copyProperties(dtos, entidade);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return dtos;
	}

}
