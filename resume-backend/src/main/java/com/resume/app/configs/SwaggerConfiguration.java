package com.resume.app.configs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket resumeApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("resumeGroup")
				.apiInfo(apiInfo())
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.resume.app.controllers"))
				.paths(PathSelectors.regex("/api.*"))
				.build();
	}

	@Bean
	public Docket securityApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("securityGroup")
				.apiInfo(apiInfo())
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.resume.app.security.controllers"))
				.paths(PathSelectors.regex("/api/auth.*"))
				.build();
	}
	
	private ApiKey apiKey() {
		return new ApiKey("JWT", "Bearer", "header");
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("RESUME - REST API", "REST API for manage cv.", "1.0", "Terms of service",
				new Contact("1000codes", "https://github.com/1000codes", "1000codes@gmail.com"), "License of API",
				"API license URL", Collections.emptyList());
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}
}
