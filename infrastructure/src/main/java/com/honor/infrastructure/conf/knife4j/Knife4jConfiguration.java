package com.honor.infrastructure.conf.knife4j;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author honor
 */
@Configuration
@Slf4j
public class Knife4jConfiguration {

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
