/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Model;
import views.View;

/**
 * Controller must listen to the view using the observer design pattern
 * @author otsaan
 */
public class Controller {
    
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    
    
}
