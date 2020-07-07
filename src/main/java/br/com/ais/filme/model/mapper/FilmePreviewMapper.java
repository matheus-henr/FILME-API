package br.com.ais.filme.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import br.com.ais.filme.model.dto.FilmePreviewDTO;
import br.com.ais.filme.model.entity.Filme;

public class FilmePreviewMapper implements IMapper<Filme, FilmePreviewDTO> {

	@Inject
	private ModelMapper mapper;

	@Override
	public Filme toEntity(FilmePreviewDTO dto) {
		Filme filme = new Filme();
		mapper.map(dto, filme);
		return filme;
	}

	@Override
	public FilmePreviewDTO toDTO(Filme entidade) {
		FilmePreviewDTO dto = new FilmePreviewDTO();
		mapper.map(entidade, dto);
		return dto;
	}

	@Override
	public List<Filme> toEntity(List<FilmePreviewDTO> dtos) {
		return dtos.stream().map(filme -> toEntity(filme)).collect(Collectors.toList());
	}

	@Override
	public List<FilmePreviewDTO> toDTO(List<Filme> entidade) {
		return entidade.stream().map(filme -> toDTO(filme)).collect(Collectors.toList());
	}


}
