package com.jscoe.infrastructure.conf.jackson;


import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;
import java.time.Instant;

/**
 * @author honor
 */
@Configuration
public class JacksonConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> {
//            builder.serializerByType(BigInteger.class, LongSerializer.instance);
//            builder.serializerByType(Long.class, LongSerializer.instance);
//            builder.serializerByType(Long.TYPE, LongSerializer.instance);
//            builder.serializerByType(Instant.class, new InstantSerializer());
//            builder.deserializerByType(Instant.class, new InstantDeserializer());
        };
    }

}
