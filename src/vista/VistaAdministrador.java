/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import vista.producto.CrearCategoria;
  import vista.producto.CrearProducto;
import vista.producto.EditarCategoria;
//import ec.edu.ups.vista.producto.RudCategoria;
  import vista.producto.EditarProducto;
//import ec.edu.ups.vista.proveedor.CrearProveedor;
//import ec.edu.ups.vista.proveedor.RudProveedor;
  import vista.usuario.CrearUsuario;
  import vista.usuario.EditarUsuario;

/**
 *
 * @author Darwin
 */
public class VistaAdministrador extends javax.swing.JFrame {
    //private CrearProducto crearProducto;
    //private RudCategoria rudCategoria;

      private EditarProducto rudProducto;
      private CrearCategoria crearCategoria;
      private EditarCategoria editarCategoria;
//    
      private CrearUsuario crearUsuario;
      private EditarUsuario rudUsuario;
//    
//    private CrearProveedor regProveedor;
//    private RudProveedor rudProveedor;

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
        itemCrear = new javax.swing.JMenuItem();
        itemRProducto = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        itemCrearCat = new javax.swing.JMenuItem();
        itemEditarCat = new javax.swing.JMenuItem();
        menuProveedor = new javax.swing.JMenu();
        itemRegistrarProveedor = new javax.swing.JMenuItem();
        itemRudProveedor = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

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

        itemCrear.setMnemonic('o');
        itemCrear.setText("Crear");
        itemCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCrearActionPerformed(evt);
            }
        });
        menuProducto.add(itemCrear);

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

        jMenuItem1.setText("Entrega de Proveedor");
        jMenu2.add(jMenuItem1);

        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCrearActionPerformed
//        if (crearProducto == null || !crearProducto.isVisible()) {
//            crearProducto = new CrearProducto();
//            crearProducto.setVisible(true);
//            desktopPane.add(crearProducto);
//         } 
    }//GEN-LAST:event_itemCrearActionPerformed

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
    private javax.swing.JMenuItem itemCrear;
    private javax.swing.JMenuItem itemCrearCat;
    private javax.swing.JMenuItem itemCrearE;
    private javax.swing.JMenuItem itemEditarCat;
    private javax.swing.JMenuItem itemEditarE;
    private javax.swing.JMenuItem itemRProducto;
    private javax.swing.JMenuItem itemRegistrarProveedor;
    private javax.swing.JMenuItem itemRudProveedor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuProducto;
    private javax.swing.JMenu menuProveedor;
    // End of variables declaration//GEN-END:variables

}