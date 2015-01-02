/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import database.Database;
import java.sql.ResultSet;
import java.util.Vector;
import models.Consultation;

/**
 *
 * @author zianwar
 */
public class ConsultationDAO implements DAO<Consultation>{
    
    @Override
    public Consultation find(String id) {
        
        Consultation con = new Consultation();
        
        PatientDAO patientDAO = DAOFactory.getPatientDAO();
        PatientInfoDAO patientInfoDAO = DAOFactory.getPatientInfoDAO();
        
        String findQuery = "SELECT * FROM consultations"
                        + " WHERE id_consultation =" + id + ";";
        
        ResultSet rs = Database.getInstance().query(findQuery);
        
        try {
            rs.next();
            con.setType(rs.getString("type_consultation"));
            con.setDescription(rs.getString("desc_consultation"));
            con.setConsultationDate(rs.getDate("date_consultation"));
            con.setStatus(rs.getString("status"));
            con.setPrix(rs.getInt("prix"));
            con.setPatient(patientDAO.find(rs.getString("id_patient")));
            con.setPatientInfo(patientInfoDAO.find(rs.getString("infos_id_info")));
            
        } catch (Exception ex) {
            System.out.println("Problem in find - ConsultationDAO");
        } 
        
        return con;
    }

    @Override
    public Vector<Consultation> all() {
        
        Vector<Consultation> consultations = new Vector<Consultation>();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();
        PatientInfoDAO patientInfoDAO = DAOFactory.getPatientInfoDAO();
        
        String findAllQuery = "SELECT * FROM consultations;";
        ResultSet rs = Database.getInstance().query(findAllQuery);
        
        try {
            
            while(rs.next()) {
                
                Consultation con = new Consultation();
                
                con.setConsultationId(rs.getInt("id_consultation"));
                con.setType(rs.getString("type_consultation"));
                con.setDescription(rs.getString("desc_consultation"));
                con.setConsultationDate(rs.getDate("date_consultation"));
                con.setStatus(rs.getString("status"));
                con.setPrix(rs.getInt("prix"));
                con.setPatient(patientDAO.find(rs.getString("id_patient")));
                con.setPatientInfo(patientInfoDAO.find(rs.getString("infos_id_info")));
                
                consultations.add(con);
            }
            
        } catch (Exception ex) {
            System.out.println("Problem in all - ConsultationDAO");
        }
        
        return consultations;
    }

    @Override
    public boolean create(Consultation con) {
        String insertQuery = "INSERT INTO consultations(type_consultation, desc_consultation, "
                + "date_consultation, status, prix, id_patient, infos_id_info) VALUES("
                            + "'" + con.getType()               + "', "
                            + "'" + con.getDescription()        + "', "
                            + "'" + con.getConsultationDate()   + "', "
                            + "'" + con.getStatus()             + "', "
                            + con.getPrix()                     + ", "
                            + con.getPatient().getPatientId()   + ", "
                            + con.getPatientInfo().getId()      + ");";
        
        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }

    @Override
    public boolean update(Consultation con) {
        String updateQuery = "UPDATE consultations "
                           + "SET type_consultation = " + "'" + con.getType() + "', "
                           + "desc_consultation = '" + con.getDescription() + "', "
                           + "date_consultation = '" + con.getConsultationDate()+ "', "
                           + "status = '" + con.getStatus() + "', "
                           + "prix = '" + con.getPrix() + "', "
                           + "id_patient = '" + con.getPatient().getPatientId() + "', "
                           + "infos_id_info = '" + con.getPatientInfo().getId() + "' "
                           + "WHERE id_consultation = '" + con.getConsultationId() + "';";
        
        return (Database.getInstance().dmlQuery(updateQuery) != 0);
    }

    @Override
    public boolean delete(Consultation con) {
        String deleteQuery = "DELETE FROM consultations "
                           + "WHERE id_consultation = " + con.getConsultationId()+ ";";
        
        String deleteInfosQuery = "DELETE FROM infos "
                           + "WHERE consultations_id_consultation = " + con.getConsultationId()+ ";";
        
        return (Database.getInstance().dmlQuery(deleteQuery) != 0 && Database.getInstance().dmlQuery(deleteInfosQuery) != 0);
    }

}