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
public class ClientesTableModel extends AbstractTableModel {
    private String[] columnNames =
    {
        "ID",
        "Identificacion",
        "Nombre",
        "Alias"
    };
 
    private ArrayList<Clientes> clientes;
 
    public ClientesTableModel() 
    {   
        clientes = new ArrayList<>();
    }
 
    public ClientesTableModel(ArrayList<Clientes> clientes)
    {
        this.clientes = clientes;
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
        return clientes.size();
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
        Clientes clientes = getClientes(row);

        switch (column)
        {
            case 0: return clientes.getCodCliente();
            case 1: return clientes.getCedula();
            case 2: return clientes.getNombre();
            case 3: return clientes.getAlias();
            default: return null;
        }
    }
    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
    
    public Clientes getClientes(int row){
        return clientes.get(row);
    }
 
    
}
