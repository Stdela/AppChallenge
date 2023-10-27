package com.sdelamer.midas.MidasChallenge.Configuration.Swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration

public class SwaggerApplicationConfiguration {
	
	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("Api Rest para challenge Midas").description(
				"Api rest realizada como challenge de empresa Midas consultores. Tiene como objetivo formar parte de un carrito de compras, donde se trabaja con Autenticación y autorización sobre productos y usuarios.	")
				.version("1.0"));
	}
}
	