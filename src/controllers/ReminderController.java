/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Reminder;

/**
 *
 * @author zianwar
 */
public class ReminderController implements Observer{
    
    
    private void onCreate(Reminder reminder) {
        System.out.println("Reminder Created!");
    }
    
    
    private void onUpdate(Reminder reminder) {
        System.out.println("Reminder Updated!");
    }
    
    
    private void onDelete(Reminder reminder) { 
        System.out.println("Reminder Deleted!");
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
