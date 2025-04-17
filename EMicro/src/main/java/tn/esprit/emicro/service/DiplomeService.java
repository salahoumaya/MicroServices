package tn.esprit.emicro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.emicro.entity.Diplome;
import tn.esprit.emicro.repository.DiplomeRepository;

import java.util.List;

@Service
public class DiplomeService implements DiplomeImpService {

    @Autowired
    private DiplomeRepository diplomeRepository;

    @Override
    public Diplome saveDiplome(Diplome diplome) {
        return diplomeRepository.save(diplome);
    }

    @Override
    public Diplome getDiplomeById(Long id) {
        return diplomeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Diplome> getAllDiplomes() {
        return diplomeRepository.findAll();
    }

    @Override
    public Diplome updateDiplome(Long id, Diplome updatedDiplome) {
        Diplome existing = getDiplomeById(id);
        if (existing != null) {
            existing.setPath(updatedDiplome.getPath());
            existing.setDateObtention(updatedDiplome.getDateObtention());
            existing.setFormation(updatedDiplome.getFormation());
            return diplomeRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteDiplome(Long id) {
        diplomeRepository.deleteById(id);
    }
}
