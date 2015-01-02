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
public class PatientInfo {
    
    int id;
    String property;
    String value;
    Date dateAdded;
    Consultation consultation;

    
    public int getId() {
        return id;
    }

    public String getProperty() {
        return property;
    }

    public String getValue() {
        return value;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    @Override
    public String toString() {
        return "PatientInfo{" + "id=" + id + ", property=" + property + ", value=" + value + ", dateAdded=" + dateAdded + ", consultation=" + consultation + '}';
    }

    
}
