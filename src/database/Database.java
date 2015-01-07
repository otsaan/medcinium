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
 * @author otsaan
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

    
    public  void connect() {
        if (conn != null)
            return;

        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            String url = String.format("jdbc:mysql://localhost:3306/medcinium", 3306);
            conn = DriverManager.getConnection(url, "root", "");
            
        } catch (Exception e) {
            System.out.println("Can't connect to Database " + e);
        }

       
    }
        
        
    /**
    * Run a SELECT query
    * @param q la requete
    */
    public  ResultSet query(String q) {
        
        try {
            connect();
            st = conn.createStatement();
            rs = st.executeQuery(q);
            
        } catch (Exception e) {
            System.err.println("Error Message : problem in query() method.");
            System.out.println(e);
        } 
        
        return rs;
    }
    
    /**
     * Run a query of type DML statement,
     * as INSERT, UPDATE ou DELETE 
     * @param q la requete
     */
    public  int dmlQuery(String q) {
        try {
            connect();
            st = conn.createStatement();
            return st.executeUpdate(q, Statement.RETURN_GENERATED_KEYS);
            
        } catch (Exception e) {
            
            System.err.println("Error Message : problem in dmlQuery() method.");
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

