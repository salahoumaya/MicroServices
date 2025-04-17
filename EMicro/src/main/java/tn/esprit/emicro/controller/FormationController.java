package tn.esprit.emicro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.emicro.entity.Formation;
import tn.esprit.emicro.service.FormationService;

import java.util.List;

@RestController
@RequestMapping("/api/formations")
public class FormationController {

    @Autowired
    private FormationService formationService;

    @PostMapping
    public Formation createFormation(@RequestBody Formation formation) {
        return formationService.saveFormation(formation);
    }

    @GetMapping("/{id}")
    public Formation getFormation(@PathVariable Long id) {
        return formationService.getFormationById(id);
    }

    @GetMapping
    public List<Formation> getAllFormations() {
        return formationService.getAllFormations();
    }

    @PutMapping("/{id}")
    public Formation updateFormation(@PathVariable Long id, @RequestBody Formation formation) {
        return formationService.updateFormation(id, formation);
    }

    @DeleteMapping("/{id}")
    public void deleteFormation(@PathVariable Long id) {
        formationService.deleteFormation(id);
    }
}
