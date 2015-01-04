/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.DAO.DAOFactory;
import models.Reminder;

/**
 *
 * @author otsaan
 */
public class ReminderController implements Observer{
    
    
    private void onCreate(Reminder reminder) {
        System.out.println("Reminder Created!");
        DAOFactory.getReminderDAO().create(reminder);
    }
    
    
    private void onUpdate(Reminder reminder) {
        System.out.println("Reminder Updated!");
        DAOFactory.getReminderDAO().update(reminder);
    }
    
    
    private void onDelete(Reminder reminder) { 
        System.out.println("Reminder Deleted!");
        DAOFactory.getReminderDAO().delete(reminder);
    }
    
    @Override
    public void execute(Object view, Object dataObj, String action) {
        
        if ((view instanceof Object) && (dataObj instanceof Reminder)) {
            
            if (action.equalsIgnoreCase("create")) {
                this.onCreate((Reminder)dataObj);
            }

            if (action.equalsIgnoreCase("update")) {
                this.onUpdate((Reminder)dataObj);
            }

            if (action.equalsIgnoreCase("delete")) {
                this.onDelete((Reminder)dataObj);
            }
            
        }
    }
    
}
