package com.esprit.microservice.sujetpfe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SujetPfeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SujetPfeApplication.class, args);
    }

}
