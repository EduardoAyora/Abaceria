/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.factura;

import controlador.ControladorEmpleado;
import controlador.ControladorFactura;
import controlador.ControladorFacturaDetalle;
import controlador.ControladorPersona;
import controlador.ControladorProductos;
import excepcion.ExcepcionBinaria;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.Factura;
import modelo.FacturaDetalle;
import modelo.Persona;
import modelo.Producto;
import vista.VistaEmpleado;
import vista.persona.CrearCliente;

/**
 *
 * @author Paul Arichabala
 */
public class CrearFactura extends javax.swing.JInternalFrame {
    
    private CrearCliente registroCliente;
    private ControladorProductos controladorProductos;
    private ControladorFactura controladorFactura;
    private ControladorFacturaDetalle controladorFacturaDetalle;
    private ControladorPersona controladorPersona;
    private ControladorEmpleado controladorEmpleado;
    private Producto producto;
    private List<FacturaDetalle> facturaDetalles;
    private Persona cliente;
    private Empleado empleado;
    /**
     * Creates new form Factura
     */
    public CrearFactura() {
        initComponents();
        txtBCedula.requestFocus();
        controladorProductos = new ControladorProductos();
        controladorFactura = new ControladorFactura();
        controladorFacturaDetalle = new ControladorFacturaDetalle();
        controladorPersona = new ControladorPersona();
        controladorEmpleado = new ControladorEmpleado();
        facturaDetalles = new ArrayList<>();
        llenarCabecera();
    }
    
    public void setEmpleado(Empleado empleado){
        this.empleado = empleado;
    }

    public void listar(){
        tblDetalles.setRowHeight(55);
        DefaultTableModel modelo = (DefaultTableModel) tblDetalles.getModel();
        modelo.setRowCount(0);
        DecimalFormat df = new DecimalFormat("#.00");
        for (FacturaDetalle facturaDetalle : facturaDetalles) {
            Object[] datos = {
                facturaDetalle.getProducto().getDescripcion(),
                facturaDetalle.getCantidad(),
                df.format(facturaDetalle.getIva()) + " $",
                df.format(facturaDetalle.getSubtotal()) + " $",
                df.format(facturaDetalle.getTotal()) + " $"
            };
            modelo.addRow(datos);
        }
    }
    
    public void llenarCabecera(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaComoCadena = sdf.format(new Date());
        lblFecha.setText(fechaComoCadena);
    }
    
    public void llenarDatosCliente(){
        lblNombres.setText(cliente.getNombre());
        lblApellidos.setText(cliente.getApellido());
        lblCedulaCli.setText(cliente.getCedula());
        lblDireccion.setText(cliente.getDireccion());
        if(cliente.getTelefono() != null && !cliente.getTelefono().equals("null")){
            lblConvencional.setText(cliente.getTelefono());
        }
        if(cliente.getCelular() != null && !cliente.getCelular().equals("null")){
            lblCelular.setText(cliente.getCelular());
        }
    }
    
    public void vaciarDatosCliente(){
        lblNombres.setText("");
        lblApellidos.setText("");
        lblCedulaCli.setText("");
        lblDireccion.setText("");
        lblConvencional.setText("");
        lblCelular.setText("");
        txtBCedula.setText("");
    }
    
    public void vaciarValores(){
        txtSubTotal.setText("");
        txtIva.setText("");
        txtTotal.setText("");
    }
    
    public void vaciarDatosBuscar(){
        txtBarras.setText("");
        txtNombreProducto.setText("");
        
    }
    
    public void vaciarDatosProducto(){
        txtBarras2.setText("");
        txtNombrePro2.setText("");
        spnCantidad.setValue(new Integer(0));
    }
    
    public void actualizar(){
        if(facturaDetalles.size() > 0){
            double subtotal = 0;
            double iva = 0;
            double total = 0;

            for(FacturaDetalle facturaDetalle : facturaDetalles){
                subtotal += facturaDetalle.getSubtotal();
                iva += facturaDetalle.getIva();
                total += facturaDetalle.getTotal();
            }
            DecimalFormat df = new DecimalFormat("#.00");
            txtSubTotal.setText(df.format(subtotal));
            txtIva.setText(df.format(iva));
            txtTotal.setText(df.format(total));
        }else{
            txtSubTotal.setText("0");
            txtIva.setText("0");
            txtTotal.setText("0");
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

        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtBCedula = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtBarras2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtNombrePro2 = new javax.swing.JTextField();
        btnRegistrarCliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblFecha1 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblCedulaCli = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblConvencional = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalles = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtBarras = new javax.swing.JTextField();
        txtNombreProducto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        btnRegistrarCliente1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Crear Factura");
        setToolTipText("");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("CLIENTE");

        txtBCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBCedulaActionPerformed(evt);
            }
        });
        txtBCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBCedulaKeyPressed(evt);
            }
        });

        jLabel22.setText("Cédula: ");

        jLabel23.setText("PRODUCTO");

        jLabel24.setText("Código de Barras:");

        jLabel25.setText("Cantidad: ");

        spnCantidad.setToolTipText("0");
        spnCantidad.setName("0"); // NOI18N

        jButton2.setText("AGREGAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnBuscarCliente.setText("BUSCAR");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jLabel14.setText("Nombre:");

        btnRegistrarCliente.setText("REGISTRAR");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBarras2)
                                    .addComponent(txtNombrePro2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                .addGap(19, 19, 19)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jButton2))))
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtNombrePro2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtBCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBarras2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel25)
                                        .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        spnCantidad.getAccessibleContext().setAccessibleName("0");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblFecha1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFecha1.setText("FECHA:");

        lblFecha.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("CEDULA:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("NOMBRES:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("APELLIDOS: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("DIRECCION: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("CONVENCIONAL:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("CELULAR:");

        lblCedulaCli.setText(" ");

        lblNombres.setText(" ");

        lblApellidos.setText(" ");

        lblDireccion.setText(" ");

        lblConvencional.setText(" ");

        lblCelular.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(22, 22, 22)
                        .addComponent(lblApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(lblCedulaCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblConvencional, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(lblCelular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(335, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblCedulaCli)
                    .addComponent(jLabel4)
                    .addComponent(lblDireccion))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNombres)
                    .addComponent(jLabel5)
                    .addComponent(lblConvencional))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblApellidos)
                    .addComponent(jLabel6)
                    .addComponent(lblCelular)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripcion", "Cantidad", "Iva", "Subtotal", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDetalles);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setText("BUSCAR PRODUCTO");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setText("CODIGO DE BARRAS:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("NOMBRE:");

        txtBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBarrasKeyPressed(evt);
            }
        });

        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyPressed(evt);
            }
        });

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 100, Short.MAX_VALUE))
                    .addComponent(txtNombreProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel28.setText("SubTotal:");

        jLabel35.setText("Iva:");

        jLabel36.setText("TOTAL:");

        txtSubTotal.setEditable(false);

        txtIva.setEditable(false);

        txtTotal.setEditable(false);

        btnRegistrarCliente1.setText("QUITAR");
        btnRegistrarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCliente1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(384, 384, 384)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSubTotal)
                    .addComponent(txtIva)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addGap(68, 68, 68))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrarCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIva, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBCedulaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(cliente != null && facturaDetalles.size() > 0){
            Factura factura = new Factura();
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(new java.util.Date());
            factura.setFecha(cal);
            factura.setEmpleado(this.empleado);
            factura.setCliente(cliente);

            double subtotal = 0;
            double iva = 0;
            double total = 0;

            for(FacturaDetalle facturaDetalle : facturaDetalles){
                subtotal += facturaDetalle.getSubtotal();
                iva += facturaDetalle.getIva();
                total += facturaDetalle.getTotal();
            }

            factura.setSubtotal(subtotal);
            factura.setIva(iva);
            factura.setTotal(total);
            try {
                factura.setEstado(1);
            } catch (ExcepcionBinaria ex) {
                Logger.getLogger(CrearFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
            controladorFactura.create(factura);
            for(FacturaDetalle facturaDetalle : facturaDetalles){
                facturaDetalle.setFactura(factura);
                controladorFacturaDetalle.create(facturaDetalle);
                Producto producto = facturaDetalle.getProducto();
                producto.setStock(producto.getStock() - facturaDetalle.getCantidad());
                controladorProductos.update(producto);
            }
            cliente = null;
            facturaDetalles = new ArrayList<>();
            vaciarDatosCliente();
            listar();
            vaciarDatosBuscar();
            vaciarDatosProducto();
            vaciarValores();
            JOptionPane.showMessageDialog(null, "Factura creada con exito", "Factura", JOptionPane.INFORMATION_MESSAGE);
            controladorFactura.imprimirFactura(factura.getId());
        }else{
            JOptionPane.showMessageDialog(null, "No se puede generar la factura por falta de datos", "Factura", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        if (registroCliente == null || !registroCliente.isVisible()) {
            registroCliente = new CrearCliente();
            VistaEmpleado.desktopEmpleado.add(registroCliente);
            registroCliente.setVisible(true);           
        }        
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        try{
            cliente = controladorPersona.read(txtBCedula.getText());
            if(cliente.getActivo() == 0){
                JOptionPane.showMessageDialog(null, "El cliente esta desactivado", "Cliente", JOptionPane.ERROR_MESSAGE);
                cliente = null;
            }else{
                llenarDatosCliente();
            }
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "El cliente no esta registrado", "Cliente", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            if(!txtBarras.getText().equals("")){
                producto = controladorProductos.readByBarCode(txtBarras.getText());
                if(producto != null){
                    txtBarras2.setText(producto.getCodigoBarra());
                    txtNombrePro2.setText(producto.getDescripcion());
                }else{
                    vaciarDatosProducto();
                    JOptionPane.showMessageDialog(null, "La busqueda no produce ningun resultado", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }else if (!txtNombreProducto.getText().equals("")){
                producto = controladorProductos.readByName(txtNombreProducto.getText());
                if(producto != null){
                    txtBarras2.setText(producto.getCodigoBarra());
                    txtNombrePro2.setText(producto.getDescripcion());
                }else{
                    vaciarDatosProducto();
                    JOptionPane.showMessageDialog(null, "La busqueda no produce ningun resultado", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            vaciarDatosBuscar();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRegistrarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCliente1ActionPerformed
        // TODO add your handling code here:
        int numeroDetalle = tblDetalles.getSelectedRow();
        facturaDetalles.remove(numeroDetalle);
        listar();
        actualizar();
    }//GEN-LAST:event_btnRegistrarCliente1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(producto != null){
            
            boolean existe = false;
            int cantidad = (int) spnCantidad.getValue();
            for (FacturaDetalle facturaDetalle : facturaDetalles) {
                if(facturaDetalle.getProducto().getId() == producto.getId()){
                    cantidad = cantidad + facturaDetalle.getCantidad();
                    if(cantidad > 0 && cantidad <= producto.getStock()){
                        facturaDetalle.setCantidad(cantidad);
                        facturaDetalle.setSubtotal(facturaDetalle.getProducto().getPrecio() * facturaDetalle.getCantidad());
                        if(facturaDetalle.getProducto().getTieneIva() == 1){
                            facturaDetalle.setIva(facturaDetalle.getSubtotal() * 0.12);
                        }else{
                            facturaDetalle.setIva(0);
                        }
                        facturaDetalle.setTotal(facturaDetalle.getSubtotal() + facturaDetalle.getIva());
                    }else{
                        JOptionPane.showMessageDialog(null, "No se puede vender esta cantidad", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                    existe = true;
                    break;
                }
            }
            
            if(cantidad > 0 && cantidad <= producto.getStock() && existe == false){
                
                FacturaDetalle facturaDetalle = new FacturaDetalle();
                facturaDetalle.setProducto(producto);
                facturaDetalle.setCantidad(cantidad);
                facturaDetalle.setSubtotal(facturaDetalle.getProducto().getPrecio() * facturaDetalle.getCantidad());
                if(facturaDetalle.getProducto().getTieneIva() == 1){
                    facturaDetalle.setIva(facturaDetalle.getSubtotal() * 0.12);
                }else{
                    facturaDetalle.setIva(0);
                }
                facturaDetalle.setTotal(facturaDetalle.getSubtotal() + facturaDetalle.getIva());
                facturaDetalles.add(facturaDetalle);
                
            }else{
                if(existe == false){
                    JOptionPane.showMessageDialog(null, "No se puede vender esta cantidad", "Error", JOptionPane.WARNING_MESSAGE);
//                    producto = null;
//                    vaciarDatosProducto();
                }
            }
            
            listar();
            actualizar();
        }else{
            JOptionPane.showMessageDialog(null, "No se puede vender esta cantidad", "Error", JOptionPane.WARNING_MESSAGE);
            vaciarDatosProducto();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtBCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBCedulaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                try{
            cliente = controladorPersona.read(txtBCedula.getText());
            llenarDatosCliente();
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "El cliente no esta registrado", "Cliente", JOptionPane.ERROR_MESSAGE);
        }
            
        }
    }//GEN-LAST:event_txtBCedulaKeyPressed

    private void txtBarrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarrasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            try{
            if(!txtBarras.getText().equals("")){
                producto = controladorProductos.readByBarCode(txtBarras.getText());
                if(producto != null){
                    txtBarras2.setText(producto.getCodigoBarra());
                    txtNombrePro2.setText(producto.getDescripcion());
                }else{
                    vaciarDatosProducto();
                    JOptionPane.showMessageDialog(null, "La busqueda no produce ningun resultado", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }else if (!txtNombreProducto.getText().equals("")){
                producto = controladorProductos.readByName(txtNombreProducto.getText());
                if(producto != null){
                    txtBarras2.setText(producto.getCodigoBarra());
                    txtNombrePro2.setText(producto.getDescripcion());
                }else{
                    vaciarDatosProducto();
                    JOptionPane.showMessageDialog(null, "La busqueda no produce ningun resultado", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            vaciarDatosBuscar();
        }catch(Exception ex){
            ex.printStackTrace();
        }
            
        }
    }//GEN-LAST:event_txtBarrasKeyPressed

    private void txtNombreProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            try{
            if(!txtBarras.getText().equals("")){
                producto = controladorProductos.readByBarCode(txtBarras.getText());
                if(producto != null){
                    txtBarras2.setText(producto.getCodigoBarra());
                    txtNombrePro2.setText(producto.getDescripcion());
                }else{
                    vaciarDatosProducto();
                    JOptionPane.showMessageDialog(null, "La busqueda no produce ningun resultado", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }else if (!txtNombreProducto.getText().equals("")){
                producto = controladorProductos.readByName(txtNombreProducto.getText());
                if(producto != null){
                    txtBarras2.setText(producto.getCodigoBarra());
                    txtNombrePro2.setText(producto.getDescripcion());
                }else{
                    vaciarDatosProducto();
                    JOptionPane.showMessageDialog(null, "La busqueda no produce ningun resultado", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            vaciarDatosBuscar();
        }catch(Exception ex){
            ex.printStackTrace();
        }
            
        }
    }//GEN-LAST:event_txtNombreProductoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnRegistrarCliente1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCedulaCli;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblConvencional;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFecha1;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblDetalles;
    private javax.swing.JTextField txtBCedula;
    private javax.swing.JTextField txtBarras;
    private javax.swing.JTextField txtBarras2;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNombrePro2;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
