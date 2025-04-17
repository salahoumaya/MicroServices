package com.esprit.microservice.sujetpfe;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sujets")
@AllArgsConstructor
public class SujetPfeRestController {

    @Autowired
    private SujetPfeService sujetPfeService;

    // Ajouter un sujet
    @PostMapping("/ajouter")
    public ResponseEntity<SujetPfe> ajouterSujet(@RequestBody SujetPfe sujetPfe) {
        SujetPfe createdSujet = sujetPfeService.ajouterSujet(sujetPfe);
        return new ResponseEntity<>(createdSujet, HttpStatus.CREATED);
    }

    // Récupérer tous les sujets
    @GetMapping("/all")
    public ResponseEntity<List<SujetPfe>> getAllSujets() {
        List<SujetPfe> sujets = sujetPfeService.getAllSujets();
        return new ResponseEntity<>(sujets, HttpStatus.OK);
    }

    // Récupérer un sujet par son ID
    @GetMapping("/{id}")
    public ResponseEntity<SujetPfe> getSujetById(@PathVariable Integer id) {
        try {
            SujetPfe sujet = sujetPfeService.getSujetById(id);
            return new ResponseEntity<>(sujet, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Modifier un sujet
    @PutMapping("/{id}")
    public ResponseEntity<SujetPfe> modifierSujet(@PathVariable Integer id, @RequestBody SujetPfe updatedSujet) {
        try {
            SujetPfe sujetModifie = sujetPfeService.modifierSujet(id, updatedSujet);
            return new ResponseEntity<>(sujetModifie, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Supprimer un sujet
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerSujet(@PathVariable Integer id) {
        try {
            sujetPfeService.supprimerSujet(id);
            return new ResponseEntity<>("Sujet supprimé avec succès", HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Sujet non trouvé", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public List<SujetPfe> searchSujets(
            @RequestParam(required = false) String technologie,
            @RequestParam(required = false) DemandeStatus status) {
        return sujetPfeService.searchSujets(technologie, status);
    }
    @PutMapping("/{id}/moderateur/{moderatorId}")
    public ResponseEntity<SujetPfe> affecterModerateur(@PathVariable Integer id, @PathVariable Integer moderatorId) {
        SujetPfe sujetModifie = sujetPfeService.affecterModerateur(id, moderatorId);
        if (sujetModifie != null) {
            return new ResponseEntity<>(sujetModifie, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/statistiques")
    public ResponseEntity<Map<String, Long>> obtenirStatistiques() {
        Map<String, Long> statistiques = sujetPfeService.obtenirStatistiques();
        return new ResponseEntity<>(statistiques, HttpStatus.OK);
    }


}
