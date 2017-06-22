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
import Multi.*;
import UI.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CLPDV {
    
  
    private MultiUsuario multiUsuario; 
    private MultiAccount multiAccount;
    private MultiClientes multiClientes;
    private MultiProveedor multiProveedor;
    private MultiInventario multiInventario;
    private MultiCompras multiCompras;
    private MultiVentas multiVentas;
    private MultiPagos multiPagos;
    private MultiOpcionesUsuario multiOpcionesUsuario;
   // private VBuscarArticuloPorNombre buscarArticulo;
    
     public CLPDV() {
        multiUsuario = new MultiUsuario();
        multiAccount = new MultiAccount();
        multiClientes= new MultiClientes();
        multiProveedor=new MultiProveedor();
        multiInventario=new MultiInventario();
        multiCompras=new MultiCompras();
        multiVentas=new MultiVentas();
        multiPagos=new MultiPagos();
        multiOpcionesUsuario = new MultiOpcionesUsuario();
      //  buscarArticulo=new VBuscarArticuloPorNombre();
     }
    
     //------------------------------------------------------------------------
//OpcionesUsuario
  
     public void crearOpcionesUsuario(String id, String compras, String clientes, String proveedores, String inventario, String pagos, String consignacion, String reportes, String facturacion) throws PDVException {
        try {
            multiOpcionesUsuario.crear(id, compras, clientes, proveedores, inventario, pagos, consignacion, reportes, facturacion);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
    }
     
    public OpcionesUsuario buscarPorCed(String pId)throws PDVException{
        OpcionesUsuario unUsuario = null;
        try{
           unUsuario = multiOpcionesUsuario.buscarPorCedula(pId);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return unUsuario;
    }      


//Usuarios
     public void crearUsuario(String id, String nombre, String apellidos, String telefono, String rol, String direccion, String correo, LocalDate fechaNacimiento) throws PDVException {
        try {
            multiUsuario.crear(id, nombre, apellidos, telefono, rol, direccion, correo, fechaNacimiento);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
    }
     
    public Usuario buscarPorId(String pId)throws PDVException{
        Usuario unUsuario = null;
        try{
           unUsuario = multiUsuario.buscarPorId(pId);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return unUsuario;
    } 
    //-------------------------------------------------------------------------
    //Account
    public Account buscar(String pCed) throws PDVException{
        Account unaCuenta= null;
        try{
            unaCuenta = multiAccount.buscar(pCed);
            
        }catch (java.sql.SQLException e){
        throw new PDVException("Error en la Base de Datos." + e.getMessage());
        
    }catch (Exception e){
        throw new PDVException("Error en el programa." + e.getMessage());
    }
        return unaCuenta;
    }
    
    public Account crear(String pCed, String pClave) throws PDVException{
        Account nuevaCuenta=null;
        try{
            nuevaCuenta= multiAccount.crear(pCed, pClave);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return nuevaCuenta;
    }
    //--------------------------------------------------------------------------
    //Clientes
    public Clientes crearCliente(String cedula, String nombre, String alias, String telefonoUno, String telefonoDos, String email, String direccion, String referidoPor) throws PDVException{
        Clientes nuevoCliente = null;
        try{
            nuevoCliente=multiClientes.crear(cedula, nombre, alias, telefonoUno, telefonoDos, email, direccion, referidoPor);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." +  e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return nuevoCliente;
    }
    
     public Clientes buscarPorCedula(String pCedula)throws PDVException{
        Clientes unCliente = null;
        try{
           unCliente = multiClientes.buscarPorCedula(pCedula);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return unCliente;
    }
     
     public Clientes buscarCodCliente()throws PDVException{
        ArrayList<Clientes> cliente;
        Clientes unCliente=null;
        String codCliente;
        try{
           cliente = multiClientes.buscarCodCliente();
           for(int i=0;i<cliente.size();i++){
               unCliente=cliente.get(i);
           }
            cliente.add(unCliente);
           
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return unCliente;
    }
    
    public Clientes buscarIdCliente(int pIdCliente)throws PDVException{
        //ArrayList<Clientes> cliente;
        Clientes unCliente=null;
       
        try{
           unCliente = multiClientes.buscarIdCliente(pIdCliente);
          // cliente.add(unCliente);
           
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return unCliente;
    }
    
     public Clientes buscarPorNombreCliente(String pNombre)throws PDVException{
        Clientes unCliente = null;
        try{
           unCliente = multiClientes.buscarPorNombreCliente(pNombre);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return unCliente;
    }
    
    public Clientes buscarClientePorNombre(String pNombre)throws PDVException{
        Clientes unCliente = null;
        try{
           unCliente = multiClientes.buscarClientePorNombre(pNombre);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return unCliente;
    }
     
    //--------------------------------------------------------------------------
    //Proveedores
    public Proveedores buscarCodProveedor()throws PDVException{
        ArrayList<Proveedores> proveedor;
        Proveedores unProveedor=null;
        String codProveedor;
        try{
            proveedor= multiProveedor.buscarCodProveedor();
            for(int i=0;i<proveedor.size();i++){
                unProveedor=proveedor.get(i);
            }
            proveedor.add(unProveedor);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return unProveedor;
    }
    //Busca el proveedor para saber si ya existe cuando se está incluyendo desde el form de proveedores
    public Proveedores buscarProveedorPorNombre(String pNombre)throws PDVException{
        Proveedores unProveedor=null;
        try{
            unProveedor=multiProveedor.buscarProveedorPorNombre(pNombre);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
    }
        return unProveedor;
    }
    
     public Proveedores crearProveedor(String pNombre, String pEmpresa, String pTelefonoUno, String pTelefonoDos, String pEmail) throws PDVException{
        Proveedores nuevoProveedor = null;
        try{
            nuevoProveedor=multiProveedor.crear(pNombre,pEmpresa, pTelefonoUno, pTelefonoDos, pEmail);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." +  e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return nuevoProveedor;
    }
    
    //--------------------------------------------------------------------------
    //Inventario
     public Inventario crearInventario(String idArticulo, String nombreArticulo, String unidad, int cantidad, String precioCompraUnd, String precioVentaUnd, int cantidadReserva) throws PDVException{
        Inventario nuevoInventario = null;
        try{
            nuevoInventario=multiInventario.crear(idArticulo, nombreArticulo, unidad, cantidad, precioCompraUnd, precioVentaUnd, cantidadReserva);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." +  e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return nuevoInventario;
    }
     
    public Inventario buscarArticuloPorCodigo(String pIdArticulo)throws PDVException{
        Inventario unInventario=null;
        try{
            unInventario=multiInventario.buscarPorIdArticulo(pIdArticulo);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
    }
        return unInventario;
    }
    public Inventario buscarArticuloPorNombre(String pNombreArticulo)throws PDVException{
        Inventario unInventario=null;
        try{
            unInventario=multiInventario.buscarPorNombreArticulo(pNombreArticulo);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
    }
        return unInventario;
    }
    
   /* public Inventario listarArticulos()throws PDVException{
        Inventario unInventario=null;
        try{
            unInventario=buscarArticulo.encontrarArticulo();
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
    }
        return unInventario;
    }*/
    
    
     public void actualizarInventario(String idArticulo, int cantidad) throws PDVException {
        Inventario nInventario = new Inventario(idArticulo, cantidad);
        try {
            multiInventario.modificar(nInventario);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
    }
     
     
     
    //ojo
     public void descontarArticuloDeInventario(String idArticulo, int cantidad,int pCantTotal) throws PDVException {
        Inventario nInventario = new Inventario(idArticulo, cantidad);
        try {
            multiInventario.descontarArticuloDeInventario(nInventario,pCantTotal);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
    }
    
     public void actualizarInventarioDevuelto(String idArticulo, int cantidad, int pCantTotal) throws PDVException {
        Inventario nInventario = new Inventario(idArticulo, cantidad);
        try {
            multiInventario.modificarInventarioDevuelto(nInventario,pCantTotal);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
    }
     
     
     
     
   //Compras tableModel
    public ComprasTableModel getComprasTableModel(int pIdCompra) throws PDVException {
        return new ComprasTableModel(getListaCompras(pIdCompra));
    }
    
   
    public ComprasTableModel getBuscarComprasTableModel(String pconsulta) throws PDVException {
        return new ComprasTableModel(buscarCompras(pconsulta));
    }
    
   
    
    public ArrayList<Compras> getListaCompras(int pIdCompra) throws PDVException {
        ArrayList<Compras> compras = new ArrayList<>();
        Compras unaCompra=null;
        
        try {
            compras.addAll(multiCompras.listar(pIdCompra));
           
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
       return compras; 
    }
     
     public ArrayList<Compras> buscarCompras(String pconsulta) throws PDVException {
        ArrayList<Compras> compras = new ArrayList<>();
        try {
            
            compras.addAll(multiCompras.buscarPorNombre(pconsulta));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
       return compras; 
    }
     
     public void crearCompra(int pIdCompra,String pIdArticulo, String pNombreArticulo, int pCantidadActual, int pAgregarCantidad, int pCantidadTotal, String pPrecioCompra, String pPrecioVenta, String pSubTotal, String pTotal, String pProveedor, LocalDate pFechaCompra, String pTipoCompra, String pNumFactura) throws PDVException {
        try {
            multiCompras.crear(pIdCompra, pIdArticulo, pNombreArticulo, pCantidadActual, pAgregarCantidad, pCantidadTotal, pPrecioCompra, pPrecioVenta, pSubTotal, pTotal, pProveedor, pFechaCompra, pTipoCompra, pNumFactura);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
    }
     
     public Compras buscarNoCompra()throws PDVException{
        ArrayList<Compras> compra;
        Compras unaCompra=null;
        String codCompra;
        try{
            compra= multiCompras.buscarCodCompra();
            for(int i=0;i<compra.size();i++){
                unaCompra=compra.get(i);
            }
            compra.add(unaCompra);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return unaCompra;
    }
     
     public void eliminarCompras(Compras compra,int pCodCompra) throws PDVException {
        try {
            multiCompras.eliminar(compra, pCodCompra);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos.");
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
    }
    //cancela una compra que se esté haciendo en caso de que el usuario no decida continuar con la misma
     //con el fin de que no se cree un numero de compra en la tabla, de una compra que nunca se hizo
      public void cancelarCompra(int pCodCompra) throws PDVException {
        try {
            multiCompras.cancelarCompra(pCodCompra);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos.");
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
    }
      
    public void actualizarTotalCompra(int codCompra, String idArticulo, String pTotal,String pTipoCompra) throws PDVException {
        Compras nCompra = new Compras(codCompra, idArticulo);
        try {
            multiCompras.actualizarTotalCompra(nCompra,pTotal,pTipoCompra);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
    }
    
    
     //Inventario TableModel
    public InventarioTableModel getInventarioTableModel() throws PDVException {
        return new InventarioTableModel(getListaInventario());
    }
    
    public InventarioTableModel getBuscarInventarioTableModel(String pconsulta) throws PDVException {
        return new InventarioTableModel(buscarInventario(pconsulta));
    }
    
     public ArrayList<Inventario> getListaInventario() throws PDVException {
        ArrayList<Inventario> inventario = new ArrayList<>();
        Inventario unArticulo=null;
        
        try {
            inventario.addAll(multiInventario.listar());
           
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
       return inventario; 
    }
     
     public ArrayList<Inventario> buscarInventario(String pconsulta) throws PDVException {
        ArrayList<Inventario> inventario = new ArrayList<>();
        try {
            
            inventario.addAll(multiInventario.buscarPorNombre(pconsulta));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
       return inventario; 
    }
    
     //Ventas
      public Ventas buscarNoVenta()throws PDVException{
        ArrayList<Ventas> venta;
        Ventas unaVenta=null;
        String codVenta;
        try{
            venta= multiVentas.buscarCodVenta();
            for(int i=0;i<venta.size();i++){
                unaVenta=venta.get(i);
            }
            venta.add(unaVenta);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return unaVenta;
    }
      
    public ArrayList<Ventas> buscarTipoVenta()throws PDVException, Exception{
        
        ArrayList<Ventas> unaVenta=null;
        unaVenta=multiVentas.buscarTipoVenta();
        
        return unaVenta;
    }
      
     public void crearVenta(int pIdVenta,String pIdArticulo, String pNombreArticulo, String pPrecioVenta, int pCantidad, String pSubTotal, String pTotal, String pCliente, LocalDate pFechaVenta, String pTipoVenta) throws PDVException {
        try {
            multiVentas.crear(pIdVenta, pIdArticulo, pNombreArticulo, pPrecioVenta, pCantidad, pSubTotal, pTotal, pCliente, pFechaVenta, pTipoVenta);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
    }
       
     public void actualizarTotalVenta(int codVenta, String pTipoPago) throws PDVException {
        Ventas nVenta = new Ventas(codVenta);
        try {
            multiVentas.actualizarTotalVenta(nVenta,pTipoPago);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
    }
    
     public void actualizarTotalVentaDos(int codVenta, String pTotal) throws PDVException {
        Ventas nVenta = new Ventas(codVenta);
        try {
            multiVentas.actualizarTotalVentaDos(nVenta,pTotal);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
    }
    public void actualizarVentaContadoConDescuento(int codVenta, String codArt, String total)throws PDVException{
         Ventas nVenta = new Ventas(codVenta);
        try {
            multiVentas.actualizarVentaContadoConDescuento(nVenta,codArt, total);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
    }
     //cancela una venta que se esté haciendo en caso de que el usuario no decida continuar con la misma
     //con el fin de que no se cree un numero de compra en la tabla, de una compra que nunca se hizo
      public void cancelarVenta(int pCodVenta) throws PDVException {
        try {
            multiVentas.cancelarVenta(pCodVenta);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos.");
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
    }
       
    //Ventas TableModel
    
    public VentasTableModel getVentasTableModel(int pIdVenta) throws PDVException {
        return new VentasTableModel(getListaVentas(pIdVenta));
    }
    
   
    public VentasTableModel getBuscarVentasTableModel(String pconsulta) throws PDVException {
        return new VentasTableModel(buscarVentas(pconsulta));
    }
    
   
    
    public ArrayList<Ventas> getListaVentas(int pIdVenta) throws PDVException {
        ArrayList<Ventas> ventas = new ArrayList<>();
        Ventas unaVenta=null;
        
        try {
            ventas.addAll(multiVentas.listar(pIdVenta));
           
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
       return ventas; 
    }
     
     public ArrayList<Ventas> buscarVentas(String pconsulta) throws PDVException {
        ArrayList<Ventas> ventas = new ArrayList<>();
        try {
            
            ventas.addAll(multiVentas.buscarPorNombreProducto(pconsulta));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
       return ventas; 
    }
     
     public void eliminarVentas(Ventas venta,int pCodVenta) throws PDVException {
        try {
            multiVentas.eliminar(venta, pCodVenta);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos.");
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
    }
    
    
    public Ventas buscarVentaPorCodArticulo(String pIdArticulo)throws PDVException{
        Ventas unaVenta=null;
        try{
            unaVenta=multiVentas.buscarPorIdArticulo(pIdArticulo);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
    }
        return unaVenta;
    }
    
    public ArrayList<Ventas> buscarVentaPorCodVenta(int pCodVenta)throws PDVException{
        Ventas venta=null;
        ArrayList<Ventas> unaVenta;
        try{
            unaVenta=multiVentas.buscarPorCodVenta(pCodVenta);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
    }
        return unaVenta;
    }
    
  //Pagos
   public Pagos crearPago(int pCodPago, int pCodCliente, String pCedula, String pNombreCliente, LocalDate pFechaUltPago, String pTotal, String pAbono, String pSaldo, int pNumFactura) throws PDVException{
        Pagos unPago = null;
        try{
            unPago=multiPagos.crear(pCodPago, pCodCliente, pCedula, pNombreCliente, pFechaUltPago, pTotal, pAbono, pSaldo, pNumFactura);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." +  e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return unPago;
    }
    public Pagos buscarNoPago()throws PDVException{
        ArrayList<Pagos> pago;
        Pagos unPago=null;
        String codPago;
        try{
            pago= multiPagos.buscarCodPago();
            for(int i=0;i<pago.size();i++){
                unPago=pago.get(i);
            }
            pago.add(unPago);
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return unPago;
    }
    
    public Pagos buscarPagosPorFactura(int pNumFactura)throws PDVException{
        //ArrayList<Clientes> cliente;
        Pagos unPago=null;
       
        try{
           unPago = multiPagos.buscarPagosPorFactura(pNumFactura);
          // cliente.add(unCliente);
           
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return unPago;
    }
    
    public Pagos buscarPagosPorCedula(String pCedula)throws PDVException{
        //ArrayList<Clientes> cliente;
        Pagos unPago=null;
       
        try{
           unPago = multiPagos.buscarPagosPorCedula(pCedula);
          // cliente.add(unCliente);
           
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return unPago;
    }
    public Pagos buscarPagosPorNombre(String pNombre)throws PDVException{
        //ArrayList<Clientes> cliente;
        Pagos unPago=null;
       
        try{
           unPago = multiPagos.buscarPagosPorNombre(pNombre);
          // cliente.add(unCliente);
           
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return unPago;
    }
    //buscar fecha Venta
     public ArrayList<Ventas> buscarFechaVenta(LocalDate pFecha)throws PDVException{
        ArrayList<Ventas> venta=new ArrayList<>();
        Ventas unaFecha=null;
       
        try{
            venta=multiVentas.buscarFechaVenta(pFecha);
          // cliente.add(unCliente);
           
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return venta;
    }
    
     public ArrayList<Pagos> buscarFechaCierreCredito(LocalDate pFecha)throws PDVException{
        ArrayList<Pagos> pago=new ArrayList<>();
        Ventas unaFecha=null;
       
        try{
            pago=multiPagos.buscarFechaCierreCredito(pFecha);
          // cliente.add(unCliente);
           
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return pago;
    }
    
     public ArrayList<Pagos> buscarCxC()throws PDVException{
        ArrayList<Pagos> pago=new ArrayList<>();
        
       
        try{
            pago=multiPagos.buscarCxC();
          // cliente.add(unCliente);
           
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return pago;
    }
    
     public ArrayList<Ventas> buscarVentasConsignacion(int pIdFactura)throws PDVException{
        ArrayList<Ventas> ventas=new ArrayList<>();
        //Ventas unaFecha=null;
       
        try{
            ventas=multiVentas.buscarVentasConsignacion(pIdFactura);
          // cliente.add(unCliente);
           
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return ventas;
    }
    
     //buscar Facturas 
      public ArrayList<Ventas> buscarFacturasHechas()throws PDVException{
        ArrayList<Ventas> venta=new ArrayList<>();
        
       
        try{
            venta=multiVentas.buscarFacturas();
          // cliente.add(unCliente);
           
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return venta;
    }
    // Busca facturas de compras
       public ArrayList<Compras> buscarFacturasDeCompras()throws PDVException{
        ArrayList<Compras> compra=new ArrayList<>();
        
       
        try{
            compra=multiCompras.buscarFacturasDeCompras();
          // cliente.add(unCliente);
           
        }catch (java.sql.SQLException e){
            throw new PDVException("Error en la Base de Datos." + e.getMessage());
        }catch (Exception e){
            throw new PDVException("Error en el programa." + e.getMessage());
        }
        return compra;
    }
      
      //Clientes TableModel
   public ArrayList<Clientes> getListaClientes() throws PDVException {
        ArrayList<Clientes> cliente = null;
        try {
            cliente = multiClientes.listar();
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
        return cliente;
    }
   
   public ArrayList<Clientes> buscarClientes(String pnombre) throws PDVException {
        ArrayList<Clientes> cliente = null;
        try {
            cliente =  multiClientes.buscarPorNombre(pnombre);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
            
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
        return cliente;
    }
    
    
    public ClientesTableModel getClientesTableModel() throws PDVException {
        return new ClientesTableModel(getListaClientes());
    
    }
    
    public ClientesTableModel getBuscarClienteTableModel(String nombre) throws PDVException {
        return new ClientesTableModel(buscarClientes(nombre));
    }

     //Proveedores TableModel
   public ArrayList<Proveedores> getListaProveedores() throws PDVException {
        ArrayList<Proveedores> proveedor = null;
        try {
            proveedor = multiProveedor.listar();
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
        return proveedor;
    }
   //Busca el proveedor para mostrarlo en la tabla del modal de proveedores
   public ArrayList<Proveedores> buscarProveedor(String pnombre) throws PDVException {
        ArrayList<Proveedores> proveedor = null;
        try {
            proveedor =  multiProveedor.buscarPorNombre(pnombre);
        } catch (java.sql.SQLException e) {
            throw new PDVException("Error en la base de datos. " + e.getMessage());
            
        } catch (Exception e){
            throw new PDVException("Error en el programa. " + e.getMessage());
        }
        return proveedor;
    }
    
    
    public ProveedoresTableModel getProveedoresTableModel() throws PDVException {
        return new ProveedoresTableModel(getListaProveedores());
    
    }
    
    public ProveedoresTableModel getBuscarProveedoresTableModel(String nombre) throws PDVException {
        return new ProveedoresTableModel(buscarProveedor(nombre));
    }

}
