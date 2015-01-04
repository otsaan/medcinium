/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.DAO.DAOFactory;
import models.PatientInfo;

/**
 *
 * @author otsaan
 */
public class PatientInfoController implements Observer {
 
    
    private void onCreate(PatientInfo PatientInfo) {
        System.out.println("PatientInfo Created!");
        DAOFactory.getPatientInfoDAO().create(PatientInfo);
    }
    
    
    private void onUpdate(PatientInfo PatientInfo) {
        System.out.println("PatientInfo Updated!");
        DAOFactory.getPatientInfoDAO().update(PatientInfo);
    }
    
    
    private void onDelete(PatientInfo PatientInfo) { 
        System.out.println("PatientInfo Deleted!");
        DAOFactory.getPatientInfoDAO().delete(PatientInfo);
    }
    
    @Override
    public void execute(Object view, Object dataObj, String action) {
        
        if ((view instanceof Object) && (dataObj instanceof PatientInfo)) {
            
            if (action.equalsIgnoreCase("create")) {
                this.onCreate((PatientInfo)dataObj);
            }

            if (action.equalsIgnoreCase("update")) {
                this.onUpdate((PatientInfo)dataObj);
            }

            if (action.equalsIgnoreCase("delete")) {
                this.onDelete((PatientInfo)dataObj);
            }
            
        }
    }
}
