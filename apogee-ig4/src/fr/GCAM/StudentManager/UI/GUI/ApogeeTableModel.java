/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.UI.GUI;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Quentin
 */
public class ApogeeTableModel extends AbstractTableModel {

    private String[] columnNames;
    private Object[][] data;    
    
    public ApogeeTableModel(String[] columnNames, Object[][] data) {
        super();
        this.columnNames = columnNames;
        this.data = data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }    

    @Override
    public boolean isCellEditable(int row, int col) {
        return !(this.getColumnName(col).equals("Nom") ||
                this.getColumnName(col).equals("Prenom") ||
                this.getColumnName(col).equals("Moyenne"));
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

    
}
