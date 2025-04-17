package tn.esprit.emicro.service;

import tn.esprit.emicro.entity.Diplome;

import java.util.List;

public interface DiplomeImpService {
    Diplome saveDiplome(Diplome diplome);
    Diplome getDiplomeById(Long id);
    List<Diplome> getAllDiplomes();
    Diplome updateDiplome(Long id, Diplome updatedDiplome);
    void deleteDiplome(Long id);
}
