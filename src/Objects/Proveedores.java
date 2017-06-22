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
public class Proveedores {

   
    
    protected int codProveedor;
    protected String nombre;
    protected String empresa;
    protected String telefonoUno;
    protected String telefonoDos;
    protected String email;

    public Proveedores() {
        
    }

    public Proveedores(int codProveedor, String empresa) {
        this.codProveedor = codProveedor;
        this.empresa = empresa;
    }

    public Proveedores(int codProveedor, String nombre, String empresa, String telefonoUno, String telefonoDos, String email) {
        this.codProveedor = codProveedor;
        this.nombre = nombre;
        this.empresa = empresa;
        this.telefonoUno = telefonoUno;
        this.telefonoDos = telefonoDos;
        this.email = email;
    }
    
    

    public Proveedores(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public Proveedores(String nombre) {
        this.nombre = nombre;
    }
    
    

    public Proveedores(String nombre, String empresa, String telefonoUno, String telefonoDos, String email) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.telefonoUno = telefonoUno;
        this.telefonoDos = telefonoDos;
        this.email = email;
    }

     /**
     * @return the codProveedor
     */
    public int getCodProveedor() {
        return codProveedor;
    }

    /**
     * @param codProveedor the codProveedor to set
     */
    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
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
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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

    @Override
    public String toString() {
        return "Datos de los Proveedores" +
               "\nNombre................:[" + nombre + "]"+
               "\nEmpresa...............:[" + empresa + "]"+
               "\nTelefono Uno..........:[" + telefonoUno + "]"+
               "\nTelefono Dos..........:[" + telefonoDos + "]"+
               "\nE-mail................:[" + email + "]";
    }
    
    
  
    
}
