package br.com.ais.filme.model.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import br.com.ais.filme.model.dto.AvaliacaoDTO;
import br.com.ais.filme.model.entity.Avaliacao;

public class AvaliacaoMapper implements IMapper<Avaliacao, AvaliacaoDTO> {

	@Override
	public Avaliacao toEntity(AvaliacaoDTO dto) {
		Avaliacao Avaliacao = new Avaliacao();
		try {
			BeanUtils.copyProperties(Avaliacao, dto);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return Avaliacao;
	}

	@Override
	public AvaliacaoDTO toDTO(Avaliacao entidade) {
		AvaliacaoDTO dto = new AvaliacaoDTO();
		try {
			BeanUtils.copyProperties(dto, entidade);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<Avaliacao> toEntity(List<AvaliacaoDTO> dtos) {
		List<Avaliacao> Avaliacaos = new ArrayList<>();
		try {
			BeanUtils.copyProperties(Avaliacaos, dtos);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return Avaliacaos;
	}

	@Override
	public List<AvaliacaoDTO> toDTO(List<Avaliacao> entidade) {
		List<AvaliacaoDTO> dtos = new ArrayList<AvaliacaoDTO>();
		try {
			BeanUtils.copyProperties(dtos, entidade);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return dtos;
	}
}

