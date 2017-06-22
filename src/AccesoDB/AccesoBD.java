package AccesoDB;
/**
 *Clase AccesoBD
 *@version 2.0
 *@author Laura Monge Izaguirre
 *Clase que maneja el acceso a la base de datos.
 *Se debe hacer una instancia de la
 *clase para poder utilizar sus servicios
 *
 *
 */
import java.sql.*;

public class AccesoBD{
	//atributos del objeto
	private Connection conn=null;
	private Statement st;
	
	/**
	 *M�todo constructor que recibe todos
	 *los par�metros necesarios para abrir
	 *una conexi�n v�lida
	 *@param driver especificaci�n del tipo
	 *de driver que se utiliza, el cual responde
	 *al repositorio utilizado
	 *@param conexion cadena de conexi�n con la
	 *base de datos
	 *@param usuario nombre del usuario de la base 
	 *de datos, si no se utiliza, se debe enviar
	 *un string vac�o
	 *@param clave palabra clave del usuario
	 *para realizar su autenticaci�n en la base
	 *de datos
	 */
//	public AccesoBD(String driver, String conexion,	String usuario, String clave) throws SQLException,Exception{
//		Class.forName(driver);
//		conn = DriverManager.getConnection(conexion, usuario, clave);
//		st = conn.createStatement();
//	}
	
	public AccesoBD(String driver,String conexion) throws SQLException,Exception{
		Class.forName(driver);
		conn = DriverManager.getConnection(conexion);
		st = conn.createStatement();
	}
	
	/**
	 *M�todo que ejecuta una sentencia en la
	 *base de datos, la cual no tiene retorno,
	 *es decir un insert, delete o update
	 *@param sentencia cadena sql que ser�
	 *ejecutada en la base de datos
	 *
	 */
	
	public void ejecutarSQL(String sentencia) 
	throws SQLException,Exception{	
		st.execute(sentencia);		
	}
	
	/**
	 *M�todo que ejecuta una sentencia en la
	 *base de datos y devuelve un ResultSet
	 *con los resultados	 
	 *@param sentencia cadena sql que ser�
	 *ejecutada en la base de datos
	 *@param retorno booleana que indica que se
	 *desea un resultado de la consulta
	 */	
	public ResultSet ejecutarSQL(String sentencia,
	boolean retorno)
	throws SQLException,Exception{
		ResultSet rs;
		rs = st.executeQuery(sentencia);
		return rs;
	}
	
	/**
	 *Permite controlar el inicio una transacci�n 
	 *desde afuera.  A partir de este momento 
	 *todas las sentencias esperar�n la orden para
	 *ser aceptadas en la base de datos
	 *
	 */
	public void iniciarTransaccion()
	throws java.sql.SQLException{
		conn.setAutoCommit(false);	
	}
	
	/**
	 *Permite controlar el t�rmino una transacci�n 
	 *desde afuera.  A partir de este momento 
	 *todas las sentencias se ejectur�n de forma
	 *individual en la base de datos
	 *
	 */
	
	public void terminarTransaccion()
	throws java.sql.SQLException{
		conn.setAutoCommit(true);
	}
	
	/**
	 *Indica que la transacci�n ha sido aceptada
	 *
	 */	
	
	public void aceptarTransaccion()
	throws java.sql.SQLException{
		conn.commit();
	}
	
	/**
	 *Indica que la transacci�n debe ser
	 *deshecha porque no se realiz� de
	 *forma exitosa
	 *
	 */	
	
	public void deshacerTransaccion()
	throws java.sql.SQLException{
		conn.rollback();	
	}
	
	/**
	 *M�todo sobreescrito de la clase Object
	 *que es invocado por el Garbage Collector
	 *cuando es invocado libera la conexi�n
	 *abierta durante la creaci�n del objeto
	 *
	 */
	protected void finalize(){
		try {
			conn.close();	
		}
		catch(Exception e){
			/*este m�todo es llamado por el
			 *garbage collector, por lo tanto
			 *se atrapa la excepci�n pero no se
			 *reporta*/			
		}
	}				
}