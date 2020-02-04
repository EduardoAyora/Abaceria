/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.compra;

import controlador.ControladorCompraProveedor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.CompraProveedor;

/**
 *
 * @author Darwin
 */
public class ListaProdcuto extends javax.swing.JInternalFrame {
    private ControladorCompraProveedor controladorCompraProveedor;
    private CompraProveedor compraProveedor;
    private String compra;

    /**
     * Creates new form ListaProdcuto
     */
    public ListaProdcuto(ControladorCompraProveedor controladorCompraProveedor) {
        initComponents();
        this.controladorCompraProveedor= controladorCompraProveedor;
        llenarDatos();
        
         //asiganmos fecha a la factura
        //Date fechaActual = new Date();
        //damos formato a la fecha 
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        //String fechaFormateada =  formato.format(fechaActual);
        //txtFecha.setText(fechaFormateada);
    }
    
    public void llenarDatos(){
        DefaultTableModel modelo = (DefaultTableModel) tablaCompra.getModel();
        modelo.setRowCount(0);
        List<CompraProveedor> lista = controladorCompraProveedor.list();
       
        for (CompraProveedor compra : lista) {
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String fecha =  formato.format(compra.getFecha().getTime());
            Object[] datos = {compra.getNumeroFacturaProveedor(),
            fecha,
            compra.getPersona().getEmpresa(),
            compra.getPersona().getNombre()+"   "+compra.getPersona().getApellido(),
            compra.getProducto().getDescripcion(),
            compra.getProducto().getCodigoBarra(),
            compra.getCantidad()};
            modelo.addRow(datos);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCompra = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ventana Lista de Compra ");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Compras"));

        tablaCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N. Factura", "Fecha de Compra", "Empresa", "Proveedor", "Producto", "Codigo de Barras", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaCompra);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCompra;
    // End of variables declaration//GEN-END:variables
}
