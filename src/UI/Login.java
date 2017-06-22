/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;
import java.sql.*;
import java.io.*;
import java.util.*;// para usar vector
import Objects.*;
import AccesoDB.*;
import Multi.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Erick Cordero
 */
public class Login extends javax.swing.JFrame {
    
    //private AccountManager accountManager;
    private Usuario usuario;
    private Account unaCuenta;
    private OpcionesUsuario unUsuario;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        btn_RegistrarUs.setVisible(false);
        usuario=null; 
        unaCuenta=null;
        accountManager=null;
        unUsuario=null;
        txtUsuario.grabFocus();
        clpdv = new CLPDV();
        accountManager = new AccountManager();
        
    }
    /*public Image getIconImage(){
        Image retValue= Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/logo.jpg"));
        return retValue;
        
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btoSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jpsPassword = new javax.swing.JPasswordField();
        btnIniciarSesion = new javax.swing.JButton();
        btn_RegistrarUs = new javax.swing.JButton();
        chk_RegistrarAdmin = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(366, 500));
        setMinimumSize(new java.awt.Dimension(366, 500));
        setName("frmLogin"); // NOI18N
        setPreferredSize(new java.awt.Dimension(366, 500));
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btoSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btoSalir.setText("Salir");
        btoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btoSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btoSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 70, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 180, -1));

        jpsPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jpsPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpsPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jpsPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 180, -1));

        btnIniciarSesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 130, 30));

        btn_RegistrarUs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_RegistrarUs.setText("Registrar Usuario");
        btn_RegistrarUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarUsActionPerformed(evt);
            }
        });
        getContentPane().add(btn_RegistrarUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, 30));

        chk_RegistrarAdmin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        chk_RegistrarAdmin.setText("Registrar usuario Administrador");
        chk_RegistrarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_RegistrarAdminActionPerformed(evt);
            }
        });
        getContentPane().add(chk_RegistrarAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 340, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 230, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btoSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btoSalirActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
       
       
        try {
            // TODO add your handling code here:
            usuario = clpdv.buscarPorId(txtUsuario.getText());
        } catch (PDVException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(usuario==null){
             txtUsuario.setText("");
             jpsPassword.setText("");
             txtUsuario.grabFocus();
            
             JOptionPane.showMessageDialog(null,"NO hay un Usuario Registrado,Proceda a registrarse como Usuario","Error",JOptionPane.ERROR_MESSAGE);
         
        }else{
            iniciarSesion();
        }
    }
    public void iniciarSesion(){
        
        //MultiUsuario multiUsuario = new MultiUsuario();
        try {
         
            usuario = clpdv.buscarPorId(txtUsuario.getText());
         
         //if(unUsuario==null)
         //{
                //evt.setSource((char) KeyEvent.VK_CLEAR);
             //btn_cerrar.requestFocus();// al presionar enter mandas el cursor a jTextField2
             //btn_cerrar.doClick();
             //VentanaRegistroAdmin registrarAdmin = new VentanaRegistroAdmin();
             //registrarAdmin.setVisible(true);
             //registrarAdmin.txtRol.setEnabled(false);
         
         //}else{
             //unUsuario = multiUsuario.buscarPorId(txtUsuario.getText());
             if(usuario.getRol().equals("DEPENDIENTE"))
             {
                
                 //unaCuenta=null;
                 unaCuenta= accountManager.validateAccount(txtUsuario.getText());
                 String user=txtUsuario.getText();
                 char passArray[] = jpsPassword.getPassword();
                 for (int i = 0; i < passArray.length; i++) 
                 {
                     
                 }
                 String pass = new String(passArray);
                     
                 if(unaCuenta.getUserName().equals(user)&& unaCuenta.getPassword().equals(pass))
                 {
                    dispose();
                    unUsuario=clpdv.buscarPorCed(user);
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
                        
                    
                     //aqui va el menu del administrador
                     //medicos.setVisible(true);
                     //medicos.txt_IdMedico.setText(unaCuenta.getUserName());
                    
                    
                 
                     
                     VMenuAdmin.txtTipoUsuario.setText("DEPENDIENTE");
                            
                     JOptionPane.showMessageDialog(null,"Bienvenido, Usuario Tipo DEPENDIENTE");
                     //aqui se tiene que mostrar el menú de los DEPENDIENTES
              
                 }else{
                     JOptionPane.showMessageDialog(null,"Error de Login o Contraseña, digite de nuevo la informacion","Error",JOptionPane.ERROR_MESSAGE);
                     txtUsuario.setText("");
                     jpsPassword.setText("");
                     txtUsuario.grabFocus();
                     
                 }
             }else{
                 
                 
                     if(usuario.getRol().equals("ADMINISTRADOR"))
                     {
                         //unaCuenta=null;
                         unaCuenta=accountManager.validateAccount(txtUsuario.getText());
                         String user=txtUsuario.getText();
                         char passArray[] = jpsPassword.getPassword();
                         for (int i = 0; i < passArray.length; i++) 
                         {
                     
                         }
                         String pass = new String(passArray);
                         if(unaCuenta.getUserName().equals(user)&& unaCuenta.getPassword().equals(pass))
                         {
                             dispose();
                             //MenuAdministrador menuAdmin = new MenuAdministrador();
                             //menuAdmin.setVisible(true);
                             JOptionPane.showMessageDialog(null,"Bienvenido, Administrador del Sistema");
                             //aqui se tiene que mostrar el menu del Administrador
                             VMenuAdmin menuAdmin = new VMenuAdmin();
                             menuAdmin.setVisible(true);
                             VMenuAdmin.txtTipoUsuario.setText("ADMINISTRADOR");
                             VMenuAdmin.txtUsuario.setText(txtUsuario.getText());
                             
                          }else{
                          JOptionPane.showMessageDialog(null,"Error de Login o Contraseña, digite de nuevo la informacion","Error",JOptionPane.ERROR_MESSAGE);
                          txtUsuario.setText("");
                          jpsPassword.setText("");
                          txtUsuario.grabFocus();
                         }
                     }
                 }
             
         
        }catch (java.lang.Exception e){
            System.out.println(e.getMessage());
        }
           
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
        evt.setSource((char) KeyEvent.VK_CLEAR);
        jpsPassword.requestFocus();// al presionar enter mandas el cursor a jTextField2
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLetter(c)) {
              getToolkit().beep();
              evt.consume();
              
              JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!,El Usuario es su Número de Cédula","Error",JOptionPane.ERROR_MESSAGE);
              
          }
           if (txtUsuario.getText().length()>=9) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void btn_RegistrarUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarUsActionPerformed
        // TODO add your handling code here:
        dispose();
        ventanaValidateAdm validarAdm = new ventanaValidateAdm();
        validarAdm.setVisible(true);
        
        
        
    }//GEN-LAST:event_btn_RegistrarUsActionPerformed

    private void chk_RegistrarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_RegistrarAdminActionPerformed
        // TODO add your handling code here:
        if(chk_RegistrarAdmin.isSelected())
        {
            btn_RegistrarUs.setVisible(true);
        }else{
            btn_RegistrarUs.setVisible(false);
            
        }
    }//GEN-LAST:event_chk_RegistrarAdminActionPerformed

    private void jpsPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpsPasswordActionPerformed
        // TODO add your handling code here:
         evt.setSource((char) KeyEvent.VK_CLEAR);
        btnIniciarSesion.requestFocus();// al presionar enter mandas el cursor a jTextField2
        btnIniciarSesion.doClick();
    }//GEN-LAST:event_jpsPasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    private CLPDV clpdv;
    private AccountManager accountManager;
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btn_RegistrarUs;
    private javax.swing.JButton btoSalir;
    private javax.swing.JCheckBox chk_RegistrarAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jpsPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
