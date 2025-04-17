package com.esprit.microservice.sujetpfe;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SujetPfeService  implements ISujetPfe{
    @Autowired
    private SujetPfeRepository sujetPfeRepository;

    @Override
    public SujetPfe ajouterSujet(SujetPfe sujetPfe) {
        return sujetPfeRepository.save(sujetPfe);
    }

    @Override
    public List<SujetPfe> getAllSujets() {
        return sujetPfeRepository.findAll();
    }

    @Override
    public SujetPfe getSujetById(Integer id) {
        return sujetPfeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sujet non trouvé"));
    }

    @Override
    public SujetPfe modifierSujet(Integer id, SujetPfe updatedSujet) {
        SujetPfe s = sujetPfeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sujet non trouvé"));
        updatedSujet.setId(s.getId()); // Ici, tu es sûr que s n'est pas null
        return sujetPfeRepository.save(updatedSujet);
    }

    @Override
    public void supprimerSujet(Integer id) {
        if (sujetPfeRepository.existsById(id)) {
            sujetPfeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Sujet non trouvé");
        }
    }

    @Override
    public double calculerPourcentageSujetsAttribues() {
        return 0;
    }

    @Override
    public SujetPfe affecterModerateur(Integer sujetPfeId, Integer moderatorId) {
        SujetPfe sujetPfe = sujetPfeRepository.findById(sujetPfeId).orElse(null);
        if (sujetPfe != null) {
            sujetPfe.setModeratorId(moderatorId); // Attribuer le modérateur
            return sujetPfeRepository.save(sujetPfe);
        }
        return null; // Sujet non trouvé
    }

    public List<SujetPfe> searchSujets(String technologie, DemandeStatus status) {
        if (technologie != null && status != null) {
            return sujetPfeRepository.findByTechnologieAndDemandeStatus(technologie, status);
        } else if (technologie != null) {
            return sujetPfeRepository.findByTechnologie(technologie);
        } else if (status != null) {
            return sujetPfeRepository.findByDemandeStatus(status);
        } else {
            return sujetPfeRepository.findAll();
        }
    }


    public long compterTotalSujets() {
        return sujetPfeRepository.count(); // Compte tous les sujets
    }

    public long compterSujetsAttribues() {
        return sujetPfeRepository.countByDemandeStatus(DemandeStatus.ACCEPTED);
    }

    public long compterSujetsEnAttente() {
        return sujetPfeRepository.countByDemandeStatus(DemandeStatus.PENDING); // Compte les sujets PENDING
    }
    public Map<String, Long> obtenirStatistiques() {
        Map<String, Long> statistiques = new HashMap<>();
        statistiques.put("totalSujets", compterTotalSujets());
        statistiques.put("sujetsAttribues", compterSujetsAttribues());
        statistiques.put("sujetsEnAttente", compterSujetsEnAttente());
        return statistiques;
    }

}


