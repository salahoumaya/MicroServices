package com.esprit.microservice.sujetpfe;

import java.util.List;

public interface ISujetPfe {
    SujetPfe ajouterSujet(SujetPfe sujetPfe);
    List<SujetPfe> getAllSujets();
    SujetPfe getSujetById(Integer id);
    SujetPfe modifierSujet(Integer id, SujetPfe updatedSujet);
    void supprimerSujet(Integer id);
    public double calculerPourcentageSujetsAttribues();
    SujetPfe affecterModerateur(Integer sujetPfeId, Integer moderatorId);
}
