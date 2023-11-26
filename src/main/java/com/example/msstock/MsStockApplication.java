package com.example.msstock;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class MsStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsStockApplication.class, args);
    }
    @Bean
    ApplicationRunner init(){
        return (args -> {

            System.out.println("starting");
        }) ;
    }

}
