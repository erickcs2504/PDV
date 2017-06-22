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
import UI.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
/**
 *
 * @author Erick Cordero
 */
public class MultiAccount {
    
    public  Account crear(String pId, String pClave) 
			throws Exception{
		Account unaCuenta=null;
		String sql;
		sql = "INSERT INTO TAccount "+
		"(userName, clave) "+
		"VALUES ('"+pId+"', '"+pClave+"');";
		try {
			//AccesoBD acceso = Conector.getConector();
			//acceso.ejecutarSQL(sql);
			Conector.getConector().ejecutarSQL(sql);
			unaCuenta = new Account (pId,pClave);
                        
                        
		}
		catch(java.sql.SQLException e)
		{
			throw e;
		}
		catch (Exception e) {
			throw e;
			//throw new Exception ("El número de ntificación ya está en el sistema.");
		}
		return unaCuenta;
	}
    
    public  Account buscar(String pId) throws 
			java.sql.SQLException,Exception{
		Account unUsuario=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT userName, clave "+
		"FROM TAccount "+
		"WHERE userName='"+ pId+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()) {
			unUsuario = new Account (rs.getString("userName"), rs.getString("clave"));
		} else {
			throw new Exception (" Usuario no registrado.");
		}
		rs.close();
		return unUsuario;
	}
    
}
