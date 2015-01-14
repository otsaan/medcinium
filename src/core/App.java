/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import controllers.Controller;
import controllers.UserController;
import javax.swing.SwingUtilities;
import models.Model;
import models.User;
import views.LoginFrame;
import views.View;

/**
 * This class creates and manages other controllers, It does the database connection stuff,
 * constructs the MainFrame, and displays the GUI of the app.
 * @author otsaan
 */
public class App {

    
    
    public static void main(String[] args) {
        /* 
         * This is the recommended way to create a Swing
         * event dispatch thread -- i.e. to run a Swing
         * program.
         */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                runApp();
            }
        });
    }
    
    
    public static void runApp() {
        
        UserController userController = new UserController();
        
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.addObserver(userController);
        
        loginFrame.setVisible(true);
        
        // once the user logged in successfully then >> View.setVisible(true)
        
        
        //Controller controller = new Controller(view, model);

    }
    
}


