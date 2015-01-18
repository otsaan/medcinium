/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import models.Allergy;
import models.Drug;
import models.PatientInfo;
import models.dao.DAOFactory;

/**
 *
 * @author otm
 */
public class DBInsertPanel extends javax.swing.JPanel  implements ListSelectionListener{

     Drug drug;
    PatientInfo info;
    Allergy allergy;
    /**
     * Creates new form DBInsertPanel
     */
    public DBInsertPanel() {
          
        initComponents();
        
        update.setEnabled(false);
        delete.setEnabled(false);
        infos.setModel(TableModelBuilder.buildDBinfosTableModel(DAOFactory.getPatientInfoDAO().all()));
        drugs.setModel(TableModelBuilder.buildDBdrugsTableModel(DAOFactory.getDrugDAO().all()));
        allergies.setModel(TableModelBuilder.buildDBAllergiesTableModel(DAOFactory.getAllergyDAO().all()));
        ListSelectionModel selectionModelDrugs = drugs.getSelectionModel();
        ListSelectionModel selectionModelInfos = infos.getSelectionModel();
        ListSelectionModel selectionModelAllergies = allergies.getSelectionModel();
        selectionModelDrugs.addListSelectionListener(this);
        selectionModelInfos.addListSelectionListener(this);
        selectionModelAllergies.addListSelectionListener(this);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        choice = new javax.swing.JComboBox();
        text = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        allergies = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        infos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        drugs = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        choice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Medicament", "Allergie", "Info" }));

        allergies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "Allergie"
            }
        ));
        jScrollPane1.setViewportView(allergies);

        infos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "Infos"
            }
        ));
        jScrollPane2.setViewportView(infos);

        drugs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "medicament"
            }
        ));
        jScrollPane3.setViewportView(drugs);

        addButton.setText("Ajouter");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        update.setText("modifier");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("supprimer");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(update))
                    .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delete)
                    .addComponent(choice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(choice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton)
                            .addComponent(update)
                            .addComponent(delete))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        drug= new Drug();
        info= new PatientInfo();
        allergy= new Allergy();
        drugs.clearSelection();

        if(!text.getText().equalsIgnoreCase("")) {
            if(choice.getSelectedItem().toString().equalsIgnoreCase("Medicament"))
            {

                drug.setDrugName(text.getText());
                if(DAOFactory.getDrugDAO().create(drug)) {
                    text.setText("");
                    try {
                        drugs.setModel(TableModelBuilder.buildDBdrugsTableModel(DAOFactory.getDrugDAO().all()));
                    }catch(Exception e){
                        drugs.repaint();
                    }
                }
                SwingUtilities.updateComponentTreeUI(this);
                this.invalidate();
                this.validate();
                this.repaint();
            }else if(choice.getSelectedItem().toString().equalsIgnoreCase("Allergie")){
                allergy.setAllergyName(text.getText());
                if(DAOFactory.getAllergyDAO().create(allergy))
                {
                    text.setText("");
                    try {
                        allergies.setModel(TableModelBuilder.buildDBAllergiesTableModel(DAOFactory.getAllergyDAO().all()));
                    }catch(Exception e){
                        allergies.repaint();
                    }
                }
                SwingUtilities.updateComponentTreeUI(this);
                this.invalidate();
                this.validate();
                this.repaint();
            }else if(choice.getSelectedItem().toString().equalsIgnoreCase("Info")) {
                info.setProperty(text.getText());
                if(DAOFactory.getPatientInfoDAO().create(info)) {
                    text.setText("");
                    try {
                        infos.setModel(TableModelBuilder.buildDBinfosTableModel(DAOFactory.getPatientInfoDAO().all()));
                    }catch(Exception e){
                        infos.repaint();
                    }
                }
                SwingUtilities.updateComponentTreeUI(this);
                this.invalidate();
                this.validate();
                this.repaint();
            }
        }else {
            JOptionPane.showMessageDialog(this, "Le champ est vide", "Erreur", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_addButtonActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if(!text.getText().equalsIgnoreCase("")) {
            if(choice.getSelectedItem().toString().equalsIgnoreCase("Medicament"))
            {

                drug.setDrugName(text.getText());
                if(DAOFactory.getDrugDAO().update(drug)) {
                    text.setText("");
                    try {
                        drugs.setModel(TableModelBuilder.buildDBdrugsTableModel(DAOFactory.getDrugDAO().all()));
                    }catch(Exception e){
                        drugs.repaint();
                    }
                }
                SwingUtilities.updateComponentTreeUI(this);
                this.invalidate();
                this.validate();
                this.repaint();
            }else if(choice.getSelectedItem().toString().equalsIgnoreCase("Allergie")){
                allergy.setAllergyName(text.getText());
                if(DAOFactory.getAllergyDAO().update(allergy))
                {
                    text.setText("");
                    try {
                        allergies.setModel(TableModelBuilder.buildDBAllergiesTableModel(DAOFactory.getAllergyDAO().all()));
                    }catch(Exception e){
                        allergies.repaint();
                    }
                }
                SwingUtilities.updateComponentTreeUI(this);
                this.invalidate();
                this.validate();
                this.repaint();
            }else if(choice.getSelectedItem().toString().equalsIgnoreCase("Info")) {
                info.setProperty(text.getText());
                if(DAOFactory.getPatientInfoDAO().update(info)) {
                    text.setText("");
                    try {
                        infos.setModel(TableModelBuilder.buildDBinfosTableModel(DAOFactory.getPatientInfoDAO().all()));
                    }catch(Exception e){
                        allergies.repaint();
                    }
                }
                SwingUtilities.updateComponentTreeUI(this);
                this.invalidate();
                this.validate();
                this.repaint();
            }
        }else {
            JOptionPane.showMessageDialog(this, "Le champ est vide", "Erreur", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        if(!text.getText().equalsIgnoreCase("")) {
            if(choice.getSelectedItem().toString().equalsIgnoreCase("Medicament"))
            {
                int val = JOptionPane.showConfirmDialog(this, "Etes vous sur?", "Validation", JOptionPane.OK_CANCEL_OPTION);
                if(val == 0) {
                    if(DAOFactory.getDrugDAO().delete(drug)) {
                        text.setText("");
                        try{
                            drugs.setModel(TableModelBuilder.buildDBdrugsTableModel(DAOFactory.getDrugDAO().all()));
                        }catch(Exception e){
                            drugs.repaint();
                        }
                    }
                    SwingUtilities.updateComponentTreeUI(this);
                    this.invalidate();
                    this.validate();
                    this.repaint();
                }

            }else if(choice.getSelectedItem().toString().equalsIgnoreCase("Allergie")){
                int val = JOptionPane.showConfirmDialog(this, "Etes vous sur?", "Validation", JOptionPane.OK_CANCEL_OPTION);
                if(val == 0) {
                    if(DAOFactory.getAllergyDAO().delete(allergy))
                    {
                        text.setText("");

                        try {
                            allergies.setModel(TableModelBuilder.buildDBAllergiesTableModel(DAOFactory.getAllergyDAO().all()));

                        }catch(Exception e){
                            allergies.repaint();
                        }

                    }
                    SwingUtilities.updateComponentTreeUI(this);
                    this.invalidate();
                    this.validate();
                    this.repaint();
                }
            }else if(choice.getSelectedItem().toString().equalsIgnoreCase("Info")) {
                int val = JOptionPane.showConfirmDialog(this, "Etes vous sur?", "Validation", JOptionPane.OK_CANCEL_OPTION);
                if(val == 0) {
                    if(DAOFactory.getPatientInfoDAO().delete(info)) {
                        text.setText("");
                        try {
                            infos.setModel(TableModelBuilder.buildDBinfosTableModel(DAOFactory.getPatientInfoDAO().all()));
                        }catch(Exception e){
                            allergies.repaint();
                        }
                    }
                    SwingUtilities.updateComponentTreeUI(this);
                    this.invalidate();
                    this.validate();
                    this.repaint();
                }
            }
        }else {
            JOptionPane.showMessageDialog(this, "Le champ est vide", "Erreur", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable allergies;
    private javax.swing.JComboBox choice;
    private javax.swing.JButton delete;
    private javax.swing.JTable drugs;
    private javax.swing.JTable infos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField text;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

        @Override
    public void valueChanged(ListSelectionEvent e) {
        
        update.setEnabled(true);
        delete.setEnabled(true);
        if (e.getSource() == drugs.getSelectionModel() && e.getValueIsAdjusting()) {
            TableModel model = (TableModel)drugs.getModel();
            String num = String.valueOf(model.getValueAt(drugs.getSelectedRow(), 0));
            
           drug = DAOFactory.getDrugDAO().find(num);
           text.setText(drug.getDrugName());
           choice.setSelectedIndex(0);
           choice.setEditable(false);
           
        }
        
        if (e.getSource() == allergies.getSelectionModel() && e.getValueIsAdjusting()) {
            
            TableModel model = (TableModel)allergies.getModel();
            String num = String.valueOf(model.getValueAt(allergies.getSelectedRow(), 0));
           allergy = DAOFactory.getAllergyDAO().find(num);
           text.setText(allergy.getAllergyName());
           choice.setSelectedIndex(1);
           choice.setEditable(false);
           
           
        }
        
        if (e.getSource() == infos.getSelectionModel() && e.getValueIsAdjusting()) {
            
            TableModel model = (TableModel)infos.getModel();
            String num = String.valueOf(model.getValueAt(infos.getSelectedRow(), 0));
           info = DAOFactory.getPatientInfoDAO().findAlone(num);
           text.setText(info.getProperty());
           choice.setSelectedIndex(2);
           System.out.println("selected");
           choice.setEditable(false);
        }
    
    }

}