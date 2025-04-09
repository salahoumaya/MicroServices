package com.example.microservices;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidatureRepo extends JpaRepository<Candidature, Long> {

    List<Candidature> findAllByOrderByNbrExpDesc(); // pour le tri décroissant

}
