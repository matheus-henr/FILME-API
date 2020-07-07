package br.com.ais.filme.producer;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.modelmapper.ModelMapper;

@Named
public class ModelMapeer {

	@Produces
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
