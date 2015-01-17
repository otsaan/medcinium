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
import models.Drug;
import models.Patient;
import models.PatientInfo;
import models.Payment;
import models.Reminder;

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
        columnNames.add("Num");
        columnNames.add("Nom");
        columnNames.add("Prenom");
        columnNames.add("Type");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Consultation c : pendingConsultations) {
            
            Vector<Object> line = new Vector<Object>();
            line.add(c.getConsultationId());
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
    
    
     public static DefaultTableModel buildConsultationAllergiesTableModel(Vector<Allergy> allergies) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        
        columnNames.add("Allergie");
//        columnNames.add("Date");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Allergy al : allergies) {
              Vector<Object> line = new Vector<Object>();
              line.add(al.getAllergyName());
              data.add(line);
        }

        return new DefaultTableModel(data, columnNames);
    }
    
    
    public static DefaultTableModel buildConsultationInfosTableModel(Vector<PatientInfo> infos) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        
        columnNames.add("Propriete");
        columnNames.add("Valeur");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (PatientInfo info : infos) {
            Vector<Object> line = new Vector<Object>();
            line.add(info.getProperty());
            line.add(info.getValue());
            data.add(line);
        }

        return new DefaultTableModel(data, columnNames);
    }
    
    public static DefaultTableModel buildConsultationDrugsTableModel(Vector<Drug> drugs) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        
        columnNames.add("Médicament");
        columnNames.add("Utilisation");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Drug dr : drugs) {
            Vector<Object> line = new Vector<Object>();
            line.add(dr.getDrugName());
            line.add(dr.getDrugDescription());
            data.add(line);
        }

        return new DefaultTableModel(data, columnNames);
    }
    
    
    /**
     * Build Table Model for "Rappels"
     * @param finishedConsultations
     * @return 
     */
    public static DefaultTableModel buildRemindersTableModel(Vector<Reminder> reminders) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Titre");
        columnNames.add("Heure");
        columnNames.add("Patient");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Reminder r : reminders) {
            
            Vector<Object> line = new Vector<Object>();

            line.add(r.getDescription());
            line.add(r.getDate().toString());
            line.add(r.getPatient().getName() + " " + r.getPatient().getLastName());

            data.add(line);
        }

        return new DefaultTableModel(data, columnNames);
    }
    
    
    public static DefaultTableModel buildRemindersConsultationsTableModel(Vector<Reminder> reminders, Vector<Consultation> consultations) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Titre");
        columnNames.add("Heure");
        columnNames.add("Patient");
        columnNames.add("Type");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Reminder r : reminders) {
            
            Vector<Object> line = new Vector<Object>();

            line.add(r.getDescription());
            line.add(r.getDate().toString());
            line.add(r.getPatient().getName() + " " + r.getPatient().getLastName());
            line.add("Rappel");

            data.add(line);
        }
        
        for (Consultation c : consultations) {
            
            Vector<Object> line = new Vector<Object>();

            line.add(c.getType());
            line.add(c.getConsultationDate().toString());
            line.add(c.getPatient().getName() + " " + c.getPatient().getLastName());
            line.add("Réservation");

            data.add(line);
        }

        return new DefaultTableModel(data, columnNames);
    }
    
    
    public static DefaultTableModel buildPaymentTableModel(Vector<Patient> patients) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Num");
        columnNames.add("Nom");
        columnNames.add("Prénom");
        columnNames.add("Crédit");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Patient p : patients) {
            if(p.getCredit() != 0) {
                Vector<Object> line = new Vector<Object>();

                line.add(p.getPatientId());
                line.add(p.getLastName());
                line.add(p.getName());
                line.add(p.getCredit());

                data.add(line);
            }
        }

        return new DefaultTableModel(data, columnNames);
    }
    
    public static DefaultTableModel buildDBdrugsTableModel(Vector<Drug> drugs) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Num");
        columnNames.add("Medicament");
        

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Drug d : drugs) {
            
            Vector<Object> line = new Vector<Object>();

            line.add(d.getDrugId());
            line.add(d.getDrugName());

            data.add(line);
        }

        return new DefaultTableModel(data, columnNames);
    }
    public static DefaultTableModel buildDBinfosTableModel(Vector<PatientInfo> patientInfos) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Num");
        columnNames.add("Infos");
        

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (PatientInfo pi : patientInfos) {
            
            Vector<Object> line = new Vector<Object>();

            line.add(pi.getId());
            line.add(pi.getProperty());

            data.add(line);
        }

        return new DefaultTableModel(data, columnNames);
    }
    
    public static DefaultTableModel buildDBAllergiesTableModel(Vector<Allergy> allergys) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Num");
        columnNames.add("Allergie");
        

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Allergy a : allergys) {
            
            Vector<Object> line = new Vector<Object>();

            line.add(a.getAllergyId());
            line.add(a.getAllergyName());

            data.add(line);
        }

        return new DefaultTableModel(data, columnNames);
    }
    
    public static DefaultTableModel buildPaymentHistoryTableModel(Vector<Payment> pay) {
        
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Num");
        columnNames.add("Patient");
        columnNames.add("Montant");

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (Payment p : pay) {
            
            Vector<Object> line = new Vector<Object>();

            line.add(p.getId());
            line.add(p.getPatient().getLastName() + " " + p.getPatient().getName());
            line.add(p.getAmount());
            
            data.add(line);
        }

        return new DefaultTableModel(data, columnNames);
    }
}
