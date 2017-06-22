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
public class ComprasTableModel extends AbstractTableModel{
    
    private String[] columnNames =
    {
        "Cantidad",
        "Codigo",
        "Articulo",
        "Precio Compra",
        "SubTotal"
        
            
    };
    
     private ArrayList<Compras> compras;
 
    public ComprasTableModel() 
    {
        compras =  new ArrayList<>();
    }
 
    public ComprasTableModel(ArrayList<Compras> compras)
    {
        this.compras = compras;
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
        return compras.size();
    }
    
    @Override
    public Class getColumnClass(int column)
    {
        return String.class;
    }
    
    @Override
    public Object getValueAt(int row, int column)
    {
        Compras compras = getCompras(row);

        switch (column)
        {
            case 0: return compras.getAgregarCantidad();
            case 1: return compras.getIdArticulo();
            case 2: return compras.getNombreArticulo();
            case 3: return compras.getPrecioCompra();
            case 4: return compras.getSubTotal();
            default: return null;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
    
    public Compras getCompras(int row){
        return compras.get(row);
    }
 
}
