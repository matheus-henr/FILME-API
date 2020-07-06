package br.com.ais.filme.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.ais.filme.enums.Categoria;
import br.com.ais.filme.exception.NotFoundException;
import br.com.ais.filme.model.dto.FilmeDTO;
import br.com.ais.filme.model.dto.FilmePreviewDTO;
import br.com.ais.filme.model.entity.Filme;
import br.com.ais.filme.model.mapper.FilmeMapper;
import br.com.ais.filme.model.mapper.FilmePreviewMapper;
import br.com.ais.filme.repository.FilmeRepository;
import br.com.ais.filme.util.Page;

@RequestScoped
public class FilmeService {

	@Inject
	private FilmeRepository filmeRepository;
	@Inject
	private FilmeMapper filmeMapper;
	@Inject
	private FilmePreviewMapper filmePreviewMapper;
	@Inject
	private AvaliacaoService avaliacaoService;

	public FilmeDTO salvar(FilmeDTO dto) {

		final Filme filme = filmeMapper.toEntity(dto);

		return filmeMapper.toDTO(filmeRepository.salvar(filme));
	}
	
	public Page<FilmePreviewDTO> buscarFilmePorCategoriaPreview(Categoria categoria, int totalElmentos, int pagina) {
		
		final Page<Filme> filmesPage = filmeRepository.obterPorCategoria(categoria, pagina, totalElmentos)
					.orElseThrow(() -> new NotFoundException("Nenhum recurso encontrado"));
		
		List<FilmePreviewDTO> filmes = filmePreviewMapper.toDTO(filmesPage.getConteudo());
		setarAvaliacao(filmes);
		
		return new Page<>(filmes, filmesPage.getTotalElementos(), filmesPage.getPage(), filmesPage.getItensPorPagina());
	} 

	public FilmeDTO buscarFilmePorId(long id) {

		final Filme filme = filmeRepository.obterPorId(Filme.class, id)
				.orElseThrow(() -> new NotFoundException("Nenhum recurso encontrado"));

		FilmeDTO filmeDTO = filmeMapper.toDTO(filme);
		setarAvaliacao(filmeDTO);

		return filmeDTO;
	}

	public FilmeDTO atualizar(long id, FilmeDTO dto) {

		buscarFilmePorId(id);

		final Filme filme = filmeMapper.toEntity(dto);

		return filmeMapper.toDTO(filmeRepository.salvar(filme));
	}

	public void deletar(Long id) {
		Filme filme = filmeRepository.obterPorId(Filme.class, id)
				.orElseThrow(() -> new NotFoundException("Nenhum recurso encontrado"));

		filmeRepository.deletar(filme);
	}

	private void setarAvaliacao(List<FilmePreviewDTO> filmes) {
		 filmes.parallelStream().forEach(filme ->
		 filme.setAvaliacao(avaliacaoService.consultarNota(filme.getId())));

	}

	private void setarAvaliacao(FilmeDTO filme) {
		 filme.setAvaliacao(avaliacaoService.consultarNota(filme.getId()));
	}
}
