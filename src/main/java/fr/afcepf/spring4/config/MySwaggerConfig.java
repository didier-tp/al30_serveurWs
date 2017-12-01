package fr.afcepf.spring4.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(MySwaggerUiConfig.class) // config des resources nécessaires à
									// swagger-ui
public class MySwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				// .apis(RequestHandlerSelectors.basePackage("fr.xyz.dja.rest"))
				.paths(PathSelectors.any())
				// .paths(PathSelectors.ant("/rest/*"))
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("My REST API (serverSpring MVC)", "Api pour Devise", "API TOS", "Terms of service",
				new Contact("AL30", "www.xyz.fr", "toto@worldcompany.com"), "License of API", "API license URL",
				Collections.emptyList());
	}

}
