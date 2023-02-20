/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentaciones;

import dominio.Cliente;
import dominio.Cuenta;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import interfaces.IDepositosDAO;
import interfaces.IDireccionesDAO;
import interfaces.IMoviminetosDAO;
import interfaces.IRetirosSinCuentaDAO;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
public class TransferenciasForm extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IClientesDAO clientesDAO;
    private final IDireccionesDAO direccionesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IRetirosSinCuentaDAO retirosDAO;
    private Cliente cliente;
    private List<Cuenta> cuentasCliente;
    private int numCuenta;
    private final IDepositosDAO depositosDAO;
    private final IMoviminetosDAO movimientosDAO;

    /**
     * Creates new form TransferenciasForm
     */
    public TransferenciasForm(IClientesDAO clientesDAO, IDireccionesDAO direccionesDAO, ICuentasDAO cuentasDAO, IRetirosSinCuentaDAO retirosDAO, Cliente cliente, List<Cuenta> cuentasCliente,IDepositosDAO depositosDAO,IMoviminetosDAO movimientosDAO) {
        this.clientesDAO = clientesDAO;
        this.direccionesDAO = direccionesDAO;
        this.cuentasDAO = cuentasDAO;
        this.retirosDAO = retirosDAO;
        this.cliente = cliente;
        this.cuentasCliente = cuentasCliente;
        this.depositosDAO = depositosDAO;
        this.movimientosDAO = movimientosDAO;
        initComponents();
        this.cargarCuentas();
    }

    private void cargarCuentas() {
        for (Cuenta cuenta : cuentasCliente) {
            cmbCuentas.addItem(cuenta.getNumeroCuenta());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbCuentas = new javax.swing.JComboBox<>();
        txtCuentaDestino = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Cuenta");

        jLabel2.setText("Cuenta Destino");

        jLabel3.setText("Monto");

        cmbCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCuentasActionPerformed(evt);
            }
        });

        txtCuentaDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuentaDestinoKeyTyped(evt);
            }
        });

        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });

        jLabel4.setText("Contraseña");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCuentaDestino)
                            .addComponent(txtMonto)
                            .addComponent(cmbCuentas, 0, 134, Short.MAX_VALUE)
                            .addComponent(txtContraseña)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCuentaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarMensajeErrorAlConsultarCuenta() {
        JOptionPane.showMessageDialog(this, "La cuenta no existe",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeErrorCuentaExistente() {
        JOptionPane.showMessageDialog(this, "NO se puede hacer transferencias a la misma cuenta",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeErrorContrasena() {
        JOptionPane.showMessageDialog(this, "Verificar Contraseña",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeErorMonto(){
        JOptionPane.showMessageDialog(this, "La cuenta no tiene los suficientes fondos",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    
    private boolean validarContrasena(Integer numCuenta) {
        if (txtContraseña != null) {
            String contrasena = txtContraseña.getText();
            if (cliente.getContrasena().equals(contrasena)) {
                return true;
            } else {
                this.mostrarMensajeErrorContrasena();
                return false;
            }
        } else {
            this.mostrarMensajeErrorContrasena();
            return false;
        }

    }

    private void comprobarCuentaDestino() {
        try {
            int cuentaDestino = Integer.parseInt(txtCuentaDestino.getText());
            Cuenta cuenta = this.cuentasDAO.consultarCuenta(cuentaDestino);
            if (cuenta.getCodigoCliente() != null) {
                if (numCuenta != cuenta.getNumeroCuenta()) {
                    if (this.validarContrasena(numCuenta)) {
                        float monto = Float.parseFloat(txtMonto.getText());
                        this.cuentasDAO.transferencia(numCuenta, cuentaDestino, monto);
                    }
                } else {
                    this.mostrarMensajeErrorCuentaExistente();
                }
            } else {
                this.mostrarMensajeErrorAlConsultarCuenta();
            }
        } catch (PersistenciaException ex) {
            this.mostrarMensajeErorMonto();
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        new AdministracionCuentaForm(clientesDAO,direccionesDAO,cuentasDAO,retirosDAO,cliente,depositosDAO,movimientosDAO).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
          this.comprobarCuentaDestino();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cmbCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCuentasActionPerformed
            this.numCuenta = (Integer)cmbCuentas.getSelectedItem();
    }//GEN-LAST:event_cmbCuentasActionPerformed

    private void txtCuentaDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaDestinoKeyTyped
        char car = evt.getKeyChar();
        if (car < '0' || car > '9')
            evt.consume();
    }//GEN-LAST:event_txtCuentaDestinoKeyTyped

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < '.' ))
            evt.consume();
    }//GEN-LAST:event_txtMontoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<Integer> cmbCuentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCuentaDestino;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
