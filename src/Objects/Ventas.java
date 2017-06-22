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
public class Ventas {

    

   
    
    protected int idVenta;
    protected String idArticulo;
    protected String nombreArticulo;
    protected String precioVenta;
    protected int    cantidad;
    protected String subTotal;
    protected String total;
    protected String cliente;
    protected LocalDate fechaVenta;
    protected String tipoVenta;

    public Ventas() {
        
    }

    public Ventas(int idVenta) {
        this.idVenta = idVenta;
    }

    public Ventas(String total, LocalDate fechaVenta) {
        this.total = total;
        this.fechaVenta = fechaVenta;
    }
     
    public Ventas(int idVenta, String idArticulo) {
        this.idVenta = idVenta;
        this.idArticulo = idArticulo;
    }

    public Ventas(String total,LocalDate fecha, String tipoVenta) {
        this.total = total;
        this.fechaVenta=fecha;
        this.tipoVenta = tipoVenta;
    }
    
    

    public Ventas(int cantidad, String idArticulo, String nombreArticulo, String precioVenta, String subTotal) {
        this.idArticulo=idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }
    
    

    public Ventas(int idVenta,String idArticulo, String nombreArticulo, String precioVenta, int cantidad, String subTotal, String total, String cliente, LocalDate fechaVenta, String tipoVenta) {
        this.idVenta=idVenta;
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.total = total;
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
        this.tipoVenta=tipoVenta;
    }

    /**
     * @return the idVenta
     */
    public int getIdVenta() {
        return idVenta;
    }

    /**
     * @param idVenta the idVenta to set
     */
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
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
     * @return the nombreArticulo
     */
    public String getNombreArticulo() {
        return nombreArticulo;
    }

    /**
     * @param nombreArticulo the nombreArticulo to set
     */
    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    /**
     * @return the precioVenta
     */
    public String getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @param precioVenta the precioVenta to set
     */
    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
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
     * @return the subTotal
     */
    public String getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the fechaVenta
     */
    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    /**
     * @param fechaVenta the fechaVenta to set
     */
    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    /**
     * @return the tipoVenta
     */
    public String getTipoVenta() {
        return tipoVenta;
    }

    /**
     * @param tipoVenta the tipoVenta to set
     */
    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }
    

    @Override
    public String toString() {
        return "Datos de las Ventas" + 
               "\nId.Venta............:[" + idVenta + "]"+
                "\nCOD.Articulo.......:[" + idArticulo + "]"+
               "\nArticulo............:[" + nombreArticulo + "]"+
               "\nPrecio Venta........:[" + precioVenta + "]"+
               "\nCantidad............:[" + cantidad + "]"+
               "\nSub-Total...........:[" + subTotal + "]"+
               "\nTotal...............:[" + total + "]"+
               "\nCliente.............:[" + cliente + "]"+
               "\nFecha Venta.........:[" + fechaVenta + "]"+
               "\nTipo Venta..........:[" + tipoVenta  + "]";
    }
    
    
    
   
    
}
