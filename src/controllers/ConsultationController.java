/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Consultation;
import models.DAO.DAOFactory;

/**
 *
 * @author zianwar
 */
public class ConsultationController implements Observer {

    public void onCreate(Consultation consultation) {
        DAOFactory.getConsultationDAO().create(consultation);
        System.out.println("Consultation Created!");
    }

    public void onUpdate(Consultation consultation) {
        DAOFactory.getConsultationDAO().update(consultation);
        System.out.println("Consultation Updated!");
    }

    public void onDelete(Consultation consultation) {
        DAOFactory.getConsultationDAO().delete(consultation);
        System.out.println("Consultation Deleted!");
    }
    
    @Override
    public void execute(Object view, Object dataObj, String action) {
        if ((dataObj instanceof Consultation)) {
            
            if (action.equalsIgnoreCase("create")) {
                this.onCreate((Consultation)dataObj);
            }

            if (action.equalsIgnoreCase("update")) {
                this.onUpdate((Consultation)dataObj);
            }

            if (action.equalsIgnoreCase("delete")) {
                this.onDelete((Consultation)dataObj);
            }
        }
    }
    
}
