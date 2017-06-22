/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Objects.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Erick Cordero
 */
public class VPagos extends javax.swing.JFrame {
private Pagos pago;

private Account unaCuenta;
private OpcionesUsuario unUsuario;
private Usuario usuario;

    /**
     * Creates new form VPagos
     */
    public VPagos() {
        initComponents();
        pago=null;
        unaCuenta=null;
        unUsuario=null;
        usuario=null;
        
        clpdv = new CLPDV();
        dpFechaActual.setDateToToday();
        this.setLocationRelativeTo(null);
        buscarNoPago();
        txtTotal.setHorizontalAlignment(JTextField.RIGHT);
        txtAbono.setHorizontalAlignment(JTextField.RIGHT);
        txtSaldo.setHorizontalAlignment(JTextField.RIGHT);
    }
    public void buscarNoPago(){
       int idPago=0;
         try{
             pago=clpdv.buscarNoPago();
             idPago=(pago.getCodPago()+1);
             txtNumFactura.setText(Integer.toString(idPago));
             txtNumFactura.grabFocus();
             txtIdCliente.requestFocus();
             //txtIdVenta.setText(Integer.toString(idVenta));
            //txtIdArticulo.grabFocus();
         }catch (Exception ex){
             Logger.getLogger(VClientes.class.getName()).log(Level.SEVERE,null, ex);
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

        txtUsuario = new javax.swing.JTextField();
        panel_Clientes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnBuscarCOD = new javax.swing.JButton();
        btnBuscarCED = new javax.swing.JButton();
        btnBuscarNOMBRE = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNumFactura = new javax.swing.JTextField();
        btnBuscarFactura = new javax.swing.JButton();
        dpFechaActual = new com.github.lgooddatepicker.components.DatePicker();
        panel_Pagos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAbono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        dpFechaUltPago = new com.github.lgooddatepicker.components.DatePicker();
        panel_Opciones = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cuentas por Cobrar");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(1451, 979));
        setName("Cuentas por Cobrar"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(927, 699));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_Clientes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("COD.Cliente:");
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtIdCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtIdCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdClienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdClienteKeyTyped(evt);
            }
        });

        jLabel2.setText("Cedula:");
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtCedula.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        jLabel3.setText("Nombre:");
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        btnBuscarCOD.setText("...");
        btnBuscarCOD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCODActionPerformed(evt);
            }
        });

        btnBuscarCED.setText("...");
        btnBuscarCED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCEDActionPerformed(evt);
            }
        });

        btnBuscarNOMBRE.setText("...");
        btnBuscarNOMBRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNOMBREActionPerformed(evt);
            }
        });

        jLabel8.setText("Num.Factura:");
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtNumFactura.setEditable(false);
        txtNumFactura.setBackground(new java.awt.Color(153, 255, 153));
        txtNumFactura.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnBuscarFactura.setText("jButton1");
        btnBuscarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_ClientesLayout = new javax.swing.GroupLayout(panel_Clientes);
        panel_Clientes.setLayout(panel_ClientesLayout);
        panel_ClientesLayout.setHorizontalGroup(
            panel_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ClientesLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(panel_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_ClientesLayout.createSequentialGroup()
                        .addGroup(panel_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(panel_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_ClientesLayout.createSequentialGroup()
                                .addGroup(panel_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdCliente)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuscarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addGroup(panel_ClientesLayout.createSequentialGroup()
                                        .addGroup(panel_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnBuscarNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnBuscarCOD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(panel_ClientesLayout.createSequentialGroup()
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(btnBuscarCED, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(83, 83, 83))
        );
        panel_ClientesLayout.setVerticalGroup(
            panel_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnBuscarFactura))
                .addGap(18, 18, 18)
                .addGroup(panel_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnBuscarCOD))
                .addGroup(panel_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ClientesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarCED)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(panel_ClientesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panel_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(panel_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarNOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(panel_Clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 810, 210));

        dpFechaActual.setEnabled(false);
        getContentPane().add(dpFechaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 30, 271, -1));

        panel_Pagos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pagos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel4.setText("Fecha Ultimo Pago:");
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setText("Saldo :");
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(153, 255, 153));
        txtTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Abono:");
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtAbono.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtAbono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAbonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAbonoKeyTyped(evt);
            }
        });

        jLabel7.setText("Nuevo Saldo:");
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtSaldo.setEditable(false);
        txtSaldo.setBackground(new java.awt.Color(153, 255, 153));
        txtSaldo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        dpFechaUltPago.setEnabled(false);

        javax.swing.GroupLayout panel_PagosLayout = new javax.swing.GroupLayout(panel_Pagos);
        panel_Pagos.setLayout(panel_PagosLayout);
        panel_PagosLayout.setHorizontalGroup(
            panel_PagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PagosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panel_PagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_PagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_PagosLayout.createSequentialGroup()
                        .addGroup(panel_PagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotal)
                            .addComponent(txtAbono)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCalcular))
                    .addComponent(dpFechaUltPago, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panel_PagosLayout.setVerticalGroup(
            panel_PagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PagosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panel_PagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpFechaUltPago, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(13, 13, 13)
                .addGroup(panel_PagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_PagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_PagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        getContentPane().add(panel_Pagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 810, 230));

        panel_Opciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        btnGuardar.setText("Guardar");
        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_OpcionesLayout = new javax.swing.GroupLayout(panel_Opciones);
        panel_Opciones.setLayout(panel_OpcionesLayout);
        panel_OpcionesLayout.setHorizontalGroup(
            panel_OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_OpcionesLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        panel_OpcionesLayout.setVerticalGroup(
            panel_OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_OpcionesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel_OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(panel_Opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, 810, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        cerrar();
     
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
           if(Character.isLetter(c)) {
              getToolkit().beep();
              evt.consume();
              
              JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!,","Error",JOptionPane.ERROR_MESSAGE);
              
          }
           if (txtCedula.getText().length()>=9) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtAbonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
           if(Character.isLetter(c)) {
              getToolkit().beep();
              evt.consume();
              
              JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!,","Error",JOptionPane.ERROR_MESSAGE);
              
          }
    }//GEN-LAST:event_txtAbonoKeyTyped

    private void txtIdClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdClienteKeyTyped
        // TODO add your handling code here:
         char c=evt.getKeyChar();
           if(Character.isLetter(c)) {
              getToolkit().beep();
              evt.consume();
              
              JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!,El Código de Usuario es un dato Numérico","Error",JOptionPane.ERROR_MESSAGE);
              
          }
    }//GEN-LAST:event_txtIdClienteKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
         char charecter = evt.getKeyChar();
        if (Character.isLowerCase(charecter)) {
            evt.setKeyChar(Character.toUpperCase(charecter));
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnBuscarCODActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCODActionPerformed
    try {
        // TODO add your handling code here:
        buscarIdCliente();
    } catch (PDVException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_btnBuscarCODActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
    try {
        // TODO add your handling code here:
        calcularNuevoSaldo();
    } catch (PDVException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    try {
        // TODO add your handling code here:
        guardarPago();
    } catch (PDVException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarCEDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCEDActionPerformed
        // TODO add your handling code here:
        try {
        // TODO add your handling code here:
        buscarPorCedula();
    } catch (PDVException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnBuscarCEDActionPerformed

    private void btnBuscarNOMBREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNOMBREActionPerformed
        // TODO add your handling code here:
           try {
        // TODO add your handling code here:
        buscarPorNombre();
    } catch (PDVException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnBuscarNOMBREActionPerformed

    private void txtIdClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdClienteKeyReleased
    try {
        // TODO add your handling code here:
        buscarIdCliente();
    } catch (PDVException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_txtIdClienteKeyReleased

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased
    try {
        // TODO add your handling code here:
        buscarPorCedula();
    } catch (PDVException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_txtCedulaKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
    try {
        // TODO add your handling code here:
        buscarPorNombre();
    } catch (PDVException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtIdClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdClienteKeyPressed
        // TODO add your handling code here:
        if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Escape")){
           cerrar();
         }
    }//GEN-LAST:event_txtIdClienteKeyPressed

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
        // TODO add your handling code here:
        if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Escape")){
            cerrar();
         }
    }//GEN-LAST:event_txtCedulaKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
        if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Escape")){
            cerrar();
         }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtAbonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbonoKeyPressed
        // TODO add your handling code here:
        if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Escape")){
            cerrar();
         }
    }//GEN-LAST:event_txtAbonoKeyPressed

    private void btnBuscarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFacturaActionPerformed
    try {
        // TODO add your handling code here:
        buscarFactura();
    } catch (ParseException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnBuscarFacturaActionPerformed
    public void buscarFactura() throws ParseException{
         DecimalFormat formato = new DecimalFormat("#,###.00");   
        try{
            int numFactura=Integer.parseInt(txtNumFactura.getText());
            pago=clpdv.buscarPagosPorFactura(numFactura);
            if(pago==null){
                JOptionPane.showMessageDialog(null,"La Factura [" + numFactura +"] NO existe en la Base de Datos, Favor Verificar!!!","Atención",JOptionPane.ERROR_MESSAGE);
                txtIdCliente.setText("");
                txtIdCliente.requestFocus();
            }else{
               
               
               String cedula=pago.getCedula();
               String nombre=pago.getNombreCliente();
               LocalDate fechaUltPago=pago.getFechaUltPago();
               Number nSaldo= java.text.NumberFormat.getInstance().parse(pago.getSaldo());
               float saldo=nSaldo.floatValue();
               Number nAbono= java.text.NumberFormat.getInstance().parse(pago.getAbono());
               float abono=nAbono.floatValue();
              
              
               
               
               txtCedula.setText(cedula);
               txtNombre.setText(nombre);
               dpFechaUltPago.setDate(fechaUltPago);
               txtTotal.setText(formato.format(saldo));
               txtAbono.requestFocus();
         
            }
        } catch (PDVException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void buscarPorNombre()throws PDVException, ParseException{
        DecimalFormat formato = new DecimalFormat("#,###.00");   
        try{
            String nombre=txtNombre.getText();
            pago=clpdv.buscarPagosPorNombre(nombre);
            if(pago==null){
               // JOptionPane.showMessageDialog(null,"El  Cliente  [" + nombre +"] NO existe en la Base de Datos, Favor Verificar!!!","Atención",JOptionPane.ERROR_MESSAGE);
                //txtIdCliente.setText("");
                //txtIdCliente.requestFocus();
            }else{
               
               
               int codCliente=pago.getCodCliente();
               String cedula=pago.getCedula();
               LocalDate fechaUltPago=pago.getFechaUltPago();
               Number nSaldo= java.text.NumberFormat.getInstance().parse(pago.getSaldo());
               float saldo=nSaldo.floatValue();
               Number nAbono= java.text.NumberFormat.getInstance().parse(pago.getAbono());
               float abono=nAbono.floatValue();
               
              
               
               
               txtIdCliente.setText(Integer.toString(codCliente));
               txtCedula.setText(cedula);
               txtNombre.setText(nombre);
               dpFechaUltPago.setDate(fechaUltPago);
               txtTotal.setText(formato.format(saldo));
               txtAbono.requestFocus();
         
            }
        } catch (PDVException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    public void buscarPorCedula()throws PDVException, ParseException{
       DecimalFormat formato = new DecimalFormat("#,###.00");   
        try{
            String cedula=txtCedula.getText();
            pago=clpdv.buscarPagosPorCedula(cedula);
            if(pago==null){
                //JOptionPane.showMessageDialog(null,"El  Cliente Cédula [" + cedula +"] NO existe en la Base de Datos, Favor Verificar!!!","Atención",JOptionPane.ERROR_MESSAGE);
                //txtIdCliente.setText("");
                //txtIdCliente.requestFocus();
            }else{
               
               
               int codCliente=pago.getCodCliente();
               String nombre=pago.getNombreCliente();
               LocalDate fechaUltPago=pago.getFechaUltPago();
               Number nSaldo= java.text.NumberFormat.getInstance().parse(pago.getSaldo());
               float saldo=nSaldo.floatValue();
               Number nAbono= java.text.NumberFormat.getInstance().parse(pago.getAbono());
               float abono=nAbono.floatValue();
              
               
               
               txtIdCliente.setText(Integer.toString(codCliente));
               txtCedula.setText(cedula);
               txtNombre.setText(nombre);
               dpFechaUltPago.setDate(fechaUltPago);
               txtTotal.setText(formato.format(saldo));
               txtAbono.requestFocus();
         
            }
        } catch (PDVException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void guardarPago()throws PDVException{
         try{
            int codPago;
            codPago=Integer.parseInt(txtNumFactura.getText());
            int codCliente=Integer.parseInt(txtIdCliente.getText());
            clpdv.crearPago(codPago,codCliente,txtCedula.getText(),txtNombre.getText(),dpFechaActual.getDate(),txtTotal.getText(),txtAbono.getText(),txtSaldo.getText(),Integer.parseInt(txtNumFactura.getText()));
            JOptionPane.showMessageDialog(null,"Pago realizado con Éxito","Atención",JOptionPane.INFORMATION_MESSAGE);
            if(txtSaldo.getText().equals(0)){
                JOptionPane.showMessageDialog(null,"La Cuenta ha sido cancelada","Atención",JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            }else{
                 limpiar();
                
            }
           
        }catch (PDVException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void limpiar(){
        txtIdCliente.setText("");
        txtCedula.setText("");
        txtNombre.setText("");
        dpFechaUltPago.setText("");
        txtTotal.setText("");
        txtAbono.setText("");
        txtSaldo.setText("");
        txtIdCliente.requestFocus();
        buscarNoPago();
    }
    public void calcularNuevoSaldo()throws PDVException, ParseException{
        float saldo;
        float abono;
        float nuevoSaldo;
        DecimalFormat formato=new DecimalFormat("#,###.00");
        Number nSaldo= java.text.NumberFormat.getInstance().parse(txtTotal.getText());
               
        saldo=nSaldo.floatValue();
        Number nAbono= java.text.NumberFormat.getInstance().parse(txtAbono.getText());
        abono=nAbono.floatValue();
        
       if(abono>saldo){
           JOptionPane.showMessageDialog(null,"El Abono no puede ser mayor al saldo, favor verificar","Atención",JOptionPane.ERROR_MESSAGE);
           txtAbono.setText("");
           txtAbono.requestFocus();
       }else{
           nuevoSaldo=saldo-abono;
           txtSaldo.setText(formato.format(nuevoSaldo));
           
       }
        
        
        
    }
    public void buscarIdCliente()throws PDVException, ParseException{
       DecimalFormat formato = new DecimalFormat("#,###.00");   
        try{
            int CODCliente=Integer.parseInt(txtIdCliente.getText());
            pago=clpdv.buscarPagosPorFactura(CODCliente);
            if(pago==null){
                JOptionPane.showMessageDialog(null,"El Código Cliente [" + CODCliente +"] NO existe en la Base de Datos, Favor Verificar!!!","Atención",JOptionPane.ERROR_MESSAGE);
                txtIdCliente.setText("");
                txtIdCliente.requestFocus();
            }else{
               
               
               String cedula=pago.getCedula();
               String nombre=pago.getNombreCliente();
               LocalDate fechaUltPago=pago.getFechaUltPago();
               Number nSaldo= java.text.NumberFormat.getInstance().parse(pago.getSaldo());
               float saldo=nSaldo.floatValue();
               Number nAbono= java.text.NumberFormat.getInstance().parse(pago.getAbono());
               float abono=nAbono.floatValue();
              
              
               
               
               txtCedula.setText(cedula);
               txtNombre.setText(nombre);
               dpFechaUltPago.setDate(fechaUltPago);
               txtTotal.setText(formato.format(saldo));
               txtAbono.requestFocus();
         
            }
        } catch (PDVException ex) {
        Logger.getLogger(VPagos.class.getName()).log(Level.SEVERE, null, ex);
    }
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
            java.util.logging.Logger.getLogger(VPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCED;
    private javax.swing.JButton btnBuscarCOD;
    private javax.swing.JButton btnBuscarFactura;
    private javax.swing.JButton btnBuscarNOMBRE;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private com.github.lgooddatepicker.components.DatePicker dpFechaActual;
    private com.github.lgooddatepicker.components.DatePicker dpFechaUltPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel panel_Clientes;
    private javax.swing.JPanel panel_Opciones;
    private javax.swing.JPanel panel_Pagos;
    private javax.swing.JTextField txtAbono;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumFactura;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
