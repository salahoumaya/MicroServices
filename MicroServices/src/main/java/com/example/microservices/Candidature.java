package com.example.microservices;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
    public class Candidature {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long CandidatId;
        private String nom;
        private String prenom;
        private String email;
        private long nbrExp;
        private String specialite;

        public Candidature(String nom, String prenom, String email, long nbrExp, String specialite) {

            this.nom = nom;
            this.prenom = prenom;
            this.email = email;
            this.nbrExp = nbrExp;
            this.specialite = specialite;
        }

        public Candidature() {

        }

        public long getCandidatId() {
            return CandidatId;
        }

        public void setCandidatId(long candidatId) {
            CandidatId = candidatId;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public long getNbrExp() {
            return nbrExp;
        }

        public void setNbrExp(long nbr_exp) {
            this.nbrExp = nbr_exp;
        }

        public String getSpecialite() {
            return specialite;
        }

        public void setSpecialite(String specialite) {
            this.specialite = specialite;
        }
}
