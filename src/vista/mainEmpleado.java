/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import vista.factura.CrearFactura;
import vista.persona.CrearCliente;
import vista.mainEmpleado;
import vista.persona.EditarCliente;
/**
 *
 * @author Paul Arichabala
 */
public class mainEmpleado extends javax.swing.JFrame {
    private CrearCliente registroCliente;
    private CrearFactura factura;
    private EditarCliente editarCliente;
    /**
     * Creates new form mainEmpleado
     */
    public mainEmpleado() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopEmpleado = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        editMenu = new javax.swing.JMenu();
        RegFac = new javax.swing.JMenuItem();
        fileMenu = new javax.swing.JMenu();
        itemCrearC = new javax.swing.JMenuItem();
        itemEditarC = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editMenu.setMnemonic('e');
        editMenu.setText("Factura");

        RegFac.setMnemonic('t');
        RegFac.setText("Crear");
        RegFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegFacActionPerformed(evt);
            }
        });
        editMenu.add(RegFac);

        menuBar.add(editMenu);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Registro Cliente");

        itemCrearC.setMnemonic('o');
        itemCrearC.setText("Crear");
        itemCrearC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCrearCActionPerformed(evt);
            }
        });
        fileMenu.add(itemCrearC);

        itemEditarC.setText("Editar");
        itemEditarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarCActionPerformed(evt);
            }
        });
        fileMenu.add(itemEditarC);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCrearCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCrearCActionPerformed
        // TODO add your handling code here:

         if (registroCliente == null || !registroCliente.isVisible()) {
             registroCliente = new CrearCliente();

           registroCliente.setVisible(true);
           desktopEmpleado.add(registroCliente);
         }
    }//GEN-LAST:event_itemCrearCActionPerformed
    
    private void RegFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegFacActionPerformed
        // TODO add your handling code here:
        if (factura == null || !factura.isVisible()) {
             factura = new CrearFactura();
          factura.setVisible(true);
           desktopEmpleado.add(factura);
        }
    }//GEN-LAST:event_RegFacActionPerformed

    private void itemEditarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarCActionPerformed
        if (editarCliente == null || !editarCliente.isVisible()) {
             editarCliente = new EditarCliente();
          editarCliente.setVisible(true);
           desktopEmpleado.add(editarCliente);
        }
    }//GEN-LAST:event_itemEditarCActionPerformed
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(mainEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem RegFac;
    public static javax.swing.JDesktopPane desktopEmpleado;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem itemCrearC;
    private javax.swing.JMenuItem itemEditarC;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
