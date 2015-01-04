/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import models.PatientInfo;
import models.Payment;

/**
 *
 * @author otsaan
 */
public class PaymentDAO implements DAO<Payment> {
    
    
    @Override
    public Payment find(String id) {
        
        Payment payment = new Payment();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();
        
        String findQuery = "SELECT * "
                        + "FROM paiements "
                        + "WHERE id_paiement = " + Integer.parseInt(id) + ";";

        ResultSet rs = database.Database.getInstance().query(findQuery);
            
        try {
            
            rs.first();
            payment.setId(Integer.parseInt(id));
            payment.setAmount(rs.getInt("montant"));
            payment.setDate(rs.getDate("date_paiement"));
            payment.setPatient(patientDAO.find(rs.getString(id)));
            
        } catch (SQLException ex) {
            System.out.println("Error : PaymentDAO.find()" + ex);
        }
        
        return payment;
    }


    @Override
    public boolean create(Payment p) {
        
        String insertQuery = "INSERT INTO paiements(id_paiement, montant, date_paiement, id_patient) VALUES("
                           + p.getAmount() + ", "
                           + "'" + p.getDate()+ "', "
                           + "'" + p.getPatient().getPatientId() + ");";
        
        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }

    
    @Override
    public boolean update(Payment p) {
        
        String updateQuery = "UPDATE paiements "
                          + "SET montant = " + p.getAmount()+ ", "
                          + "date_paiement = '" + p.getDate()+ "', "
                          + "id_patient = " + p.getPatient().getPatientId() + " "
                          + "WHERE id_paiement = " + p.getId() + ";";
        
        return (Database.getInstance().dmlQuery(updateQuery) != 0);
    }

    
    @Override
    public boolean delete(Payment p) {
        
        String deleteQuery = "DELETE FROM paiements "
                          + "WHERE id_paiement = " + p.getId() + ";";
        
        return (Database.getInstance().dmlQuery(deleteQuery) != 0);
    }
    
    
    @Override
    public Vector<Payment> all() {
        
        Vector<Payment> payments = new Vector<Payment>();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();
        

        String findQuery = "SELECT * "
                        + "FROM paiements;";
        
        ResultSet rs = database.Database.getInstance().query(findQuery);

        try {
            
            while(rs.next()) {
                
                Payment p = new Payment();
                
                p.setId(rs.getInt("id_paiement"));
                p.setAmount(rs.getInt("montant"));
                p.setDate(rs.getDate("date_paiement"));
                p.setPatient(patientDAO.find(rs.getString("id_patient")));
            
                payments.add(p);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error : PaymentDAO.all()" + ex);
        }
        
        return payments;
    }
    
    
}
