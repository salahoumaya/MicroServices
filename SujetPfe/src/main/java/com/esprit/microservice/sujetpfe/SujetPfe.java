package com.esprit.microservice.sujetpfe;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SujetPfe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titre;
    private String description;
    private String technologie;
    private String image;
    private String rapport;

    @Enumerated(EnumType.STRING)
    private DemandeStatus demandeStatus;

    private Integer moderatorId; // ID du modérateur

    private Integer userAttribueId; // ID de l'utilisateur attribué

    @ElementCollection
    private List<Integer> demandeurIds; // Liste des IDs des demandeurs


}
