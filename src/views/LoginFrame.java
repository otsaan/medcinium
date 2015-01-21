/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;



import controllers.Observer;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import models.User;

/**
 *
 * @author otsaan
 */
public class LoginFrame extends javax.swing.JFrame {

    private Vector<Observer> observers;
    
    
    public LoginFrame() {
        
        observers = new Vector<Observer>();
        
        URL iconURL = getClass().getResource("/assets/ico.png");
        // iconURL is null when not found
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        
        initComponents();
        configPanel.setVisible(false);
        User user = new User();
        usernameTextField.addKeyListener(new KeyAdapter() {    
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER ) {        
                    user.setUsername(usernameTextField.getText());
                    
                    user.setPassword(new String(password.getPassword()));
                    System.out.println("fff"+user.getPassword());
                    notifyObservers(user,"login");
                }
            } 
        });
        password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER ) {        
                    user.setUsername(usernameTextField.getText());
                   
                    user.setPassword(new String(password.getPassword()));
                    notifyObservers(user,"login");
                }
            } 
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        configPanel = new javax.swing.JPanel();
        login = new javax.swing.JLabel();
        saveConfigLabel = new javax.swing.JLabel();
        driver = new javax.swing.JTextField();
        url = new javax.swing.JTextField();
        port = new javax.swing.JTextField();
        dbUser = new javax.swing.JTextField();
        dbPassword = new javax.swing.JTextField();
        configBackground = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        configLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        seConnecterLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medcinium");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        configPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });
        configPanel.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 110, 30));

        saveConfigLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveConfigLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveConfigLabelMouseClicked(evt);
            }
        });
        configPanel.add(saveConfigLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 120, 30));

        driver.setBorder(null);
        configPanel.add(driver, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 105, 250, 30));

        url.setBorder(null);
        configPanel.add(url, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 250, 30));

        port.setBorder(null);
        configPanel.add(port, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 250, 30));

        dbUser.setBorder(null);
        configPanel.add(dbUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 245, 250, 30));

        dbPassword.setBorder(null);
        configPanel.add(dbPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 295, 250, 30));

        configBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/config.png"))); // NOI18N
        configBackground.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                configBackgroundMouseClicked(evt);
            }
        });
        configPanel.add(configBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 490));

        jPanel1.add(configPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -3, 590, 460));

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        configLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        configLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                configLabelMouseClicked(evt);
            }
        });
        mainPanel.add(configLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 40, 30));

        usernameTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        usernameTextField.setBorder(null);
        mainPanel.add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 265, 250, 30));

        password.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        password.setBorder(null);
        mainPanel.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 315, 250, 30));

        seConnecterLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seConnecterLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seConnecterLabelMouseClicked(evt);
            }
        });
        mainPanel.add(seConnecterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 396, 140, 40));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/login.png"))); // NOI18N
        backgroundLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backgroundLabelMouseClicked(evt);
            }
        });
        mainPanel.add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backgroundLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundLabelMouseClicked

    }//GEN-LAST:event_backgroundLabelMouseClicked

    private void seConnecterLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seConnecterLabelMouseClicked
        
        User user = new User();
        user.setUsername(usernameTextField.getText());
      
        user.setPassword(new String(password.getPassword()));
        notifyObservers(user,"login");
    }//GEN-LAST:event_seConnecterLabelMouseClicked

    private void configLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configLabelMouseClicked
        mainPanel.setVisible(false);
        configPanel.setVisible(true);
        
    }//GEN-LAST:event_configLabelMouseClicked

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
        mainPanel.setVisible(true);
        configPanel.setVisible(false);
    }//GEN-LAST:event_loginMouseClicked

    private void saveConfigLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveConfigLabelMouseClicked
        
         Properties prop = new Properties();
	OutputStream output = null;
 
	try {
 
		output = new FileOutputStream("config.properties");
 
		// set the properties value
		prop.setProperty("driver", driver.getText());
		prop.setProperty("url", url.getText());
		prop.setProperty("port", port.getText());
                prop.setProperty("dbUser", dbUser.getText());
                prop.setProperty("dbPassword", dbPassword.getText());
 
		// save properties to project root folder
		prop.store(output, null);
                 driver.setText("");
                 url.setText("");
                 port.setText("");
                 dbUser.setText("");
                 dbPassword.setText("");
	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 
	}
    }//GEN-LAST:event_saveConfigLabelMouseClicked

    private void configBackgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configBackgroundMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_configBackgroundMouseClicked
    
    
    public void addObserver(Observer observer) {
       observers.add(observer);
    }
    
    public void notifyObservers(User user, String action ) {
        for (Observer observer : observers) {
            observer.execute(this, user,action);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel configBackground;
    private javax.swing.JLabel configLabel;
    private javax.swing.JPanel configPanel;
    private javax.swing.JTextField dbPassword;
    private javax.swing.JTextField dbUser;
    private javax.swing.JTextField driver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel login;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField port;
    private javax.swing.JLabel saveConfigLabel;
    private javax.swing.JLabel seConnecterLabel;
    private javax.swing.JTextField url;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
