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
public class MultiProveedor {
    
    public  Proveedores crear(String pNombre, String pEmpresa, String pTelefonoUno, String pTelefonoDos, String pEmail) 
			throws Exception{
		Proveedores unProveedor=null;
		String sql;
		sql = "INSERT INTO TProveedor "+
		"(NombreProveedor, Empresa, Telefono1, Telefono2, Email) "+
		"VALUES ('"+pNombre+"', '"+pEmpresa+"', '"+pTelefonoUno+"', '"+pTelefonoDos+"', '"+pEmail+"');";
		try {
			//AccesoBD acceso = Conector.getConector();
			//acceso.ejecutarSQL(sql);
			Conector.getConector().ejecutarSQL(sql);
			unProveedor = new Proveedores (pNombre,pEmpresa,pTelefonoUno,pTelefonoDos,pEmail);
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
		return unProveedor;
	}
   
    
     public ArrayList<Proveedores> buscarCodProveedor()
        throws java.sql.SQLException, Exception{
        String sql = "SELECT max(CodigoProveedor) AS nuevoId from TProveedor";
        java.sql.ResultSet rs;
        ArrayList<Proveedores> proveedor = new ArrayList();
        Proveedores codProveedor = null;
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
         codProveedor =  new Proveedores(rs.getInt("nuevoId"));
         proveedor.add(codProveedor);
        }
        
        return proveedor;
    }
     
      public ArrayList<Proveedores> buscarPorNombre(String pNombre)
        throws java.sql.SQLException, Exception{
        String sql = "SELECT * FROM TProveedor WHERE Empresa LIKE '%" + pNombre + "%'";
        java.sql.ResultSet rs;
        ArrayList<Proveedores> proveedor = new ArrayList<>();
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
          proveedor.add((new Proveedores(rs.getInt("CodigoProveedor"), rs.getString("Empresa"))));
        }
        
        return proveedor;
    }
    
      public ArrayList<Proveedores> listar()
        throws java.sql.SQLException, Exception{
        String sql = "SELECT CodigoProveedor, Empresa FROM TProveedor";
        java.sql.ResultSet rs;
        ArrayList<Proveedores> proveedor = new ArrayList<>();
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
          proveedor.add((new Proveedores(rs.getInt("CodigoProveedor"), rs.getString("Empresa"))));
        }
        
        return proveedor;
    }
    
      public  Proveedores buscarProveedorPorNombre(String pNombre) throws 
			java.sql.SQLException,Exception{
		Proveedores unProveedor=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * " +
		"FROM TProveedor "+
		"WHERE Empresa='"+ pNombre +"'";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
                if (rs.next()) {
                    try{
                    
			unProveedor = new Proveedores(
                                      rs.getInt("CodigoProveedor"),
                                      rs.getString("NombreProveedor"),
                                      rs.getString("Empresa"),
                                      rs.getString("Telefono1"),
                                      rs.getString("Telefono2"),
                                      rs.getString("Email"));
                                   
                    }catch(java.sql.SQLException e){
                        
			//throw new Exception (" Usuario no registrado.");
                       
                        
                        JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
                    }
                }
                rs.close();
		return unProveedor;
	}
    
}
