package com.spring.SpringBootApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ConfigurationDependency {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.spring.SpringBootApp.controller"))
				.paths(PathSelectors.any()).build();
	}
	/*
	 * @Bean // (name = "org.dozer.Mapper") public DozerBeanMapper mapper() { return
	 * new DozerBeanMapper(); }
	 */

}