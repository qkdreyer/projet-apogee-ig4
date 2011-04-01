/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.UI.GUI;

import javax.swing.table.AbstractTableModel;

/**
 * Classe permettant d'utiliser les JTable (tableaux) de maniere personnalisee
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

    /**
     *
     * @return
     */
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     *
     * @return
     */
    public int getRowCount() {
        return data.length;
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /**
     * Redefinition de la fonction parente
     */
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }    

    /**
     * Redefinition de la fonction parente
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        return !(this.getColumnName(col).equals("Nom") ||
                this.getColumnName(col).equals("Prenom") ||
                this.getColumnName(col).equals("Moyenne"));
    }

    /**
     * Redefinition de la fonction parente
     */
    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

    
}
