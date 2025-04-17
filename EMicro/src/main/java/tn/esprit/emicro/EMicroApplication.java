package tn.esprit.emicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EMicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(EMicroApplication.class, args);
    }

}
