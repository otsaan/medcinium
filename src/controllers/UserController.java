/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.DAO.UserDAO;
import models.User;
import views.LoginFrame;

/**
 *
 * @author otsaan
 */
public class UserController implements Observer{
    
    
    public UserController() {  
    }
    

    private void logIn(User user) {
        System.out.println("logIn!");
    }
    
    
    private void logOut(User user) {
        System.out.println("logOut!");
    }
    
    
    private void onCreate(User user) {
        System.out.println("User Created!");
    }
    
    
    private void onUpdate(User user) {
        System.out.println("User Updated!");
    }
    
    
    private void onDelete(User user) { 
        System.out.println("User Deleted!");
    }

    
    @Override
    public void execute(Object view, Object dataObj, String action) {
       
        if ((view instanceof LoginFrame) && (dataObj instanceof User)) {
            
            if (action.equalsIgnoreCase("create")) {
                this.onCreate((User)dataObj);
            }

            if (action.equalsIgnoreCase("update")) {
                this.onUpdate((User)dataObj);
            }

            if (action.equalsIgnoreCase("delete")) {
                this.onDelete((User)dataObj);
            }

            if (action.equalsIgnoreCase("login")) {
                this.logIn((User)dataObj);
            }

            if (action.equalsIgnoreCase("logout")) {
                this.logOut((User)dataObj);
            }
        }
        
    }
    
}
