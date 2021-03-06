/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.view.panel;

import com.school.constant.D_Msg;
import com.school.dao.DatabaseManager;
import com.school.dao.DatabaseQueryExecuter;
import com.school.log.AppLog;
import com.school.model.Awards;
import com.school.model.Campus;
import com.school.model.Event;
import com.school.model.Student;
import com.school.model.UserPrivilege;
import com.school.model.Years;
import com.school.utils.AppMsg;
import com.school.utils.ComponentHandler;
import com.school.view.JkPanel;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;

/**
 *
 * @author JAY
 */
public class EventsPanel extends  JkPanel{

    EventsStudentPanel studentPanel = null;
    
    /**
     * Creates new form EventsPanel
     */
    public EventsPanel(UserPrivilege privilege) {
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
        comboBoxYear = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textFieldEventDescription = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dateChooserEvent = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        listEvents = new javax.swing.JList();
        buttonAdd = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAwards = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textFieldAwardName = new javax.swing.JTextField();
        textFieldPostion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textFieldRemarksAward = new javax.swing.JTextField();
        buttonSelectionStudent = new javax.swing.JButton();
        comboBoxStudent = new javax.swing.JComboBox();
        buttonAddAward = new javax.swing.JButton();
        buttonDeleteAward = new javax.swing.JButton();
        comboBoxCampus = new javax.swing.JComboBox();

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EVENTS / COMPITITIONS");

        comboBoxYear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboBoxYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxYearItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Year*");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Event*");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Day*");

        listEvents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listEvents.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listEventsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listEvents);

        buttonAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-add-icon.png"))); // NOI18N
        buttonAdd.setText("Add  ");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/database-delete-icon.png"))); // NOI18N
        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Positions"));

        tableAwards.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Postion", "Award", "Student", "Father", "Surname", "Gr#", "Remarks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAwards.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tableAwards);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Award Name*");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Postion");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Remarks");

        buttonSelectionStudent.setText("Select");
        buttonSelectionStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSelectionStudentActionPerformed(evt);
            }
        });

        buttonAddAward.setText("ADD");
        buttonAddAward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddAwardActionPerformed(evt);
            }
        });

        buttonDeleteAward.setText("DEL");
        buttonDeleteAward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteAwardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(buttonSelectionStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(comboBoxStudent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textFieldAwardName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textFieldPostion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(textFieldRemarksAward, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonAddAward, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonDeleteAward, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonAdd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonDelete)
                                        .addGap(0, 4, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textFieldEventDescription)
                                            .addComponent(dateChooserEvent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(comboBoxCampus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(comboBoxYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboBoxCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(comboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(dateChooserEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textFieldEventDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonAdd)
                            .addComponent(buttonDelete)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonSelectionStudent)
                            .addComponent(comboBoxStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textFieldAwardName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buttonAddAward, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonDeleteAward, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textFieldPostion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textFieldRemarksAward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxYearItemStateChanged
        refreshEvents();
        if (studentPanel != null) {
            studentPanel.setVisible(false);
            studentPanel = null;
        }
    }//GEN-LAST:event_comboBoxYearItemStateChanged

    private void listEventsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listEventsValueChanged
        try {
            if(listEvents.isSelectionEmpty())return;
            Event event = (Event) listEvents.getSelectedValue();
            if (evt == null ) {
                return;
            }
            textFieldEventDescription.setText(event.getDesciption());
            dateChooserEvent.setDate(event.getDay());
            refreshAwards(event);
        } catch (Exception ex) {
            Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listEventsValueChanged

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        try {
            com.school.model.Years year = (com.school.model.Years) comboBoxYear.getSelectedItem();
            if (year == null) {
                return;
            }
            com.school.model.Event event = new com.school.model.Event(year);
            if (!isSetEvents(event)) {
                return;
            }
            DatabaseManager.addData(event);
            AppMsg.info(this, D_Msg.MSG_46);
            refreshEvents();
        } catch (Exception ex) {
            AppMsg.error(this, D_Msg.MSG_6,ex);
            Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        try {
            Years year = (Years) comboBoxYear.getSelectedItem();
            Event event = (Event) listEvents.getSelectedValue();
            if (evt == null || year == null) {
                return;
            }
            int option = AppMsg.confirm2(this, D_Msg.MSG_40);
            if(option == JOptionPane.NO_OPTION){
                return;
            }

            DatabaseManager.deleteData(event);
            AppMsg.info(this, D_Msg.MSG_47);
            refreshEvents();
            ComponentHandler.emptyTable(tableAwards);
        } catch (Exception ex) {
            AppMsg.error(this, D_Msg.MSG_6,ex);
            Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonSelectionStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSelectionStudentActionPerformed
        try {
            Years batch = (Years) comboBoxYear.getSelectedItem();
            Campus campus = (Campus) comboBoxCampus.getSelectedItem();
            if (batch == null || studentPanel != null) {
                studentPanel.setVisible(true);
                return;
            }
            studentPanel = new EventsStudentPanel(privilege,campus);
            studentPanel.buttonOK.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    comboBoxStudent.setModel(new DefaultComboBoxModel(new Object[]{studentPanel.getSelectedStudent()}));
                }
            });
            //studentPanel.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonSelectionStudentActionPerformed

    private void buttonAddAwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddAwardActionPerformed
        try {
            com.school.model.Event event = (com.school.model.Event) listEvents.getSelectedValue();
            Student st = (Student) comboBoxStudent.getSelectedItem();
            if (evt == null) {
                return;
            }
            if (st == null) {
                AppMsg.warning(this, D_Msg.MSG_48);
                return;
            }
            Awards award = new Awards(event, st, textFieldAwardName.getText(), textFieldPostion.getText(), textFieldRemarksAward.getText());
            DatabaseManager.addData(award);
            AppMsg.info(this, D_Msg.MSG_49);
            refreshAwards(event);
        } catch (Exception ex) {
            AppMsg.error(this, D_Msg.MSG_6,ex);
            Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonAddAwardActionPerformed

    private void buttonDeleteAwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteAwardActionPerformed
        try {
            int row = tableAwards.getSelectedRow();
            if (row < 0) {
                return;
            }
            com.school.model.Event event = (com.school.model.Event) listEvents.getSelectedValue();
            if (evt == null) {
                return;
            }
            int option = AppMsg.confirm2(this, D_Msg.MSG_40);
            if(option == JOptionPane.NO_OPTION){
                return;
            }
            Awards award = (Awards) tableAwards.getValueAt(row, 0);
            event.getAwardses().remove(award);
            DatabaseManager.deleteData(award);
            AppMsg.info(this, D_Msg.MSG_50);
            refreshAwards(event);
        } catch (HibernateException | HeadlessException ex) {
            AppMsg.error(this, D_Msg.MSG_6,ex);
            Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
        }catch(Exception ex){
            AppMsg.error(this, D_Msg.MSG_6,ex);
            Logger.getLogger(AppLog.ERROR_LOG).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonDeleteAwardActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonAddAward;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonDeleteAward;
    private javax.swing.JButton buttonSelectionStudent;
    private javax.swing.JComboBox comboBoxCampus;
    private javax.swing.JComboBox comboBoxStudent;
    private javax.swing.JComboBox comboBoxYear;
    private com.toedter.calendar.JDateChooser dateChooserEvent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listEvents;
    private javax.swing.JTable tableAwards;
    private javax.swing.JTextField textFieldAwardName;
    private javax.swing.JTextField textFieldEventDescription;
    private javax.swing.JTextField textFieldPostion;
    private javax.swing.JTextField textFieldRemarksAward;
    // End of variables declaration//GEN-END:variables

    @Override
    public void refresh() {
        
                ComponentHandler.setCampus(comboBoxCampus);
                ComponentHandler.setYear(comboBoxYear);
                refreshEvents();
        
    }
    
    /**
     * Set the values from text field in bean.Event object.
     * @param event
     * @return true if bean.Event data is set without any interruption otherwise false. 
     */
    private boolean isSetEvents(com.school.model.Event event) {
        String name = textFieldEventDescription.getText();
        Date day = dateChooserEvent.getDate();
        if (name == null || name.trim().isEmpty() || day == null) {
            AppMsg.warning(this, D_Msg.MSG_51);
            return false;
        }
        event.setDesciption(name);
        event.setDay(day);
        return true;
    }

    /**
     * Refresh the list of awards of selected event (i.e occasion, competition, celebration events, etc).
     * @param event 
     */
    private void refreshAwards(com.school.model.Event event) {
        ComponentHandler.emptyTable(tableAwards);
        DefaultTableModel model = (DefaultTableModel) tableAwards.getModel();
        List<Awards> awardList =  DatabaseQueryExecuter.getAwards(event);
        for(int i=0;i<awardList.size();i++) {
            Awards awards = awardList.get(i);
            Student student = awards.getStudent();
            model.addRow(new Object[]{awards, awards.getAwardsName(),student , student.getFatherName(), student.getSurname(), student.getGrNo(), awards.getRemarks()});
        }
    }

    /**
     * Refresh events of selected year (session / batch) in list.
     */
    private void refreshEvents() {
        Years year = (Years) comboBoxYear.getSelectedItem();
        if (year == null) {
            return;
        }
        List<Event> eventList =  DatabaseQueryExecuter.getEvents(year);
        listEvents.setListData(eventList.toArray());
    }

    private void setSelectionModelListener() {
        tableAwards.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tableAwards.getSelectedRow() < 0) {
                    return;
                }
                buttonDeleteAward.setEnabled(true);
            }
        });
    }

    @Override
    protected void postInit() {
        setSelectionModelListener();
    }

    @Override
    protected void handlePrivilege() {
        if (privilege.getIsAdd() == null || (!privilege.getIsAdd())) {
            buttonAdd.setVisible(false);
            buttonAddAward.setVisible(false);
            buttonSelectionStudent.setVisible(false);
        }
        if (privilege.getIsDelete()== null || (!privilege.getIsDelete())) {
            buttonDelete.setVisible(false);
            buttonDeleteAward.setVisible(false);
        }
    }

    @Override
    protected void initComponentImplementation() {
        initComponents();
    }
}
