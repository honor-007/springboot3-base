package com.honor.infrastructure.conf.knife4j;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * @author honor
 */
@Configuration
public class Knife4jConfiguration {

//    @Bean
//    public GroupedOpenApi backendApi() {
//        return GroupedOpenApi.builder()
//                .group("Rest Backend API")
//                .pathsToMatch("/api/**")
//                .packagesToScan("com.jscoe.backend.rest")
//                .addOpenApiCustomizer(authorizationOpenApiCustomiser())
//                .build();
//    }

//    @Bean
//    public SpringDocConfigProperties backendGroupConfig() {
//        SpringDocConfigProperties.ApiDocs apiDocs = new SpringDocConfigProperties.ApiDocs();
//        apiDocs.setPath("/v3/api-docs");
//
//        SpringDocConfigProperties.GroupConfig groupConfig = new SpringDocConfigProperties.GroupConfig();
//        groupConfig.setGroup("hahah");
//        List<String> pathsToMatch = new ArrayList<>();
//        pathsToMatch.add("/api/**");
//        groupConfig.setPathsToMatch(pathsToMatch);
//        List<String> packageToScan = new ArrayList<>();
//        packageToScan.add("com.jscoe.backend.rest");
//        groupConfig.setPackagesToScan(packageToScan);
//
//
//        SpringDocConfigProperties springDocConfigProperties = new SpringDocConfigProperties();
//        springDocConfigProperties.setApiDocs(apiDocs);
//        springDocConfigProperties.setGroupConfigs(List.of(groupConfig));
//
//        return springDocConfigProperties;
//    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("成分检测系统API")
                        .version("1.0")
                        .description("成分检测系统API")
                        .termsOfService("http://doc.xiaominfo.com")
                );
    }
}
