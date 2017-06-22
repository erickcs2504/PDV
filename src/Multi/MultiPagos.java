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
public class MultiPagos {
    public  Pagos crear(int pCodPago, int pCodCliente, String pCedula, String pNombreCliente, LocalDate pFechaUltPago, String pTotal, String pAbono, String pSaldo, int pNumFactura) 
			throws Exception{
		Pagos unPago=null;
		String sql;
		sql = "INSERT INTO TPagos "+
		"(CodPago, IdCliente, Cedula, NombreCliente, FechaUltPago, Total, Abono, Saldo, numFactura ) "+
		"VALUES ('"+pCodPago+"','"+pCodCliente+"', '"+pCedula+"', '"+pNombreCliente+"', '"+pFechaUltPago+"', '"+pTotal+"','"+pAbono+"','"+pSaldo+"','"+pNumFactura+"');";
		try {
			//AccesoBD acceso = Conector.getConector();
			//acceso.ejecutarSQL(sql);
			Conector.getConector().ejecutarSQL(sql);
			unPago = new Pagos (pCodPago, pCodCliente, pCedula, pNombreCliente, pFechaUltPago, pTotal, pAbono, pSaldo, pNumFactura);
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
		return unPago;
	}
    public  Ventas buscarPorIdArticulo(String pIdArticulo) throws 
			java.sql.SQLException,Exception{
		Ventas unaVenta=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT idVenta, CodigoProducto, NombreProducto, Cantidad, PrecioVenta, Subtotal, Total, NombreCliente, FechaVenta, TipoVenta " +
		"FROM TVentas "+
		"WHERE CodigoProducto='"+ pIdArticulo +"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
                if (rs.next()) {
                    try{
                    
			unaVenta = new Ventas(
                                    rs.getInt("idVenta"),
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
     
      public ArrayList<Pagos> buscarCodPago()
        throws java.sql.SQLException, Exception{
        String sql = "SELECT max(CodPago) AS nuevoId from TPagos";
        java.sql.ResultSet rs;
        ArrayList<Pagos> pago = new ArrayList();
        Pagos noPago = null;
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
         noPago =  new Pagos(rs.getInt("nuevoId"));
         pago.add(noPago);
        }
        
        return pago;
    }
    
     public void eliminar(Ventas pVenta,int pCodVenta)
        throws java.sql.SQLException, Exception{
        String sql = "DELETE FROM TVentas WHERE idVenta= "+ pCodVenta+""+
                     "AND CodigoProducto = '"+ pVenta.getIdArticulo()+"'";
        Conector.getConector().ejecutarSQL(sql);
    }
     
      public void actualizarTotalVenta(Ventas pVentas,String pSaldo)
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
    }
      
    public void actualizarTotalVenta(Ventas pVenta, String pSaldo, String pTipoPago)
            throws java.sql.SQLException, Exception {
        String sqlVenta;

        sqlVenta = "UPDATE TVentas "
                + "SET Total ='" + pSaldo+ "', "
                + "TipoVenta = '" + pTipoPago +"'"
                + "WHERE CodigoProducto = '" + pVenta.getIdArticulo() + "'"
                + "AND idVenta = " + pVenta.getIdVenta()+"";
        
        

       try {
            Conector.getConector().ejecutarSQL(sqlVenta);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Articulo no esta registrado.");
        }
    }
    
    public Pagos buscarPagosPorFactura(int pNumFactura)
        throws java.sql.SQLException, Exception{
        String sql = "SELECT IdCliente, Cedula, NombreCliente, FechaUltPago, Total, Abono, Saldo, numFactura " +
                     "FROM TPagos " +
                     "WHERE numFactura =" + pNumFactura+"";
        java.sql.ResultSet rs;
       // ArrayList<Clientes> cliente = new ArrayList();
        Pagos unPago = null;
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
         unPago =  new Pagos(rs.getInt("IdCliente"),
                                   rs.getString("Cedula"),
                                   rs.getString("NombreCliente"),
                                   rs.getDate("FechaUltPago").toLocalDate(),
                                   rs.getString("Total"),
                                   rs.getString("Abono"),
                                   rs.getString("Saldo"),
                                   rs.getInt("numFactura"));
                                   
                                   
         
        // cliente.add(codigo);
        }
        
        return unPago;
    }
    
    public Pagos buscarPagosPorCedula(String pCedula)
        throws java.sql.SQLException, Exception{
        String sql = "SELECT IdCliente, Cedula, NombreCliente, FechaUltPago, Total, Abono, Saldo, numFactura " +
                     "FROM TPagos " +
                     "WHERE Cedula ='" + pCedula+"'";
        java.sql.ResultSet rs;
       // ArrayList<Clientes> cliente = new ArrayList();
        Pagos unPago = null;
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
         unPago =  new Pagos(rs.getInt("IdCliente"),
                                   rs.getString("Cedula"),
                                   rs.getString("NombreCliente"),
                                   rs.getDate("FechaUltPago").toLocalDate(),
                                   rs.getString("Total"),
                                   rs.getString("Abono"),
                                   rs.getString("Saldo"),
                                   rs.getInt("numFactura"));
                                   
                                   
         
        // cliente.add(codigo);
        }
        
        return unPago;
    }
    public Pagos buscarPagosPorNombre(String pNombre)
        throws java.sql.SQLException, Exception{
        String sql = "SELECT IdCliente, Cedula, NombreCliente, FechaUltPago, Total, Abono, Saldo, numFactura " +
                     "FROM TPagos " +
                     "WHERE NombreCliente ='" + pNombre+"'";
        java.sql.ResultSet rs;
       // ArrayList<Clientes> cliente = new ArrayList();
        Pagos unPago = null;
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
         unPago =  new Pagos(rs.getInt("IdCliente"),
                                   rs.getString("Cedula"),
                                   rs.getString("NombreCliente"),
                                   rs.getDate("FechaUltPago").toLocalDate(),
                                   rs.getString("Total"),
                                   rs.getString("Abono"),
                                   rs.getString("Saldo"),
                                   rs.getInt("numFactura"));
                                   
                                   
         
        // cliente.add(codigo);
        }
        
        return unPago;
    }
   
    public  ArrayList<Pagos> buscarFechaCierreCredito(LocalDate pFecha) throws 
			java.sql.SQLException,Exception{
		Pagos unPago=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT  FechaUltPago,Abono,Saldo " +
		"FROM TPagos "+
		"WHERE FechaUltPago='"+ pFecha +"';";
		ArrayList<Pagos> pago = new ArrayList<>();
                rs = Conector.getConector().ejecutarSQL(sql,true);
		
               while (rs.next()){
               pago.add((new Pagos(rs.getDate("FechaUltPago").toLocalDate(),
                                   rs.getString("Abono"),
                                   rs.getString("Saldo"))));
        }
        
        return pago;
  }
  
   public  ArrayList<Pagos> buscarCxC() throws 
			java.sql.SQLException,Exception{
		Pagos unPago=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT  FechaUltPago,Abono, Saldo " +
		      "FROM TPagos ";
		//"WHERE FechaUltPago='"+ pFecha +"';";
		ArrayList<Pagos> pago = new ArrayList<>();
                rs = Conector.getConector().ejecutarSQL(sql,true);
		
               while (rs.next()){
               pago.add((new Pagos(rs.getDate("FechaUltPago").toLocalDate(),
                                   rs.getString("Abono"),
                                   rs.getString("Saldo"))));
        }
        
        return pago;
  }
    
}
