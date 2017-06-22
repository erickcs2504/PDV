package AccesoDB;
/**
 * Universidad Cenfotec
 * Programación orientada a objetos
 * Proyecto Final
 * Prof. Alvaro Cordero
 * Estudiantes:
 * @author Erick Cordero
 * @author Alex Fernandez
 */
 
public class Conector{
    private static AccesoBD conectorBD = null;

    /**
     * Metodo que retorna el objeto de acceso a los datos;
     * @return connector a la base de datos
     * @throws java.sql.SQLException
     * @throws Exception 
     */
    public static AccesoBD getConector() throws java.sql.SQLException,Exception{
        /* Datos de connecion */
        String server = "ERICKCORDERO-PC"; 
        String dbName = "PDV"; 
        String user = "sa"; 
        String password = "egcs2504"; 
        
        if(conectorBD==null){
            conectorBD = new AccesoBD("com.microsoft.sqlserver.jdbc.SQLServerDriver","jdbc:sqlserver://" + server + ";DatabaseName=" +dbName+ ";user=" + user + ";password=" + password);
        }
        return conectorBD;
    }
}