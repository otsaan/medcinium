/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.Listeners.PatientListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Patient;
import views.PatientsTable;

/**
 *
 * @author zianwar
 */
public class PatientController implements PatientListener{
    
    private Patient patient;
    private PatientsTable patientsTable;

    @Override
    public void onPatientCreated(Patient patient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onPatientUpdated(Patient patient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onPatientDeleted(Patient patient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
