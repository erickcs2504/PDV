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
public class MultiCompras {
     public  Compras crear(int pIdCompra, String pIdArticulo, String pNombreArticulo, int pCantidadActual, int pAgregarCantidad, int pCantidadTotal, String pPrecioCompra, String pPrecioVenta, String pSubTotal, String pTotal, String pProveedor, LocalDate pFechaCompra,String pTipoCompra, String pNumFactura) 
			throws Exception{
		Compras unaCompra=null;
		String sql;
		sql = "INSERT INTO TCompras "+
		"(IdCompra, CodigoProducto, NombreProducto, CantidadActual, AgregarCantidad, CantidadTotal, PrecioCompra, PrecioVenta, SubTotal, Total, Proveedor, FechaCompra, TipoCompra, numFactura) "+
		"VALUES ('"+pIdCompra+"','"+pIdArticulo+"', '"+pNombreArticulo+"', '"+pCantidadActual+"', '"+pAgregarCantidad+"', '"+pCantidadTotal+"','"+pPrecioCompra+"', '"+pPrecioVenta+"', '"+ pSubTotal +"', '"+ pTotal + "', '" + pProveedor +"', '" + pFechaCompra +"','" + pTipoCompra +"','" + pNumFactura +"');";
		try {
			//AccesoBD acceso = Conector.getConector();
			//acceso.ejecutarSQL(sql);
			Conector.getConector().ejecutarSQL(sql);
			unaCompra = new Compras (pIdCompra, pIdArticulo, pNombreArticulo, pCantidadActual, pAgregarCantidad, pCantidadTotal, pPrecioCompra, pPrecioVenta, pSubTotal, pTotal, pProveedor, pFechaCompra, pTipoCompra, pNumFactura);
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
		return unaCompra;
	}
    public  Compras buscarPorIdArticulo(String pIdArticulo) throws 
			java.sql.SQLException,Exception{
		Compras unaCompra=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT CodigoProducto, NombreProducto, CantidadActual, AgregarCantidad, PrecioCompra, PrecioVenta, SubTotal,Total,Proveedor,FechaCompra,TipoCompra " +
		"FROM TCompras "+
		"WHERE CodigoProducto='"+ pIdArticulo +"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
                if (rs.next()) {
                    try{
                    
			unaCompra = new Compras(
                                    rs.getString("CodigoProducto"),
                                    rs.getString("NombreProducto"),
                                    rs.getInt("CantidadActual"),
                                    rs.getInt("AgregarCantidad"),
                                    rs.getInt("CantidadTotal"),
                                    rs.getString("PrecioCompra"),
                                    rs.getString("PrecioVenta"),
                                    rs.getString("SubTotal"),
                                    rs.getString("Total"),
                                    rs.getString("Proveedor"),
                                    rs.getDate("FechaCompra").toLocalDate(),
                                    rs.getString("TipoCompra"));
                                   
                    }catch(java.sql.SQLException e){
                        
			//throw new Exception (" Usuario no registrado.");
                       
                        
                        JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
                    }
                }
                rs.close();
		return unaCompra;
	}
    public ArrayList <Compras> listar(int pIdCompra)
        throws java.sql.SQLException, Exception{
        String sql = "SELECT AgregarCantidad, CodigoProducto, NombreProducto, PrecioCompra, SubTotal FROM TCompras WHERE IdCompra=" + pIdCompra;
        java.sql.ResultSet rs;
        ArrayList<Compras> compras = new ArrayList<>();
        Compras unaCompra=null;
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
          compras.add((new Compras(rs.getInt("AgregarCantidad"),
                                   rs.getString("CodigoProducto"),
                                   rs.getString("NombreProducto"),
                                   rs.getString("PrecioCompra"),
                                   rs.getString("SubTotal"))));
        }
        
        return compras;
    }
    
    
     public ArrayList<Compras> buscarPorNombre(String pNombre)
        throws java.sql.SQLException, Exception{
        String sql = "SELECT AgregarCantidad, CodigoProducto, NombreProducto, PrecioCompra, SubTotal FROM TCompras  WHERE NombreProducto LIKE '%" + pNombre + "%'";
        java.sql.ResultSet rs;
        ArrayList<Compras> compras = new ArrayList<>();
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
          compras.add((new Compras(rs.getInt("AgregarCantidad"),
                                   rs.getString("CodigoProducto"),
                                   rs.getString("NombreProducto"),
                                   rs.getString("PrecioCompra"),
                                   rs.getString("SubTotal"))));
        }
        
        return compras;
    }
     
      public ArrayList<Compras> buscarCodCompra()
        throws java.sql.SQLException, Exception{
        String sql = "SELECT max(IdCompra) AS nuevoId from TCompras";
        java.sql.ResultSet rs;
        ArrayList<Compras> compra = new ArrayList();
        Compras noCompra = null;
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
         noCompra =  new Compras(rs.getInt("nuevoId"));
         compra.add(noCompra);
        }
        
        return compra;
    }
    
     public void eliminar(Compras pCompra,int pCodCompra)
        throws java.sql.SQLException, Exception{
        String sql = "DELETE FROM TCompras WHERE IdCompra= "+ pCodCompra+""+
                     "AND CodigoProducto = '"+ pCompra.getIdArticulo()+"'";
        Conector.getConector().ejecutarSQL(sql);
    }
    
    public void cancelarCompra(int pCodCompra)
        throws java.sql.SQLException, Exception{
        String sql = "DELETE FROM TCompras WHERE IdCompra= "+ pCodCompra+"";
                     
        Conector.getConector().ejecutarSQL(sql);
    }
    public void actualizarTotalCompra(Compras pCompra, String pSaldo,String pTipoCompra)
            throws java.sql.SQLException, Exception {
        String sqlCompra;

        sqlCompra = "UPDATE TCompras "
                + "SET Total = '" + pSaldo+ "', "
                + "TipoCompra = '" + pTipoCompra +"'"
                + "WHERE CodigoProducto = '" + pCompra.getIdArticulo() + "'"
                + "AND IdCompra = " + pCompra.getCodCompra()+"";
        
        

       try {
            Conector.getConector().ejecutarSQL(sqlCompra);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Articulo no esta registrado.");
        }
    }
    
    public  ArrayList<Compras> buscarFacturasDeCompras() throws 
			java.sql.SQLException,Exception{
		Compras unaCompra=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT  SubTotal, FechaCompra " +
		      "FROM TCompras ";
		//"WHERE FechaUltPago='"+ pFecha +"';";
		ArrayList<Compras> compra = new ArrayList<>();
                rs = Conector.getConector().ejecutarSQL(sql,true);
		
               while (rs.next()){
               compra.add((new Compras(rs.getString("SubTotal"),
                                     rs.getDate("FechaCompra").toLocalDate())));
                                   
        }
        
        return compra;
  }
     
    
}
