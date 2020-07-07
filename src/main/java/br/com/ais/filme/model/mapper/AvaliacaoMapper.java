package br.com.ais.filme.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;

import br.com.ais.filme.model.dto.AvaliacaoDTO;
import br.com.ais.filme.model.entity.Avaliacao;

public class AvaliacaoMapper implements IMapper<Avaliacao, AvaliacaoDTO> {

	@Inject
	private ModelMapper mapper;

	@Override
	public Avaliacao toEntity(AvaliacaoDTO dto) {
		Avaliacao Avaliacao = new Avaliacao();
		mapper.map(dto, Avaliacao);
		return Avaliacao;
	}

	@Override
	public AvaliacaoDTO toDTO(Avaliacao entidade) {
		AvaliacaoDTO dto = new AvaliacaoDTO();
		mapper.map(entidade, dto);
		return dto;
	}

	@Override
	public List<Avaliacao> toEntity(List<AvaliacaoDTO> dtos) {
		return dtos.stream().map(avaliacao -> toEntity(avaliacao)).collect(Collectors.toList());
	}

	@Override
	public List<AvaliacaoDTO> toDTO(List<Avaliacao> entidade) {
		return entidade.stream().map(avaliacao -> toDTO(avaliacao)).collect(Collectors.toList());
	}


}
