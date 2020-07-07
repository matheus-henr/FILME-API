package br.com.ais.filme.service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.ais.filme.exception.NotFoundException;
import br.com.ais.filme.model.dto.AvaliacaoDTO;
import br.com.ais.filme.model.entity.Avaliacao;
import br.com.ais.filme.model.entity.Filme;
import br.com.ais.filme.model.mapper.AvaliacaoMapper;
import br.com.ais.filme.repository.AvaliacaoRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@RequestScoped
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoService {

	private AvaliacaoRepository avaliacaoRepository;
	
	
	@Inject
	public void setAvaliacaoRepository(AvaliacaoRepository avaliacaoRepository) {
		this.avaliacaoRepository = avaliacaoRepository;
	}
	
	@Inject
	private AvaliacaoMapper avaliacaoMapper;
	
	@Transactional
	public boolean avaliar(AvaliacaoDTO avaliacaoDTO, Long idFilme) {
		Avaliacao avaliacao = avaliacaoMapper.toEntity(avaliacaoDTO);
		Filme filme = Filme.builder()
				.id(idFilme)
				.build();
		
		avaliacao.setFilme(filme);
		
		if(avaliacao.getNota() < 0 || avaliacao.getNota() > 10) {
			throw new IllegalArgumentException("Nota deve está entre 0 e 10");
		}
		
		avaliacaoRepository.salvar(avaliacao);
		
		return true;
	}
	
	public double consultarNota(long idFilme) {
		  Optional<List<Avaliacao>> optionalAvaliacao = avaliacaoRepository.obterAvalicaoPorFilme(idFilme);
		  
		  if(!optionalAvaliacao.isPresent() || optionalAvaliacao.get().isEmpty()) {
			  return 0;
		  }
		  
		  List<Avaliacao> avaliacoes = optionalAvaliacao.get();
		 
		  OptionalDouble media = avaliacoes.stream()
		 	.mapToInt(avaliacao -> avaliacao.getNota())
		 	.average();
		 
		 
		 return media.orElseThrow(() -> new NotFoundException("Nenhum recurso encontrado"));
					 
	}

	

}
