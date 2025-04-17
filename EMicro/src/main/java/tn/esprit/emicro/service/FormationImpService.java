package tn.esprit.emicro.service;


import tn.esprit.emicro.entity.Formation;

import java.util.List;

public interface FormationImpService {
    Formation saveFormation(Formation formation);
    Formation getFormationById(Long id);
    List<Formation> getAllFormations();
    Formation updateFormation(Long id, Formation updatedFormation);
    void deleteFormation(Long id);
}
