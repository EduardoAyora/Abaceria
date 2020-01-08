/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import vista.compra.EntregaProveedor;
import vista.producto.CrearCategoria;
  import vista.producto.CrearProducto;
import vista.producto.EditarCategoria;
//import ec.edu.ups.vista.producto.RudCategoria;
  import vista.producto.EditarProducto;
//import ec.edu.ups.vista.proveedor.CrearProveedor;
//import ec.edu.ups.vista.proveedor.RudProveedor;
  import vista.persona.CrearUsuario;
  import vista.persona.EditarUsuario;

/**
 *
 * @author Darwin
 */
public class VistaAdministrador extends javax.swing.JFrame {
    
      private CrearProducto crearProducto;
      private EditarProducto rudProducto;
      
      private CrearCategoria crearCategoria;
      private EditarCategoria editarCategoria;
      
      private CrearUsuario crearUsuario;
      private EditarUsuario rudUsuario;

      private EntregaProveedor entregaProveedor;

    /**
     * Creates new form MainA
     */
    public VistaAdministrador() {
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

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        helpMenu = new javax.swing.JMenu();
        itemCrearE = new javax.swing.JMenuItem();
        itemEditarE = new javax.swing.JMenuItem();
        menuProducto = new javax.swing.JMenu();
        itemCrearP = new javax.swing.JMenuItem();
        itemRProducto = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        itemCrearCat = new javax.swing.JMenuItem();
        itemEditarCat = new javax.swing.JMenuItem();
        menuProveedor = new javax.swing.JMenu();
        itemRegistrarProveedor = new javax.swing.JMenuItem();
        itemRudProveedor = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemEntregaP = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(new java.awt.Color(240, 240, 240));

        helpMenu.setMnemonic('h');
        helpMenu.setText("Empleados");

        itemCrearE.setText("Crear");
        itemCrearE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCrearEActionPerformed(evt);
            }
        });
        helpMenu.add(itemCrearE);

        itemEditarE.setText("Editar");
        itemEditarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarEActionPerformed(evt);
            }
        });
        helpMenu.add(itemEditarE);

        menuBar.add(helpMenu);

        menuProducto.setMnemonic('f');
        menuProducto.setText("Productos");

        itemCrearP.setMnemonic('o');
        itemCrearP.setText("Crear");
        itemCrearP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCrearPActionPerformed(evt);
            }
        });
        menuProducto.add(itemCrearP);

        itemRProducto.setMnemonic('a');
        itemRProducto.setText("Editar");
        itemRProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRProductoActionPerformed(evt);
            }
        });
        menuProducto.add(itemRProducto);

        menuBar.add(menuProducto);

        jMenu1.setText("Categoria");

        itemCrearCat.setText("Crear");
        itemCrearCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCrearCatActionPerformed(evt);
            }
        });
        jMenu1.add(itemCrearCat);

        itemEditarCat.setText("Editar");
        itemEditarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarCatActionPerformed(evt);
            }
        });
        jMenu1.add(itemEditarCat);

        menuBar.add(jMenu1);

        menuProveedor.setText("Proveedor");

        itemRegistrarProveedor.setText("Crear");
        itemRegistrarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarProveedorActionPerformed(evt);
            }
        });
        menuProveedor.add(itemRegistrarProveedor);

        itemRudProveedor.setText("Editar");
        itemRudProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRudProveedorActionPerformed(evt);
            }
        });
        menuProveedor.add(itemRudProveedor);

        menuBar.add(menuProveedor);

        jMenu2.setText("Compras de Mercancia");

        itemEntregaP.setText("Entrega de Proveedor");
        itemEntregaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEntregaPActionPerformed(evt);
            }
        });
        jMenu2.add(itemEntregaP);

        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCrearPActionPerformed(java.awt.event.ActionEvent evt) {                                           

                                           

        if (crearProducto == null || !crearProducto.isVisible()) {
            crearProducto = new CrearProducto();
            crearProducto.setVisible(true);
            desktopPane.add(crearProducto);
         } 
    }                                         

    private void itemCrearEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCrearEActionPerformed
        if (crearUsuario == null || !crearUsuario.isVisible()) {
            crearUsuario = new CrearUsuario();
            crearUsuario.setVisible(true);
            desktopPane.add(crearUsuario);
         } 
    }//GEN-LAST:event_itemCrearEActionPerformed

    private void itemEditarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarEActionPerformed
       if (rudUsuario == null || !rudUsuario.isVisible()) {
            rudUsuario = new EditarUsuario();
            rudUsuario.setVisible(true);
            desktopPane.add(rudUsuario);
         }  
    }//GEN-LAST:event_itemEditarEActionPerformed

    private void itemRegistrarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarProveedorActionPerformed
//         if (regProveedor == null || !regProveedor.isVisible()) {
//            regProveedor = new CrearProveedor();
//            regProveedor.setVisible(true);
//            desktopPane.add(regProveedor);
//         } 
    }//GEN-LAST:event_itemRegistrarProveedorActionPerformed

    private void itemRudProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRudProveedorActionPerformed
//        if (rudProveedor == null || !rudProveedor.isVisible()) {
//            rudProveedor = new RudProveedor();
//            rudProveedor.setVisible(true);
//            desktopPane.add(rudProveedor);
//         } 
    }//GEN-LAST:event_itemRudProveedorActionPerformed

    private void itemRProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRProductoActionPerformed
                if (rudProducto == null || !rudProducto.isVisible()) {
                        rudProducto = new EditarProducto();
                        rudProducto.setVisible(true);
                        desktopPane.add(rudProducto);
                     }
    }//GEN-LAST:event_itemRProductoActionPerformed

    private void itemCrearCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCrearCatActionPerformed
       if (crearCategoria == null || !crearCategoria.isVisible()) {
                        crearCategoria = new CrearCategoria();
                        crearCategoria.setVisible(true);
                        desktopPane.add(crearCategoria);
                     } 
    }//GEN-LAST:event_itemCrearCatActionPerformed

    private void itemEditarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarCatActionPerformed
        if (editarCategoria == null || !editarCategoria.isVisible()) {
                        editarCategoria = new EditarCategoria();
                        editarCategoria.setVisible(true);
                        desktopPane.add(editarCategoria);
                     } 
    }//GEN-LAST:event_itemEditarCatActionPerformed

    private void itemEntregaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEntregaPActionPerformed
        // TODO add your handling code here:
        if (entregaProveedor == null || !entregaProveedor.isVisible()) {
                        entregaProveedor = new EntregaProveedor();
                        entregaProveedor.setVisible(true);
                        desktopPane.add(entregaProveedor);
                     } 
    }//GEN-LAST:event_itemEntregaPActionPerformed

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
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem itemCrearCat;
    private javax.swing.JMenuItem itemCrearE;
    private javax.swing.JMenuItem itemCrearP;
    private javax.swing.JMenuItem itemEditarCat;
    private javax.swing.JMenuItem itemEditarE;
    private javax.swing.JMenuItem itemEntregaP;
    private javax.swing.JMenuItem itemRProducto;
    private javax.swing.JMenuItem itemRegistrarProveedor;
    private javax.swing.JMenuItem itemRudProveedor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuProducto;
    private javax.swing.JMenu menuProveedor;
    // End of variables declaration//GEN-END:variables

}
