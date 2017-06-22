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
public class MultiOpcionesUsuario {
    
     public  OpcionesUsuario crear(String pId, String pCompras, String pClientes, String pProveedores, String pInventario, String pPagos, String pConsignacion, String pReportes, String pFacturacion) 
			throws Exception{
		OpcionesUsuario unUsuario=null;
		String sql;
		sql = "INSERT INTO TOpcionesUsuario "+
		"(id, compras, clientes, proveedores, inventario, pagos, consignacion, reportes, facturacion) "+
		"VALUES ('"+pId+"','"+pCompras+"', '"+pClientes+"', '"+pProveedores+"', '"+pInventario+"', '"+pPagos+"', '"+pConsignacion+"', '"+pReportes+"', '"+pFacturacion+"');";
		try {
			//AccesoBD acceso = Conector.getConector();
			//acceso.ejecutarSQL(sql);
			Conector.getConector().ejecutarSQL(sql);
			unUsuario = new OpcionesUsuario (pId,pCompras,pClientes,pProveedores,pInventario,pPagos,pConsignacion,pReportes, pFacturacion);
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
		return unUsuario;
	}
    public  OpcionesUsuario buscarPorCedula(String pCedula) throws 
			java.sql.SQLException,Exception{
		OpcionesUsuario unUsuario=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT id, compras, clientes, proveedores, inventario, pagos, consignacion, reportes, facturacion " +
		"FROM TOpcionesUsuario "+
		"WHERE id='"+ pCedula +"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
                if (rs.next()) {
                    try{
                    
			unUsuario = new OpcionesUsuario(
                                    rs.getString("id"),
                                    rs.getString("compras"),
                                    rs.getString("clientes"),
                                    rs.getString("proveedores"),
                                    rs.getString("inventario"),
                                    rs.getString("pagos"),
                                    rs.getString("consignacion"),
                                    rs.getString("reportes"),
                                    rs.getString("facturacion"));
                                
                 
                                   
                    }catch(java.sql.SQLException e){
                        
			//throw new Exception (" Usuario no registrado.");
                       
                        
                        JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
                    }
                }
                rs.close();
		return unUsuario;
	}
    
    
    
   
    
    
}
