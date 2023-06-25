/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.view.panel;

import com.school.constant.ConsConfiguration;
import com.school.constant.D_Msg;
import com.school.dao.DatabaseManager;
import com.school.log.AppLog;
import com.school.model.Grade;
import com.school.model.SchoolConfig;
import com.school.model.UserPrivilege;
import com.school.utils.AppMsg;
import com.school.utils.ComponentHandler;
import com.school.utils.Filter;
import com.school.view.JkPanel;
import java.io.File;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JAY
 */
public class ConfigurationPanel extends JkPanel{

//    private JFileChooser fileChooser;
    private Hashtable configTable;
    private final int GRADE_NAME_COLUMN = 0;
    private final int MIN_PERC_COLUMN = 1;
    private final int MAX_PERC_COLUMN = 2;
    private final int OBJECT_COLUMN = 3;
    
    public ConfigurationPanel(UserPrivilege privilege) {
        super(privilege);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textFieldName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGrades = new javax.swing.JTable();
        buttonDelete = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        textFieldPrincipal = new javax.swing.JTextField();
        buttonAdd = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SCHOOL");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Name");

        textFieldName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textFieldName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldNameKeyReleased(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GRADE");

        tableGrades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grade", "Min %", "Max %", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableGrades.getTableHeader().setReorderingAllowed(false);
        tableGrades.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tableGradesPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tableGrades);

        buttonDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource(com.school.config.AppIcon.DELETE)));
        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource(com.school.config.AppIcon.SAVE)));
        buttonSave.setText("SAVE");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Principal");

        textFieldPrincipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldPrincipalKeyReleased(evt);
            }
        });

        buttonAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource(com.school.config.AppIcon.ADD)));
        buttonAdd.setText("Add");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldPrincipal)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldName)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textFieldPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSave))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonDelete, buttonSave});

    }// </editor-fold>//GEN-END:initComponents

    private void textFieldNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldNameKeyReleased
        buttonSave.setEnabled(true);
    }//GEN-LAST:event_textFieldNameKeyReleased

    private void tableGradesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tableGradesPropertyChange
        buttonSave.setEnabled(true);
    }//GEN-LAST:event_tableGradesPropertyChange

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        int rows[] = tableGrades.getSelectedRows();
        for (int i = 0; i < rows.length; i++) {
            //            System.out.println("Rows: " + rows[i]);
            try {
                DatabaseManager.deleteData(tableGrades.getValueAt(rows[0], OBJECT_COLUMN));
                //                System.out.println("Deleted");
            } catch (Exception ex) {
            }
            ((DefaultTableModel) tableGrades.getModel()).removeRow(rows[0]);
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        saveConfiguration();
        saveGrades();
        ComponentHandler.emptyTable(tableGrades);
        getGrades();
        buttonSave.setEnabled(false);
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void textFieldPrincipalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldPrincipalKeyReleased
        buttonSave.setEnabled(true);
    }//GEN-LAST:event_textFieldPrincipalKeyReleased

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        ((DefaultTableModel) tableGrades.getModel()).addRow(new Object[]{"", 0.00f, 0.00f, null});
    }//GEN-LAST:event_buttonAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableGrades;
    private javax.swing.JTextField textFieldName;
    private javax.swing.JTextField textFieldPrincipal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void refresh() {
        if (privilege.getIsAdd() == null || (!privilege.getIsAdd())) {
            buttonAdd.setVisible(false);
        }
        if (privilege.getIsDelete() == null || (!privilege.getIsDelete())) {
            buttonDelete.setVisible(false);
        }
        if (privilege.getIsUpdate() == null || (!privilege.getIsUpdate())) {
            buttonSave.setVisible(false);
        }
        getSchoolConfiguration();
        ComponentHandler.emptyTable(tableGrades);
        getGrades();
        buttonSave.setEnabled(false);

//        textFieldLogoPath.getDocument().addDocumentListener(getDocumentListener());   
    }
    
    /**
     * Save configuration in database.
     */
    private void saveConfiguration() {
        String schoolName = Filter.filterString(textFieldName.getText());
//        String logo = textFieldLogoPath.getText();
//        String contact = Filter.filterString(textFieldContact.getText());
//        String email = Filter.filterString(textFieldEmail.getText());
        String principal = Filter.filterString(textFieldPrincipal.getText());
        try {
            if (configTable.containsKey(ConsConfiguration.SCHOOL)) {
                SchoolConfig conf = ((SchoolConfig) configTable.get(ConsConfiguration.SCHOOL));
                conf.setValueName(schoolName);
                DatabaseManager.updateData(conf);
            } else {
                DatabaseManager.addData(new SchoolConfig(ConsConfiguration.SCHOOL, schoolName));
            }
//            if (configTable.containsKey(ConsConfiguration.LOGO)) {
//                SchoolConfig conf = ((SchoolConfig) configTable.get(ConsConfiguration.LOGO));
//                conf.setValueName(logo);
//                DatabaseManager.updateData(conf);
//            } else {
//                DatabaseManager.addData(new SchoolConfig(ConsConfiguration.LOGO, logo));
//            }
//            if (configTable.containsKey(ConsConfiguration.CONTACT)) {
//                SchoolConfig conf = ((SchoolConfig) configTable.get(ConsConfiguration.CONTACT));
//                conf.setValueName(contact);
//                DatabaseManager.updateData(conf);
//            } else {
//                DatabaseManager.addData(new SchoolConfig(ConsConfiguration.CONTACT, contact));
//            }
//            if (configTable.containsKey(ConsConfiguration.EMAIL)) {
//                SchoolConfig conf = ((SchoolConfig) configTable.get(ConsConfiguration.EMAIL));
//                conf.setValueName(email);
//                DatabaseManager.updateData(conf);
//            } else {
//                DatabaseManager.addData(new SchoolConfig(ConsConfiguration.EMAIL, email));
//            }
            if (configTable.containsKey(ConsConfiguration.PRINCIPAL)) {
                SchoolConfig conf = ((SchoolConfig) configTable.get(ConsConfiguration.PRINCIPAL));
                conf.setValueName(principal);
                DatabaseManager.updateData(conf);
            } else {
                DatabaseManager.addData(new SchoolConfig(ConsConfiguration.PRINCIPAL, principal));
            }
        } catch (Exception ex) {
          AppMsg.error(this, D_Msg.MSG_6,ex);
            Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Save grades in database.
     */
    private void saveGrades() {
        int rowsTotal = tableGrades.getRowCount();
        for (int rowNo = 0; rowNo < rowsTotal; rowNo++) {
            String name = (String) tableGrades.getValueAt(rowNo, GRADE_NAME_COLUMN);
            Float min = (Float) tableGrades.getValueAt(rowNo, MIN_PERC_COLUMN);
            Float max = (Float) tableGrades.getValueAt(rowNo, MAX_PERC_COLUMN);

            Object ob = tableGrades.getValueAt(rowNo, OBJECT_COLUMN);
            if (ob instanceof Grade) {
//                System.out.println("UPDATED  Row: " + (rowNo + 1));
                Grade g = (Grade) ob;
                g.setName(name);
                g.setPercMin(min);
                g.setPercMax(max);
                DatabaseManager.updateData(g);
            } else {
//                System.out.println(">ADDED  Row: " + (rowNo + 1));
                DatabaseManager.addData(new Grade(name, min, max));
            }
        }
    }

    /*
     * Listener for logo text field.
     */
    private DocumentListener getDocumentListener() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                buttonSave.setEnabled(true);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                buttonSave.setEnabled(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                buttonSave.setEnabled(true);
            }
        };
    }
    
    
    /**
     * getting configuration values from database and set data on their field.
     */
    private void getSchoolConfiguration() {
        try {
            List list = DatabaseManager.getData(SchoolConfig.class);
            for (Object ob : list) {
                SchoolConfig conf = (SchoolConfig) ob;
                configTable.put(conf.getKeyName(), ob);
            }
        } catch (Exception ex) {
            AppMsg.error(this, D_Msg.MSG_6,ex);
            Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
        }
        setConfigValues();
    }

    /**
     * called by getSchoolConfiguration() to set the values at their field.
     */
    private void setConfigValues() {
        if (configTable.containsKey(ConsConfiguration.SCHOOL)) {
            textFieldName.setText(((SchoolConfig) configTable.get(ConsConfiguration.SCHOOL)).getValueName());
        }
//        if (configTable.containsKey(ConsConfiguration.LOGO)) {
//            textFieldLogoPath.setText(((SchoolConfig) configTable.get(ConsConfiguration.LOGO)).getValueName());
//        }
//        if (configTable.containsKey(ConsConfiguration.CONTACT)) {
//            textFieldContact.setText(((SchoolConfig) configTable.get(ConsConfiguration.CONTACT)).getValueName());
//        }
//        if (configTable.containsKey(ConsConfiguration.EMAIL)) {
//            textFieldEmail.setText(((SchoolConfig) configTable.get(ConsConfiguration.EMAIL)).getValueName());
//        }
        if (configTable.containsKey(ConsConfiguration.PRINCIPAL)) {
            textFieldPrincipal.setText(((SchoolConfig) configTable.get(ConsConfiguration.PRINCIPAL)).getValueName());
        }
    }

    /**
     * getting grades values from database and set data on table.
     */
    
    private void getGrades() {
        try {
            List list = DatabaseManager.getData(Grade.class);
            for (Object ob : list) {
                Grade g = (Grade) ob;
                ((DefaultTableModel) tableGrades.getModel()).addRow(new Object[]{g.getName(), g.getPercMin(), g.getPercMax(), g});
            }
        } catch (Exception ex) {
            AppMsg.error(this, D_Msg.MSG_6,ex);
            Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void postInit() {
//        fileChooser = new JFileChooser("../");
//        fileChooser.setDialogTitle("LOGO PATH");
//        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        configTable = new Hashtable();
        
    }

    @Override
    protected void handlePrivilege() {
        
    }

    @Override
    protected void initComponentImplementation() {
        initComponents();
    }
}
