/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.listeners;

import models.User;

/**
 *
 * @author zianwar
 */
public interface LoginListener {
    public void loginPerformed(User user);
}
