package tn.esprit.emicro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.emicro.entity.Formation;
import tn.esprit.emicro.repository.FormationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FormationService implements FormationImpService {

    @Autowired
    private FormationRepository formationRepository;

    @Override
    public Formation saveFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public Formation getFormationById(Long id) {
        return formationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    @Override
    public Formation updateFormation(Long id, Formation updatedFormation) {
        Formation existing = getFormationById(id);
        if (existing != null) {
            existing.setTitre(updatedFormation.getTitre());
            existing.setDescription(updatedFormation.getDescription());
            existing.setNiveau(updatedFormation.getNiveau());
            existing.setFormationT(updatedFormation.getFormationT());
            return formationRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);
    }
}
