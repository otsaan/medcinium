/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Vector;
import models.DAO.DAOFactory;

/**
 * Model doesn't import anything 
 * @author otsaan
 */
public class Model {
    
    
    // -------------- this data will be shown on AccueilFrame -------------------
    // this vectors will pulled directly from the database by the DAOs
    // so ConsultationDAO will have 2 methods returning these 2 vectors
    private Vector<Consultation> pendingConsultations; // file d'attente
    private Vector<Consultation> finishedConsultations; // dernieres visites
    
    // this vectors will be provided by the appropriate DAO
    private Vector<Reminder> reminders; // today's or 3 days reminders it depends...
    
    
    // -------------- this data will be shown on PatientFrame -------------------
    private Vector<Patient> patients;
    
    
    // -------------- this data will be shown on ConsultationsFrame -------------------
    private Vector<Consultation> allConsultations; // all types of 
    
    
    // --------------------- this data will be shown on PatientProfileFrame (not yet) ---------------------
    // Consultations made by a given Patient to show them on his profile 
    // this consultation should be return by the PatientDAO.getConsultations(id)
    private Vector<Consultation> patientConsultations;
    
    // infromations of a given Patient 
    private Vector<PatientInfo> patientInfos;
    
    // allergies of a given patient
    private Vector<Allergy> patientAllergies;

    
    
    
    public Model() {
        load();
    }
   
    /**
     * Loades all data using the DAOs
     */
    public void load() {
        this.pendingConsultations = DAOFactory.getConsultationDAO().pendingConsultations();
        this.finishedConsultations = DAOFactory.getConsultationDAO().byStaus("finished");
    }

    
    // ------------------ GETTERS ---------------------
    
    public Vector<Consultation> getPendingConsultations() {
        return pendingConsultations;
    }

    public Vector<Consultation> getFinishedConsultations() {
        return finishedConsultations;
    }

    public Vector<Reminder> getReminders() {
        return reminders;
    }

    public Vector<Patient> getPatients() {
        return patients;
    }

    public Vector<Consultation> getAllConsultations() {
        return allConsultations;
    }

    public Vector<Consultation> getPatientConsultations() {
        return patientConsultations;
    }

    public Vector<PatientInfo> getPatientInfos() {
        return patientInfos;
    }

    public Vector<Allergy> getPatientAllergies() {
        return patientAllergies;
    }
    
    
    
    
   
    
}
