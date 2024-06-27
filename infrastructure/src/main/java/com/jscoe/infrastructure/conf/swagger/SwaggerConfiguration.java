package com.jscoe.infrastructure.conf.swagger;

import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * @author honor
 */
@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi backendApi() {
        return GroupedOpenApi.builder()
                .group("Rest Backend API")
                .pathsToMatch("/api/**")
                .packagesToScan("com.jscoe.backend.rest")
                .addOpenApiCustomizer(authorizationOpenApiCustomiser())
                .build();
    }


    public OpenApiCustomizer authorizationOpenApiCustomiser() {
        return openApi -> openApi.schemaRequirement("AUTHORIZATION", new SecurityScheme().type(SecurityScheme.Type.APIKEY)
                        .in(SecurityScheme.In.HEADER)
                        .name(AUTHORIZATION))
                .addSecurityItem(new SecurityRequirement().addList("AUTHORIZATION"))
                ;
    }

}
