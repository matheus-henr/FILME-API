package br.com.ais.filme.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.ais.filme.model.dto.AvaliacaoDTO;
import br.com.ais.filme.service.AvaliacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/avaliacao")
@Api(tags = "Avaliação")
public class AvaliacaoController {

	@Inject
	private  AvaliacaoService avaliacaoService;
	
	@POST
	@Path("/id-filme/{idFilme}")
	@ApiOperation(value = "Adicionar uma nova avaliação")
	public Response avaliar(AvaliacaoDTO avaliacaoDTO, @PathParam("idFilme") Long idFilme) {
		avaliacaoService.avaliar(avaliacaoDTO, idFilme);
		
		return Response.status(Response.Status.CREATED).build();
	}
	
	@GET
	@Path("/id-filme/{idFilme}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Consultar avaliação de um filme")
	public Response obterNotaFilme(@PathParam("idFilme") Long idFilme) {
		double avaliacao = avaliacaoService.consultarNota(idFilme);
		
		return Response.ok(avaliacao).build();
	} 
}
