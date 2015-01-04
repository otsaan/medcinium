/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import database.Database;
import java.sql.ResultSet;
import java.util.Vector;
import models.Drug;

/**
 *
 * @author otsaan
 */
public class DrugDAO implements DAO<Drug> {
    
    
    @Override
    public Drug find(String id) {
        
        Drug drug = new Drug();
        
        String findQuery = "SELECT * FROM medicaments"
                        + " WHERE id_medicament =" + id + ";";
        
        ResultSet rs = Database.getInstance().query(findQuery);
        
        try {
            rs.next();
            drug.setDrugId(rs.getInt("id_medicament"));
            drug.setDrugName(rs.getString("nom_medicament"));
            drug.setDrugDescription(rs.getString("desc_medicament"));
            
        } catch (Exception ex) {
            System.out.println("Error : DrugDAO.find() " + ex);
        } 
        
        return drug;
    }

    
    @Override
    public Vector<Drug> all() {
        
        Vector<Drug> medicaments = new  Vector<Drug>();
        
        String findQuery = "SELECT * FROM medicaments";
        
        ResultSet rs = Database.getInstance().query(findQuery);
        
        try {
            
           while(rs.next()) {
               Drug drug= new Drug();
               drug.setDrugId(rs.getInt("id_medicament"));
               drug.setDrugName(rs.getString("nom_medicament"));
               drug.setDrugDescription("desc_medicament");
               medicaments.add(drug);
           }
           
        } catch (Exception ex) {
            System.out.println("Error : DrugDAO.all() " + ex);
        } 
        
        return medicaments;
    }
     

    @Override
    public boolean create(Drug drug) {
        
         String insertQuery = "INSERT INTO medicaments(nom_medicament,desc_medicament) "
                            + "VALUES("
                            + "'" + drug.getDrugName() + "', "
                            + "'" + drug.getDrugDescription()
                            + "'); ";
        
        return (Database.getInstance().dmlQuery(insertQuery) != 0);  
    }

    
    @Override
    public boolean update(Drug drug) {
        
        String insertQuery = "UPDATE medicaments "
                           + " set nom_medicament = '" + drug.getDrugName()+ "', "
                           + " desc_medicament = '" + drug.getDrugDescription() + "'"
                           + " WHERE id_medicament = " + drug.getDrugId() + ";";
                           
        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }

    
    @Override
    public boolean delete(Drug drug) {
           
        String deleteQuery = "DELETE FROM medicaments "
                           + "WHERE id_medicament = " + drug.getDrugId() + ";";
        
        return (Database.getInstance().dmlQuery(deleteQuery) != 0);
    }
    
    
    
}
