package com.infra.mgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAutoConfiguration
@SpringBootApplication
@EnableScheduling
public class SpringBootAppp {
	public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootAppp.class, args);
    }

}