package br.com.ais.filme.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import br.com.ais.filme.model.dto.AvaliacaoDTO;
import br.com.ais.filme.model.entity.Avaliacao;
import br.com.ais.filme.model.mapper.AvaliacaoMapper;
import br.com.ais.filme.repository.AvaliacaoRepository;

//@RunWith(JUnitPlatform.class)	
public class AvaliacaoServiceTest {
	
	@Inject
	private AvaliacaoService avaliacaoService;
	@Mock
	private AvaliacaoRepository avaliacaoRepository;
	
	@BeforeEach
	public void setup(){
		avaliacaoRepository = Mockito.mock(AvaliacaoRepository.class);
		
		avaliacaoService = AvaliacaoService.builder()
				.avaliacaoMapper(new AvaliacaoMapper(new ModelMapper()))
				.avaliacaoRepository(avaliacaoRepository)
				.build();
	}
	
	@Test
	public void teste_intervalo_nota_invalida() {
		Mockito.when(avaliacaoRepository.salvar(new Avaliacao())).thenReturn(new Avaliacao());
		Exception exception = assertThrows(RuntimeException.class, () -> {
			avaliacaoService.avaliar(new AvaliacaoDTO(15), 3L);
		    });
		
		 String expectedMessage = "Nota deve está entre 0 e 10";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void testa_intervalo_nota_valida() {
		Mockito.when(avaliacaoRepository.salvar(new Avaliacao())).thenReturn(new Avaliacao());
		assertTrue(avaliacaoService.avaliar(new AvaliacaoDTO(8), 3L));
	}
	
	@Test
	public void testa_media() {
		
		Avaliacao ava1 = Avaliacao.builder().nota(8).build();
		Avaliacao ava2 = Avaliacao.builder().nota(6).build();
		Avaliacao ava3 = Avaliacao.builder().nota(9).build();
		
		
		Optional<List<Avaliacao>> avaliacoes = Optional.of(Arrays.asList(ava1, ava2, ava3));
		Mockito.when(avaliacaoRepository.obterAvalicaoPorFilme(1L)).thenReturn(avaliacoes);
		
		assertEquals(7.66, avaliacaoService.consultarNota(1L), 0.01);
	}
}
