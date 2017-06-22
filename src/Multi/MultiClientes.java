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
public class MultiClientes {
    
     public  Clientes crear(String pCedula, String pNombre, String pAlias, String pTelefono1, String pTelefono2, String pEmail, String pDireccion, String pReferidoPor) 
			throws Exception{
		Clientes unCliente=null;
		String sql;
		sql = "INSERT INTO TClientes "+
		"(Cedula, NombreCliente, Alias, Telefono1, Telefono2, Email, Direccion, ReferidoPor) "+
		"VALUES ('"+pCedula+"', '"+pNombre+"', '"+pAlias+"', '"+pTelefono1+"', '"+pTelefono2+"', '"+pEmail+"', '"+pDireccion+"', '"+pReferidoPor+"');";
		try {
			//AccesoBD acceso = Conector.getConector();
			//acceso.ejecutarSQL(sql);
			Conector.getConector().ejecutarSQL(sql);
			unCliente = new Clientes (pCedula,pNombre,pAlias,pTelefono1,pTelefono2,pEmail,pDireccion,pReferidoPor);
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
		return unCliente;
	}
    public  Clientes buscarPorCedula(String pCedula) throws 
			java.sql.SQLException,Exception{
		Clientes unCliente=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT Cedula " +
		"FROM TClientes "+
		"WHERE Cedula='"+ pCedula +"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
                if (rs.next()) {
                    try{
                    
			unCliente = new Clientes(
                                    rs.getString("Cedula"));
                                   
                    }catch(java.sql.SQLException e){
                        
			//throw new Exception (" Usuario no registrado.");
                       
                        
                        JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
                    }
                }
                rs.close();
		return unCliente;
	}
    
     public ArrayList<Clientes> buscarCodCliente()
        throws java.sql.SQLException, Exception{
        String sql = "SELECT max(CodigoCliente) AS nuevoId from TClientes";
        java.sql.ResultSet rs;
        ArrayList<Clientes> cliente = new ArrayList();
        Clientes codigo = null;
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
         codigo =  new Clientes(rs.getInt("nuevoId"));
         cliente.add(codigo);
        }
        
        return cliente;
    }
    
     public Clientes buscarIdCliente(int pIdCliente)
        throws java.sql.SQLException, Exception{
        String sql = "SELECT CodigoCliente, Cedula, NombreCliente " +
                     "FROM TClientes " +
                     "WHERE CodigoCliente=" + pIdCliente+"";
        java.sql.ResultSet rs;
       // ArrayList<Clientes> cliente = new ArrayList();
        Clientes unCliente = null;
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
         unCliente =  new Clientes(rs.getInt("CodigoCliente"),
                                   rs.getString("Cedula"),
                                   rs.getString("NombreCliente"));
         
        // cliente.add(codigo);
        }
        
        return unCliente;
    }
    
    public  Clientes buscarPorNombreCliente(String pNombre) throws 
			java.sql.SQLException,Exception{
		Clientes unCliente=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT NombreCliente " +
		"FROM TClientes "+
		"WHERE NombreCliente='"+ pNombre +"'";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
                if (rs.next()) {
                    try{
                    
			unCliente = new Clientes(
                                    rs.getString("NombreCliente"));
                                   
                    }catch(java.sql.SQLException e){
                        
			//throw new Exception (" Usuario no registrado.");
                       
                        
                        JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
                    }
                }
                rs.close();
		return unCliente;
	}
   
    public  Clientes buscarClientePorNombre(String pNombre) throws 
			java.sql.SQLException,Exception{
		Clientes unCliente=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT CodigoCliente, Cedula, NombreCliente " +
		"FROM TClientes "+
		"WHERE NombreCliente='"+ pNombre +"'";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
                if (rs.next()) {
                    try{
                    
			unCliente = new Clientes(
                                      rs.getInt("CodigoCliente"),
                                      rs.getString("Cedula"),
                                      rs.getString("NombreCliente"));
                                   
                    }catch(java.sql.SQLException e){
                        
			//throw new Exception (" Usuario no registrado.");
                       
                        
                        JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
                    }
                }
                rs.close();
		return unCliente;
	}
    
    public ArrayList<Clientes> listar()
        throws java.sql.SQLException, Exception{
        String sql = "SELECT CodigoCliente, Cedula, NombreCliente, Alias FROM TClientes";
        java.sql.ResultSet rs;
        ArrayList<Clientes> cliente = new ArrayList<>();
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
          cliente.add((new Clientes(rs.getInt("CodigoCliente"), rs.getString("Cedula"), rs.getString("NombreCliente"), rs.getString("Alias"))));
        }
        
        return cliente;
    }
    
      public ArrayList<Clientes> buscarPorNombre(String pNombre)
        throws java.sql.SQLException, Exception{
        String sql = "SELECT * FROM TClientes WHERE NombreCliente LIKE '%" + pNombre + "%'";
        java.sql.ResultSet rs;
        ArrayList<Clientes> cliente = new ArrayList<>();
        
        rs = Conector.getConector().ejecutarSQL(sql, true);
        
        while (rs.next()){
          cliente.add((new Clientes(rs.getInt("CodigoCliente"), rs.getString("Cedula"), rs.getString("NombreCliente"), rs.getString("Alias"))));
        }
        
        return cliente;
    }
    
    
}
