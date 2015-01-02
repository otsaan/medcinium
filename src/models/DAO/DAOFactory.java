/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import models.PatientInfo;

/**
 *
 * @author zianwar
 */
public class DAOFactory {
    
    
    public PatientDAO getPatientDAO(){
        
        return new PatientDAO();
    }
    
    public ConsultationDAO getConsultationDAO(){
        
        return new ConsultationDAO();
    }
    
     public PatientInfoDAO getPatientInfoDAO(){
        
        return new PatientInfoDAO();
    }
     
      public PaymentDAO getPaymentDAO(){
        
        return new PaymentDAO();
    }
    
     public ReminderDAO getReminderDAO(){
        
        return new ReminderDAO();
    }
     
     public UserDAO getUserDAO(){
        
        return new UserDAO();
    }
     
     public DrugDAO getDrugDAO(){
        
        return new DrugDAO();
    }
      
     public AllergyDAO getAllergyDAO(){
        
        return new AllergyDAO();
    }
    
}
