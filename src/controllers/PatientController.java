/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import models.DAO.DAOFactory;
import models.Patient;
import views.PatientsTable;

/**
 *
 * @author zianwar
 */
public class PatientController implements Observer {

    
    private void onCreate(Patient Patient) {
        System.out.println("Patient Created!");
        DAOFactory.getPatientDAO().create(Patient);
    }
    
    
    private void onUpdate(Patient Patient) {
        System.out.println("Patient Updated!");
        DAOFactory.getPatientDAO().update(Patient);
    }
    
    
    private void onDelete(Patient Patient) { 
        System.out.println("Patient Deleted!");
        DAOFactory.getPatientDAO().delete(Patient);
    }
    
    @Override
    public void execute(Object view, Object dataObj, String action) {
        
        if ((view instanceof Object) && (dataObj instanceof Patient)) {
            
            if (action.equalsIgnoreCase("create")) {
                this.onCreate((Patient)dataObj);
            }

            if (action.equalsIgnoreCase("update")) {
                this.onUpdate((Patient)dataObj);
            }

            if (action.equalsIgnoreCase("delete")) {
                this.onDelete((Patient)dataObj);
            }
            
        }
    }
   
}
