/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentaciones;

import dominio.Cuenta;
import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import interfaces.IDireccionesDAO;
import interfaces.IRetirosSinCuentaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
public class RetiroForm extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName()); 
    private final IClientesDAO clientesDAO;
    private final IDireccionesDAO direccionesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IRetirosSinCuentaDAO retirosDAO;
    /**
     * Creates new form RetiroForm
     */
    public RetiroForm(IClientesDAO clientesDAO,IDireccionesDAO direccionesDAO,ICuentasDAO cuentasDAO,IRetirosSinCuentaDAO retirosDAO) {
        this.clientesDAO = clientesDAO;
        this.direccionesDAO = direccionesDAO;
        this.cuentasDAO = cuentasDAO;
        this.retirosDAO = retirosDAO;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Folio");

        jLabel2.setText("Contraseña");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Monto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFolio)
                            .addComponent(txtMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtContrasena)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private RetiroSinCuenta extrarDatosForm(){
        Integer folio = Integer.getInteger(txtFolio.getText());
        Integer contrasena = Integer.getInteger(txtContrasena.getText());
        Float monto  = Float.valueOf(txtMonto.getText());
        RetiroSinCuenta retiroSinCuenta = new RetiroSinCuenta(folio, contrasena, monto);
        return retiroSinCuenta;
    }
    
    public void mostrarMensajeErrorConsultarCuenta() {
        JOptionPane.showMessageDialog(this, "El folio no es correcto",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void mostrarMensajeErrorSaldoInsuficiente() {
        JOptionPane.showMessageDialog(this, "Saldo en cuenta insucificiente",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void comprobarFolio(){
        try{
            RetiroSinCuenta retiroSinCuenta = this.extrarDatosForm();
            this.retirosDAO.consultar(retiroSinCuenta.getFolio());
        }catch (PersistenciaException ex){
             LOG.log(Level.SEVERE, ex.getMessage());
             this.mostrarMensajeErrorConsultarCuenta();
        }
    }
    private RetiroSinCuenta comprobarSaldo(){
        try{
            RetiroSinCuenta retiroSinCuenta = this.extrarDatosForm();
            RetiroSinCuenta folioConsultado = this.retirosDAO.consultar(retiroSinCuenta.getFolio());
            Cuenta consultarCuenta = this.cuentasDAO.consultarCuenta(folioConsultado.getCuenta_retirada());
            if(consultarCuenta.getMonto()<retiroSinCuenta.getMonto()){
                this.mostrarMensajeErrorSaldoInsuficiente();
                return null;
            }else{
                return folioConsultado;
            }
        }catch (PersistenciaException ex){
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }
    private void realizarRetiro(){
        try{
            RetiroSinCuenta retiroSinCuenta = this.extrarDatosForm();
            this.comprobarFolio();
            if(this.comprobarSaldo() == null){
                
            }else{
                if(retiroSinCuenta.getContraseña() == this.comprobarSaldo().getContraseña()){
                  this.retirosDAO.actualizarRetiro(retiroSinCuenta.getFolio(),retiroSinCuenta.getMonto(), "Cobrado");
                }
            }
        }catch (PersistenciaException ex){
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        new InicioForm(clientesDAO,direccionesDAO,cuentasDAO,retirosDAO).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        this.realizarRetiro();
    }//GEN-LAST:event_btnAceptarActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
