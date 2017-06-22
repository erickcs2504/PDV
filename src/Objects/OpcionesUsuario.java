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
public class OpcionesUsuario {
    
    protected String id;
    protected String compras;
    protected String clientes;
    protected String proveedores;
    protected String inventario;
    protected String pagos;
    protected String consignacion;
    protected String reportes;
    protected String facturacion;

    public OpcionesUsuario() {
    }

    public OpcionesUsuario(String id, String compras, String clientes, String proveedores, String inventario, String pagos, String consignacion, String reportes, String facturacion) {
        this.id = id;
        this.compras = compras;
        this.clientes = clientes;
        this.proveedores = proveedores;
        this.inventario = inventario;
        this.pagos = pagos;
        this.consignacion = consignacion;
        this.reportes = reportes;
        this.facturacion = facturacion;
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
     * @return the compras
     */
    public String getCompras() {
        return compras;
    }

    /**
     * @param compras the compras to set
     */
    public void setCompras(String compras) {
        this.compras = compras;
    }

    /**
     * @return the clientes
     */
    public String getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(String clientes) {
        this.clientes = clientes;
    }

    /**
     * @return the proveedores
     */
    public String getProveedores() {
        return proveedores;
    }

    /**
     * @param proveedores the proveedores to set
     */
    public void setProveedores(String proveedores) {
        this.proveedores = proveedores;
    }

    /**
     * @return the invetario
     */
    public String getInventario() {
        return inventario;
    }

    /**
     * @param invetario the invetario to set
     */
    public void setInventario(String inventario) {
        this.inventario = inventario;
    }

    /**
     * @return the pagos
     */
    public String getPagos() {
        return pagos;
    }

    /**
     * @param pagos the pagos to set
     */
    public void setPagos(String pagos) {
        this.pagos = pagos;
    }

    /**
     * @return the consignacion
     */
    public String getConsignacion() {
        return consignacion;
    }

    /**
     * @param consignacion the consignacion to set
     */
    public void setConsignacion(String consignacion) {
        this.consignacion = consignacion;
    }

    /**
     * @return the reportes
     */
    public String getReportes() {
        return reportes;
    }

    /**
     * @param reportes the reportes to set
     */
    public void setReportes(String reportes) {
        this.reportes = reportes;
    }

    /**
     * @return the facturacion
     */
    public String getFacturacion() {
        return facturacion;
    }

    /**
     * @param facturacion the facturacion to set
     */
    public void setFacturacion(String facturacion) {
        this.facturacion = facturacion;
    }
    
    
    
}
