/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.dao.DAOFactory;
import models.dao.UserDAO;
import models.Model;
import models.User;
import views.LoginFrame;
import views.View;

/**
 *
 * @author otsaan
 */
public class UserController implements Observer{
    
    
    public UserController() {  
    }
    
    private void logIn(User user, Object view) {
        
        try {
            database.Database.getInstance().connect();
            
            if (user.getUsername().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog((LoginFrame)view, "Veuillez entrer le nom d'utilisateur.");
            } else {

                if (user.getPassword().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog((LoginFrame)view, "Veuillez entrer le mot de passe.");
                } else {
                    if (DAOFactory.getUserDAO().findUser(user) > 0) {
                        ((LoginFrame)view).dispose();
                        Model model = new Model();
                        View mainView = new View(model);
                    } else {
                        JOptionPane.showMessageDialog((LoginFrame)view, "Nom d'utilisateur ou mot de passe incorrect.");
                    }
                }
            }
            
        } catch (Exception ex) {
            System.out.println("Error Connection to Database" + ex);
            JOptionPane.showMessageDialog((LoginFrame)view, "Erreur de Connexion à la base de données.");
        }
        

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
                this.logIn((User)dataObj, view);
            }

            if (action.equalsIgnoreCase("logout")) {
                this.logOut((User)dataObj);
            }
        }
        
    }
    
}
