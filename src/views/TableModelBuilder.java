/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import models.Allergy;
import models.Consultation;
import models.PatientInfo;

/**
 *
 * @author zianwar
 */
public class TableModelBuilder {
    
    
    
    public static DefaultTableModel buildConsultationsTableModel(Vector<Consultation> Consultations) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        
        columnNames.add("Numéro");
        columnNames.add("Date");
        columnNames.add("Patient");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Consultation c : Consultations) {
            
            Vector<Object> line = new Vector<Object>();

            line.add(c.getConsultationId());
            line.add(c.getConsultationDate());
            line.add(c.getPatient().getLastName() + " " + c.getPatient().getName());

            data.add(line);
        }

        return new DefaultTableModel(data, columnNames);
    }
    
    /**
     * Build Table Model for "file d'attente" 
     * @param consultations pendingConsultations 
     * @return 
     */
    public static DefaultTableModel buildPendingConsultationTableModel(Vector<Consultation> pendingConsultations) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Nom");
        columnNames.add("Prenom");
        columnNames.add("Type");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Consultation c : pendingConsultations) {
            
            Vector<Object> line = new Vector<Object>();

            line.add(c.getPatient().getName());
            line.add(c.getPatient().getLastName());
            line.add(c.getType());

            data.add(line);
        }

        return new DefaultTableModel(data, columnNames);
    }
    
    
    /**
     * Build Table Model for "Dernieres consultations"
     * @param finishedConsultations
     * @return 
     */
    public static DefaultTableModel buildLastConsultationTableModel(Vector<Consultation> finishedConsultations) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Num");
        columnNames.add("Date");
        columnNames.add("Patient");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Consultation c : finishedConsultations) {
            
            Vector<Object> line = new Vector<Object>();

            line.add(c.getConsultationId());
            line.add(c.getConsultationDate());
            line.add(c.getPatient().getName() + " " + c.getPatient().getLastName());

            data.add(line);
        }

        return new DefaultTableModel(data, columnNames);
    }
    
    
     public static DefaultTableModel buildPatientConsultationTableModel(Vector<Consultation> hisConsultations) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        
        columnNames.add("Date");
        columnNames.add("Type");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Consultation c : hisConsultations) {
            
            Vector<Object> line = new Vector<Object>();

            line.add(c.getConsultationDate());
            line.add(c.getType());
            

            data.add(line);
        }

        return new DefaultTableModel(data, columnNames);
    }
   
    public static DefaultTableModel buildPatientInfosTableModel(Vector<Consultation> hisConsultations) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        
        columnNames.add("Proppriete");
        columnNames.add("Valeur");
        columnNames.add("Date");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Consultation c : hisConsultations) {
            
            
            for (PatientInfo info : c.getPatientInfoList()) {
              Vector<Object> line = new Vector<Object>();
              line.add(info.getProperty());
              line.add(info.getValue()); 
              line.add(info.getDateAdded()); 
              data.add(line);
            }
            
        }

        return new DefaultTableModel(data, columnNames);
    }
    
    
             public static DefaultTableModel buildPatientDiagnosticsTableModel(Vector<Consultation> hisConsultations) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        
        columnNames.add("Diagnostics");
       
        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Consultation c : hisConsultations) {
            
            Vector<Object> line = new Vector<Object>();

            line.add(c.getDiagnostics());

            data.add(line);
        }
            
        return new DefaultTableModel(data, columnNames);
    }
    
             
     public static DefaultTableModel buildPatientAllergiesTableModel(Vector<Consultation> hisConsultations) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        
        columnNames.add("Allergie");
        columnNames.add("Date");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Consultation c : hisConsultations) {
            
            
            for (Allergy allergy : c.getAllergyList()) {
              Vector<Object> line = new Vector<Object>();
              line.add(allergy.getAllergyName());
              line.add(c.getConsultationDate()); 
              data.add(line);
            }
            
        }

        return new DefaultTableModel(data, columnNames);
    }
}
