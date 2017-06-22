/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.time.LocalDate;

/**
 *
 * @author Erick Cordero
 */
public class Usuario {
/**
 *
 * @author Erick Cordero
 */
    protected String id;
    protected String nombre;
    protected String apellidos;
    protected String telefono;
    protected String rol;
    protected String direccion;
    protected String correo;
    protected LocalDate fechaNacimiento;

    public Usuario()
    {
        
    }
    public Usuario(String id)
    {
        this.id=id;
    }
    
    public Usuario(String id,String nombre, String apellidos)
    {
        this.id=id;
        this.nombre=nombre;
        this.apellidos=apellidos;
        
    }
   
    
    public Usuario(String id,String nombre,String apellidos, String telefono, String rol, String direccion, String correo)
    {
        this.id = id;
        this.nombre = nombre;
        this.apellidos=apellidos;
        this.telefono = telefono;
        this.rol = rol;
        this.direccion = direccion;
        this.correo = correo;
        
    }

    public Usuario(String id,String nombre,String apellidos, String telefono, String rol, String direccion, String correo,LocalDate fechaNacimiento) 
    {
        this.id = id;
        this.nombre = nombre;
        this.apellidos=apellidos;
        this.telefono = telefono;
        this.rol = rol;
        this.direccion = direccion;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
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
     * @return the telefono
     */
    
      /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
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
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the fechaNacimiento
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    

    @Override
    public String toString() {
        return "Datos de los Usuarios" + 
               "\nId................:[" + id + "]"+
               "\nNombre............:[" + nombre + "]"+
               "\nApellidos.........:[" + apellidos +"]"+
               "\nTelefono..........:[" + telefono + "]"+
               "\nRol...............:[" + rol + "]"+
               "\nDireccion.........:[" + direccion + "]"+
               "\nCorreo............:[" + correo + "]"+
               "\nFecha Nacimiento..:[" + fechaNacimiento + "]";
    }
    
    
}
