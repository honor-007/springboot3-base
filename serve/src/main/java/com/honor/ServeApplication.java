package com.honor;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author honor
 */
@Slf4j
@SpringBootApplication
@EnableCaching
@EnableScheduling
@MapperScan(value = {"com.honor.backend.core.modules.*.dao.mapper"})
public class ServeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServeApplication.class, args);
	}

}
