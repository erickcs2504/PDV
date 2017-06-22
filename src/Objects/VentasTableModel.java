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
public class VentasTableModel extends AbstractTableModel {
    
    private String[] columnNames =
    {
        "Cantidad",
        "Codigo",
        "Articulo",
        "Precio Venta",
        "SubTotal"
        
            
    };
    
     private ArrayList<Ventas> ventas;
 
    public VentasTableModel() 
    {
        ventas =  new ArrayList<>();
    }
 
    public VentasTableModel(ArrayList<Ventas> ventas)
    {
        this.ventas = ventas;
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
        return ventas.size();
    }
    
    @Override
    public Class getColumnClass(int column)
    {
        return String.class;
    }
    
    @Override
    public Object getValueAt(int row, int column)
    {
        Ventas ventas = getVentas(row);

        switch (column)
        {
            case 0: return ventas.getCantidad();
            case 1: return ventas.getIdArticulo();
            case 2: return ventas.getNombreArticulo();
            case 3: return ventas.getPrecioVenta();
            case 4: return ventas.getSubTotal();
            default: return null;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
    
    public Ventas getVentas(int row){
        return ventas.get(row);
    }
 
    
}
