package com.esprit.microservice.sujetpfe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SujetPfeRepository extends JpaRepository<SujetPfe, Integer> {


    List<SujetPfe> findByTechnologie(String technologie);
    List<SujetPfe> findByDemandeStatus(DemandeStatus status);
    List<SujetPfe> findByTechnologieAndDemandeStatus(String technologie, DemandeStatus status);

    long countByDemandeStatus(DemandeStatus demandeStatus);

    }




