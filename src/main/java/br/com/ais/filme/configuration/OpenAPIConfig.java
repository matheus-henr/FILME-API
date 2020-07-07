package br.com.ais.filme.configuration;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.swagger.v3.oas.integration.GenericOpenApiContextBuilder;
import io.swagger.v3.oas.integration.OpenApiConfigurationException;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

public class OpenAPIConfig {

	private Info getInfo() {
		return new Info().title("Filme API").description("Api para consumo dos serviços").version("1.0");
	}

	private SwaggerConfiguration getSwaggerConfig(OpenAPI openApi) {
		return new SwaggerConfiguration().openAPI(openApi).readAllResources(false).prettyPrint(true)
				.resourcePackages(Stream.of("io.swagger.sample.resource").collect(Collectors.toSet()));
	}

	private Server getServer() {
		return new Server().url("http://localhost:8080/filme-api");
	}

	private OpenAPI getOpenApi() {
		return new OpenAPI().addServersItem(getServer()).info(this.getInfo());
	}

	public OpenAPI gerar() {
		try {
			return new GenericOpenApiContextBuilder<>().openApiConfiguration(this.getSwaggerConfig(this.getOpenApi()))
					.buildContext(true).read();
		} catch (OpenApiConfigurationException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
