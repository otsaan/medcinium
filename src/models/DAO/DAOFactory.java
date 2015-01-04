/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import models.PatientInfo;

/**
 *
 * @author otsaan
 */
public class DAOFactory {
    
    
    public static PatientDAO getPatientDAO(){
        
        return new PatientDAO();
    }
    
    public static ConsultationDAO getConsultationDAO(){
        
        return new ConsultationDAO();
    }
    
     public static PatientInfoDAO getPatientInfoDAO(){
        
        return new PatientInfoDAO();
    }
     
      public static PaymentDAO getPaymentDAO(){
        
        return new PaymentDAO();
    }
    
     public static ReminderDAO getReminderDAO(){
        
        return new ReminderDAO();
    }
     
     public static UserDAO getUserDAO(){
        
        return new UserDAO();
    }
     
     public static DrugDAO getDrugDAO(){
        
        return new DrugDAO();
    }
      
     public static AllergyDAO getAllergyDAO(){
        
        return new AllergyDAO();
    }
    
}
