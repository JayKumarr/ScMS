/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.utils.jtable.sort;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JAY KUMAR
 */
public class JTableJKSort {
    Class classes[] = {};
    boolean canEdit[] = {};
    String names[] = {};
    TableModelListener listeners[] = {};
    JTable table;
    public JTableJKSort(JTable table){
        this.table = table;
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        int columns = model.getColumnCount();
        classes = new Class[columns];
        canEdit = new boolean[columns];
        names = new String[columns];
        for(int i=0;i<columns;i++){
            classes[i]=model.getColumnClass(i);
            canEdit[i] = model.isCellEditable(0, i);
            names[i] = model.getColumnName(i);
        }
        listeners =  model.getTableModelListeners();
        
        setDefaultModel(table);
    }
    
    private void setDefaultModel(JTable table){
        GTableModel gtModel = new GTableModel(){  
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                try{
                    return canEdit [columnIndex];
                }catch(Exception ex){
                    
                }
                return true;
            }    
            @Override
            public Class getColumnClass(int columnIndex) {
                try{
                    return classes[columnIndex];
                } catch(Exception ex){
                    
                }//To change body of generated methods, choose Tools | Templates.
                return Object.class;
            }
        };
        for(int i=0;i<names.length;i++){
            gtModel.addColumn(names[i]);
        }
        for(int i=0;i<listeners.length;i++){
            gtModel.addTableModelListener(listeners[i]);
        }
        table.setModel(gtModel);
        gtModel.addMouseListenerToHeaderInTable(table);
    }
}
