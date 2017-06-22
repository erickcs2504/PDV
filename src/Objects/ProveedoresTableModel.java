/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;
import javax.swing.table.AbstractTableModel;
import Objects.*;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author Erick Cordero
 */
public class ProveedoresTableModel extends AbstractTableModel {
    private String[] columnNames =
    {
        "ID",
        "Nombre"
        
    };
 
    private ArrayList<Proveedores> proveedores;
 
    public ProveedoresTableModel() 
    {   
        proveedores = new ArrayList<>();
    }
 
    public ProveedoresTableModel(ArrayList<Proveedores> proveedores)
    {
        this.proveedores = proveedores;
    }
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public int getRowCount()
    {
        return proveedores.size();
    }
    
    @Override
    public Class getColumnClass(int column)
    {
        switch (column)
        {
            case 1: return String.class;
            default: return Integer.class;
        }
    }
    @Override
    public Object getValueAt(int row, int column)
    {
        Proveedores proveedores = getProveedores(row);

        switch (column)
        {
            case 0: return proveedores.getCodProveedor();
            case 1: return proveedores.getEmpresa();
            
            default: return null;
        }
    }
    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
    
    public Proveedores getProveedores(int row){
        return proveedores.get(row);
    }
 
    
}
