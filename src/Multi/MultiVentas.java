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
public class MultiVentas {
    
    public  Ventas crear(int pIdVenta,String pIdArticulo, String pNombreArticulo, String pPrecioVenta, int pCantidad, String pSubTotal, String pTotal, String pCliente, LocalDate pFechaVenta, String pTipoVenta) 
			throws Exception{
		Ventas unaVenta=null;
		String sql;
		sql = "INSERT INTO TVentas "+
		"(IdVenta, CodigoProducto, NombreProducto, PrecioVenta, Cantidad, SubTotal, Total, NombreCliente, FechaVenta, TipoVenta) "+
		"VALUES ('"+pIdVenta+"','"+pIdArticulo+"', '"+pNombreArticulo+"', '"+pPrecioVenta+"', '"+pCantidad+"', '"+pSubTotal+"','"+pTotal+"', '"+pCliente+"', '"+ pFechaVenta +"', '"+ pTipoVenta + "');";
		try {
			//AccesoBD acceso = Conector.getConector();
			//acceso.ejecutarSQL(sql);
			Conector.getConector().ejecutarSQL(sql);
			unaVenta = new Ventas (pIdVenta, pIdArticulo, pNombreArticulo, pPrecioVenta, pCantidad, pSubTotal, pTotal, pCliente, pFechaVenta , pTipoVenta);
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
		return unaVenta;
	}
    public  Ventas buscarPorIdArticulo(String pIdArticulo) throws 
			java.sql.SQLException,Exception{
		Ventas unaVenta=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT IdVenta, CodigoProducto, NombreProducto, Cantidad, PrecioVenta, Subtotal, Total, NombreCliente, FechaVenta, TipoVenta " +
		"FROM TVentas "+
		"WHERE CodigoProducto='"+ pIdArticulo +"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
                if (rs.next()) {
                    try{
                    
			unaVenta = new Ventas(
                                    rs.getInt("IdVenta"),
                                    rs.getString("CodigoProducto"),
                                    rs.getString("NombreProducto"),
                                    rs.getString("PrecioVenta"),
                                    rs.getInt("Cantidad"),
                                    rs.getString("SubTotal"),
                                    rs.getString("Total"),
                                    rs.getString("NombreCliente"),
                                    rs.getDate("FechaVenta").toLocalDate(),
                                    rs.getString("TipoVenta"));
                                   
                    }catch(java.sql.SQLException e){
                        
			//throw new Exception (" Usuario no registrado.");
                       
                        
                        JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
                    }
                }
                rs.close();
		return unaVenta;
	}
    
    public  ArrayList<Ventas> buscarPorCodVenta(int pCodVenta) throws 
			java.sql.SQLException,Exception{
		Ventas venta=null;
                ArrayList<Ventas> unaVenta=new ArrayList<>();
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT IdVenta, CodigoProducto, NombreProducto, Cantidad, PrecioVenta, Subtotal, Total, NombreCliente, FechaVenta, TipoVenta " +
		"FROM TVentas "+
		"WHERE IdVenta="+ pCodVenta +"";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
                while (rs.next()) {
                    try{
                    
			unaVenta.add(( new Ventas(
                                    rs.getInt("IdVenta"),
                                    rs.getString("CodigoProducto"),
                                    rs.getString("NombreProducto"),
                                    rs.getString("PrecioVenta"),
                                    rs.getInt("Cantidad"),
                                    rs.getString("SubTotal"),
                                    rs.getString("Total"),
                                    rs.getString("NombreCliente"),
                                    rs.getDate("FechaVenta").toLocalDate(),
                                    rs.getString("TipoVenta"))));
                                   
                    }catch(java.sql.SQLException e){
                        
			//throw new Exception (" Usuario no registrado.");
                       
                        
                        JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
                    }
                }
                rs.close();
		return unaVenta;
	}
    public ArrayList <Ventas> listar(int pIdVenta)
        throws java.sql.SQLException, Exception{
        String sql = "SELECT Cantidad, CodigoProducto, NombreProducto, PrecioVenta, Subtotal FROM TVentas WHERE idVenta=" + pIdVenta;
        java.sql.ResultSet rs;
        ArrayList<Ventas> ventas = new ArrayList<>();
        Ventas unaVenta=null;
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
          ventas.add((new Ventas(rs.getInt("Cantidad"),
                                   rs.getString("CodigoProducto"),
                                   rs.getString("NombreProducto"),
                                   rs.getString("PrecioVenta"),
                                   rs.getString("Subtotal"))));
        }
        
        return ventas;
    }
    
    
     public ArrayList<Ventas> buscarPorNombreProducto(String pNombre)
        throws java.sql.SQLException, Exception{
        String sql = "SELECT Cantidad, CodigoProducto, NombreProducto, PrecioVenta, Subtotal FROM TVentas  WHERE NombreProducto LIKE '%" + pNombre + "%'";
        java.sql.ResultSet rs;
        ArrayList<Ventas> ventas = new ArrayList<>();
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
          ventas.add((new Ventas(rs.getInt("Cantidad"),
                                   rs.getString("CodigoProducto"),
                                   rs.getString("NombreProducto"),
                                   rs.getString("PrecioCompra"),
                                   rs.getString("Subtotal"))));
        }
        
        return ventas;
    }
     
      public ArrayList<Ventas> buscarCodVenta()
        throws java.sql.SQLException, Exception{
        String sql = "SELECT max(IdVenta) AS nuevoId from TVentas";
        java.sql.ResultSet rs;
        ArrayList<Ventas> venta = new ArrayList();
        Ventas noVenta = null;
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
         noVenta =  new Ventas(rs.getInt("nuevoId"));
         venta.add(noVenta);
        }
        
        return venta;
    }
    
     public void eliminar(Ventas pVenta,int pCodVenta)
        throws java.sql.SQLException, Exception{
        String sql = "DELETE FROM TVentas WHERE IdVenta= "+ pCodVenta+""+
                     "AND CodigoProducto = '"+ pVenta.getIdArticulo()+"'";
        Conector.getConector().ejecutarSQL(sql);
    }
     
      /*public void actualizarTotalVenta(Ventas pVentas,String pSaldo)
            throws java.sql.SQLException, Exception {
        String sqlVentas;

        sqlVentas = "UPDATE TVentas "
                + "SET Total ='" + (pSaldo) + "'"
                + "WHERE IdArticulo = '" + pVentas.getIdArticulo() + "'"
                + "AND idVenta= " + pVentas.getIdVenta()+"";
     
       try {
            Conector.getConector().ejecutarSQL(sqlVentas);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Articulo no esta registrado.");
        }
    }*/
      
    public void actualizarTotalVenta(Ventas pVenta,String pTipoPago)
            throws java.sql.SQLException, Exception {
        String sqlVenta;

        sqlVenta = "UPDATE TVentas "
                + "SET TipoVenta = '" + pTipoPago +"'"
                + "WHERE IdVenta = " + pVenta.getIdVenta()+"";
        
        

       try {
            Conector.getConector().ejecutarSQL(sqlVenta);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Articulo no esta registrado.");
        }
    }
    
    public void actualizarTotalVentaDos(Ventas pVenta,String pTotal)
            throws java.sql.SQLException, Exception {
        String sqlVenta;

        sqlVenta = "UPDATE TVentas "
                + "SET Total = '" + pTotal +"'"
                + "WHERE IdVenta = " + pVenta.getIdVenta()+"";
        
        

       try {
            Conector.getConector().ejecutarSQL(sqlVenta);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Articulo no esta registrado.");
        }
    }
    
    public void actualizarVentaContadoConDescuento(Ventas pVenta, String codArt, String total)
           throws java.sql.SQLException, Exception{
        String sqlVenta;

        sqlVenta = "UPDATE TVentas "
                + "SET Total = '" + total +"'"
                + "WHERE CodigoProducto = '" + codArt+ "'"
                + "AND IdVenta= " + pVenta.getIdVenta()+"";
        
        

       try {
            Conector.getConector().ejecutarSQL(sqlVenta);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Articulo no esta registrado.");
        }
        
        
    }
     public  ArrayList<Ventas> buscarFechaVenta(LocalDate pFecha) throws 
			java.sql.SQLException,Exception{
		Ventas unaVenta=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT  Total, FechaVenta, TipoVenta " +
		"FROM TVentas "+
		"WHERE FechaVenta='"+ pFecha +"';";
		ArrayList<Ventas> ventas = new ArrayList<>();
                rs = Conector.getConector().ejecutarSQL(sql,true);
		
               while (rs.next()){
               ventas.add((new Ventas(rs.getString("Total"),
                                   rs.getDate("FechaVenta").toLocalDate(),
                                   rs.getString("TipoVenta"))));
        }
        
        return ventas;
  }
     
 public  ArrayList<Ventas> buscarVentasConsignacion(int pIdFactura) throws 
			java.sql.SQLException,Exception{
		//Ventas unaVenta=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * " +
		"FROM TVentas "+
		"WHERE IdVenta ="+ pIdFactura +";";
		ArrayList<Ventas> ventas = new ArrayList<>();
                rs = Conector.getConector().ejecutarSQL(sql,true);
		
               while (rs.next()){
               ventas.add((new Ventas(rs.getInt("IdVenta"),
                                   rs.getString("CodigoProducto"),
                                   rs.getString("NombreProducto"),
                                   rs.getString("PrecioVenta"),
                                   rs.getInt("Cantidad"),
                                   rs.getString("SubTotal"),
                                   rs.getString("Total"),
                                   rs.getString("NombreCliente"),
                                   rs.getDate("FechaVenta").toLocalDate(),
                                   rs.getString("TipoVenta"))));
                       
        }
        
        return ventas;
  }
 
  public  ArrayList<Ventas> buscarFacturas() throws 
			java.sql.SQLException,Exception{
		Ventas unaVenta=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT  Total, FechaVenta " +
		      "FROM TVentas ";
		//"WHERE FechaUltPago='"+ pFecha +"';";
		ArrayList<Ventas> venta = new ArrayList<>();
                rs = Conector.getConector().ejecutarSQL(sql,true);
		
               while (rs.next()){
               venta.add((new Ventas(rs.getString("Total"),
                                     rs.getDate("FechaVenta").toLocalDate())));
                                   
        }
        
        return venta;
  }
  
   public ArrayList<Ventas> buscarTipoVenta() throws 
			java.sql.SQLException,Exception{
		Ventas venta=null;
                ArrayList<Ventas> unaVenta=new ArrayList<>();
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT  *" +
		      "FROM TVentas ";
		//"WHERE FechaUltPago='"+ pFecha +"';";
		
                rs = Conector.getConector().ejecutarSQL(sql,true);
		
               while (rs.next()){
               unaVenta.add((new Ventas(rs.getInt("IdVenta"),
                                   rs.getString("CodigoProducto"),
                                   rs.getString("NombreProducto"),
                                   rs.getString("PrecioVenta"),
                                   rs.getInt("Cantidad"),
                                   rs.getString("SubTotal"),
                                   rs.getString("Total"),
                                   rs.getString("NombreCliente"),
                                   rs.getDate("FechaVenta").toLocalDate(),
                                   rs.getString("TipoVenta"))));
                                   
        }
        
        return unaVenta;
  }
  
  public void cancelarVenta(int pCodVenta)
        throws java.sql.SQLException, Exception{
        String sql = "DELETE FROM TVentas WHERE IdVenta= "+ pCodVenta+"";
                     
        Conector.getConector().ejecutarSQL(sql);
    }
                
   
    
}
