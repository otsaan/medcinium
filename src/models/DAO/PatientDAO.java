/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import database.Database;
import java.sql.ResultSet;
import java.util.Vector;
import models.Patient;

/**
 *
 * @author otsaan
 */
public class PatientDAO implements DAO<Patient>{
    
    
    @Override
    public Patient find(String id) {
        Patient p = new Patient();
        
        String findQuery = "SELECT * FROM patients"
                        + " WHERE id_patient =" + id + ";";
        
        ResultSet rs = Database.getInstance().query(findQuery);
        
        try {
            rs.next();
            p.setPatientId(rs.getInt("id_patient"));
            p.setLastName(rs.getString("nom_patient"));
            p.setName(rs.getString("prenom_patient"));
            p.setBirthDate(rs.getDate("date_naissance"));
            p.setAddress(rs.getString("adresse"));
            p.setCity(rs.getString("ville"));
            p.setCin(rs.getString("cin"));
            p.setSexe(rs.getString("sexe"));
            p.setTelephone(rs.getString("telephone"));
            p.setCredit(rs.getDouble("credit"));
            
        } catch (Exception ex) {
            System.out.println("Problem in find - PatientDAO" + ex);
        } 
        
        return p;

    }

    
    @Override
    public Vector<Patient> all() {
        Vector<Patient> patients = new Vector<Patient>();
        
        String findAllQuery = "SELECT * FROM patients;";
        ResultSet rs = Database.getInstance().query(findAllQuery);
        
        try {
            
            while(rs.next()) {
                
                Patient p = new Patient();
                
                p.setPatientId(rs.getInt("id_patient"));
                p.setLastName(rs.getString("nom_patient"));
                p.setName(rs.getString("prenom_patient"));
                p.setBirthDate(rs.getDate("date_naissance"));
                p.setAddress(rs.getString("adresse"));
                p.setCity(rs.getString("ville"));
                p.setSexe(rs.getString("sexe"));
                p.setCin(rs.getString("cin"));
                p.setTelephone(rs.getString("telephone"));
                p.setCredit(rs.getDouble("credit"));
                
                patients.add(p);
            }
            
        } catch (Exception ex) {
            System.out.println("Problem in all - PatientDAO");
        }
        
        return patients;
    }
    
    public Vector<Patient> like(String like) {
        
        Vector<Patient> patients = new Vector<Patient>();
        
        String findLikeQuery = "SELECT * FROM patients " +
            "WHERE nom_patient LIKE '%" + like + "%' OR prenom_patient LIKE '%" + like + "%';";
        ResultSet rs = Database.getInstance().query(findLikeQuery);
        
        try {
            
            while(rs.next()) {
                
                Patient p = new Patient();
                
                p.setPatientId(rs.getInt("id_patient"));
                p.setLastName(rs.getString("nom_patient"));
                p.setName(rs.getString("prenom_patient"));
                p.setBirthDate(rs.getDate("date_naissance"));
                p.setAddress(rs.getString("adresse"));
                p.setCity(rs.getString("ville"));
                p.setSexe(rs.getString("sexe"));
                p.setCin(rs.getString("cin"));
                p.setTelephone(rs.getString("telephone"));
                p.setCredit(rs.getDouble("credit"));
                
                patients.add(p);
            }
            
        } catch (Exception ex) {
            System.out.println("Problem in all - PatientDAO");
        }
        
        return patients;
    }
    
    @Override
    public boolean create(Patient p) {
        String insertQuery = "INSERT INTO patients(nom_patient, prenom_patient, "
                            + "date_naissance, telephone, adresse,ville, sexe,cin, credit) VALUES("
                            + "'" + p.getLastName()      + "', "
                            + "'" + p.getName()          + "', "
                            + "'" + p.getBirthDate()     + "', "
                            + "'" + p.getTelephone()     + "', "
                            + "'" + p.getAddress()       + "', "
                            + "'" + p.getCity()          + "', "
                            + "'" + p.getSexe()          + "', "
                            + "'" + p.getCin()           + "', "
                            + p.getCredit()              + ");";
        
        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }

    
    @Override
    public boolean update(Patient p) {
          
        String updateQuery = "UPDATE patients "
                           + "SET nom_patient = " + "'" + p.getName()+ "', "
                           + "prenom_patient = '" + p.getLastName()+ "', "
                           + "date_naissance = '" + p.getBirthDate()+ "', "
                           + "telephone = '" + p.getTelephone()+ "', "
                           + "adresse = '" + p.getAddress()+ "', "
                           + "ville = '" + p.getCity()+ "', "
                           + "sexe = '" + p.getSexe()+ "', "
                           + "cin = '" + p.getCin()+ "', "
                           + "credit = '" + p.getCredit()+ "' "
                           + "WHERE id_patient = '" + p.getPatientId()+ "';";
        
        return (Database.getInstance().dmlQuery(updateQuery) != 0);
    }

    
    @Override
    public boolean delete(Patient p) {
        String deleteQuery = "DELETE FROM patients "
                           + "WHERE id_patient = " + p.getPatientId()+ ";";
        
        return (Database.getInstance().dmlQuery(deleteQuery) != 0);
    }
    
}
