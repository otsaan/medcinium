/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zianwar
 */
public class Database {
	
    private static Database instance = new Database();

    private  Connection conn;
    private  ResultSet rs;
    private  Statement st;


    private Database() {}

    public static  Database getInstance() {
        return instance;
    }	

    /*
     * Add whatever methods you like to your singleton class.
     */
    public  void connect() throws Exception {
        if (conn != null)
            return;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver not found");
        }

        String url = String.format("jdbc:mysql://localhost:3306/medcinium", 3306);

        conn = DriverManager.getConnection(url, "root", "");
    }
        
        
        /**
     * Executer une requete SELECT
     * @param q la requete
     */
    public  ResultSet query(String q) {
        
        try {
            connect();
            st = conn.createStatement();
            rs = st.executeQuery(q);
            
        } catch (Exception e) {
            System.err.println("Error Message : Driver problem in dmlQuery() methode.");
            System.out.println(e);
        } 
        
        return rs;
    }
    
    /**
     * Executer une requete de type DML statement,
     * comme INSERT, UPDATE ou DELETE 
     * @param q la requete
     */
    public  int dmlQuery(String q) {
        try {
            connect();
            st = conn.createStatement();
            return st.executeUpdate(q);
            
        } catch (Exception e) {
            
            System.err.println("Error Message : Driver problem in dmlQuery() methode.");
            System.out.println(e);
        } 
        return 0;
    }
        
	
    public void disconnect() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Can't close connection");
            }
        }

        conn = null;
    }
	
}

