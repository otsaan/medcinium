/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Vector;

/**
 *
 * @author otsaan
 */
public class Allergy {
    
    
     private int allergyId;
     private String allergyName;
     private Vector<Consultation> consultationListe;

    public void setAllergyId(int allergyId) {
        this.allergyId = allergyId;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }

    public void setConsultationListe(Vector<Consultation> consultationListe) {
        this.consultationListe = consultationListe;
    }

    public int getAllergyId() {
        return allergyId;
    }

    public String getAllergyName() {
        return allergyName;
    }

    public Vector<Consultation> getConsultationListe() {
        return consultationListe;
    }

    @Override
    public String toString() {
        return "Allergy{" + "allergyId=" + allergyId + ", allergyName=" + allergyName + '}';
    }
     
     
    
     
     
     
}
