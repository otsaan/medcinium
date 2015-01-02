/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.util.Map;


/**
 *
 * @author zianwar
 */
public class PatientInfo {
    
    int id;
    Map<String,String> info;
    Date dateAdded;
    Consultation consultation;

    
    public int getId() {
        return id;
    }

    public Map<String, String> getInfo() {
        return info;
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

    public void setInfo(Map<String, String> info) {
        this.info = info;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    @Override
    public String toString() {
        return "PatientInfo(" + "id=" + id + ", info=" + info + ", dateAdded=" + dateAdded + ", consultation=" + consultation + ')';
    }
    
    
    
    
}
