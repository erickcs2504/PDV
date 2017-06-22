/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import Objects.*;
import Reportes.*;
import static UI.VCompras.txtIdArticulo;
import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import static groovy.xml.Entity.gt;
import static groovy.xml.Entity.lt;
import java.awt.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Erick Cordero
 */
public class VVentas extends javax.swing.JFrame implements ActionListener {
private Ventas venta;
private Inventario inventario;
private Clientes cliente;
private Pagos pago;
int cont=0;

private Account unaCuenta;
private OpcionesUsuario unUsuario;
private Usuario usuario;

    /**dpFechaActual.setDateToToday();
     * Creates new form VVentas
     */
    public VVentas() throws ParseException {
        
        initComponents();
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
      //  calcularTotal();
        formateaGrid();
        venta=null;
        inventario=null;
        cliente=null;
        pago=null;
        unaCuenta=null;
        unUsuario=null;
        usuario=null;
        
        dpFechaActual.setDateToToday();
        clpdv = new CLPDV();
        this.setLocationRelativeTo(null);
        btnImprimir.setEnabled(false);
        btnNuevaVenta.setEnabled(false);
        //Alineo los datos numericos de las cajas con valores de moneda a la derecha como 
        //tiene que ser
        txtPrecioVenta.setHorizontalAlignment(JTextField.RIGHT);
        txtSubTotal.setHorizontalAlignment(JTextField.RIGHT);
        txtTotal.setHorizontalAlignment(JTextField.RIGHT);
        txtDescuento.setHorizontalAlignment(JTextField.RIGHT);
        txtPrecioConDescuento.setHorizontalAlignment(JTextField.RIGHT);
        txtPagoInicial.setHorizontalAlignment(JTextField.RIGHT);
        txtSaldo.setHorizontalAlignment(JTextField.RIGHT);
        txtPagoEfectivo.setHorizontalAlignment(JTextField.RIGHT);
        txtVuelto.setHorizontalAlignment(JTextField.RIGHT);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //txtIdArticulo.grabFocus();
        if(cboTipoPago.getSelectedItem().equals("CONTADO")){
            lblPInicial.setVisible(false);
            txtPagoInicial.setVisible(false);
            lblSaldo.setVisible(false);
            txtSaldo.setVisible(false);
            btnCalcularSaldo.setVisible(false);
            chkDescuento.setVisible(true);
            
        }else{
            chkDescuento.setVisible(false);
        }
        
        
        if(chkDescuento.isSelected()){
            lblPorc.setVisible(true);
            txtPorcentaje.setVisible(true);
            btnCalcularDesc.setVisible(true);
            lblDescuento.setVisible(true);
            txtDescuento.setVisible(true);
            lblPrecioConDescuento.setVisible(true);
            txtPrecioConDescuento.setVisible(true);
        }else{
            
            lblPorc.setVisible(false);
            txtPorcentaje.setVisible(false);
            btnCalcularDesc.setVisible(false);
            lblDescuento.setVisible(false);
            txtDescuento.setVisible(false);
            lblPrecioConDescuento.setVisible(false);
            txtPrecioConDescuento.setVisible(false);
            
        }
        if(chkBotonBuscarArtPorNombre.isSelected()){
            btnBuscarNomArt.setVisible(true);
        }else{
            btnBuscarNomArt.setVisible(false);
            
        }
       
        buscarNoVenta();
        txtIdArticulo.grabFocus();
        
    }
    
    
    
  
   

    public void formateaGrid(){
        DefaultTableCellRenderer TablaRenderer = new DefaultTableCellRenderer();
        tableVentas.getColumnModel().getColumn(0).setPreferredWidth(30);
        tableVentas.getColumnModel().getColumn(1).setPreferredWidth(100);
        tableVentas.getColumnModel().getColumn(2).setPreferredWidth(370);
        tableVentas.getColumnModel().getColumn(3).setPreferredWidth(70);
        tableVentas.getColumnModel().getColumn(4).setPreferredWidth(50);
        TablaRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tableVentas.getColumnModel().getColumn(3).setCellRenderer(TablaRenderer);
        tableVentas.getColumnModel().getColumn(4).setCellRenderer(TablaRenderer);
    }
    
    /*public void calcularTotal() throws ParseException{
        float subTotalFlt=0;
        float totalFlt=0;
        DecimalFormat formato = new DecimalFormat("#,###.00");
        int row = tableVentas.getRowCount();
        if (row < -1){
            
        }else{
            if(row > -1){
              VentasTableModel vtm = (VentasTableModel)tableVentas.getModel();
              for(int i=0;i<vtm.getRowCount();i++){
                 Number nSubTotal= java.text.NumberFormat.getInstance().parse(vtm.getVentas(row).getSubTotal());
                 subTotalFlt=nSubTotal.floatValue();
                 totalFlt=totalFlt+subTotalFlt;
                 txtTotal.setText(formato.format(totalFlt));
          }
                
           
        }
       }
    }*/
    
    /*public void calcularTotalVenta()throws PDVException, ParseException{
        float abono;
        float saldo;
        float total;
        DecimalFormat formato = new DecimalFormat("#,###.00");
        if(txtPagoInicial.getText().equals("")){
            txtSaldo.setText(formato.format(txtTotal.getText()));
        }else{
            Number nAbono = java.text.NumberFormat.getInstance().parse(txtPagoInicial.getText());
            abono=nAbono.floatValue();
            Number nSaldo = java.text.NumberFormat.getInstance().parse(txtSaldo.getText());
            
            saldo=nSaldo.floatValue();
            Number nTotal = java.text.NumberFormat.getInstance().parse(txtTotal.getText());
            total=nTotal.floatValue();
            
            if(abono>total){
                JOptionPane.showMessageDialog(null,"El Pago Inicial no puede ser mayor al total de la deuda","Atención",JOptionPane.ERROR_MESSAGE);
                txtPagoInicial.setText("");
                txtPagoInicial.requestFocus();
                
            }else{
                saldo= total-abono;
                
                txtSaldo.setText(formato.format(saldo));
                //actualizarTotalVenta();
            }
        }
    }*/
    public void buscarNoVenta(){
    int idVenta;
         try{
             venta=clpdv.buscarNoVenta();
             idVenta=(venta.getIdVenta()+1);
             txtIdVenta.setText(Integer.toString(idVenta));
             //txtIdArticulo.grabFocus();
         }catch (Exception ex){
             Logger.getLogger(VClientes.class.getName()).log(Level.SEVERE,null, ex);
         }
   }
   public int buscarNoPago(){
       int idPago=0;
         try{
             pago=clpdv.buscarNoPago();
             idPago=(pago.getCodPago()+1);
             
             //txtIdVenta.setText(Integer.toString(idVenta));
            //txtIdArticulo.grabFocus();
         }catch (Exception ex){
             Logger.getLogger(VClientes.class.getName()).log(Level.SEVERE,null, ex);
         }
         return idPago;
   }
   public void calcularVuelto(){
       float pagoEfectivo;
       float vuelto=0;
       float totalVenta=0;
       DecimalFormat formato = new DecimalFormat("#,###.00");
        
            
          
    try {
        Number nPagoEfectivo = java.text.NumberFormat.getInstance().parse(txtPagoEfectivo.getText());
        
            pagoEfectivo=nPagoEfectivo.floatValue();
            txtPagoEfectivo.setText(formato.format(pagoEfectivo));
            Number nTotalVenta = java.text.NumberFormat.getInstance().parse(txtTotal.getText());
            totalVenta=nTotalVenta.floatValue();
            vuelto=pagoEfectivo-totalVenta;
            txtVuelto.setText(formato.format(vuelto));
            txtIdArticulo.grabFocus();
            
             } catch (ParseException ex) {
        Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
   public void cerrar(){
        try {
             usuario = clpdv.buscarPorId(txtUsuario.getText());
         } catch (PDVException ex) {
             Logger.getLogger(VInventario.class.getName()).log(Level.SEVERE, null, ex);
         }
        
             if(usuario.getRol().equals("DEPENDIENTE")){
                
                    dispose();
            try {
                unUsuario=clpdv.buscarPorCed(txtUsuario.getText());
            } catch (PDVException ex) {
                Logger.getLogger(VInventario.class.getName()).log(Level.SEVERE, null, ex);
            }
                    if(unUsuario==null){
                        
                    }else{
                         VMenuAdmin menuAdmin=new VMenuAdmin();
                         menuAdmin.setVisible(true);
                         VMenuAdmin.txtUsuario.setText(txtUsuario.getText());
                         if(unUsuario.getCompras().equals("SI")){
                             VMenuAdmin.btnCompras.setEnabled(true);
                        }else{
                             VMenuAdmin.btnCompras.setEnabled(false);
                        }
                        if(unUsuario.getClientes().equals("SI")){
                             VMenuAdmin.btnClientes.setEnabled(true);
                        }else{
                             VMenuAdmin.btnClientes.setEnabled(false);
                        }
                        if(unUsuario.getProveedores().equals("SI")){
                            VMenuAdmin.btnProveedor.setEnabled(true);
                        }else{
                            VMenuAdmin.btnProveedor.setEnabled(false);
                        }
                        if(unUsuario.getInventario().equals("SI")){
                             VMenuAdmin.btnInventario.setEnabled(true);
                        }else{
                             VMenuAdmin.btnInventario.setEnabled(false);
                        }
                        if(unUsuario.getPagos().equals("SI")){
                            VMenuAdmin.btnPagos.setEnabled(true);
                        }else{
                            VMenuAdmin.btnPagos.setEnabled(false);
                        }
                        if(unUsuario.getConsignacion().equals("SI")){
                            VMenuAdmin.btnVentasConsignacion.setEnabled(true);
                        }else{
                            VMenuAdmin.btnVentasConsignacion.setEnabled(false);
                        }
                        if(unUsuario.getReportes().equals("SI")){
                             VMenuAdmin.btnReportes.setEnabled(true);
                        }else{
                             VMenuAdmin.btnReportes.setEnabled(false);
                        }
                        if(unUsuario.getFacturacion().equals("SI")){
                            VMenuAdmin.btnVentas.setEnabled(true);
                        }else{
                            VMenuAdmin.btnVentas.setEnabled(false);
                        }
                    }
             }else{
                 if(usuario.getRol().equals("ADMINISTRADOR")){
                     dispose();
                      VMenuAdmin menu = new VMenuAdmin();
                     menu.setVisible(true);
                     VMenuAdmin.txtUsuario.setText(txtUsuario.getText());
                 }
             }
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCantidadInventario = new javax.swing.JTextField();
        txtCantDos = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        btnImprimirTicket = new javax.swing.JButton();
        txtTipoUsuario = new javax.swing.JTextField();
        txtTotalDos = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnQuitarProducto = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnNuevaVenta = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        txtIdCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdArticulo = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnBuscarNomArt = new javax.swing.JButton();
        txtIdVenta = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dpFechaActual = new com.github.lgooddatepicker.components.DatePicker();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cboTipoPago = new javax.swing.JComboBox<>();
        btnCalcularSaldo = new javax.swing.JButton();
        txtPagoInicial = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        lblSaldo = new javax.swing.JLabel();
        lblPInicial = new javax.swing.JLabel();
        lblPagoEfectivo = new javax.swing.JLabel();
        txtPagoEfectivo = new javax.swing.JTextField();
        lblVuelto = new javax.swing.JLabel();
        txtVuelto = new javax.swing.JTextField();
        btnCalcularVuelto = new javax.swing.JButton();
        txtSubTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtArticulo = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        chkBotonBuscarArtPorNombre = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        chkDescuento = new javax.swing.JCheckBox();
        lblDescuento = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        lblPorc = new javax.swing.JLabel();
        txtPorcentaje = new javax.swing.JTextField();
        btnCalcularDesc = new javax.swing.JButton();
        lblPrecioConDescuento = new javax.swing.JLabel();
        txtPrecioConDescuento = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVentas = new javax.swing.JTable();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JLabel();
        btnCancelarVenta = new javax.swing.JButton();

        txtCantidadInventario.setEditable(false);
        txtCantidadInventario.setBackground(new java.awt.Color(153, 255, 153));
        txtCantidadInventario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCantidadInventario.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCantidadInventarioCaretUpdate(evt);
            }
        });
        txtCantidadInventario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantidadInventarioFocusGained(evt);
            }
        });
        txtCantidadInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadInventarioKeyReleased(evt);
            }
        });

        btnImprimirTicket.setText("Imprimir Ticket");
        btnImprimirTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirTicketActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Modulo de Ventas");
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(1451, 979));
        setMinimumSize(new java.awt.Dimension(1451, 979));
        setName("Ventas"); // NOI18N
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnQuitarProducto.setText("Quitar Producto");
        btnQuitarProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProductoActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar Producto [F4]");
        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        btnAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnAgregarKeyTyped(evt);
            }
        });

        btnNuevaVenta.setText("Nueva Venta [F2]");
        btnNuevaVenta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        btnImprimir.setText("Factura [F6]");
        btnImprimir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir [Escape]");
        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnQuitarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregar)
                .addGap(10, 10, 10)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 730, 130));
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(1445, 973, -1, 0));
        getContentPane().add(txtIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1445, 979, -1, 0));

        jLabel2.setText("Artículo:");
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 640, -1, 20));

        txtIdArticulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtIdArticulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtIdArticulo.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                txtIdArticuloComponentAdded(evt);
            }
        });
        txtIdArticulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdArticuloFocusGained(evt);
            }
        });
        txtIdArticulo.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtIdArticuloInputMethodTextChanged(evt);
            }
        });
        txtIdArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdArticuloActionPerformed(evt);
            }
        });
        txtIdArticulo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtIdArticuloPropertyChange(evt);
            }
        });
        txtIdArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdArticuloKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdArticuloKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdArticuloKeyTyped(evt);
            }
        });
        txtIdArticulo.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                txtIdArticuloVetoableChange(evt);
            }
        });
        getContentPane().add(txtIdArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 630, 480, 40));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/search.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 570, 0, 20));

        txtCantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCantidadFocusGained(evt);
            }
        });
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 220, 160, 35));

        jLabel5.setText("Cantidad:");
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, -1, -1));

        btnBuscarNomArt.setText("...");
        btnBuscarNomArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNomArtActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarNomArt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 120, 30, -1));

        txtIdVenta.setEditable(false);
        txtIdVenta.setBackground(new java.awt.Color(153, 255, 153));
        txtIdVenta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtIdVenta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(txtIdVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 100, 40));

        jLabel1.setText("No.Venta:");
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        dpFechaActual.setEnabled(false);
        getContentPane().add(dpFechaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 20, 220, -1));

        jLabel8.setText("Cliente:");
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 180, 80, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONTADO", "CREDITO", "CONSIGNACION", "TARJETA" }));
        cboTipoPago.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboTipoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoPagoActionPerformed(evt);
            }
        });
        jPanel1.add(cboTipoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 230, 25));

        btnCalcularSaldo.setText("Calcular Saldo");
        btnCalcularSaldo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCalcularSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularSaldoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalcularSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 150, 35));

        txtPagoInicial.setBackground(new java.awt.Color(153, 255, 153));
        txtPagoInicial.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPagoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagoInicialKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoInicialKeyTyped(evt);
            }
        });
        jPanel1.add(txtPagoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 150, 35));

        txtSaldo.setEditable(false);
        txtSaldo.setBackground(new java.awt.Color(153, 255, 153));
        txtSaldo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtSaldo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 150, 35));

        lblSaldo.setText("Saldo:");
        lblSaldo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(lblSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 60, -1));

        lblPInicial.setText("Pago Inicial:");
        lblPInicial.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(lblPInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 100, -1));

        lblPagoEfectivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPagoEfectivo.setText("Paga con:");
        jPanel1.add(lblPagoEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txtPagoEfectivo.setBackground(new java.awt.Color(153, 255, 153));
        txtPagoEfectivo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtPagoEfectivo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtPagoEfectivo.setForeground(new java.awt.Color(255, 0, 0));
        txtPagoEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagoEfectivoActionPerformed(evt);
            }
        });
        jPanel1.add(txtPagoEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 160, 35));

        lblVuelto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblVuelto.setText("Vuelto:");
        jPanel1.add(lblVuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 60, -1));

        txtVuelto.setBackground(new java.awt.Color(153, 255, 153));
        txtVuelto.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtVuelto.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(txtVuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 160, 35));

        btnCalcularVuelto.setText("Procesar Pago");
        btnCalcularVuelto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCalcularVuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularVueltoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalcularVuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 420, 570, 200));

        txtSubTotal.setEditable(false);
        txtSubTotal.setBackground(new java.awt.Color(153, 255, 153));
        txtSubTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtSubTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 320, 160, 35));

        jLabel6.setText("Sub-Total ¢");
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 330, 100, -1));

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(153, 255, 153));
        txtTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 370, 160, 35));

        jLabel7.setText("Total ¢");
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 380, 60, -1));

        txtArticulo.setBackground(new java.awt.Color(255, 0, 0));
        txtArticulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtArticulo.setEnabled(false);
        txtArticulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtArticulo.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(txtArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, 470, 40));

        txtPrecioVenta.setEditable(false);
        txtPrecioVenta.setAlignmentY(1.0F);
        txtPrecioVenta.setBackground(new java.awt.Color(153, 255, 153));
        txtPrecioVenta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtPrecioVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtPrecioVenta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 270, 160, 35));

        jLabel9.setText("Precio :");
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 70, -1));

        chkBotonBuscarArtPorNombre.setText("Buscar Artículo por Nombre");
        chkBotonBuscarArtPorNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chkBotonBuscarArtPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBotonBuscarArtPorNombreActionPerformed(evt);
            }
        });
        getContentPane().add(chkBotonBuscarArtPorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descuento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chkDescuento.setText("Descuento");
        chkDescuento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chkDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDescuentoActionPerformed(evt);
            }
        });
        jPanel3.add(chkDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        lblDescuento.setText("Monto Descuento");
        lblDescuento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(lblDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtDescuento.setEditable(false);
        txtDescuento.setBackground(new java.awt.Color(153, 255, 153));
        txtDescuento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDescuento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyReleased(evt);
            }
        });
        jPanel3.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 35));

        lblPorc.setText("%");
        lblPorc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(lblPorc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        txtPorcentaje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPorcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPorcentajeActionPerformed(evt);
            }
        });
        txtPorcentaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPorcentajeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPorcentajeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPorcentajeKeyTyped(evt);
            }
        });
        jPanel3.add(txtPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, 35));

        btnCalcularDesc.setText("Calcular");
        btnCalcularDesc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCalcularDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularDescActionPerformed(evt);
            }
        });
        jPanel3.add(btnCalcularDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 110, 35));

        lblPrecioConDescuento.setText("Precio/Descuento");
        lblPrecioConDescuento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(lblPrecioConDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        txtPrecioConDescuento.setEditable(false);
        txtPrecioConDescuento.setBackground(new java.awt.Color(153, 255, 153));
        txtPrecioConDescuento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtPrecioConDescuento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(txtPrecioConDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 140, 35));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 220, 340, 190));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableVentas.setModel(new VentasTableModel());
        jScrollPane1.setViewportView(tableVentas);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 720, 450));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 740, 470));

        btnBuscarCliente.setText("...");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 170, 30, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Artículo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 70, -1));

        txtCliente.setBackground(new java.awt.Color(255, 0, 0));
        txtCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCliente.setEnabled(false);
        txtCliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtCliente.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 170, 470, 40));

        btnCancelarVenta.setText("Cancelar Venta");
        btnCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
       
       cerrar();
        
        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    try {
        // TODO add your handling code here:
        
        agregarLineaEnlaTabla();
    } catch (PDVException ex) {
        Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
        Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
    }
   
       
    }//GEN-LAST:event_btnAgregarActionPerformed
   public void agregarLineaEnlaTabla()throws PDVException, ParseException{
       int codCliente;
       String cedula;
       float subTotalFlt=0;
       float totalFlt=0;
       
        
        
        if(txtIdArticulo.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Debe de indicar el Código del Artículos a Comprar","Atención",JOptionPane.ERROR_MESSAGE);
            txtIdArticulo.requestFocus();
            
        }
        if(txtCantidad.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Debe de indicar la Cantidad de Artículos a Comprar","Atención",JOptionPane.ERROR_MESSAGE);
            txtCantidad.grabFocus();
            
        }else{
            if(txtCliente.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debe de indicar el nombre del Cliente","Atención",JOptionPane.ERROR_MESSAGE);
                txtCliente.grabFocus();
                
            }else{
                int idVenta= Integer.parseInt(txtIdVenta.getText());
                if ((txtIdArticulo.getText() != null) && (txtIdArticulo.getText().length() > 0)) {
            
                try {
                    inventario=clpdv.buscarArticuloPorCodigo(txtIdArticulo.getText());
                    cliente=clpdv.buscarClientePorNombre(txtCliente.getText());
                    if(cliente==null){
                        JOptionPane.showMessageDialog(null,"El Cliente [" + txtCliente.getText() +"] no Existe en la Base de Datos,Favor Verificar","Atención",JOptionPane.ERROR_MESSAGE);
                        txtCliente.setText("");
                        txtCliente.requestFocus();
                    }else{
                        codCliente=cliente.getCodCliente();
                        cedula=cliente.getCedula();
                        txtIdCliente.setText(Integer.toString(codCliente));
                        txtCedula.setText(cedula);
                        
                        
                        int cantidadEnInventario=inventario.getCantidad();
                        int cantidadAComprar=Integer.parseInt(txtCantidad.getText());
                        if(cantidadEnInventario<cantidadAComprar){
                            JOptionPane.showMessageDialog(null,"La cantidad ingresada en la Venta es mayor a la cantidad existente en el Inventario,Fabor Verificar!!!","Atención",JOptionPane.ERROR_MESSAGE);
                            txtCantidad.setText("");
                            txtCantidad.requestFocus();
                       }else{
                           // Number nPrecioVenta = java.text.NumberFormat.getInstance().parse(txtPrecioVenta.getText());
                            //Number nSubTotal = java.text.NumberFormat.getInstance().parse(txtSubTotal.getText());
                            //Number nTotal = java.text.NumberFormat.getInstance().parse(txtTotal.getText()); 
                             
                            if(cboTipoPago.getSelectedItem().equals("CONTADO")|| cboTipoPago.getSelectedItem().equals("TARJETA")){
                               
                                  
                                    clpdv.crearVenta(Integer.parseInt(txtIdVenta.getText()),
                                    txtIdArticulo.getText(),
                                    txtArticulo.getText(),
                                    txtPrecioVenta.getText(),
                                    (Integer.parseInt(txtCantidad.getText())),
                                    txtSubTotal.getText(),
                                    txtTotal.getText(),
                                    txtCliente.getText(),
                                    dpFechaActual.getDate(),
                                    (String)cboTipoPago.getSelectedItem());
                            }else{
                                if(cboTipoPago.getSelectedItem().equals("CREDITO")){
                                    //si la factura es de crédito se guarda en el campo de total el abono(adelanto) que el cliente
                                    //hace al total de la factura, para que cuando se saque el reporte de facturas se vea reflejado el monto 
                                    //en efectivo que se recaudó ese día.
                                    clpdv.crearVenta(Integer.parseInt(txtIdVenta.getText()),
                                    txtIdArticulo.getText(),
                                    txtArticulo.getText(),
                                    txtPrecioVenta.getText(),
                                    (Integer.parseInt(txtCantidad.getText())),
                                    txtTotal.getText(),//Si el tipo de venta es credito entonces mi venta total de ese día va a ser
                                    txtPagoInicial.getText(),//al adelanto que el cliente le haga a esa cuenta
                                    txtCliente.getText(),//pero el total de la factura sigue siendo el mismo monto de un inicio
                                    dpFechaActual.getDate(),//esto es para efectos de que en el reporte de facturas por fechas
                                    (String)cboTipoPago.getSelectedItem());//se vea reflejado en el campo de total de la factura
                                    
                                    }
                                
                                        
                                    //el monto en efectivo que entro ese día
                            }
                        
                            //actualizar cantidad de articulos en el inventario
                            clpdv.descontarArticuloDeInventario(txtIdArticulo.getText(),
                            (Integer.parseInt(txtCantidad.getText())), 
                            (cantidadEnInventario));
                            tableVentas.setModel(clpdv.getVentasTableModel(idVenta));
                             formateaGrid();
                            JOptionPane.showMessageDialog(null,"Agregado correctamente.","Resultado" , JOptionPane.INFORMATION_MESSAGE);
                             txtTotalDos.setText(txtTotal.getText());
                             btnImprimir.setEnabled(true);
                             btnNuevaVenta.setEnabled(true);
                            limpiar();
                       
                     
                    }
                    }
                }catch (PDVException e){
                            JOptionPane.showMessageDialog(this,e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 }
                }else {
                        JOptionPane.showMessageDialog(this,"Datos no insertados", "Información", JOptionPane.WARNING_MESSAGE);
                }
                
            }
        }
   }
   
   
    public void crearPago()throws PDVException{
       int codPago;
       codPago=buscarNoPago();
       //Guarda en la tabla TPagos el total de la factura, el abono que el cliente le hizo a esa factura
       //y el saldo, para que cuando el cliente vuelva a llegar a cancelar la factura, todos estos datos aparezcan
       clpdv.crearPago(codPago,
                       Integer.parseInt(txtIdCliente.getText()),
                       txtCedula.getText(),
                       txtCliente.getText(),
                       dpFechaActual.getDate(),
                       txtTotal.getText(),
                       txtPagoInicial.getText(),
                       txtSaldo.getText(),
                       Integer.parseInt(txtIdVenta.getText()));
       
       JOptionPane.showMessageDialog(null,"Venta registrada satisfactoriamente ","Atención",JOptionPane.INFORMATION_MESSAGE);
       //imprimir();
            //lblPInicial.setVisible(false);
            //txtPagoInicial.setVisible(false);
            //lblSaldo.setVisible(false);
            //txtSaldo.setVisible(false);
            //btnCalcularSaldo.setVisible(false);
            //cboTipoPago.setSelectedIndex(0);
            //txtSubTotal.setText("");
            //txtTotal.setText("");
            //txtCliente.setText("");
            //buscarNoVenta();
            //tableVentas.setModel(new DefaultTableModel());
   }
    public void validarVenta(float pMontoDesc) throws ParseException{
        int cantidad=Integer.parseInt(txtCantidad.getText());
        int cantidadInventario=Integer.parseInt(txtCantidadInventario.getText());
        if(cantidad==0){
            
        }else{
            if(cantidad>cantidadInventario){
                JOptionPane.showMessageDialog(null,"La Cantidad ingresada es mayor a la existente en el inventario","Atención",JOptionPane.ERROR_MESSAGE);
                txtCantidad.setText("");
                txtCantidad.requestFocus();
            }else{
                subTotal(pMontoDesc);
                //txtCliente.requestFocus();
           }
            
        }
        
    }
    private void limpiar(){
         
        txtIdArticulo.setText("");
        //txtArticulo.setText("");
        txtPrecioVenta.setText("");
        txtCantidad.setText("");
       // txtSubTotal.setText("");
        //txtTotal.setText("");
        //txtCliente.setText("");
        txtIdArticulo.grabFocus();
        txtCantidadInventario.setText("");
        
        chkDescuento.setSelected(false);
        lblPorc.setVisible(false);
        txtPorcentaje.setVisible(false);
        btnCalcularDesc.setVisible(false);
        lblDescuento.setVisible(false);
        txtDescuento.setVisible(false);
        lblPrecioConDescuento.setVisible(false);
        txtPrecioConDescuento.setVisible(false);
        
        
    }
    public void restarTotal(float precioVenta) throws ParseException{
        //Procedimiento para restarle del total de la venta en caso de que el usuario
        //haya decidido quitar un producto de la linea de compra
        float totalVenta=0;
        DecimalFormat formato = new DecimalFormat("#,###.00");
        
        Number nTotalVenta = java.text.NumberFormat.getInstance().parse(txtTotal.getText());
        totalVenta = nTotalVenta.floatValue();
        totalVenta = totalVenta-precioVenta;
        txtTotal.setText(formato.format(totalVenta));
        txtTotalDos.setText(formato.format(totalVenta));
       
    }
    private void btnQuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProductoActionPerformed
        // TODO add your handling code here:
         int codVenta = Integer.parseInt(txtIdVenta.getText());
         float precioVenta=0;
       //int cantTotal = Integer.parseInt(txtCantidadTotal.getText());
        try {
            int row = tableVentas.getSelectedRow();
            if (row > -1){
                VentasTableModel vtm = (VentasTableModel)tableVentas.getModel();
                //int cantidadAgregada= ctm.getCompras(row).getAgregarCantidad();
                clpdv.eliminarVentas(vtm.getVentas(row),codVenta);
                
                tableVentas.setModel(clpdv.getVentasTableModel(codVenta));
                //se saca el precio de venta de la linea del producto que el usuario está eliminando de la compra
                Number nPrecioVenta = java.text.NumberFormat.getInstance().parse(vtm.getVentas(row).getSubTotal());
                precioVenta=nPrecioVenta.floatValue();
                //se envía al procedimiento restarTotal, el monto del precio de la venta del producto que se está quitando
                //de la compra, para que pueda ser restado del total de la venta.
                restarTotal(precioVenta);
                
                inventario=clpdv.buscarArticuloPorCodigo(vtm.getVentas(row).getIdArticulo());
                int cantTotal= inventario.getCantidad();
                clpdv.actualizarInventarioDevuelto(vtm.getVentas(row).getIdArticulo(),
                                                  (vtm.getVentas(row).getCantidad()),
                                                  (cantTotal));
               
                
                clpdv.actualizarTotalVentaDos(codVenta, txtTotal.getText());
                JOptionPane.showMessageDialog(this,"Eliminado correctamente.","Resultado" , JOptionPane.INFORMATION_MESSAGE);
                txtIdArticulo.grabFocus();
            }
            else
            JOptionPane.showMessageDialog(this,"Seleccione el Artículo a Eliminar", "Información", JOptionPane.WARNING_MESSAGE);
        } catch (PDVException e){
            JOptionPane.showMessageDialog(this,e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
        Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnQuitarProductoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    try {
        // TODO add your handling code here:
        buscarArticuloPorCodigo();
    } catch (ParseException ex) {
        Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_btnBuscarActionPerformed
   
  



    private void txtIdArticuloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdArticuloKeyReleased
    try {
        buscarArticuloPorCodigo();
    } catch (ParseException ex) {
        Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_txtIdArticuloKeyReleased

    private void txtIdArticuloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdArticuloKeyTyped
        // TODO add your handling code here:
         char charecter = evt.getKeyChar();
        if (Character.isLowerCase(charecter)) {
            evt.setKeyChar(Character.toUpperCase(charecter));
        }
    }//GEN-LAST:event_txtIdArticuloKeyTyped

    private void btnBuscarNomArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNomArtActionPerformed
        // TODO add your handling code here:
        VBuscarArticuloPorNombre buscarArticulo = new VBuscarArticuloPorNombre();
        buscarArticulo.setVisible(true);
        VBuscarArticuloPorNombre.txtTipoTransaccion.setText("VENTAS");
        
    }//GEN-LAST:event_btnBuscarNomArtActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(Character.isLetter(c)) {
              getToolkit().beep();
              evt.consume();
              
              JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!,","Error",JOptionPane.ERROR_MESSAGE);
        }  
        
        
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void cboTipoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoPagoActionPerformed
        // TODO add your handling code here:
         DecimalFormat formato = new DecimalFormat("#,###.00");
        if(cboTipoPago.getSelectedItem().equals("CONTADO")){
            lblPInicial.setVisible(false);
            txtPagoInicial.setVisible(false);
            lblSaldo.setVisible(false);
            txtSaldo.setVisible(false);
            btnCalcularSaldo.setVisible(false);
            chkDescuento.setVisible(true);
            lblPagoEfectivo.setVisible(true);
            txtPagoEfectivo.setVisible(true);
            lblVuelto.setVisible(true);
            txtVuelto.setVisible(true);
            btnCalcularVuelto.setVisible(true);
            txtCantidad.grabFocus();
            
           
            
        }else{
            if(cboTipoPago.getSelectedItem().equals("CREDITO")){
                lblPInicial.setVisible(true);
                txtPagoInicial.setVisible(true);
                lblSaldo.setVisible(true);
                txtSaldo.setVisible(true);
                btnCalcularSaldo.setVisible(true);
                chkDescuento.setVisible(false);
                lblPagoEfectivo.setVisible(false);
                txtPagoEfectivo.setVisible(false);
                lblVuelto.setVisible(false);
                txtVuelto.setVisible(false);
                btnCalcularVuelto.setVisible(false);
                txtCantidad.grabFocus();
                if(txtTotal.getText().equals("")){
                    
                    }else{
                        //********
                        if(txtPagoInicial.getText().equals("")){
                        float total;
                        try {
                            Number nTotal = java.text.NumberFormat.getInstance().parse(txtTotal.getText());
                            total=nTotal.floatValue();
                            txtSaldo.setText(formato.format(total));
                            txtPagoInicial.requestFocus();
                        } catch (ParseException ex) {
                            Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    
                 }
                }
            }else{
                if(cboTipoPago.getSelectedItem().equals("TARJETA")){
                    lblPagoEfectivo.setVisible(false);
                    txtPagoEfectivo.setVisible(false);
                    lblVuelto.setVisible(false);
                    txtVuelto.setVisible(false);
                     lblPInicial.setVisible(false);
                    txtPagoInicial.setVisible(false);
                    lblSaldo.setVisible(false);
                    txtSaldo.setVisible(false);
                    btnCalcularSaldo.setVisible(false);
                    chkDescuento.setVisible(false);
                    btnCalcularVuelto.setVisible(false);
                    txtCantidad.grabFocus();
                }
            }
        }
    
                    
                    //********
  
    }//GEN-LAST:event_cboTipoPagoActionPerformed

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
    float montoDesc=0;
    
    if(txtCantidad.getText().equals("")){
        
    }else{
        try {
            validarVenta(montoDesc);
        }catch (ParseException ex) {
            Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
 
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtPagoInicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoInicialKeyReleased
    
    }//GEN-LAST:event_txtPagoInicialKeyReleased

    private void txtPagoInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoInicialKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(Character.isLetter(c)) {
              getToolkit().beep();
              evt.consume();
              
              JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!,","Error",JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_txtPagoInicialKeyTyped

    private void btnCalcularSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularSaldoActionPerformed
        // TODO add your handling code here:
         try {
        // TODO add your handling code here:
        calcularSaldo();
    } catch (PDVException ex) {
        Logger.getLogger(VCompras.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
        Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_btnCalcularSaldoActionPerformed

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        // TODO add your handling code here:
        nuevaVenta();
        txtIdArticulo.grabFocus();
    }//GEN-LAST:event_btnNuevaVentaActionPerformed
    public void nuevaVenta(){
        lblPInicial.setVisible(false);
        txtPagoInicial.setVisible(false);
        lblSaldo.setVisible(false);
        txtSaldo.setVisible(false);
        btnCalcularSaldo.setVisible(false);
        cboTipoPago.setSelectedIndex(0);
        txtSubTotal.setText("");
        txtTotal.setText("");
        txtCliente.setText("");
        txtArticulo.setText("");
        
        buscarNoVenta();
        tableVentas.setModel(new DefaultTableModel());
        chkDescuento.setSelected(false);
        lblPorc.setVisible(false);
        txtPorcentaje.setVisible(false);
        btnCalcularDesc.setVisible(false);
        lblDescuento.setVisible(false);
        txtDescuento.setVisible(false);
        lblPrecioConDescuento.setVisible(false);
        txtPrecioConDescuento.setVisible(false);
        
       
    }
    
    private void txtCantidadInventarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadInventarioKeyReleased
   
    }//GEN-LAST:event_txtCantidadInventarioKeyReleased

    private void txtCantidadInventarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadInventarioFocusGained
        // TODO add your handling code here:
     
    }//GEN-LAST:event_txtCantidadInventarioFocusGained

    private void txtCantidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCantidadFocusGained
        // TODO add your handling code here:
    
    }//GEN-LAST:event_txtCantidadFocusGained

    private void txtCantidadInventarioCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCantidadInventarioCaretUpdate
        // TODO add your handling code here:
         if(txtCantidadInventario.getText().equals("")){
            
        }else{
            try {
                validaCantidadReserva();
            } catch (PDVException ex) {
                Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_txtCantidadInventarioCaretUpdate

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        actualizarVentaContadoConDescuento();
        imprimir(); 
        txtIdArticulo.grabFocus();
       
    }//GEN-LAST:event_btnImprimirActionPerformed
    public void actualizarVentaContadoConDescuento(){
        DecimalFormat formato = new DecimalFormat("#,###.00"); 
        float total;
        try{
            
            int codVenta=Integer.parseInt(txtIdVenta.getText());
            String codArt=txtId.getText();
            
            
            //Number nSaldo = java.text.NumberFormat.getInstance().parse(txtSaldo.getText());
            //float saldo=nSaldo.floatValue();
            String tipoVenta=(String) cboTipoPago.getSelectedItem();
           
            
            if(tipoVenta.equals("CONTADO")){
                if(chkDescuento.isSelected()){
                    if(txtPorcentaje.getText()!=null){
                        clpdv.actualizarVentaContadoConDescuento(codVenta,codArt,txtTotal.getText());
                    
                }
                }
            }
            
            
                    
        }catch (Exception ex){
                Logger.getLogger(VClientes.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
        
         
        
    }//GEN-LAST:event_txtCantidadActionPerformed
    
     
    private void txtIdArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdArticuloActionPerformed
        // TODO add your handling code here:
       
    
    }//GEN-LAST:event_txtIdArticuloActionPerformed

    private void chkDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDescuentoActionPerformed
        // TODO add your handling code here:
        float montoDesc=0;
        if(chkDescuento.isSelected()){
            if(txtPrecioVenta.getText().equals("")){
                JOptionPane.showMessageDialog(null,"No hay un Precio para calcular el Descuento, Favor Verificar","Atención",JOptionPane.ERROR_MESSAGE);
               chkDescuento.setSelected(false);
            }else{
                lblPorc.setVisible(true);
                txtPorcentaje.setVisible(true);
                txtPorcentaje.setText("");
                btnCalcularDesc.setVisible(true);
                lblDescuento.setVisible(true);
                txtDescuento.setVisible(true);
                lblPrecioConDescuento.setVisible(true);
                txtPrecioConDescuento.setVisible(true);

                //si la caja de textos de descuento está vacía entonces no pasa nada
                txtPorcentaje.requestFocus();
                }
            
           
            
            
        }else{
            
            lblPorc.setVisible(false);
            txtPorcentaje.setVisible(false);
            btnCalcularDesc.setVisible(false);
            lblDescuento.setVisible(false);
            txtDescuento.setVisible(false);
            lblPrecioConDescuento.setVisible(false);
            txtPrecioConDescuento.setVisible(false);
            DecimalFormat formato = new DecimalFormat("#,###.00");
          
            try {
                
                Number nPrecioVenta= java.text.NumberFormat.getInstance().parse(inventario.getPrecioVentaUnd());
                 float precioVenta=nPrecioVenta.floatValue();
                 txtPrecioVenta.setText(formato.format(precioVenta));
                 int cantidad=Integer.parseInt(txtCantidad.getText());
                 //validarVenta(montoDesc);
                 float subTotal;
                 subTotal=(cantidad*precioVenta);
                 txtSubTotal.setText(formato.format(subTotal));
                 float totalVenta;
                 float totalDos;
                 
            
                 totalVenta=subTotal;
                 txtTotal.setText(formato.format(totalVenta));
                 
                //nTotalDos = java.text.NumberFormat.getInstance().parse(txtTotalDos.getText());
                //totalDos=nTotalDos.floatValue();
                //txtTotal.setText(txtTotalDos.getText());
            } catch (ParseException ex) {
                Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
            
    }//GEN-LAST:event_chkDescuentoActionPerformed

    private void btnImprimirTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirTicketActionPerformed
    try {
        // TODO add your handling code here:
        imprimirTicket();
    } catch (PDVException | FileNotFoundException ex) {
        Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnImprimirTicketActionPerformed

    private void txtIdArticuloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdArticuloFocusGained
        // TODO add your handling code here:
  
    }//GEN-LAST:event_txtIdArticuloFocusGained

    private void txtIdArticuloComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txtIdArticuloComponentAdded
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtIdArticuloComponentAdded

    private void txtIdArticuloInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtIdArticuloInputMethodTextChanged
        // TODO add your handling code here:
   
    }//GEN-LAST:event_txtIdArticuloInputMethodTextChanged

    private void txtIdArticuloPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtIdArticuloPropertyChange
   
        
    }//GEN-LAST:event_txtIdArticuloPropertyChange

    private void txtIdArticuloVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_txtIdArticuloVetoableChange
        // TODO add your handling code here:
    
    }//GEN-LAST:event_txtIdArticuloVetoableChange

    private void txtPorcentajeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeKeyReleased
    float montoDesc=0;
        if(txtPorcentaje.getText().equals("")){
            txtDescuento.setText("");
            
        try {
            DecimalFormat formato = new DecimalFormat("#,###.00");
            float porcentaje=0;
            float precioVenta;
            float montoDescuento;
            float precioVentaConDesc;
            Number nPrecioVenta= java.text.NumberFormat.getInstance().parse(inventario.getPrecioVentaUnd());
            precioVenta=nPrecioVenta.floatValue();
            txtPrecioVenta.setText(formato.format(precioVenta));
            subTotal(montoDesc);
        } catch (ParseException ex) {
            Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
   
   
   
    }//GEN-LAST:event_txtPorcentajeKeyReleased

    private void txtPorcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPorcentajeActionPerformed
        // TODO add your handling code here:
         evt.setSource((char) KeyEvent.VK_CLEAR);
        btnCalcularDesc.requestFocus();// al presionar enter mandas el cursor a jTextField2
        btnCalcularDesc.doClick();
    }//GEN-LAST:event_txtPorcentajeActionPerformed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed
        //System.out.println("keypressed= "+KeyEvent.getKeyText(evt.getKeyCode()));
        if(KeyEvent.getKeyText(evt.getKeyCode()).equals("F4")){
                try {
                    agregarLineaEnlaTabla();
                } catch (PDVException ex) {
                    Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else{
            if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Escape")){
                cerrar();
           }
        }
    }//GEN-LAST:event_txtCantidadKeyPressed

    private void btnCalcularDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularDescActionPerformed
        // TODO add your handling code here:
        
             
  
        try {
            calcularDescuento();
            txtCantidad.grabFocus();
        }catch (ParseException ex) {
            Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  
  
    
    
   
    }//GEN-LAST:event_btnCalcularDescActionPerformed

    private void chkBotonBuscarArtPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBotonBuscarArtPorNombreActionPerformed
        // TODO add your handling code here:
        if(chkBotonBuscarArtPorNombre.isSelected()){
            btnBuscarNomArt.setVisible(true);
        }else{
            btnBuscarNomArt.setVisible(false);
            
        }
    }//GEN-LAST:event_chkBotonBuscarArtPorNombreActionPerformed

    private void txtDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoKeyReleased

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:
        try {
            VModalBuscarCliente buscarCliente = new VModalBuscarCliente();
            buscarCliente.setVisible(true);
            
        } catch (PDVException ex) {
            Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void btnAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarKeyPressed
     int key = evt.getKeyCode();
     if (key == KeyEvent.VK_F2) {

      JOptionPane.showMessageDialog(null,"No pueden Haber campos vacíos","Atención",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_btnAgregarKeyPressed

    private void btnAgregarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarKeyTyped

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       
        
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
       
    }//GEN-LAST:event_formKeyReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formMouseClicked

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
         // TODO add your handling code here:
       
    
      
    }//GEN-LAST:event_formKeyTyped

    private void txtIdArticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdArticuloKeyPressed
        // TODO add your handling code here:
        if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Escape")){
                cerrar();
           }else{
            if(KeyEvent.getKeyText(evt.getKeyCode()).equals("F6")){
                 actualizarVentaContadoConDescuento();
                imprimir(); 
            }else{
                 if(KeyEvent.getKeyText(evt.getKeyCode()).equals("F2")){
                     nuevaVenta();
                 }
                         
            }
        }
    }//GEN-LAST:event_txtIdArticuloKeyPressed

    private void txtPorcentajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
        if(Character.isLetter(c)) {
              getToolkit().beep();
              evt.consume();
              
              JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Error",JOptionPane.ERROR_MESSAGE);
              
          }
    }//GEN-LAST:event_txtPorcentajeKeyTyped

    private void btnCalcularVueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularVueltoActionPerformed
        // TODO add your handling code here:
        calcularVuelto();
        //hago la resta para calcular el vuelto que recibe el cliente en las compras de contado.
       
    }//GEN-LAST:event_btnCalcularVueltoActionPerformed

    private void txtPorcentajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeKeyPressed
        // TODO add your handling code here:
        
       //Si el usuario presiona la tecla F4 se captura la pulsación de la tecla del teclado
       //y se compara de la sgte manera:
       //el codigo del evento que se disparó a través de la tecla pulsada
       //se convierte a texto para saber cual fue realmente la tecla que se pulsó
       //por ejemplo si se pulsó F4 cuyo codigo es 114 por ejemplo
       //entonces el evento KeyEvent.getKeyText ya sabe que ese código le pertenece
       //a la tecla F4, entonce lo meto en un if y lo comparo para ver si lo que se
       //está pulsando por teclado es igual a "F4" que es lo que me interesa saber si se pulsó
       // si esto es verdadero , se ingresa al if y se ejecuta lo que quiero que se ejecute
       //que es se agregue el producto a la línea de compras.
        if(KeyEvent.getKeyText(evt.getKeyCode()).equals("F4")){
                try {
                    agregarLineaEnlaTabla();
                } catch (PDVException ex) {
                    Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else{
            //caso contrario si se pulsó la tecla escape, se sale del form y regresa al menú principal
            if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Escape")){
               cerrar();
           }
        }
    }//GEN-LAST:event_txtPorcentajeKeyPressed

    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        // TODO add your handling code here:private void btnCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
         int codVenta=Integer.parseInt(txtIdVenta.getText());  
           
                
    ArrayList<Ventas> unaVenta;
                
     
    try {
        unaVenta=clpdv.buscarVentaPorCodVenta(codVenta);
        if(unaVenta==null){
            
        }else{
            for(int i=0;i<unaVenta.size();i++){
               
                inventario=clpdv.buscarArticuloPorCodigo(unaVenta.get(i).getIdArticulo());
                int cantTotal= inventario.getCantidad();
                clpdv.actualizarInventarioDevuelto(unaVenta.get(i).getIdArticulo(),
                                                  (unaVenta.get(i).getCantidad()),
                                                  (cantTotal));
            }
        }
              
        clpdv.cancelarVenta(codVenta);
        JOptionPane.showMessageDialog(null,"Venta Cancelada Satisfactoriamente","Atención",JOptionPane.INFORMATION_MESSAGE);
        tableVentas.setModel(clpdv.getComprasTableModel(codVenta));
        txtIdArticulo.grabFocus();
    } catch (PDVException ex) {
        Logger.getLogger(VCompras.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        
    }//GEN-LAST:event_btnCancelarVentaActionPerformed

    private void txtPagoEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoEfectivoActionPerformed
        // TODO add your handling code here:
         evt.setSource((char) KeyEvent.VK_CLEAR);
         calcularVuelto();
    }//GEN-LAST:event_txtPagoEfectivoActionPerformed
   public void calcularDescuento()throws ParseException{
        float precioVenta=0;
        float porcentaje=0;
        float precioVentaConDesc=0;
        float montoDescuento=0;
        
        DecimalFormat formato = new DecimalFormat("#,###.00");
        
        
           
            Number nPorcentaje = java.text.NumberFormat.getInstance().parse(txtPorcentaje.getText());
            porcentaje=nPorcentaje.floatValue();
            Number nPrecioVenta = java.text.NumberFormat.getInstance().parse(txtPrecioVenta.getText());
            precioVenta= nPrecioVenta.floatValue();
            montoDescuento=((porcentaje/100)*precioVenta);
            precioVentaConDesc=(precioVenta-montoDescuento);
        
       
        //java.text.DecimalFormat formatoSalidaDecimal = new java.text.DecimalFormat("0.00");//para dos decimales  
        
          //txtPrecioVenta.setText(formato.format(precioVentaConDesc));
          txtPrecioConDescuento.setText(formato.format(precioVentaConDesc));
          txtDescuento.setText(formato.format(montoDescuento));
          validarVenta(montoDescuento);
        
        
   }
   private void teclaPresionada(int F4) throws PDVException, ParseException{
       if(F4==KeyEvent.VK_F4);
       agregarLineaEnlaTabla();
           
   }
    public void imprimirTicket()throws PDVException, FileNotFoundException{
        PrinterMatrix printer = new PrinterMatrix();
 
        Extenso e = new Extenso();
 
        e.setNumber(101.85);
 
 
        //Definir el tamanho del papel para la impresion  aca 25 lineas y 80 columnas
        printer.setOutSize(60, 80);
        //Imprimir * de la 2da linea a 25 en la columna 1;
       // printer.printCharAtLin(2, 25, 1, "*");
        //Imprimir * 1ra linea de la columa de 1 a 80
       printer.printCharAtCol(1, 1, 80, "=");
        //Imprimir Encabezado nombre del La EMpresa
       printer.printTextWrap(1, 2, 30, 80, "FACTURA DE VENTA");
       //printer.printTextWrap(linI, linE, colI, colE, null);
       printer.printTextWrap(2, 3, 1, 22, "Num. Boleta : " + txtIdVenta.getText());
       printer.printTextWrap(2, 3, 25, 55, "Fecha de Emision: " + dpFechaActual.getDate());
       printer.printTextWrap(2, 3, 60, 80, "Hora: 12:22:51");
       //printer.printTextWrap(3, 3, 1, 80, "Vendedor.  : "+ txtVentaIdVendedor.getText() +" - " + txtVentaNombreVendedor.getText());
       printer.printTextWrap(4, 4, 1, 80, "CLIENTE: " + txtCliente.getText());
      // printer.printTextWrap(5, 5, 1, 80, "RUC/CI.: " + txtVentaRucCliente.getText());
       printer.printTextWrap(6, 6, 1, 80, "DIRECCION: " + "");
       printer.printCharAtCol(7, 1, 80, "=");
       printer.printTextWrap(7, 8, 1, 90, "Codigo          Descripcion                Cant.      P  P.Unit.      P.SubTotal");
       printer.printCharAtCol(9, 1, 80, "-");
       //int filas = tblVentas.getRowCount();
       int row = tableVentas.getRowCount();
       VentasTableModel vtm = (VentasTableModel)tableVentas.getModel();
 
        for (int i=0; i<row; i++){ 
        printer.printTextWrap(9 + i, 10, 1, 90, tableVentas.getValueAt(i,0).toString()+"|"+tableVentas.getValueAt(i,1).toString()+"| "+tableVentas.getValueAt(i,2).toString()+"| "+tableVentas.getValueAt(i,3).toString()+"|"+ tableVentas.getValueAt(i,4).toString());}
        
        if(row > 15){
        printer.printCharAtCol(row + 1, 1, 80, "=");
        printer.printTextWrap(row + 1, row + 2, 1, 90, "TOTAL A PAGAR " + txtTotal.getText());
        printer.printCharAtCol(row + 2, 1, 80, "=");
        printer.printTextWrap(row + 2, row + 3, 1, 80, "Esta boleta no tiene valor fiscal, solo para uso interno.: + Descripciones........");
        }else{
        printer.printCharAtCol(25, 1, 80, "=");
        printer.printTextWrap(26, 26, 1, 80, "TOTAL A PAGAR " + txtTotal.getText());
        printer.printCharAtCol(27, 1, 80, "=");
        printer.printTextWrap(27, 28, 1, 80, "Esta boleta no tiene valor fiscal, solo para uso interno.: + Descripciones........");
 
        }
        printer.toFile("impresion.txt");
 
      FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("impresion.txt");
        } catch (FileNotFoundException ex) {
        }
        if (inputStream == null) {
            return;
        }
 
        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document = new SimpleDoc(inputStream, docFormat, null);
 
        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
 
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
 
 
        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);
 
            } catch (PrintException ex) {
            }
        } else {
            System.err.println("No existen impresoras instaladas");
        }
 
        //inputStream.close();
       
   }
   
    
    public void imprimir(){
        try{
            Reportes reporte=new Reportes();
            int venta=Integer.parseInt(txtIdVenta.getText());
            reporte.ReporteFactura(venta);
        }catch(JRException ex){
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE,null, ex);
        }catch(SQLException ex){
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE,null, ex);
        }
            
   }
    public void validaCantidadReserva()throws PDVException{
       inventario=clpdv.buscarArticuloPorCodigo(txtIdArticulo.getText());
       int cantidadReserva=inventario.getCantidadReserva();
       int cantidadInventario=Integer.parseInt(txtCantidadInventario.getText());
       
       if(cantidadInventario<cantidadReserva){
           JOptionPane.showMessageDialog(null,"Quedan [ "+ cantidadInventario +" ] Artículos tipo [ " + txtArticulo.getText() +" ] en la Base de Datos,La cantidad Mínima es [ "+cantidadReserva+" ], Favor aumentar el Inventario","Atención",JOptionPane.INFORMATION_MESSAGE);
           
       }
   }
    public void subTotal(float pMontoDesc) throws ParseException{
        
        int cantidad;
        float precioVenta;
        float subTotal=0;
        float totalVenta=0;
        float descuento=0;
        float cantPorc=0;
        float totalDos=0;
        
        
        DecimalFormat formato = new DecimalFormat("#,###.00");
        
        Number venta = java.text.NumberFormat.getInstance().parse(txtPrecioVenta.getText());
        precioVenta =venta.floatValue();
        if(txtTotalDos.getText().equals("")){
            totalDos=0;
        }else{
            Number nTotalDos = java.text.NumberFormat.getInstance().parse(txtTotalDos.getText());
            totalDos=nTotalDos.floatValue();
            
        }
        
        cantidad = Integer.parseInt((txtCantidad.getText()));
        
       //significa que ya se ha ingresado una cantidad de articulos y que el usuario digito otra cantidad distinta
       //a la ingresada primeramente
       //si la nueva cantidad ingresada es igual a la cantidad que se ingresó de primero
       //no pasa nada
        if(txtCantidad.getText().equals(txtCantDos.getText()) && txtId.getText().equals(txtIdArticulo.getText())){
            txtSubTotal.setText(txtSubTotal.getText());
            txtTotal.setText(txtTotalDos.getText());
            
        }else{
            if(txtId.getText().equals(txtIdArticulo.getText())&& txtCantidad.getText()!= txtCantDos.getText()){
                //se hace el nuevo calculo con la nnueva cantidad la cual es distinta a la cantidad que se había agregado
                //de primero y se iguala el total al subtotal 
                subTotal=(cantidad*precioVenta);
                txtSubTotal.setText(formato.format(subTotal));
                totalVenta=subTotal;
                txtTotal.setText(formato.format(totalVenta));
            }else{
                //se ha ingresado un nuevo codigo de articulo
                if(txtIdArticulo.getText()!= txtId.getText()){
                    txtCantDos.setText("");
                    subTotal=(cantidad*precioVenta);
                    txtSubTotal.setText(formato.format(subTotal));
                    totalVenta=totalDos+subTotal;
                    txtTotal.setText(formato.format(totalVenta));
                    
                }
            }
            
        }
        if(chkDescuento.isSelected()&& txtPorcentaje.getText()!=null){
            //cantPorc=Integer.parseInt(txtPorcentaje.getText());
            float precioVentaConDesc;
            Number nPrecioVentaConDesc = java.text.NumberFormat.getInstance().parse(txtPrecioConDescuento.getText());
            precioVentaConDesc=nPrecioVentaConDesc.floatValue();
            
            subTotal=(cantidad*precioVentaConDesc);
            txtSubTotal.setText(formato.format(subTotal));
            totalVenta=totalDos+subTotal;
            txtTotal.setText(formato.format(totalVenta));
        }
        /*}else{
            subTotal=(cantidad*precioVenta);
            txtSubTotal.setText(formato.format(subTotal));
            totalVenta=totalVenta+subTotal;
            txtTotal.setText(formato.format(totalVenta));
        }
        
        // significa que ya no es el primer producto que se está vendiendo
        if(txtIdArticulo.getText()!= txtId.getText()){
            if(txtCantidad.getText().equals(txtCantDos.getText()) && txtId.getText().equals(txtIdArticulo.getText())){
                txtSubTotal.setText(txtSubTotal.getText());
                txtTotal.setText(txtTotalDos.getText());
            }else{
                if(txtId.getText().equals(txtIdArticulo.getText())&& txtCantidad.getText()!= txtCantDos.getText()){
                    //se hace el nuevo calculo con la nnueva cantidad la cual es distinta a la cantidad que se había agregado
                    //de primero y se iguala el total al subtotal 
                    subTotal=(cantidad*precioVenta);
                    txtSubTotal.setText(formato.format(subTotal));
                    totalVenta=subTotal;
                    txtTotal.setText(formato.format(totalVenta));
                }
            }
            
        
        if(chkDescuento.isSelected()&& txtPorcentaje.getText()!=null){
            //cantPorc=Integer.parseInt(txtPorcentaje.getText());
            subTotal=(cantidad*precioVenta);
            txtSubTotal.setText(formato.format(subTotal));
            totalVenta=totalDos-pMontoDesc;
            txtTotal.setText(formato.format(totalVenta));
        }else{
            subTotal=(cantidad*precioVenta);
            txtSubTotal.setText(formato.format(subTotal));
            totalVenta=totalVenta+subTotal;
            txtTotal.setText(formato.format(totalVenta));
        }
        }*/
        
        
       
        txtCantDos.setText(txtCantidad.getText());
        
        
    }
    
    public void calcularSaldo() throws PDVException, ParseException{
       float abono;
       float saldo;
       float total;
       DecimalFormat formato = new DecimalFormat("#,###.00");
        if(txtPagoInicial.getText().equals("")){
            txtSaldo.setText(formato.format(txtTotal.getText()));
        }else{
            
            Number ab = java.text.NumberFormat.getInstance().parse(txtPagoInicial.getText());
            abono=ab.floatValue();
            Number nSaldo = java.text.NumberFormat.getInstance().parse(txtSaldo.getText());
            saldo=nSaldo.floatValue();
            Number nTotal = java.text.NumberFormat.getInstance().parse(txtTotal.getText());
            total=nTotal.floatValue();
            
            if(abono>total){
                JOptionPane.showMessageDialog(null,"El Pago Inicial no puede ser mayor al total de la deuda","Atención",JOptionPane.ERROR_MESSAGE);
                txtPagoInicial.setText("");
                txtPagoInicial.requestFocus();
                
            }else{
                saldo= total-abono;
                txtSaldo.setText(formato.format(saldo));
                txtPagoInicial.setText(formato.format(abono));
                
                 try {
                     if(cboTipoPago.getSelectedItem().equals("CREDITO")){
                         actualizarTotalVenta();
                         crearPago(); 
                     }
                     } catch (PDVException ex) {
                         Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
                     }
            }
        }
        txtIdArticulo.grabFocus();
            
    }
    public void actualizarTotalVenta()throws PDVException{
        try{
            DecimalFormat formato = new DecimalFormat("#,###.00");
            int codVenta=Integer.parseInt(txtIdVenta.getText());
            String codArt=txtId.getText();
            //Number nSaldo = java.text.NumberFormat.getInstance().parse(txtSaldo.getText());
            //float saldo=nSaldo.floatValue();
            String tipoVenta=(String) cboTipoPago.getSelectedItem();
           
            
            clpdv.actualizarTotalVenta(codVenta,tipoVenta);
            
                    
        }catch (Exception ex){
                Logger.getLogger(VClientes.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    public void buscarArticuloPorCodigo() throws ParseException{
     DecimalFormat formato = new DecimalFormat("#,###.00");   
    try {
        // TODO add your handling code here:
        inventario = clpdv.buscarArticuloPorCodigo(txtIdArticulo.getText());
    } catch (PDVException ex) {
        Logger.getLogger(VCompras.class.getName()).log(Level.SEVERE, null, ex);
    }
    if(inventario==null){
        //JOptionPane.showMessageDialog(null,"El Articulo Codigo [" + txtIdArticulo.getText() + "] no Existe en el inventario, favor Verificar!!!","Atención",JOptionPane.ERROR_MESSAGE);
        //txtIdArticulo.setText("");
        //txtIdArticulo.grabFocus();
    }else{
        String nombre = inventario.getNombreProducto();
        int cantidad = inventario.getCantidad();
        
        Number nPrecioVenta= java.text.NumberFormat.getInstance().parse(inventario.getPrecioVentaUnd());
        float precioVenta=nPrecioVenta.floatValue();
        
        int cantidadInventario=inventario.getCantidad();
        //int cantReserva=inventario.getCantidadReserva();
        //if(cantidadInventario<=cantReserva){
          //  JOptionPane.showMessageDialog(null,"Quedan [ "+ cantidadInventario +" ] Artículos tipo [ " + nombre +" ] en la Base de Datos,La Cantidad Mínima es [ "+ cantReserva +" ] Favor aumentar el Inventario","Atención",JOptionPane.INFORMATION_MESSAGE);
        //}
        txtPrecioVenta.setText(formato.format(precioVenta));
        txtArticulo.setText(nombre);
        txtPrecioVenta.setText(formato.format(precioVenta));
        txtCantidadInventario.setText(Integer.toString(cantidadInventario));
        if(txtCliente.getText().equals("")){
             txtCliente.requestFocus();
             txtId.setText(txtIdArticulo.getText());
            
        }else{
            
            txtCantidad.requestFocus();
        }
       
        
    }
    }
    
    public static String fechaActual(){
        Date fecha=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYY");
        return sdf.format(fecha);
        
    }
    /**
     * @param args the command line arguments
     */
    private  CLPDV clpdv;
    public static void main(String args[]) {
       
     
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VVentas().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(VVentas.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }
        });
        
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarNomArt;
    private javax.swing.JButton btnCalcularDesc;
    private javax.swing.JButton btnCalcularSaldo;
    private javax.swing.JButton btnCalcularVuelto;
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnImprimirTicket;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JButton btnQuitarProducto;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboTipoPago;
    private javax.swing.JCheckBox chkBotonBuscarArtPorNombre;
    private javax.swing.JCheckBox chkDescuento;
    private com.github.lgooddatepicker.components.DatePicker dpFechaActual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblPInicial;
    private javax.swing.JLabel lblPagoEfectivo;
    private javax.swing.JLabel lblPorc;
    private javax.swing.JLabel lblPrecioConDescuento;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblVuelto;
    private javax.swing.JTable tableVentas;
    public static javax.swing.JLabel txtArticulo;
    private javax.swing.JTextField txtCantDos;
    public static javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtCantidadInventario;
    private javax.swing.JTextField txtCedula;
    public static javax.swing.JLabel txtCliente;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtIdArticulo;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtPagoEfectivo;
    private javax.swing.JTextField txtPagoInicial;
    private javax.swing.JTextField txtPorcentaje;
    private javax.swing.JTextField txtPrecioConDescuento;
    public static javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtSubTotal;
    public static javax.swing.JTextField txtTipoUsuario;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTotalDos;
    public static javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtVuelto;
    // End of variables declaration//GEN-END:variables

    private void agregarLineaEnLaTabla() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public class MyKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("keypressed= "+KeyEvent.getKeyText(e.getKeyCode()));
           if(KeyEvent.getKeyText(e.getKeyCode()).equals("Escape")){
                if(txtTipoUsuario.getText().equals("DEPENDIENTE")){
                    dispose();
                    VMenuAdmin menuAdmin= new VMenuAdmin();
                    menuAdmin.setVisible(true);
                    VMenuAdmin.btnClientes.setEnabled(false);
                    VMenuAdmin.btnInventario.setEnabled(false);
                    VMenuAdmin.btnCompras.setEnabled(false);
                    VMenuAdmin.btnPagos.setEnabled(false);
                    VMenuAdmin.btnProveedor.setEnabled(false);
                    VMenuAdmin.btnReportes.setEnabled(false);
                    VMenuAdmin.btnVentasConsignacion.setEnabled(false);
                    VMenuAdmin.txtTipoUsuario.setText(txtTipoUsuario.getText());
                }else{
                    if(txtTipoUsuario.getText().equals("ADMINISTRADOR")){
                        dispose();
                        VMenuAdmin menuAdmin= new VMenuAdmin();
                        menuAdmin.setVisible(true);
                        VMenuAdmin.txtTipoUsuario.setText(txtTipoUsuario.getText());
                    }
                }
           }
           
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased= "+KeyEvent.getKeyText(e.getKeyCode()));
        }
    
}

   
}
