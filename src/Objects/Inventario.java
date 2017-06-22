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
public class Inventario {
    
    protected String idArticulo;
    protected String nombreArticulo;
    protected String unidad;
    protected int    cantidad;
    protected String precioCompraUnd;
    protected String precioVentaUnd;
    protected int    cantidadReserva;

    public Inventario() {
        
    }

    public Inventario(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Inventario(String idArticulo, int cantidad) {
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
    }
    
    

    public Inventario(String idArticulo, String nombreArticulo, int cantidad, String precioCompraUnd, String precioVentaUnd, int cantidadReserva) {
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.cantidad = cantidad;
        this.precioCompraUnd = precioCompraUnd;
        this.precioVentaUnd = precioVentaUnd;
        this.cantidadReserva=cantidadReserva;
    }

   
    public Inventario(String idArticulo, String nombreArticulo, String unidad, int cantidad, String precioCompraUnd, String precioVentaUnd, int cantidadReserva) {
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.precioCompraUnd = precioCompraUnd;
        this.precioVentaUnd = precioVentaUnd;
        this.cantidadReserva = cantidadReserva;
    }

    /**
     * @return the idArticulo
     */
    public String getIdArticulo() {
        return idArticulo;
    }

    /**
     * @param idArticulo the idArticulo to set
     */
    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreArticulo;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreArticulo = nombreProducto;
    }

    /**
     * @return the unidad
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precioCompraUnd
     */
    public String getPrecioCompraUnd() {
        return precioCompraUnd;
    }

    /**
     * @param precioCompraUnd the precioCompraUnd to set
     */
    public void setPrecioCompraUnd(String precioCompraUnd) {
        this.precioCompraUnd = precioCompraUnd;
    }

    /**
     * @return the precioVentaUnd
     */
    public String getPrecioVentaUnd() {
        return precioVentaUnd;
    }

    /**
     * @param precioVentaUnd the precioVentaUnd to set
     */
    public void setPrecioVentaUnd(String precioVentaUnd) {
        this.precioVentaUnd = precioVentaUnd;
    }

    /**
     * @return the cantidadReserva
     */
    public int getCantidadReserva() {
        return cantidadReserva;
    }

    /**
     * @param cantidadReserva the cantidadReserva to set
     */
    public void setCantidadReserva(int cantidadReserva) {
        this.cantidadReserva = cantidadReserva;
    }

    @Override
    public String toString() {
        return "Datos del Inventario" +
               "\nCOD.Articulo..........:[" + idArticulo +"]"+ 
               "\nArticulo..............:[" + nombreArticulo +"]"+ 
               "\nUnidad................:[" + unidad +"]"+
               "\nCantidad..............:[" + cantidad +"]"+ 
               "\nPrecio Compra Unidad..:[" + precioCompraUnd +"]"+
               "\nPrecio Venta Unidad...:[" + precioVentaUnd + "]"+
               "\nCantidad Reserva......:[" + cantidadReserva + "]";
    }
    
    
    
}
