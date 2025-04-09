package com.example.microservices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServicesApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(CandidatureRepo candidatureRepo) {
        return args -> {
            // Suppression des données existantes (optionnel)
            candidatureRepo.deleteAll();

            // Insertion de nouvelles données
            candidatureRepo.save(new Candidature( "Martinnn", "Sophie", "sophie.martin@email.com", 3, "Informatique"));
            candidatureRepo.save(new Candidature("Dupont", "Jean", "jean.dupont@email.com", 5, "Ressources Humaines"));
            candidatureRepo.save(new Candidature("Bernard", "Pierre", "pierre.bernard@email.com", 7, "Finance"));

            System.out.println("Données initiales insérées avec succès !");
        };
    }

}
