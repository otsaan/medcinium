/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author zianwar
 */
public class Reminder {
    
    int id;
    String description;
    Date rappel;
    Patient patient;
    

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getRappel() {
        return rappel;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRappel(Date rappel) {
        this.rappel = rappel;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    
}
