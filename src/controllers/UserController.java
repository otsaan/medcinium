/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.DAO.UserDAO;
import controllers.Listeners.LoginListener;
import models.User;

/**
 *
 * @author zianwar
 */
public class UserController implements LoginListener {

    public UserController() {
        
    }

    
    @Override
    public void loginPerformed(User user) {
        // UserDAO userDao = new UserDAO();
        // userDao.signIn(user);
        System.out.println("Event triggered!");
    }
    
}
