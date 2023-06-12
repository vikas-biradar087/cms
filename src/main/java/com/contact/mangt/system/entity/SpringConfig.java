package com.contact.mangt.system.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SpringConfig {
	
	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .paths(PathSelectors.any())
	                .apis(RequestHandlerSelectors.basePackage("com.contact.mangt.system"))
	                .build()
	                .apiInfo(apiInfo());
	        }
	 
	 private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("Contact Management API")
	                .description("API for managing contacts in the Contact Management System")
	                .version("1.0.0")
	                .build();
	    }
}
