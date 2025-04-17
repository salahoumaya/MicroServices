package tn.esprit.feedbacks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeedBacksApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeedBacksApplication.class, args);
    }

/*
    @Autowired
    private FeedBackRepository repository;

    @Bean
    ApplicationRunner init() {
        return (args) -> {
// save

            repository.save(new FeedBack(null, 1L, 2L, 5, "Excellent cours", LocalDateTime.now(), LocalDateTime.now()));
            repository.save(new FeedBack(null, 2L, 3L, 4, "Bon contenu", LocalDateTime.now(), LocalDateTime.now()));
            repository.save(new FeedBack(null, 3L, 2L, 3, "Peut être amélioré", LocalDateTime.now(), LocalDateTime.now()));
            repository.save(new FeedBack(null, 4L, 1L, 5, "Très utile", LocalDateTime.now(), LocalDateTime.now()));


            // fetch
            repository.findAll().forEach(System.out::println);


        };
    }*/
}

