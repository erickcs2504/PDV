/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Objects.CLPDV;
import Objects.PDVException;
import Objects.*;
import Reportes.ReporteCxC;
import Reportes.Reportes;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Erick Cordero
 */
public class VReporteCxC extends javax.swing.JFrame {
private Pagos pago;
private Account unaCuenta;
private OpcionesUsuario unUsuario;
private Usuario usuario;
    /**
     * Creates new form VReporteCxC
     */
    public VReporteCxC() {
        initComponents();
        this.setLocationRelativeTo(null);
        pago=null;
        clpdv = new CLPDV();
        unaCuenta=null;
        unUsuario=null;
        usuario=null;
        dpFechaUno.grabFocus();
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

        txtUsuario = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        dpFechaDos = new com.github.lgooddatepicker.components.DatePicker();
        dpFechaUno = new com.github.lgooddatepicker.components.DatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(1045, 439));
        setMinimumSize(new java.awt.Dimension(1045, 439));
        setPreferredSize(new java.awt.Dimension(1045, 439));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("ir a Reporte...");
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, 40));

        btnSalir.setText("Salir");
        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 140, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 580, 110));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        dpFechaDos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dpFechaDosKeyPressed(evt);
            }
        });

        dpFechaUno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dpFechaUnoKeyPressed(evt);
            }
        });

        jLabel1.setText("Fecha Inicio:");
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setText("Fecha Final:");
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dpFechaDos, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dpFechaUno, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpFechaUno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dpFechaDos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(41, 41, 41))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 580, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        try {
            // TODO add your handling code here:
            buscarTotal();
        } catch (PDVException | SQLException | JRException | ParseException ex) {
            Logger.getLogger(VReporteCxC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void dpFechaDosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dpFechaDosKeyPressed
        // TODO add your handling code here:
        if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Escape")){
            dispose();
            VMenuAdmin menu=new VMenuAdmin();
            menu.setVisible(true);
        }
    }//GEN-LAST:event_dpFechaDosKeyPressed

    private void dpFechaUnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dpFechaUnoKeyPressed
        // TODO add your handling code here:
        if(KeyEvent.getKeyText(evt.getKeyCode()).equals("Escape")){
            dispose();
            VMenuAdmin menu=new VMenuAdmin();
            menu.setVisible(true);
        }
    }//GEN-LAST:event_dpFechaUnoKeyPressed
    
    public void buscarTotal()throws PDVException, SQLException, JRException, ParseException{
        float totalGeneral=0;
        String pTotal="";
        
        DecimalFormat formato = new DecimalFormat("#,###.00");
        ArrayList<Pagos> pagos=new ArrayList<>();
        
    try {
        pagos=clpdv.buscarCxC();
        
    } catch (PDVException ex) {
        Logger.getLogger(VReportes.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    if (pagos==null){
        }else{
  
        for(int i=0;i<pagos.size();i++){
            LocalDate fecha=pagos.get(i).getFechaUltPago();
            LocalDate fecha1=dpFechaUno.getDate();
            LocalDate fecha2=dpFechaDos.getDate();
            if(fecha.isAfter(fecha1)|| fecha.isEqual(fecha1)) {
                if(fecha.isBefore(fecha2)|| fecha.isEqual(fecha2)){
                    
                String total=pagos.get(i).getSaldo();
                float totalFlt;
                Number nTotal = java.text.NumberFormat.getInstance().parse(total);
                totalFlt=nTotal.floatValue();
                totalGeneral=(totalGeneral+totalFlt);
                pTotal=formato.format(totalGeneral);
            }
            
       
        }
    }
    }
    imprimirReporte(pTotal);
    }
    public void imprimirReporte(String pTotal)throws PDVException{
    
        try{
            ReporteCxC reporteCxC=new ReporteCxC();
            Date fechaUno = java.sql.Date.valueOf(dpFechaUno.getDate());
            Date fechaDos=java.sql.Date.valueOf(dpFechaDos.getDate());
      
            reporteCxC.CxC(fechaUno,fechaDos, pTotal);
        }catch(JRException | SQLException ex){
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE,null, ex);
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
            java.util.logging.Logger.getLogger(VReporteCxC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VReporteCxC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VReporteCxC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VReporteCxC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VReporteCxC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private com.github.lgooddatepicker.components.DatePicker dpFechaDos;
    private com.github.lgooddatepicker.components.DatePicker dpFechaUno;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
