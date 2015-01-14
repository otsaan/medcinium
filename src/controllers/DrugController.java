/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.dao.DAOFactory;
import models.Drug;

/**
 *
 * @author otsaan
 */
public class DrugController implements Observer {
   
    
    private void onCreate(Drug drug){
       DAOFactory.getDrugDAO().create(drug);
    }
    
    private void onUpdate(Drug drug) {
       DAOFactory.getDrugDAO().update(drug);
    }
    
    private void onDelete(Drug drug) {
       DAOFactory.getDrugDAO().delete(drug);
    }

    @Override
    public void execute(Object view, Object dataObj, String action) {
        //@todo add condition on view  && (dataObj instanceof Drug)
        
        Drug drug = (Drug)dataObj;
        
        if(action.equals("create")) {
            this.onCreate(drug);
        }
        
        if(action.equals("update")) {
            this.onUpdate(drug);
        }
       
        if(action.equals("delete")) {
            this.onDelete(drug);
        }
    }
    
}
