/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.view.panel;

import com.school.constant.D_Msg;
import com.school.dao.DatabaseManager;
import com.school.model.Months;
import com.school.model.UserPrivilege;
import com.school.model.Years;
import com.school.utils.AppMsg;
import com.school.view.JkPanel;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.criterion.Order;

/**
 *
 * @author JAY
 */
public class YearRegisterPanel extends  JkPanel{

    private List<Years> yearsList = null;
    
    /**
     * Creates new form YearRegisterPanel
     */
    public YearRegisterPanel(UserPrivilege privilege) {
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
        jLabel5 = new javax.swing.JLabel();
        yearChooser = new com.toedter.calendar.JYearChooser();
        jLabel6 = new javax.swing.JLabel();
        textFieldRemarks = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listYear = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        buttonAdd = new javax.swing.JButton();
        buttonUpdate1 = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("YEAR");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Year *");

        yearChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                yearChooserPropertyChange(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Remarks");

        textFieldRemarks.setEditable(false);

        listYear.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listYearValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listYear);

        buttonAdd.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-add-icon.png"))); // NOI18N
        buttonAdd.setText("Add");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });
        jPanel3.add(buttonAdd);

        buttonUpdate1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        buttonUpdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/document-arrow-up-icon.png"))); // NOI18N
        buttonUpdate1.setText("Update");
        buttonUpdate1.setEnabled(false);
        buttonUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdate1ActionPerformed(evt);
            }
        });
        jPanel3.add(buttonUpdate1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(yearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldRemarks)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(yearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textFieldRemarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void yearChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_yearChooserPropertyChange
        int year = yearChooser.getYear();
        textFieldRemarks.setText(year + "-" + (year + 1));
    }//GEN-LAST:event_yearChooserPropertyChange

    private void listYearValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listYearValueChanged
        Years year = (Years)listYear.getSelectedValue();
        if(year == null)return;
        yearChooser.setYear(year.getYearName());
        textFieldRemarks.setText(year.getRemarks());
    }//GEN-LAST:event_listYearValueChanged

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        int year = yearChooser.getYear();
        if (isDuplicate(year)) {
            AppMsg.warning(this, D_Msg.MSG_55);
            return;
        }
        String remarks = textFieldRemarks.getText();
        Years y= new Years(year);
        y.setRemarks(remarks);
        Integer yearId = (Integer) DatabaseManager.addData(y);
        y.setYearId(yearId);
        for(int i=0;i<com.school.constant.ConsYear.MONTHS.length;i++){
            Months month = new Months(y, com.school.constant.ConsYear.MONTHS[i]);
            month.setRemarks(""+i);
            DatabaseManager.addData(month);
        }
        AppMsg.info(this, D_Msg.MSG_56);
        refreshJList();

    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdate1ActionPerformed

    }//GEN-LAST:event_buttonUpdate1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton buttonAdd;
    public javax.swing.JButton buttonUpdate1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listYear;
    private javax.swing.JTextField textFieldRemarks;
    private com.toedter.calendar.JYearChooser yearChooser;
    // End of variables declaration//GEN-END:variables

    @Override
    public void refresh() {
        refreshJList();
        
    }
      private void refreshJList() {
        yearsList = DatabaseManager.getData(Years.class,Order.desc("yearName"));
        listYear.setListData(yearsList.toArray());
    }
      
    private boolean isDuplicate(int year) {
        for (Years y : yearsList) {
            if (y.getYearName() == year) {
                return true;
            }
        }
        return false;
    }  

    @Override
    protected void postInit() {
        
    }

    @Override
    protected void handlePrivilege() {
        if (privilege.getIsAdd() == null || (!privilege.getIsAdd())) {
            buttonAdd.setVisible(false);
        }
    }

    @Override
    protected void initComponentImplementation() {
        initComponents();
    }
}
