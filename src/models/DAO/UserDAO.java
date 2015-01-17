/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import models.User;

/**
 *
 * @author otsaan
 */
public class UserDAO implements DAO<User>{

    
    @Override
    public User find(String id) {
        User user = new User();
        
        String findQuery = "SELECT * "
                        + "FROM utilisateurs "
                        + "WHERE id_utilisateur = " + Integer.parseInt(id) + ";";

        ResultSet rs = database.Database.getInstance().query(findQuery);
            
        try {
            
            rs.first();
            user.setUserId(rs.getInt("id_utilisateur"));
            user.setLastName(rs.getString("nom_utilisateur"));
            user.setName(rs.getString("prenom_utilisateur"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
        } catch (SQLException ex) {
            System.out.println("Error : UserDAO.find()" + ex);
        }
        
        return user;
    }
   
    
    public int findUser(User user) {
        
        int id=-1;
        String findQuery = "SELECT * "
                         + "FROM utilisateurs "
                         + "WHERE username = '" + user.getUsername() + "' "
                         + "AND password='" + user.getPassword() + "';";

        ResultSet rs = database.Database.getInstance().query(findQuery);
            
        try {
            
            rs.first();
            user.setUserId(rs.getInt("id_utilisateur"));
            user.setLastName(rs.getString("nom_utilisateur"));
            user.setName(rs.getString("prenom_utilisateur"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
           
            id = rs.getInt("id_utilisateur");
        } catch (SQLException ex) {
            System.out.println("Error : UserDAO.find()" + ex);
        }
        
        return id;
    } 
    

    @Override
    public Vector<User> all() {
        Vector<User> users = new  Vector<User>();
        
        String findQuery = "SELECT * FROM utilisateurs";
        
        ResultSet rs = Database.getInstance().query(findQuery);
        
        try {
           while(rs.next())
           {
                User user= new User();
                user.setUserId(rs.getInt("id_utilisateur"));
                user.setLastName(rs.getString("nom_utilisateur"));
                user.setName(rs.getString("prenom_utilisateur"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                users.add(user);
           }
           
        } catch (Exception ex) {
            System.out.println("UserDAO all " +ex);
        } 
        return users;    
    }

    
    @Override
    public boolean create(User user) {
        String insertQuery = "INSERT INTO utilisateurs(nom_utilisateur, "
                            + "prenom_utilisateur, username, password, role) VALUES("
                            + "'" + user.getLastName()   + "', "
                            + "'" + user.getName()       + "', "
                            + "'" + user.getUsername()   + "', "
                            + "'" + user.getPassword()   + "', "
                            + "'" + user.getRole()       + "');";
        
        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }

    
    @Override
    public boolean update(User user) {
        String updateQuery = "UPDATE utilisateurs "
                           + "SET nom_utilisateur = " + "'" + user.getLastName()+ "', "
                           + "prenom_utilisateur = '" + user.getName()+ "', "
                           + "username = '" + user.getUsername()+ "', "
                           + "password = '" + user.getPassword()+ "', "
                           + "role = '" + user.getRole()+ "' "
                           + "WHERE id_utilisateur = '" + user.getUserId() + "';";
        
        return (Database.getInstance().dmlQuery(updateQuery) != 0);
    }

    
    @Override
    public boolean delete(User user) {
        String deleteQuery = "DELETE FROM utilisateurs "
                           + "WHERE id_utilisateur = " + user.getUserId()+ ";";
        
        return (Database.getInstance().dmlQuery(deleteQuery) != 0);
    }
    
}
