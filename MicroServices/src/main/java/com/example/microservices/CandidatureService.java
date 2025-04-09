package com.example.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatureService {
    @Autowired
    private CandidatureRepo candidatureRepository;

    public List<Candidature> getAllCandidatures() {
        return candidatureRepository.findAll();
    }

    public Optional<Candidature> getCandidatureById(Long id) {
        return candidatureRepository.findById(id);
    }

    public Candidature createCandidature(Candidature candidature) {
        return candidatureRepository.save(candidature);
    }

    public Candidature updateCandidature(Long id, Candidature candidatureDetails) {
        Candidature candidature = candidatureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidature non trouvée"));

        candidature.setNom(candidatureDetails.getNom());
        candidature.setPrenom(candidatureDetails.getPrenom());
        candidature.setEmail(candidatureDetails.getEmail());
        candidature.setNbrExp(candidatureDetails.getNbrExp());
        candidature.setSpecialite(candidatureDetails.getSpecialite());

        return candidatureRepository.save(candidature);
    }

    public void deleteCandidature(Long id) {
        candidatureRepository.deleteById(id);
    }


    // Nouvelle méthode pour trier les candidatures par expérience (décroissante)
    public List<Candidature> getCandidaturesSortedByExperienceDesc() {
        return candidatureRepository.findAllByOrderByNbrExpDesc();
    }


}
