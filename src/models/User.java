/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author otsaan
 */
public class User {
    
    private int userId;
    private String name;
    private String lastName;
    private String password;
    private String username;
    private String role;
    private static User  connectedUser;

 
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static void setConnectedUser(User connectedUser) {
        User.connectedUser = connectedUser;
    }

    public static User getConnectedUser() {
        return connectedUser;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", name=" + name + ", lastName=" + lastName + ", password=" + password + ", username=" + username + ", role=" + role + '}';
    }
    
    
}
