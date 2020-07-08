package br.com.ais.filme.controller;

import java.net.URI;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.ais.filme.enums.Categoria;
import br.com.ais.filme.model.dto.FilmeDTO;
import br.com.ais.filme.model.dto.FilmePreviewDTO;
import br.com.ais.filme.service.FilmeService;
import br.com.ais.filme.util.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/filmes")
@RequestScoped
public class FilmeController {

	@Inject
	private FilmeService filmeService;
	
	@Context
	private UriInfo uriInfo;

	@POST
	public Response salvar(FilmeDTO filme) {
		filmeService.salvar(filme);

		URI uri = uriInfo.getAbsolutePath();

		return Response.created(uri).build();
	}

	@PUT()
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") Long id, FilmeDTO filme) {
		filmeService.atualizar(id, filme);

		URI uri = uriInfo.getAbsolutePath();

		return Response.created(uri).build();
	}

	@GET
	@Path("categoria/{categoria}/page/{page}/total/{totalElementos}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Obtém uma lista paginada de filmes por categoria")
	public Response obterFilmesPorCategoria(@PathParam("categoria") Categoria categoria,
			@PathParam("page") Integer page, @PathParam("totalElementos") Integer totalElementos) {
		Page<FilmePreviewDTO> filmes = filmeService.buscarFilmePorCategoriaPreview(categoria, totalElementos, page);

		return Response.ok(filmes).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterFilmePorId(@PathParam("id") Long id) {
		FilmeDTO filme = filmeService.buscarFilmePorId(id);

		return Response.ok(filme).build();
	}

	@DELETE()
	@Path("{id}")
	@ApiOperation(value = "Deletar um filme existente")
	public Response deletarFilme(@PathParam("id") Long id) {
		filmeService.deletar(id);

		return Response.noContent().build();
	}
}
