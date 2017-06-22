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
public class Compras {

   

    
    protected int codCompra;
    protected String idArticulo;
    protected String nombreArticulo;
    protected int cantidadActual;
    protected int agregarCantidad;
    protected int cantidadTotal;
    protected String precioCompra;
    protected String precioVenta;
    protected String subTotal;
    protected String total;
    protected String proveedor;
    protected LocalDate fechaCompra;
    protected String tipoCompra;
    protected String numFactura;

    public Compras() {
        
    }

    public Compras(String subTotal, LocalDate fechaCompra) {
        this.subTotal = subTotal;
        this.fechaCompra = fechaCompra;
    }

   

    public Compras(int codCompra) {
        this.codCompra = codCompra;
    }

    public Compras(int codCompra, String idArticulo) {
        this.codCompra = codCompra;
        this.idArticulo = idArticulo;
    }

    
    public Compras(int agregarCantidad,String IdArticulo,String nombreArticulo, String precioCompra, String subTotal) {
        this.agregarCantidad = agregarCantidad;
        this.idArticulo = IdArticulo;
        this.nombreArticulo=nombreArticulo;
        this.precioCompra = precioCompra;
        this.subTotal = subTotal;
    }

     public Compras(String idArticulo, String nombreArticulo, int cantidadActual, int agregarCantidad, int cantidadTotal, String precioCompra, String precioVenta, String subTotal, String total, String proveedor, LocalDate fechaCompra, String tipoCompra) {
        
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.cantidadActual = cantidadActual;
        this.agregarCantidad = agregarCantidad;
        this.cantidadTotal = cantidadTotal;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.subTotal = subTotal;
        this.total = total;
        this.proveedor = proveedor;
        this.fechaCompra = fechaCompra;
        this.tipoCompra=tipoCompra;
    }

    

    
    public Compras(int codCompra, String idArticulo, String nombreArticulo, int cantidadActual, int agregarCantidad, int cantidadTotal, String precioCompra, String precioVenta, String subTotal, String total, String proveedor, LocalDate fechaCompra, String tipoCompra, String numFactura) {
        this.codCompra=codCompra;
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.cantidadActual = cantidadActual;
        this.agregarCantidad = agregarCantidad;
        this.cantidadTotal = cantidadTotal;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.subTotal = subTotal;
        this.total = total;
        this.proveedor = proveedor;
        this.fechaCompra = fechaCompra;
        this.tipoCompra=tipoCompra;
        this.numFactura=numFactura;
    }

    /**
     * @return the codCompra
     */
    public int getCodCompra() {
        return codCompra;
    }

    /**
     * @param codCompra the codCompra to set
     */
    public void setCodCompra(int codCompra) {
        this.codCompra = codCompra;
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
     * @return the cantidadActual
     */
    public int getCantidadActual() {
        return cantidadActual;
    }

    /**
     * @param cantidadActual the cantidadActual to set
     */
    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    /**
     * @return the agregarCantidad
     */
    public int getAgregarCantidad() {
        return agregarCantidad;
    }

    /**
     * @param agregarCantidad the agregarCantidad to set
     */
    public void setAgregarCantidad(int agregarCantidad) {
        this.agregarCantidad = agregarCantidad;
    }

    /**
     * @return the cantidadTotal
     */
    public int getCantidadTotal() {
        return cantidadTotal;
    }

    /**
     * @param cantidadTotal the cantidadTotal to set
     */
    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    /**
     * @return the precioCompra
     */
    public String getPrecioCompra() {
        return precioCompra;
    }

    /**
     * @param precioCompra the precioCompra to set
     */
    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
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
     * @return the proveedor
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    /**
     * @return the fechaCompra
     */
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    /**
     * @param fechaCompra the fechaCompra to set
     */
    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
    /**
     * @return the tipoCompra
     */
    public String getTipoCompra() {
        return tipoCompra;
    }

    /**
     * @param tipoCompra the tipoCompra to set
     */
    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
    }
    
    
    /**
     * @return the numFactura
     */
    public String getNumFactura() {
        return numFactura;
    }

    /**
     * @param numFactura the numFactura to set
     */
    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }


    @Override
    public String toString() {
        return "Datos de las Compras" +
               "\nCOD.Compra............:[" + codCompra + "]"+
                "\nCOD.Articulo........:[" + idArticulo + "]"+
               "\nArticulo.............:[" + nombreArticulo + "]"+
               "\nCantidad Actual......:[" + cantidadActual + "]"+
               "\nCantidad Comprada....:[" + agregarCantidad + "]"+
               "\nCantidad Total.......:[" + cantidadTotal + "]"+
               "\nPrecio Compra........:[" + precioCompra + "]"+
               "\nPrecio Venta.........:[" + precioVenta + "]"+
               "\nSub-Total............:[" + subTotal + "]"+
               "\nTotal................:[" + total + "]"+
               "\nProveedor............:[" + proveedor + "]"+
               "\nFecha Compra.........:[" + fechaCompra + "]"+
               "\nNumero Factura.......:[" + numFactura + "]";
    }
    
    
          
    
}
