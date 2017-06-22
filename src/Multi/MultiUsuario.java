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
public class MultiUsuario {
    
    public  Usuario crear(String pId, String pNombre,String pApellidos,String pTelefono,String pRol, String pDireccion,String pEmail,LocalDate pFNac) 
			throws Exception{
		Usuario unUsuario=null;
		String sql;
		sql = "INSERT INTO TUsuarios "+
		"(id, nombre, apellidos, telefono, rol, direccion, email, fechaNacimiento) "+
		"VALUES ('"+pId+"', '"+pNombre+"', '"+pApellidos+"', '"+pTelefono+"', '"+pRol+"', '"+pDireccion+"', '"+pEmail+"', '"+pFNac+"');";
		try {
			//AccesoBD acceso = Conector.getConector();
			//acceso.ejecutarSQL(sql);
			Conector.getConector().ejecutarSQL(sql);
			unUsuario = new Usuario (pId,pNombre,pApellidos,pTelefono,pRol,pDireccion,pEmail,pFNac);
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
    public  Usuario buscarPorId(String pId) throws 
			java.sql.SQLException,Exception{
		Usuario unUsuario=null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT id, nombre, apellidos, telefono, rol, direccion, email " +
		"FROM TUsuarios "+
		"WHERE id='"+ pId+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
                if (rs.next()) {
                    try{
                    
			unUsuario = new Usuario(
                                    rs.getString("id"),
                                    rs.getString("nombre"),
				    rs.getString("apellidos"),
				    rs.getString("telefono"),
				    rs.getString("rol"),
                                    rs.getString("direccion"),
                                    rs.getString("email"));
                                   
                    }catch(java.sql.SQLException e){
                        
			//throw new Exception (" Usuario no registrado.");
                        JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
                    }
                }
                rs.close();
		return unUsuario;
	}
    
	
	
    
}
