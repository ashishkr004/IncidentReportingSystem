package com.irs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.irs"})
@ComponentScan(basePackages = {"com.irs"})
@EntityScan({"com.irs.entities"})
@EnableJpaRepositories({"com.irs"})
@EnableCaching

public class IncidentReportingSystem {
        public static void main(String[] args) {
            SpringApplication.run(IncidentReportingSystem.class, args);
        }
    }

