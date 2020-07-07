package br.com.ais.filme.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.ais.filme.enums.Categoria;
import br.com.ais.filme.enums.Funcao;
import br.com.ais.filme.enums.Sexo;
import br.com.ais.filme.model.entity.Filme;
import br.com.ais.filme.model.entity.Integrante;
import br.com.ais.filme.repository.FilmeRepository;
import br.com.ais.filme.repository.IntegranteRepository;

@Startup
@Singleton
public class FilmeDBService {

	@Inject
	private FilmeRepository filmeRepository;
	@Inject
	private IntegranteRepository integranteRepository;
	
	@Transactional()
	@PostConstruct
	public void init() {
		
		
		Integrante scarlettJohansson = Integrante.builder()
				.nome("Scarlett Johansson")
				.funcao(Funcao.ATOR)
				.sexo(Sexo.F)
				.build();
		
		Integrante robertDowney  = Integrante.builder()
				.nome("Robert Downey Jr")
				.funcao(Funcao.ATOR)
				.sexo(Sexo.M)
				.build();
		
		
		Integrante chrisHemsworth  = Integrante.builder()
				.nome("Chris Hemsworth")
				.funcao(Funcao.ATOR)
				.sexo(Sexo.M)
				.build();	
		
		Integrante jeffFowler  = Integrante.builder()
				.nome("Jeff Fowler")
				.funcao(Funcao.DIRETOR)
				.sexo(Sexo.M)
				.build();	
		
		Integrante jimCarrey  = Integrante.builder()
				.nome("Jim Carrey")
				.funcao(Funcao.ATOR)
				.sexo(Sexo.M)
				.build();	
		
		
		List<Integrante> integrantes = Arrays.asList(scarlettJohansson, robertDowney, chrisHemsworth, jeffFowler, jimCarrey);
		
		Filme osVingadores = Filme.builder()
					.nome("Marvel's The Avengers: Os Vingadores")
					.sinopse("Loki, o irmão de Thor, ganha acesso ao poder ilimitado do cubo cósmico ao roubá-lo de dentro das instalações da S.H.I.E.L.D. Nick Fury, o diretor desta agência internacional que mantém a paz, logo reúne os únicos super-heróis que serão capazes de defender a Terra de ameaças sem precedentes. Homem de Ferro, Capitão América, Hulk, Thor, Viúva Negra e Gavião Arqueiro formam o time dos sonhos de Fury, mas eles precisam aprender a colocar os egos de lado e agir como um grupo em prol da humanidade")
					.dataLancamento(LocalDate.of(2012, 04, 27))
					.categoriaCodigo(Categoria.FICCAO_CIENTIFICA.getCodigo())
					.legendaDisponivel(new HashSet<String>(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL")))
					.idiomaDisponivel(new HashSet<String>(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL")))
					.integrantes(Arrays.asList(scarlettJohansson, robertDowney, chrisHemsworth))
					.build();
		

		Filme eraUltron = Filme.builder()
					.nome("Vingadores: Era de Ultron")
					.sinopse("Ao tentar proteger o planeta de ameaças, Tony Stark constrói um sistema de inteligência artificial que cuidaria da paz mundial. O projeto acaba dando errado e gera o nascimento do Ultron. Com o destino da Terra em jogo, Capitão América, Homem de Ferro, Thor, Hulk, Viúva Negra e Gavião Arqueiro terão que se unir para mais uma vez salvar a raça humana da extinção")
					.dataLancamento(LocalDate.of(2015, 04, 23))
					.categoriaCodigo(Categoria.FICCAO_CIENTIFICA.getCodigo())
					.legendaDisponivel(new HashSet<String>(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL")))
					.idiomaDisponivel(new HashSet<String>(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL")))
					.integrantes(Arrays.asList(scarlettJohansson, robertDowney, chrisHemsworth))
					.build();
		
		
		Filme guerraInfinita = Filme.builder()
				.nome("Vingadores: Guerra Infinita")
				.sinopse("Homem de Ferro, Thor, Hulk e os Vingadores se unem para combater seu inimigo mais poderoso, o maligno Thanos. Em uma missão para coletar todas as seis pedras infinitas, Thanos planeja usá-las para infligir sua vontade maléfica sobre a realidade.")
				.dataLancamento(LocalDate.of(2018, 04, 26))
				.categoriaCodigo(Categoria.FICCAO_CIENTIFICA.getCodigo())
				.legendaDisponivel(new HashSet<String>(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL")))
				.idiomaDisponivel(new HashSet<String>(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL")))
				.integrantes(Arrays.asList(scarlettJohansson, robertDowney, chrisHemsworth))
				.build();
		
		Filme sonic = Filme.builder()
				.nome("Sonic: O Filme")
				.sinopse("Sonic, o porco-espinho azul mais famoso do mundo, se junta com os seus amigos para derrotar o terrível Doutor Eggman, um cientista louco que planeja dominar o mundo, e o Doutor Robotnik, responsável por aprisionar animais inocentes em robôs")
				.dataLancamento(LocalDate.of(2020, 02, 13))
				.categoriaCodigo(Categoria.ANIMACAO.getCodigo())
				.legendaDisponivel(new HashSet<String>(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL")))
				.idiomaDisponivel(new HashSet<String>(Arrays.asList("PORTUGUÊS", "INGLÊS", "ESPANHOL")))
				.integrantes(Arrays.asList(jeffFowler, jimCarrey))
				.build();
		
	  List<Filme> filmes = Arrays.asList(osVingadores, eraUltron, guerraInfinita, sonic);
	  
	  List<Filme> trilogiaVingadores = Arrays.asList(osVingadores, eraUltron, guerraInfinita);
	  
	  scarlettJohansson.setFilmes(trilogiaVingadores);
	  robertDowney.setFilmes(trilogiaVingadores);
	  chrisHemsworth.setFilmes(trilogiaVingadores);
	  
	  jeffFowler.setFilmes(Arrays.asList(sonic));
	  jimCarrey.setFilmes(Arrays.asList(sonic));
	  
	  
	  filmeRepository.salvar(filmes);
	  integranteRepository.salvar(integrantes);
	
 		
	}
	
	
}
