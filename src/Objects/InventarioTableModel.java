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
public class InventarioTableModel extends AbstractTableModel {
     private String[] columnNames =
    {
        "COD.Articulo",
        "Articulo",
        "Cantidad",
        "Precio Compra",
        "Precio Venta"        
        
            
    };
     
       
     private ArrayList<Inventario> inventario;
 
    public InventarioTableModel() 
    {
        inventario =  new ArrayList<>();
    }
 
    public InventarioTableModel(ArrayList<Inventario> inventario)
    {
        this.inventario = inventario;
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
        return inventario.size();
    }
    
    @Override
    public Class getColumnClass(int column)
    {
        return String.class;
    }
    
    @Override
    public Object getValueAt(int row, int column)
    {
        Inventario inventario = getInventario(row);

        switch (column)
        {
            case 0: return inventario.getIdArticulo();
            case 1: return inventario.getNombreProducto();
            case 2: return inventario.getCantidad();
            case 3: return inventario.getPrecioCompraUnd();
            case 4: return inventario.getPrecioVentaUnd();
          
            default: return null;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
    
    public Inventario getInventario(int row){
        return inventario.get(row);
    }
 
    
}
