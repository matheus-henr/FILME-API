package br.com.ais.filme.model.dto;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import br.com.ais.filme.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String sinopse;
	private double avaliacao;
	private int duracao;
	private Set<String> idiomaDisponivel;
	private Set<String> legendaDisponivel;
	private Date dataLancamento;
	private Categoria categoria;

}
