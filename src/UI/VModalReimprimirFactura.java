/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Objects.*;
import Reportes.*;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Erick Cordero
 */
public class VModalReimprimirFactura extends javax.swing.JFrame {
private Account unaCuenta;
private OpcionesUsuario unUsuario;
private Usuario usuario;
    /**
     * Creates new form VModalReimprimirFactura
     */
    public VModalReimprimirFactura() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtNumFactura.grabFocus();
        unaCuenta=null;
        unUsuario=null;
        usuario=null;
        clpdv = new CLPDV();
    }
    public void cerrar(){
         dispose();
         VReportes reportes = new VReportes();
         reportes.setVisible(true);
         VReportes.txtUsuario.setText(txtUsuario.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNumFactura = new javax.swing.JTextField();
        btnReimprimir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1045, 439));
        setMinimumSize(new java.awt.Dimension(1045, 439));
        setName("frmReimprimirFactura"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1045, 439));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ingrese el Número de Factura a Reimprimir:");

        txtNumFactura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNumFactura.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNumFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumFacturaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumFacturaKeyTyped(evt);
            }
        });

        btnReimprimir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReimprimir.setText("Reimprimir");
        btnReimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReimprimirActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(358, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(370, 370, 370))
            .addGroup(layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumFacturaKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLetter(c)) {
              getToolkit().beep();
              evt.consume();
              
              JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Error",JOptionPane.ERROR_MESSAGE);
              
          }
    }//GEN-LAST:event_txtNumFacturaKeyTyped

    private void btnReimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReimprimirActionPerformed
        // TODO add your handling code here:
         try{
            Reportes reporte=new Reportes();
            int venta=Integer.parseInt(txtNumFactura.getText());
            reporte.ReporteFactura(venta);
            //txtNumFactura.grabFocus();
        }catch(JRException ex){
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE,null, ex);
        }catch(SQLException ex){
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE,null, ex);
        }
    }//GEN-LAST:event_btnReimprimirActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNumFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumFacturaKeyPressed
        // TODO add your handling code here:
        if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Escape")){
            dispose();
         }
    }//GEN-LAST:event_txtNumFacturaKeyPressed

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
            java.util.logging.Logger.getLogger(VModalReimprimirFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VModalReimprimirFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VModalReimprimirFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VModalReimprimirFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VModalReimprimirFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReimprimir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtNumFactura;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}