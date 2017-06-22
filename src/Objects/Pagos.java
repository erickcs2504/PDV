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
public class Pagos {

        
    protected int codPago;
    protected int codCliente;
    protected String cedula;
    protected String nombreCliente;
    protected LocalDate fechaUltPago;
    protected String total;
    protected String abono;
    protected String saldo;
    protected int numFactura;
    
    
    

    public Pagos() {
    }

    public Pagos(int codPago) {
        this.codPago = codPago;
    }

    public Pagos(LocalDate fechaUltPago,String Abono, String saldo) {
        this.fechaUltPago = fechaUltPago;
        this.abono=Abono;
        this.saldo = saldo;
    }

   
    public Pagos(int codPago, int codCliente, String cedula, String nombreCliente, LocalDate fechaUltPago, String total, String abono, String saldo, int numFactura) {
        this.codPago = codPago;
        this.codCliente = codCliente;
        this.cedula = cedula;
        this.nombreCliente = nombreCliente;
        this.fechaUltPago = fechaUltPago;
        this.total = total;
        this.abono = abono;
        this.saldo=saldo;
        this.numFactura=numFactura;
        
        
    }
    
    public Pagos(int codCliente, String cedula, String nombreCliente, LocalDate fechaUltPago, String total, String abono, String saldo, int numFactura) {
        
        this.codCliente = codCliente;
        this.cedula = cedula;
        this.nombreCliente = nombreCliente;
        this.fechaUltPago = fechaUltPago;
        this.total = total;
        this.abono = abono;
        this.saldo=saldo;
        this.numFactura=numFactura;
        
    }

    /**
     * @return the codPago
     */
    public int getCodPago() {
        return codPago;
    }

    /**
     * @param codPago the codPago to set
     */
    public void setCodPago(int codPago) {
        this.codPago = codPago;
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
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the fechaUltPago
     */
    public LocalDate getFechaUltPago() {
        return fechaUltPago;
    }

    /**
     * @param fechaUltPago the fechaUltPago to set
     */
    public void setFechaUltPago(LocalDate fechaUltPago) {
        this.fechaUltPago = fechaUltPago;
    }

    /**
     * @return the saldo
     */
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
    public String getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the abono
     */
    public String getAbono() {
        return abono;
    }

    /**
     * @param abono the abono to set
     */
    public void setAbono(String abono) {
        this.abono = abono;
    }
    
    /**
     * @return the numFactura
     */
    public int getNumFactura() {
        return numFactura;
    }

    /**
     * @param numFactura the numFactura to set
     */
    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }


    @Override
    public String toString() {
        return "Pagos{" + "codPago=" + codPago + ", codCliente=" + codCliente + ", cedula=" + cedula + ", nombreCliente=" + nombreCliente + ", fechaUltPago=" + fechaUltPago + ", total=" + total + ", abono=" + abono + ", saldo=" + saldo + '}';
    }

   

    

    
    
    
    
}
