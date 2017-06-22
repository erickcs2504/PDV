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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Erick Cordero
 */
public class VProveedores extends javax.swing.JFrame {
    private Proveedores proveedor;
    private ArrayList<Proveedores> unProveedor;
    
    private Account unaCuenta;
    private OpcionesUsuario unUsuario;
    private Usuario usuario;

    /**
     * Creates new form VClientes
     */
    public VProveedores() {
        initComponents();
        this.setLocationRelativeTo(null);
        unProveedor=null;
        unaCuenta=null;
        unUsuario=null;
        usuario=null;
        clpdv = new CLPDV();
        buscarCodProveedor();
        txtEmpresa.grabFocus();
    }
    
    public void validarExisteProveedor() throws PDVException{
        
        proveedor=clpdv.buscarProveedorPorNombre(txtEmpresa.getText());
        if(unProveedor==null){
            
        }else{
            if(proveedor.getEmpresa().equals(txtEmpresa.getText())){
                JOptionPane.showMessageDialog(null,"El Proveedor ["+ txtEmpresa.getText() +"] Ya existe, Favor Verificar","Atención", JOptionPane.ERROR_MESSAGE);
                txtEmpresa.setText("");
                txtEmpresa.grabFocus();
            }
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdProveedor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Proveedores");
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(1451, 979));
        setMinimumSize(new java.awt.Dimension(1451, 979));
        setName("Proveedores"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1451, 979));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("Codigo:");

        txtIdProveedor.setEditable(false);
        txtIdProveedor.setBackground(new java.awt.Color(153, 255, 153));
        txtIdProveedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Contacto:");

        txtNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel3.setText("Empresa:");

        txtEmpresa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpresaActionPerformed(evt);
            }
        });
        txtEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmpresaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmpresaKeyTyped(evt);
            }
        });

        jLabel4.setText("Teléfono1:");

        txtTelefono1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTelefono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefono1ActionPerformed(evt);
            }
        });
        txtTelefono1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefono1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono1KeyTyped(evt);
            }
        });

        jLabel5.setText("Teléfono 2:");

        txtTelefono2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTelefono2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefono2ActionPerformed(evt);
            }
        });
        txtTelefono2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefono2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono2KeyTyped(evt);
            }
        });

        jLabel6.setText("E-mail:");

        txtEmail.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addComponent(txtTelefono1)
                    .addComponent(txtTelefono2)
                    .addComponent(txtEmail)
                    .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmpresa))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 761, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtNuevo.setText("Nuevo Proveedor");
        txtNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(txtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, -1, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void buscarCodProveedor(){
        String idProveedor;
         try{
             proveedor=clpdv.buscarCodProveedor();
             idProveedor=Integer.toString(proveedor.getCodProveedor()+1);
             txtIdProveedor.setText(idProveedor);
             txtEmpresa.grabFocus();
         }catch (Exception ex){
             Logger.getLogger(VClientes.class.getName()).log(Level.SEVERE,null, ex);
         }
    }
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
       
        
  
        //se comunica con la CL para averiguar si el numero de cedula que se 
        //está introduciendo ya existe o no en la BD
          try {
              proveedor= clpdv.buscarProveedorPorNombre(txtEmpresa.getText());
          } catch (PDVException ex) {
              Logger.getLogger(VProveedores.class.getName()).log(Level.SEVERE, null, ex);
          }
          //Si la cedula no existe entonces unCliente va a ser igual a null
          //y se le indica que debe ingresar al procedimiento para agregar un
          //nuevo cliente
        if( txtNombre.getText().equals("") || txtEmpresa.getText().equals("") || txtTelefono1.getText().equals("") || txtTelefono2.getText().equals("") || txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"No pueden Haber campos vacíos","Atención",JOptionPane.ERROR_MESSAGE);
        }else{
        if(proveedor==null){
            try {
                crearProveedor();
            } catch (PDVException ex) {
                Logger.getLogger(VProveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
        
            //caso contrario significa que ese numero de cedula que se ha introducido
            //ya existe en la BD
            JOptionPane.showMessageDialog(null,"El Cliente con Nombre ["+ txtNombre.getText() + "] Ya Existe en la Base de Datos, Favor Verificar!!!","Atención",JOptionPane.ERROR_MESSAGE);
            limpiar();
        }
        }
    
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuevoActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_txtNuevoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtTelefono1.requestFocus();// al presionar enter mandas el cursor a jTextField2
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpresaActionPerformed
        // TODO add your handling code here:
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtNombre.requestFocus();// al presionar enter mandas el cursor a jTextField2
        try { 
            validarExisteProveedor();
        } catch (PDVException ex) {
            Logger.getLogger(VProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtEmpresaActionPerformed

    private void txtTelefono1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefono1ActionPerformed
        // TODO add your handling code here:
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtTelefono2.requestFocus();// al presionar enter mandas el cursor a jTextField2
    }//GEN-LAST:event_txtTelefono1ActionPerformed

    private void txtTelefono2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefono2ActionPerformed
        // TODO add your handling code here:
        evt.setSource((char) KeyEvent.VK_CLEAR);
        txtEmail.requestFocus();// al presionar enter mandas el cursor a jTextField2
    }//GEN-LAST:event_txtTelefono2ActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
        evt.setSource((char) KeyEvent.VK_CLEAR);
        btnAgregar.requestFocus();// al presionar enter mandas el cursor a jTextField2
        btnAgregar.doClick();
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
         char charecter = evt.getKeyChar();
        if (Character.isLowerCase(charecter)) {
            evt.setKeyChar(Character.toUpperCase(charecter));
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtEmpresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpresaKeyTyped
        // TODO add your handling code here:
         char charecter = evt.getKeyChar();
        if (Character.isLowerCase(charecter)) {
            evt.setKeyChar(Character.toUpperCase(charecter));
        }
    }//GEN-LAST:event_txtEmpresaKeyTyped

    private void txtTelefono1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono1KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLetter(c)) {
              getToolkit().beep();
              evt.consume();
              
              JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Error",JOptionPane.ERROR_MESSAGE);
              
          }
           if (txtTelefono1.getText().length()>=8) {
            getToolkit().beep();
            evt.consume();
        }
        
    }//GEN-LAST:event_txtTelefono1KeyTyped

    private void txtTelefono2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono2KeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLetter(c)) {
              getToolkit().beep();
              evt.consume();
              
              JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Error",JOptionPane.ERROR_MESSAGE);
              
          }
           if (txtTelefono2.getText().length()>=8) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefono2KeyTyped

    private void txtEmpresaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpresaKeyPressed
        // TODO add your handling code here:
        if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Escape")){
            cerrar();
         }
    }//GEN-LAST:event_txtEmpresaKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
        if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Escape")){
            cerrar();
         }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtTelefono1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono1KeyPressed
        // TODO add your handling code here:
        if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Escape")){
            cerrar();
         }
    }//GEN-LAST:event_txtTelefono1KeyPressed

    private void txtTelefono2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono2KeyPressed
        // TODO add your handling code here:
        if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Escape")){
            cerrar();
         }
    }//GEN-LAST:event_txtTelefono2KeyPressed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        // TODO add your handling code here:
        if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Escape")){
           cerrar();
         }
    }//GEN-LAST:event_txtEmailKeyPressed

    public void limpiar(){
        txtNombre.setText("");
        txtEmpresa.setText("");
        txtTelefono1.setText("");
        txtTelefono2.setText("");
        txtEmail.setText("");
        txtEmpresa.grabFocus();
    }
    public void crearProveedor()throws PDVException{
        try{
            
            proveedor=clpdv.buscarProveedorPorNombre(txtEmpresa.getText());
            } catch (PDVException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(proveedor==null){
                clpdv.crearProveedor(txtNombre.getText(),
                                     txtEmpresa.getText(),
                                     txtTelefono1.getText(),
                                     txtTelefono2.getText(),
                                     txtEmail.getText());
                JOptionPane.showMessageDialog(null,"Proveedor Guardado Satisfactoriamente!!","Atención",JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                buscarCodProveedor();
            }else{
                JOptionPane.showMessageDialog(null,"El Proveedor "+ txtEmpresa.getText() +" ya existe favor Verificar!!!","Atención",JOptionPane.ERROR_MESSAGE);
                limpiar();
            }
    }
    /**
     * @param args the command line arguments
     */
    private CLPDV clpdv;
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
            java.util.logging.Logger.getLogger(VProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VProveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JButton txtNuevo;
    private javax.swing.JTextField txtTelefono1;
    private javax.swing.JTextField txtTelefono2;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
