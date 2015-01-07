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

/**
 *
 * @author otsaan
 */
public class PatientInfoDAO implements DAO<PatientInfo>{

    
   @Override
    public PatientInfo find(String id) {
        
        PatientInfo patientInfo = new PatientInfo();
        ConsultationDAO consultationDAO = DAOFactory.getConsultationDAO();
       
        
        String findQuery = "SELECT id_info, propriete, valeur, date_info "
                         + "FROM infos, contient "
                         + "WHERE infos.id_info = " + Integer.parseInt(id) + " "
                         + "AND contient.id_info = "+ Integer.parseInt(id) +";";

        ResultSet rs = database.Database.getInstance().query(findQuery);
            
        try {
            
            rs.first();
            patientInfo.setId(Integer.parseInt(id));
            patientInfo.setProperty(rs.getString("propriete"));
            patientInfo.setValue(rs.getString("valeur"));
            patientInfo.setDateAdded(rs.getDate("date_info"));
            
        } catch (SQLException ex) {
            System.out.println("Error : PatientInfo.find()" + ex);
        }
        
        return patientInfo;
    }


    @Override
    public boolean create(PatientInfo p) {
        
        String insertQuery = "INSERT INTO infos(propriete) VALUES('"
                                  + p.getProperty() + "');";
                
        p.setId(Database.getInstance().dmlQuery2(insertQuery));
        
        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }

    
    @Override
    public boolean update(PatientInfo p) {
        
        String updateQuery = "UPDATE infos "
                          + "SET propriete = '" + p.getProperty() + "' "
                          + "WHERE id_info = " + p.getId() + ";";
        
        return (Database.getInstance().dmlQuery(updateQuery) != 0);
    }

    
    @Override
    public boolean delete(PatientInfo p) {
        
        String deleteQuery = "DELETE FROM infos "
                          + "WHERE id_info = " + p.getId() + ";";
        
        return (Database.getInstance().dmlQuery(deleteQuery) != 0);
    }
    
    
    @Override
    public Vector<PatientInfo> all() {
        
        Vector<PatientInfo> patientInfos = new Vector<PatientInfo>();

        String findQuery = "SELECT id_info, propriete, valeur, date_info "
                         + "FROM infos, contient;";
        
        ResultSet rs = database.Database.getInstance().query(findQuery);

        try {
            
            while(rs.next()) {
                
                PatientInfo p = new PatientInfo();
                
                p.setId(rs.getInt("id_info"));
                p.setProperty(rs.getString("propriete"));
                p.setValue(rs.getString("valeur"));
                p.setDateAdded(rs.getDate("date_info"));
            
                patientInfos.add(p);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error : PatientInfo.all()" + ex);
        }
        
        return patientInfos;
    }
    
}
