/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Vector;

/**
 *
 * @author zianwar
 */
public class Allergy {
    
    
     private int allergyId;
     private String allergyName;
     private Vector<Consultation> CunsultationListe;

    public void setAllergyId(int allergyId) {
        this.allergyId = allergyId;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }

    public void setCunsultationListe(Vector<Consultation> CunsultationListe) {
        this.CunsultationListe = CunsultationListe;
    }

    public int getAllergyId() {
        return allergyId;
    }

    public String getAllergyName() {
        return allergyName;
    }

    public Vector<Consultation> getCunsultationListe() {
        return CunsultationListe;
    }

    @Override
    public String toString() {
        return "Allergy{" + "allergyId=" + allergyId + ", allergyName=" + allergyName + '}';
    }
     
     
    
     
     
     
}
