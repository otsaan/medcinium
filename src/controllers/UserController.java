/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JOptionPane;
import models.DAO.DAOFactory;
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
    

    private int logIn(User user) {
        System.out.println("logIn!");
       return DAOFactory.getUserDAO().findUser(user);
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
                if(this.logIn((User)dataObj)>0)
                {
                    //user found and id returnd 
                     JOptionPane.showMessageDialog((LoginFrame)view, "AccueilPannel doit etre instancier");
                    //((LoginFrame)view).dispose();
                    
                    
                }else
                {
                    //user not found 
                    JOptionPane.showMessageDialog((LoginFrame)view, "L'utilisateur n'existe pas");
 
                }
            }

            if (action.equalsIgnoreCase("logout")) {
                this.logOut((User)dataObj);
            }
        }
        
    }
    
}
