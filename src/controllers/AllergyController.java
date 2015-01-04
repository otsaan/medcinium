/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Allergy;
import models.DAO.AllergyDAO;
import models.DAO.DAOFactory;

/**
 *
 * @author otsaan
 */
public class AllergyController implements Observer  {
 
    private void onCreate(Allergy allergy) {
       DAOFactory.getAllergyDAO().create(allergy);
    }
    
    private void onUpdate(Allergy allergy) {
        DAOFactory.getAllergyDAO().update(allergy);  
    }
    
    private void onDelete( Allergy allergy) {
        DAOFactory.getAllergyDAO().delete(allergy);   
    }
    
    
    
    @Override
    public void execute(Object view, Object dataObj, String action) {
        //@todo add condition on view  && (dataObj instanceof Allergy)
        
        Allergy allergy=(Allergy)dataObj;
        
        if(action.equals("create")) {
          this.onCreate(allergy);
        }
        
        if(action.equals("update")) {
          this.onUpdate(allergy);
        }
         
        if(action.equals("delete")) {
          this.onDelete(allergy);
        }
    }
    
    
}
