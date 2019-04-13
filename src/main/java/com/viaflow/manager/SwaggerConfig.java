package com.viaflow.manager;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

import com.viaflow.manager.global.Constants;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig { 
	
	public static final String DEFAULT_INCLUDE_PATTERN = "^(?!/api/auth).*$";
	
    @Bean
    public Docket api() { 
    	final List<ResponseMessage> globalResponses = Arrays.asList(
				new ResponseMessageBuilder()
						.code(200)
						.message("OK")
						.build(),
				new ResponseMessageBuilder()
						.code(400)
						.message("Bad Request")
						.build(),
				new ResponseMessageBuilder()
						.code(401)
						.message("Unauthorized")
						.build(),
				new ResponseMessageBuilder()
						.code(500)
						.message("Internal Error")
						.build());
    	
        return new Docket(DocumentationType.SWAGGER_2) 
          .pathMapping("/")
          .apiInfo(ApiInfo.DEFAULT)
          .forCodeGeneration(true)
          .genericModelSubstitutes(ResponseEntity.class)
          .ignoredParameterTypes(Pageable.class)
          .ignoredParameterTypes(java.sql.Date.class)
          .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
          .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
          .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
          .useDefaultResponseMessages(false)
			.globalResponseMessage(RequestMethod.GET, globalResponses)
			.globalResponseMessage(RequestMethod.POST, globalResponses)
			.globalResponseMessage(RequestMethod.DELETE, globalResponses)
			.globalResponseMessage(RequestMethod.PUT, globalResponses)
			.securityContexts(Arrays.asList(securityContext()))
            .securitySchemes(Arrays.asList(apiKey()))
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo());                                           
    }
    
    private ApiKey apiKey() {
        return new ApiKey("JWT", Constants.TOKEN_LOCATION, "header");
    }
    
    private SecurityContext securityContext() {
        return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
            .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
            = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(
            new SecurityReference("JWT", authorizationScopes));
    }

	private ApiInfo apiInfo() {
        return new ApiInfo(
          "VFProject Manager", 
          "A beautiful project made by the new team of developers.", 
          "V1.0.0", 
          "", 
          new Contact("ViaFlow Consultoria", "http://www.viaflow.com.br", "contato@viaflow.com.br"), 
          "License of API", "API license URL", Collections.emptyList());
    }
}
