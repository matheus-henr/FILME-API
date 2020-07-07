package br.com.ais.filme.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.ais.filme.enums.Funcao;
import br.com.ais.filme.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="integrante")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Integrante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String sobreNome;
	private String dataNascimento;
	@ManyToMany(mappedBy="integrantes")
	@Fetch(FetchMode.JOIN)
	private List<Filme> filmes;
	private Funcao funcao;
	private Sexo sexo;
	
}
