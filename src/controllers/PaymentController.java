/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Payment;

/**
 *
 * @author zianwar
 */
public class PaymentController implements Observer {
    
    public void onCreate(Payment payment) {
        System.out.println("Payment Created!");
    }

    public void onUpdate(Payment payment) {
        System.out.println("Payment Updated!");
    }

    public void onDelete(Payment payment) {
        System.out.println("Payment Deleted!");
    }
    
    @Override
    public void execute(Object view, Object dataObj, String action) {
        if ((dataObj instanceof Payment)) {
            
            if (action.equalsIgnoreCase("create")) {
                this.onCreate((Payment)dataObj);
            }

            if (action.equalsIgnoreCase("update")) {
                this.onUpdate((Payment)dataObj);
            }

            if (action.equalsIgnoreCase("delete")) {
                this.onDelete((Payment)dataObj);
            }
        }
    }
    
}
