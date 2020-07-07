package br.com.ais.filme.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import br.com.ais.filme.model.dto.FilmeDTO;
import br.com.ais.filme.model.entity.Filme;

public class FilmeMapper implements IMapper<Filme, FilmeDTO> {

	@Inject
	private ModelMapper mapper;

	
	@Override
	public Filme toEntity(FilmeDTO dto) {
		Filme filme = new Filme();
		mapper.map(dto, filme);
		return filme;
	}

	@Override
	public FilmeDTO toDTO(Filme entidade) {
		FilmeDTO dto = new FilmeDTO();
		mapper.map(entidade, dto);
		return dto;
	}

	@Override
	public List<Filme> toEntity(List<FilmeDTO> dtos) {
		return dtos.stream().map(filme -> toEntity(filme)).collect(Collectors.toList());

	}

	@Override
	public List<FilmeDTO> toDTO(List<Filme> entidade) {
		return entidade.stream().map(filme -> toDTO(filme)).collect(Collectors.toList());
	}
}
