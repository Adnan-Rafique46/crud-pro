package com.crudprojectfordemo;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


@EnableMongoAuditing
@SpringBootApplication(scanBasePackages={"com.bundlen"})
public class CrudProApplication extends SpringBootServletInitializer {

	public static void main(String[] args) { SpringApplication.run(CrudProApplication.class, args);

		@Bean
		public OpenAPI getOpenAPI() {
			return new OpenAPI()
					.components(new Components()
							.addSecuritySchemes("OAuth", new SecurityScheme()
									.type(SecurityScheme.Type.APIKEY)
									.scheme("bearer")
									.bearerFormat("jwt")
									.in(SecurityScheme.In.HEADER)
									.name("Authorization")
							)).addSecurityItem(new SecurityRequirement().addList("OAuth"));
		}

}
