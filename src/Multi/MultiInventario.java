/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multi;
import java.sql.*;
import java.io.*;
import java.util.*;// para usar vector
import Objects.*;
import AccesoDB.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
/**
 *
 * @author Erick Cordero
 */
public class MultiInventario {
    
    public  Inventario crear(String pIdArticulo, String pNombreArticulo, String pUnidad, int pCantidad, String pPrecioCompraUnd, String pPrecioVentaUnd, int pCantidadReserva) 
			throws Exception{
		Inventario unInventario=null;
		String sql;
		sql = "INSERT INTO TInventario "+
		"(IdArticulo, NombreArticulo, Unidad, Cantidad, PrecioCompra, PrecioVenta, CantidadReserva) "+
		"VALUES ('"+pIdArticulo+"', '"+pNombreArticulo+"', '"+pUnidad+"', '"+pCantidad+"', '"+pPrecioCompraUnd+"', '"+pPrecioVentaUnd+"', '"+pCantidadReserva+"');";
		try {
			//AccesoBD acceso = Conector.getConector();
			//acceso.ejecutarSQL(sql);
			Conector.getConector().ejecutarSQL(sql);
			unInventario = new Inventario (pIdArticulo,pNombreArticulo,pUnidad,pCantidad,pPrecioCompraUnd,pPrecioVentaUnd,pCantidadReserva);
                        //JOptionPane.showMessageDialog(null,"Registro Guardado Satisfactoriamente!!");
		}
		catch(java.sql.SQLException e)
		{
			throw e;
		}
		catch (Exception e) {
			throw e;
			//throw new Exception ("El número de ntificación ya está en el sistema.");
		}
		return unInventario;
	}
    public  Inventario buscarPorIdArticulo(String pIdArticulo) throws 
			java.sql.SQLException,Exception{
		Inventario unInventario=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT IdArticulo, NombreArticulo,Cantidad, PrecioCompra, PrecioVenta, CantidadReserva " +
		"FROM TInventario "+
		"WHERE IdArticulo='"+ pIdArticulo +"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
                if (rs.next()) {
                    try{
                    
			unInventario = new Inventario(
                                    rs.getString("IdArticulo"),
                                    rs.getString("NombreArticulo"),
                                    rs.getInt("Cantidad"),
                                    rs.getString("PrecioCompra"),
                                    rs.getString("PrecioVenta"),
                                    rs.getInt("CantidadReserva"));
                                   
                    }catch(java.sql.SQLException e){
                        
			//throw new Exception (" Usuario no registrado.");
                       
                        
                        JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
                    }
                }
                rs.close();
		return unInventario;
	}
      public Inventario buscarPorNombreArticulo(String pNombre)
        throws java.sql.SQLException, Exception{
        String sql = "SELECT IdArticulo, NombreArticulo,Cantidad, PrecioCompra, PrecioVenta, CantidadReserva FROM TInventario  WHERE NombreArticulo LIKE '%" + pNombre + "%'";
        java.sql.ResultSet rs;
        ArrayList<Compras> compras = new ArrayList<>();
        Inventario unInventario=null;
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
          unInventario = new Inventario(
                                    rs.getString("IdArticulo"),
                                    rs.getString("NombreArticulo"),
                                    rs.getInt("Cantidad"),
                                    rs.getString("PrecioCompra"),
                                    rs.getString("PrecioVenta"),
                                    rs.getInt("CantidadReserva"));
        }
        
        return unInventario;
    }
    
      public ArrayList <Inventario> listar()
        throws java.sql.SQLException, Exception{
        String sql = "SELECT IdArticulo, NombreArticulo,Cantidad, PrecioCompra, PrecioVenta, CantidadReserva FROM TInventario";
        java.sql.ResultSet rs;
        ArrayList<Inventario> inventario = new ArrayList<>();
        Compras unaCompra=null;
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
          inventario.add((new Inventario(
                                    rs.getString("IdArticulo"),
                                    rs.getString("NombreArticulo"),
                                    rs.getInt("Cantidad"),
                                    rs.getString("PrecioCompra"),
                                    rs.getString("PrecioVenta"),
                                    rs.getInt("CantidadReserva"))));
        }
        
        return inventario;
    }
      
       public ArrayList <Inventario> listarNombreArticulo(Inventario pInventario)
        throws java.sql.SQLException, Exception{
        String sql = "SELECT IdArticulo, NombreArticulo,Cantidad, PrecioCompra, PrecioVenta, CantidadReserva FROM TInventario WHERE IdArticulo ='" + pInventario.getIdArticulo()+"'";
        java.sql.ResultSet rs;
        ArrayList<Inventario> inventario = new ArrayList<>();
        Compras unaCompra=null;
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
          inventario.add((new Inventario(
                                    rs.getString("IdArticulo"),
                                    rs.getString("NombreArticulo"),
                                    rs.getInt("Cantidad"),
                                    rs.getString("PrecioCompra"),
                                    rs.getString("PrecioVenta"),
                                    rs.getInt("CantidadReserva"))));
        }
        
        return inventario;
    }
      public ArrayList<Inventario> buscarPorNombre(String pNombre)
        throws java.sql.SQLException, Exception{
        String sql = "SELECT IdArticulo, NombreArticulo,Cantidad, PrecioCompra, PrecioVenta, CantidadReserva FROM TInventario  WHERE NombreArticulo LIKE '%" + pNombre + "%'";
        java.sql.ResultSet rs;
        ArrayList<Inventario> inventario = new ArrayList<>();
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
          inventario.add((new Inventario(
                                    rs.getString("IdArticulo"),
                                    rs.getString("NombreArticulo"),
                                    rs.getInt("Cantidad"),
                                    rs.getString("PrecioCompra"),
                                    rs.getString("PrecioVenta"),
                                    rs.getInt("CantidadReserva"))));
        }
        
        return inventario;
    }
      
      public void modificar(Inventario pInventario)
            throws java.sql.SQLException, Exception {
        String sqlInventario;

        sqlInventario = "UPDATE TInventario "
                + "SET Cantidad = " + pInventario.getCantidad() + " "
                + "WHERE IdArticulo = '" + pInventario.getIdArticulo() + "'";
        
        

       try {
            Conector.getConector().ejecutarSQL(sqlInventario);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Articulo no esta registrado.");
        }
    }
     
      public void descontarArticuloDeInventario(Inventario pInventario,int pCantTotal)
            throws java.sql.SQLException, Exception {
        String sqlInventario;

        sqlInventario = "UPDATE TInventario "
                + "SET Cantidad =" + (pCantTotal-pInventario.getCantidad()) + " "
                + "WHERE IdArticulo = '" + pInventario.getIdArticulo() + "'";
        
        

       try {
            Conector.getConector().ejecutarSQL(sqlInventario);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Articulo no esta registrado.");
        }
    }
      
       public void modificarInventarioDevuelto(Inventario pInventario,int pCantTotal)
            throws java.sql.SQLException, Exception {
        String sqlInventario;

        sqlInventario = "UPDATE TInventario "
                + "SET Cantidad =" + (pCantTotal+pInventario.getCantidad()) + " "
                + "WHERE IdArticulo = '" + pInventario.getIdArticulo() + "'";
        
        

       try {
            Conector.getConector().ejecutarSQL(sqlInventario);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Articulo no esta registrado.");
        }
    }
}
