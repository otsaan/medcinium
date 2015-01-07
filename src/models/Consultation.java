/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author otsaan
 */
public class Consultation {
    private int consultationId;
    private String type;
    private String description;
    private String diagnostics;
    private Date consultationDate;
    private String status;
    private int prix;
    private Patient patient;
    private Vector<PatientInfo> patientInfoList;
    private Vector<Drug> drugList;
    private Vector<Allergy> allergyList;

    public int getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(int consultationId) {
        this.consultationId = consultationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(String diagnostics) {
        this.diagnostics = diagnostics;
    }

    public Date getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(Date consultationDate) {
        this.consultationDate = consultationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Vector<PatientInfo> getPatientInfoList() {
        return patientInfoList;
    }

    public void setPatientInfoList(Vector<PatientInfo> patientInfoList) {
        this.patientInfoList = patientInfoList;
    }

    public Vector<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(Vector<Drug> drugList) {
        this.drugList = drugList;
    }

    public Vector<Allergy> getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(Vector<Allergy> allergyList) {
        this.allergyList = allergyList;
    }


    
    @Override
    public String toString() {
        return "Consultation(" + "consultationId=" + consultationId + ", desc=" + description + ", date=" + consultationDate + ", status=" + status + ", prix=" + prix + ", \npatient= (" + patient + "))";
    }
    
}
