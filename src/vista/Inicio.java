/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorEmpleado;
import controlador.ControladorPersona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modelo.Empleado;

/**
 *
 * @author Darwin
 */
public class Inicio extends javax.swing.JFrame {
    
    private Empleado e;
    private ControladorEmpleado controladorEmpleado;
    private ControladorPersona controladorPersona;
    
    private String u;
    private String p;
    
    private String upadre;
    private String pPadre;
    
    private Timer tiempo;
    private int cont;
    public final static int two_second = 1;
     
    

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        controladorEmpleado = new ControladorEmpleado();
        ControladorPersona peopleController = new ControladorPersona();
        // System.out.println(peopleController.read("0106073331"));
        upadre = "1";
        pPadre="1";
        progres.setVisible(false);
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtU = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        btnContinuar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        progres = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("USUARIO:");

        jLabel2.setText("PASSWORD:");

        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });

        btnContinuar.setText("CONTINUAR");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("     INICIAR   SESSION");
        jLabel3.setToolTipText("");

        progres.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtU)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(btnContinuar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(progres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtU)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(progres, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    class TimerListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            cont ++;
            progres.setValue(cont);
            if(cont==100){
                tiempo.stop();
                //esconder();
                JOptionPane.showMessageDialog(rootPane, "Acceso Correcto!\n");
                VistaAdministrador adm = new VistaAdministrador();
                adm.setVisible(true);
                dispose(); 
                
            }
        }   
    }
    
    public void esconder(){this.setVisible(false);}
    public void activar(){tiempo.start();}
    
    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        e = controladorEmpleado.readByUser(txtU.getText());
        System.out.println(e);
        p = new String(txtPass.getPassword());
        if(e != null){
            
            if(txtU.getText().equalsIgnoreCase(e.getUsuario()) && p.equals(e.getContrasenia()) && e.getTipoAdministrador()== 0 && e.getActivo()==1){
            JOptionPane.showMessageDialog(rootPane, "Ten un Buen dia\n"+e.getUsuario());
            VistaEmpleado emp = new VistaEmpleado();
            emp.setEmpleado(e);
            emp.setVisible(true);
            setVisible(false);
              
            } else{
                    if(txtU.getText().equalsIgnoreCase(e.getUsuario()) && p.equals(e.getContrasenia()) && e.getTipoAdministrador() ==1 && e.getActivo()==1 ){
                    try{
                        String tipo = (JOptionPane.showInputDialog(null, "Seleccione un tipo de usuario","Usuario",
                        JOptionPane.PLAIN_MESSAGE,null,new Object[] {"Administrador", "Empleado" }, "Selecciona")).toString();
                
                        if (tipo.equals("Administrador")){
                            progres.setVisible(true);
                            cont =-1;
                            progres.setValue(0);
                            progres.setStringPainted(true);
                            tiempo = new Timer(two_second, new TimerListener());
                            activar();
                       
                        }else {
                            JOptionPane.showMessageDialog(rootPane, "Acceso Correcto!\n"+"Empleado: "+e.getUsuario());
                            VistaEmpleado e1 = new VistaEmpleado();
                            e1.setEmpleado(e);
                            e1.setVisible(true);
                            dispose();
                            
                        }
                    }catch(Exception ex){
                        
                    }
                    
                
                    }else{
                    JOptionPane.showMessageDialog(rootPane, "Acceso Denegado");
                    txtPass.setText("");
                    txtU.setText("");
                    txtU.requestFocus();
                    }
            }
        
        } else{
            System.out.println("1");
            if(txtU.getText().equalsIgnoreCase(upadre) && p.equalsIgnoreCase(pPadre)){
            JOptionPane.showMessageDialog(rootPane, "Usuario Padre!\n"+"Adm: "+txtU.getText());
            VistaAdministrador a = new VistaAdministrador();
            a.setVisible(true);
            dispose();  
            
            }else{
                JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña incorrecto","ERROR",JOptionPane.WARNING_MESSAGE);
                txtPass.setText("");
                txtU.setText("");
                txtU.requestFocus(); 
            }
        }
                     
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //System.out.println(" kk");
             
        e = controladorEmpleado.readByUser(txtU.getText());
        System.out.println(e);
        p = new String(txtPass.getPassword());
        if(e != null){
            
            if(txtU.getText().equalsIgnoreCase(e.getUsuario()) && p.equals(e.getContrasenia()) && e.getTipoAdministrador()== 0 && e.getActivo()==1){
            JOptionPane.showMessageDialog(rootPane, "Ten un Buen dia\n"+e.getUsuario());

            VistaEmpleado emp = new VistaEmpleado();
            emp.setEmpleado(e);
            emp.setVisible(true);
            dispose();  
                
            } else{
                    if(txtU.getText().equalsIgnoreCase(e.getUsuario()) && p.equals(e.getContrasenia()) && e.getTipoAdministrador() ==1 && e.getActivo()==1){
                    try{
                        String tipo = (JOptionPane.showInputDialog(null, "Seleccione un tipo de usuario","Usuario",
                        JOptionPane.PLAIN_MESSAGE,null,new Object[] {"Administrador", "Empleado" }, "Selecciona")).toString();
                
                        if (tipo.equals("Administrador")){
                            progres.setVisible(true);
                            cont =-1;
                            progres.setValue(0);
                            progres.setStringPainted(true);
                            tiempo = new Timer(two_second, new TimerListener());
                            activar();  
                        }else {
                        JOptionPane.showMessageDialog(rootPane, "Acceso Correcto!\n"+"Empleado: "+e.getUsuario());
                        VistaEmpleado e1 = new VistaEmpleado();
                        e1.setEmpleado(e);
                        e1.setVisible(true);
                        dispose();
                        }
                    }catch(Exception ex){
                        
                    }
                    }else{
                    JOptionPane.showMessageDialog(rootPane, "Acceso Denegado");
                    txtPass.setText("");
                    txtU.setText("");
                    txtU.requestFocus();
                    }
            }
        
        } else{
            System.out.println("1");
            if(txtU.getText().equalsIgnoreCase(upadre) && p.equalsIgnoreCase(pPadre)){
            JOptionPane.showMessageDialog(rootPane, "Usuario Padre!\n"+"Adm: "+txtU.getText());
            VistaAdministrador a = new VistaAdministrador();
            a.setVisible(true);
            dispose();  
            
            }else{
                JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña incorrecto","ERROR",JOptionPane.WARNING_MESSAGE);
                txtPass.setText("");
                txtU.setText("");
                txtU.requestFocus(); 
            }
        }
            
        }    
    }//GEN-LAST:event_txtPassKeyPressed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar progres;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtU;
    // End of variables declaration//GEN-END:variables
}
