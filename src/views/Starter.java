/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.Listeners.AppListener;
import controllers.Listeners.LoginListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import models.Model;

/**
 *
 * @author zianwar
 */
public class Starter extends JFrame {
    
    
    public Starter() {
       // display some cool app loading stuff and launch loginframe
       // and fire the fireOpenEvent so that the controller do the onOpen() stuffs 
        //1. Create the frame.
        super("FrameDemo");

        //2. Optional: What happens when the frame closes?
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //3. Create components and put them in the frame

        //4. Size the frame.
        pack();

        //5. Show it.
        setVisible(true);
    }
    
    
}
