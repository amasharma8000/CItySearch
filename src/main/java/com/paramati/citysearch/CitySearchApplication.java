package com.paramati.citysearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CitySearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(CitySearchApplication.class, args);
    }
}
