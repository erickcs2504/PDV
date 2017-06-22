/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Erick Cordero
 */
public class Clientes {

   
    
    protected int codCliente;
    protected String cedula;
    protected String nombre;
    protected String alias;
    protected String telefonoUno;
    protected String telefonoDos;
    protected String email;
    protected String direccion;
    protected String referidoPor;

    public Clientes() {
        
    }

    public Clientes(int pCodCliente){
        this.codCliente=pCodCliente;
    }

    public Clientes(int codCliente, String cedula, String nombre, String alias) {
        this.codCliente = codCliente;
        this.cedula = cedula;
        this.nombre = nombre;
        this.alias = alias;
    }
    
    
    public Clientes(String cedula) {
        this.cedula = cedula;
    }

    public Clientes(int codCliente, String cedula, String nombre) {
        this.codCliente = codCliente;
        this.cedula = cedula;
        this.nombre = nombre;
    }
    
   
    
    public Clientes(String cedula, String nombre, String alias, String telefonoUno, String telefonoDos, String email, String direccion, String referidoPor) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.alias = alias;
        this.telefonoUno = telefonoUno;
        this.telefonoDos = telefonoDos;
        this.email = email;
        this.direccion = direccion;
        this.referidoPor = referidoPor;
    }

    /**
     * @return the codCliente
     */
    public int getCodCliente() {
        return codCliente;
    }

    /**
     * @param codCliente the codCliente to set
     */
    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    
    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * @return the telefonoUno
     */
    public String getTelefonoUno() {
        return telefonoUno;
    }

    /**
     * @param telefonoUno the telefonoUno to set
     */
    public void setTelefonoUno(String telefonoUno) {
        this.telefonoUno = telefonoUno;
    }

    /**
     * @return the telefonoDos
     */
    public String getTelefonoDos() {
        return telefonoDos;
    }

    /**
     * @param telefonoDos the telefonoDos to set
     */
    public void setTelefonoDos(String telefonoDos) {
        this.telefonoDos = telefonoDos;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the referidoPor
     */
    public String getReferidoPor() {
        return referidoPor;
    }

    /**
     * @param referidoPor the referidoPor to set
     */
    public void setReferidoPor(String referidoPor) {
        this.referidoPor = referidoPor;
    }

    @Override
    public String toString() {
        return "Datos de los Clientes" + 
               "\nCedula.............:[" + cedula + "]"+
               "\nNombre.............:[" + nombre + "]"+
               "\nAlias..............:[" + alias + "]"+
               "\nTelefono Uno.......:[" + telefonoUno + "]"+
               "\nTelefono Dos.......:[" + telefonoDos + "]"+
               "\nE-mail.............:[" + email + "]"+
               "\nDireccion..........:[" + direccion + "]"+
               "\nReferido Por........:[" + referidoPor + "]";
    }
    
    
          
          
    
}
