/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import database.Database;
import java.sql.ResultSet;
import java.util.Vector;
import models.Patient;

/**
 *
 * @author zianwar
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
            p.setSexe(rs.getString("sexe"));
            p.setTelephone(rs.getString("telephone"));
            p.setCredit(rs.getInt("credit"));
            
        } catch (Exception ex) {
            System.out.println("Problem in find - PatientDAO");
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
                p.setSexe(rs.getString("sexe"));
                p.setTelephone(rs.getString("telephone"));
                p.setCredit(rs.getInt("credit"));
                
                patients.add(p);
            }
            
        } catch (Exception ex) {
            System.out.println("Problem in all - PatientDAO");
        }
        
        return patients;
    }

    public ResultSet allToResultSet() {
        
        String findAllQuery = "SELECT * FROM patients;";
        ResultSet rs = Database.getInstance().query(findAllQuery);
        
        return rs;
    }
    
    @Override
    public boolean create(Patient p) {
        String insertQuery = "INSERT INTO patients(nom_patient, prenom_patient, "
                            + "date_naissance, telephone, adresse, sexe, credit) VALUES("
                            + "'" + p.getLastName()      + "', "
                            + "'" + p.getName()          + "', "
                            + "'" + p.getBirthDate()     + "', "
                            + "'" + p.getTelephone()     + "', "
                            + "'" + p.getAddress()       + "', "
                            + "'" + p.getSexe()          + "', "
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
                           + "sexe = '" + p.getSexe()+ "', "
                           + "credit = '" + p.getCredit()+ "' "
                           + "WHERE id_patient = '" + p.getPatientId()+ "';";
        
        return (Database.getInstance().dmlQuery(updateQuery) == 0);
    }

    @Override
    public boolean delete(Patient p) {
        String deleteQuery = "DELETE FROM patients "
                           + "WHERE id_patient = " + p.getPatientId()+ ";";
        
        return (Database.getInstance().dmlQuery(deleteQuery) == 0);
    }
    
}
