package com.example.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidatures") // Ajout de "api" pour plus de clarté
public class CandidatureController {

    @Autowired
    private CandidatureService candidatureService;

    // ✅ Affichage de toutes les candidatures
    @GetMapping("/all")
    public List<Candidature> getAllCandidatures() {
        return candidatureService.getAllCandidatures();
    }

    // ✅ Affichage d'une candidature spécifique
    @GetMapping("/view/{id}")
    public Optional<Candidature> getCandidatureById(@PathVariable Long id) {
        return candidatureService.getCandidatureById(id);
    }

    // ✅ Ajout d'une candidature
    @PostMapping("/add")
    public Candidature createCandidature(@RequestBody Candidature candidature) {
        return candidatureService.createCandidature(candidature);
    }

    // ✅ Modification d'une candidature
    @PutMapping("/update/{id}")
    public Candidature updateCandidature(@PathVariable Long id, @RequestBody Candidature candidature) {
        return candidatureService.updateCandidature(id, candidature);
    }

    // ✅ Suppression d'une candidature
    @DeleteMapping("/delete/{id}")
    public void deleteCandidature(@PathVariable Long id) {
        candidatureService.deleteCandidature(id);
    }

    // Tri décroissant par nombre d'années d'expérience
    @GetMapping("/sort-by-experience")
    public List<Candidature> getCandidaturesSortedByExperience() {
        return candidatureService.getCandidaturesSortedByExperienceDesc();
    }

}
