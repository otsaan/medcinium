/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.UserDAO;
import controllers.listeners.LoginListener;
import models.User;

/**
 *
 * @author zianwar
 */
public class UserController implements LoginListener{

    @Override
    public void loginPerformed(User user) {
        UserDAO userDao = new UserDAO();
        // userDao.signIn(user);
    }
    
}
