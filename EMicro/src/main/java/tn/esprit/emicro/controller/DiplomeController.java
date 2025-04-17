package tn.esprit.emicro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.emicro.entity.Diplome;
import tn.esprit.emicro.service.DiplomeService;

import java.util.List;

@RestController
@RequestMapping("/api/diplomes")
public class DiplomeController {

    @Autowired
    private DiplomeService diplomeService;

    @PostMapping
    public Diplome createDiplome(@RequestBody Diplome diplome) {
        return diplomeService.saveDiplome(diplome);
    }

    @GetMapping("/{id}")
    public Diplome getDiplome(@PathVariable Long id) {
        return diplomeService.getDiplomeById(id);
    }

    @GetMapping
    public List<Diplome> getAllDiplomes() {
        return diplomeService.getAllDiplomes();
    }

    @PutMapping("/{id}")
    public Diplome updateDiplome(@PathVariable Long id, @RequestBody Diplome diplome) {
        return diplomeService.updateDiplome(id, diplome);
    }

    @DeleteMapping("/{id}")
    public void deleteDiplome(@PathVariable Long id) {
        diplomeService.deleteDiplome(id);
    }
}
