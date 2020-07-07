package br.com.ais.filme;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.ais.filme.configuration.OpenAPIConfig;

@ApplicationPath(value = "api")
public class JAXRSConfiguration extends Application {
	
	public JAXRSConfiguration() {
		new OpenAPIConfig().gerar();
	}
}
	