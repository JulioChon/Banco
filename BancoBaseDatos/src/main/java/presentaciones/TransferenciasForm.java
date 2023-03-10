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
import java.awt.Color;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Frame de transferencias
 *
 * @author julio
 */
public class TransferenciasForm extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());//Logger para errores
    private final IClientesDAO clientesDAO;//Interfaz de clientes
    private final IDireccionesDAO direccionesDAO;//Interfaz de direcciones
    private final ICuentasDAO cuentasDAO;//Interfaz de cuentas
    private final IRetirosSinCuentaDAO retirosDAO;//Interfaz de retiros
    private final IDepositosDAO depositosDAO;//Interfaz de depósitos
    private final IMoviminetosDAO movimientosDAO;//Interfaz de movimientos
    private Cliente cliente;//Cliente al que le pertenecen las cuentas
    private List<Cuenta> cuentasCliente;//Lista de cuentas del cliente
    private int numCuenta;//Número de la cuenta seleccionada

    /**
     * Constructor del formulario de transferencias, se cargan las cuentas del
     * cliente.
     *
     * @param clientesDAO Interfaz de clientes
     * @param direccionesDAO Interfaz de direcciones
     * @param cuentasDAO Interfaz de cuentas
     * @param retirosDAO Interfaz de retiros
     * @param depositosDAO Interfaz de depósitos
     * @param movimientosDAO Interfaz de movimientos
     * @param cliente Cliente que va a transferir
     * @param cuentasCliente Cuentas del cliente
     */
    public TransferenciasForm(IClientesDAO clientesDAO, IDireccionesDAO direccionesDAO, ICuentasDAO cuentasDAO, IRetirosSinCuentaDAO retirosDAO, Cliente cliente, List<Cuenta> cuentasCliente, IDepositosDAO depositosDAO, IMoviminetosDAO movimientosDAO) {
        this.clientesDAO = clientesDAO;
        this.direccionesDAO = direccionesDAO;
        this.cuentasDAO = cuentasDAO;
        this.retirosDAO = retirosDAO;
        this.cliente = cliente;
        this.cuentasCliente = cuentasCliente;
        this.depositosDAO = depositosDAO;
        this.movimientosDAO = movimientosDAO;
        initComponents();
        this.setTitle("Transferencias");
        this.cargarCuentas();
    }

    /**
     * Método que a partir de la lista de cuentas carga las cuentas en un
     * comboBox.
     */
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

        jPanel1 = new javax.swing.JPanel();
        txtMonto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbCuentas = new javax.swing.JComboBox<>();
        txtCuentaDestino = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(192, 212, 193));

        txtMonto.setBackground(new java.awt.Color(192, 212, 193));
        txtMonto.setBorder(null);
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });

        jLabel4.setText("Contraseña");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(55, 81, 55));

        btnAceptar.setText("Aceptar");
        btnAceptar.setBackground(new java.awt.Color(100, 156, 104));
        btnAceptar.setBorder(null);
        btnAceptar.setBorderPainted(false);
        btnAceptar.setFocusable(false);
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAceptarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAceptarMouseReleased(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setBackground(new java.awt.Color(100, 156, 104));
        btnCancelar.setBorder(null);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setFocusable(false);
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCancelarMousePressed(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtContraseña.setBackground(new java.awt.Color(192, 212, 193));
        txtContraseña.setBorder(null);

        jLabel1.setText("Cuenta");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(55, 81, 55));

        jLabel2.setText("Cuenta Destino");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(55, 81, 55));

        jLabel3.setText("Monto");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(55, 81, 55));

        cmbCuentas.setBackground(new java.awt.Color(236, 196, 100));
        cmbCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCuentasActionPerformed(evt);
            }
        });

        txtCuentaDestino.setBackground(new java.awt.Color(192, 212, 193));
        txtCuentaDestino.setBorder(null);
        txtCuentaDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuentaDestinoKeyTyped(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(236, 196, 100));
        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Transferencias");
        jLabel5.setOpaque(true);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbCuentas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCuentaDestino)
                    .addComponent(txtMonto)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCuentaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Mensaje cuando la cuenta no existe.
     */
    public void mostrarMensajeErrorAlConsultarCuenta() {
        JOptionPane.showMessageDialog(this, "La cuenta no existe",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mensaje cuando la cuenta de destino y emisor es la misma.
     */
    public void mostrarMensajeErrorCuentaExistente() {
        JOptionPane.showMessageDialog(this, "NO se puede hacer transferencias a la misma cuenta",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mensaje cuando la contraseña es incorrecta.
     */
    public void mostrarMensajeErrorContrasena() {
        JOptionPane.showMessageDialog(this, "Verificar Contraseña",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mensaje cuando la cuenta no cuenta con los fondos para el monto puesto.
     */
    public void mostrarMensajeErrorMonto() {
        JOptionPane.showMessageDialog(this, "La cuenta no tiene los suficientes fondos",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mensaje que se muestra en caso que la cuenta destino tenga como estado
     * "Cancelada".
     */
    public void mostrarMensajeErrorAlVerificarEstado() {
        JOptionPane.showMessageDialog(this, "La cuenta destino esta cancelada",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mensaje cuando hay un error con el monto.
     */
    public void mostrarMensajeErrorConMonto() {
        JOptionPane.showMessageDialog(this, "Monto no disponible",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Mensaje cuando se cumplio con la transferencia.
     */
    public void mostrarMensajeTransferencia() {
        JOptionPane.showMessageDialog(this, "Transferencia realizada",
                "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método que a partir de la cuenta se comparan contraseñas.
     *
     * @param numCuenta Cuenta de la que se quiere sacar el dinero
     * @return Boolean dependiendo si la contraseña es correcta o incorrecta
     */
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

    /**
     * Método que verifica el estado de la cuenta destino.
     *
     * @param cuenta Cuenta destino
     * @return Boolean si esta o no "Activa" la cuenta
     */
    public boolean verificarEstado(Cuenta cuenta) {
        return cuenta.getEstado().equals("Activa");
    }

    /**
     * Método que une todo para obtener la información comparar y confirmar que
     * se puede hacer la transferencia, realizarla y salir de la ventana. En
     * caso de erro se tienen llamados a mensajes de error.
     */
    private void comprobarCuentaDestino() {
        try {
            int cuentaDestino = Integer.parseInt(txtCuentaDestino.getText());
            Cuenta cuenta = this.cuentasDAO.consultarCuenta(cuentaDestino);
            if (cuenta.getCodigoCliente() != null) {
                if (numCuenta != cuenta.getNumeroCuenta()) {
                    if (verificarEstado(cuenta)) {
                        if (this.validarContrasena(numCuenta)) {
                            if (txtMonto.getText().isEmpty() || Float.parseFloat(txtMonto.getText()) == 0.0) {
                                this.mostrarMensajeErrorConMonto();
                            } else {
                                float monto = Float.parseFloat(txtMonto.getText());
                                this.cuentasDAO.transferencia(numCuenta, cuentaDestino, monto);
                                this.mostrarMensajeTransferencia();
                                new AdministracionCuentaForm(clientesDAO, direccionesDAO, cuentasDAO, retirosDAO, cliente, depositosDAO, movimientosDAO).setVisible(true);
                                this.dispose();
                            }
                        }
                    } else {
                        this.mostrarMensajeErrorAlVerificarEstado();
                    }
                } else {
                    this.mostrarMensajeErrorCuentaExistente();
                }
            } else {
                this.mostrarMensajeErrorAlConsultarCuenta();
            }
        } catch (PersistenciaException ex) {
            this.mostrarMensajeErrorMonto();
        }
    }

    /**
     * Método que se acciona al dar click al botón para cancelar la
     * transferencia y regresar al frame de las cuentas.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        new AdministracionCuentaForm(clientesDAO, direccionesDAO, cuentasDAO, retirosDAO, cliente, depositosDAO, movimientosDAO).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Método que se acciona al dar click al botón para comprobar todos los
     * datos y realizar la transferencia.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        this.comprobarCuentaDestino();
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * Método que define el valor de la variable numCuenta dependiendo del valor
     * seleccionado en el comboBox.
     *
     * @param evt Evento que se crea al cambiar de item
     */
    private void cmbCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCuentasActionPerformed
        this.numCuenta = (Integer) cmbCuentas.getSelectedItem();
    }//GEN-LAST:event_cmbCuentasActionPerformed

    /**
     * Evento que restringe los caracteres para el numero de cuenta, permitiendo
     * solo numeros.
     *
     * @param evt Evento que se crea al teclear algo encima
     */
    private void txtCuentaDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaDestinoKeyTyped
        char car = evt.getKeyChar();
        if (car < '0' || car > '9')
            evt.consume();
    }//GEN-LAST:event_txtCuentaDestinoKeyTyped

    /**
     * Evento que restringe los caracteres para el monto, permitiendo puntos.
     *
     * @param evt Evento que se crea al teclear algo encima
     */
    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car < '.'))
            evt.consume();
    }//GEN-LAST:event_txtMontoKeyTyped

    /**
     * Evento que se acciona cuando se presiona el botón de aceptar para
     * cambiar de color.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnAceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMousePressed
        this.btnAceptar.setContentAreaFilled(false);
        this.btnAceptar.setOpaque(true);
        this.btnAceptar.setBackground(new Color(148, 116, 69));
    }//GEN-LAST:event_btnAceptarMousePressed

    /**
     * Evento que se acciona cuando se presiona el botón de cancelar para
     * cambiar de color.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMousePressed
        this.btnCancelar.setContentAreaFilled(false);
        this.btnCancelar.setOpaque(true);
        this.btnCancelar.setBackground(new Color(148, 116, 69));
    }//GEN-LAST:event_btnCancelarMousePressed

    /**
     * Evento que se acciona cuando se suelta el botón para regresar de color.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnAceptarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseReleased
        this.btnAceptar.setBackground(new Color(100, 156, 104));
    }//GEN-LAST:event_btnAceptarMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<Integer> cmbCuentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCuentaDestino;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
