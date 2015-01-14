/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import models.Consultation;

/**
 *
 * @author zianwar
 */
public class TableModelBuilder {
    
    
    
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
    
    
    
}
