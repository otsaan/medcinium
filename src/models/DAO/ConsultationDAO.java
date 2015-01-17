/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import database.Database;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import models.Allergy;
import models.Consultation;
import models.Drug;
import models.PatientInfo;

/**
 *
 * @author otsaan
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
            con.setConsultationId(rs.getInt("id_consultation"));
            con.setType(rs.getString("type_consultation"));
            con.setDescription(rs.getString("desc_consultation"));
            con.setConsultationDate(rs.getDate("date_consultation"));
            con.setStatus(rs.getString("status"));
            con.setPrix(rs.getInt("prix"));
            con.setDiagnostics(rs.getString("diagnostics"));
            con.setPatient(patientDAO.find(rs.getString("id_patient")));
            con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
            con.setPatientInfoList(patientInfoDAO.all(rs.getInt("id_consultation")));
            con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));
        } catch (Exception ex) {
            System.out.println("Problem in find - ConsultationDAO" + ex);
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
                con.setDiagnostics(rs.getString("diagnostics"));
                con.setPatient(patientDAO.find(rs.getString("id_patient")));
                con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
                con.setPatientInfoList(patientInfoDAO.all(rs.getInt("id_consultation")));
                con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));
                consultations.add(con);
            }
            
        } catch (Exception ex) {
            System.out.println("Problem in all - ConsultationDAO" + ex);
        }
        
        return consultations;
    }

    
    @Override
    public boolean create(Consultation con) {
        String insertQuery = "INSERT INTO consultations(type_consultation, desc_consultation, "
                + "diagnostics, date_consultation, status, prix, id_patient) VALUES("
                            + "'" + con.getType()               + "', "
                            + "'" + con.getDescription()        + "', "
                            + "'" + con.getDiagnostics()        + "', "
                            + "'" + con.getConsultationDate()   + "', "
                            + "'" + con.getStatus()             + "', "
                            + con.getPrix()                     + ", "
                            + con.getPatient().getPatientId()   + ");";
        
        con.setConsultationId(Database.getInstance().dmlQuery2(insertQuery));
        return (con.getConsultationId()!=0);
    }

    
    @Override
    public boolean update(Consultation con) {
        String updateQuery = "UPDATE consultations "
                           + "SET type_consultation = " + "'" + con.getType() + "', "
                           + "desc_consultation = '" + con.getDescription() + "', "
                           + "diagnostics = '" + con.getDiagnostics()+ "', "
                           + "date_consultation = '" + con.getConsultationDate()+ "', "
                           + "status = '" + con.getStatus() + "', "
                           + "prix = '" + con.getPrix() + "', "
                           + "id_patient = '" + con.getPatient().getPatientId() + "' "
                           + "WHERE id_consultation = '" + con.getConsultationId() + "';";
        
        return (Database.getInstance().dmlQuery(updateQuery) != 0);
    }

    
    @Override
    public boolean delete(Consultation con) {
        String deleteQuery = "DELETE FROM consultations "
                           + "WHERE id_consultation = " + con.getConsultationId()+ ";";
        
        return Database.getInstance().dmlQuery(deleteQuery) != 0;
    }

    
    public boolean introduit(Consultation con, Drug drug) {
        String introduceQuery = "INSERT INTO introduit VALUES("
                + con.getConsultationId() + ", " + drug.getDrugId() + ", '" + drug.getDrugDescription()
                + "');";
        
        return (Database.getInstance().dmlQuery(introduceQuery) != 0);
    }
    
    
    public boolean contient(Consultation con, PatientInfo pInfo) {
        String insertQuery = "INSERT INTO contient VALUES("
                + con.getConsultationId() + ", " + pInfo.getId() + ", '" + pInfo.getValue()
                + "', '" + pInfo.getDateAdded() + "');";
        
        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }
    
    public boolean renseigne(Consultation con, Allergy allergy) {
        String insertQuery = "INSERT INTO renseigne VALUES("
                +"'"+con.getConsultationId()+"'"
                + ", '"+allergy.getAllergyId()+"');";
        
        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }
    
    
    public Vector<Consultation> pendingConsultations() {
        
        Vector<Consultation> consultations = new Vector<Consultation>();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();
        PatientInfoDAO patientInfoDAO = DAOFactory.getPatientInfoDAO();
        
        String DayStart = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(Calendar.getInstance().getTime());
        String DayEnd = new SimpleDateFormat("yyyy-MM-dd 23:59:59").format(Calendar.getInstance().getTime());

        String findAllQuery = "SELECT * "
                            + "FROM consultations "
                            + "WHERE date_consultation "
                            + "BETWEEN '" + DayStart + "' AND '"+ DayEnd + "' ";
        
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
                con.setDiagnostics(rs.getString("diagnostics"));
                con.setPatient(patientDAO.find(rs.getString("id_patient")));
                con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
                con.setPatientInfoList(patientInfoDAO.all(rs.getInt("id_consultation")));
                con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));
                consultations.add(con);
            }
            
        } catch (Exception ex) {
            System.out.println("Problem in pendingConsultations - ConsultationDAO " + ex);
        }
        
        return consultations;
    }
    
    public Vector<Consultation> byDate(Date date) {
        
        Vector<Consultation> consultations = new Vector<Consultation>();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();
        PatientInfoDAO patientInfoDAO = DAOFactory.getPatientInfoDAO();
        
        String DayStart = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date);
        String DayEnd = new SimpleDateFormat("yyyy-MM-dd 23:59:59").format(date);
        
        
        String findAllQuery = "SELECT * "
                            + "FROM consultations "
                            + "WHERE date_consultation "
                            + "BETWEEN '" + DayStart + "' AND '"+ DayEnd + "' ";
        
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
                con.setDiagnostics(rs.getString("diagnostics"));
                con.setPatient(patientDAO.find(rs.getString("id_patient")));
                con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
                con.setPatientInfoList(patientInfoDAO.all(rs.getInt("id_consultation")));
                con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));
                consultations.add(con);
            }
            
        } catch (Exception ex) {
            System.out.println("Problem in byDate - ConsultationDAO " + ex);
        }
        
        return consultations;
    }
    
    //finishedConsultations
    public Vector<Consultation> byStatus(String status) {
        
        Vector<Consultation> consultations = new Vector<Consultation>();
        
        PatientDAO patientDAO = DAOFactory.getPatientDAO();
        PatientInfoDAO patientInfoDAO = DAOFactory.getPatientInfoDAO();
       
        String findAllQuery = "SELECT * FROM consultations " 
                            + "WHERE status ='" + status + "';";
        
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
                con.setDiagnostics(rs.getString("diagnostics"));
                con.setPatient(patientDAO.find(rs.getString("id_patient")));
                con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
                con.setPatientInfoList(patientInfoDAO.all(rs.getInt("id_consultation")));
                con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));
                consultations.add(con);
            }
            
        } catch (Exception ex) {
            System.out.println("Problem in pendingConsultations - ConsultationDAO " + ex);
        }
        
        return consultations;
    }
    
    
    public Vector<Consultation> all(int patientId) {
        
        Vector<Consultation> consultations = new Vector<Consultation>();

        String findQuery = "SELECT * FROM consultations"
                        + " WHERE id_patient =" + patientId + ";";
        
        ResultSet rs = database.Database.getInstance().query(findQuery);

        try {
            
            while(rs.next()) {
                
                Consultation con = new Consultation();
              
                con.setConsultationId(rs.getInt("id_consultation"));
                con.setType(rs.getString("type_consultation"));
                con.setDiagnostics(rs.getString("diagnostics"));
                con.setDescription(rs.getString("desc_consultation"));
                con.setConsultationDate(rs.getDate("date_consultation"));
                con.setStatus(rs.getString("status"));
                con.setPrix(rs.getInt("prix"));
                con.setPatient(DAOFactory.getPatientDAO().find(rs.getString("id_patient")));
                con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
                con.setPatientInfoList(DAOFactory.getPatientInfoDAO().all(rs.getInt("id_consultation")));
                con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));
                
                consultations.add(con);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error : Consultation.all(int)" + ex);
        }
        
        return consultations;
    }
   
}