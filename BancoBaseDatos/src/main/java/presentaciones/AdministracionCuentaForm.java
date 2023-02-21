/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentaciones;

import dominio.Cliente;
import dominio.Cuenta;
import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import interfaces.IDepositosDAO;
import interfaces.IDireccionesDAO;
import interfaces.IMoviminetosDAO;
import interfaces.IRetirosSinCuentaDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Frame de adminsitración del cliente
 * @author julio
 */
public class AdministracionCuentaForm extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());//Logger para errores
    private final IClientesDAO clientesDAO;//Interfaz de clientes
    private final IDireccionesDAO direccionesDAO;//Interfaz de direcciones
    private final ICuentasDAO cuentasDAO;//Interfaz de cuentas
    private final IRetirosSinCuentaDAO retirosDAO;//Interfaz de retiros
    private final Cliente cliente;//Cliente iniciado
    private List<Cuenta> cuentasCliente;//Lista de cuentas del cliente
    private int numeroCuenta;//Número de la cuenta en uso
    private final IDepositosDAO depositosDAO;//Interfaz de depósitos
    private final IMoviminetosDAO movimientosDAO;//Interfaz de movimientos

    /**
     * Constructor del formulario que adminsitra la cuenta, le pone título y
     * llama al método para cargar las cuentas del cliente.
     *
     * @param clientesDAO Interfaz de clientes
     * @param direccionesDAO Interfaz de direcciones
     * @param cuentasDAO Interfaz de cuentas
     * @param retirosDAO Interfaz de retiros
     * @param cliente Cliente iniciado
     * @param depositosDAO Interfaz de depósitos
     * @param movimientosDAO Interfaz de movimientos
     */
    public AdministracionCuentaForm(IClientesDAO clientesDAO, IDireccionesDAO direccionesDAO, ICuentasDAO cuentasDAO, IRetirosSinCuentaDAO retirosDAO, Cliente cliente, IDepositosDAO depositosDAO, IMoviminetosDAO movimientosDAO) {
        this.clientesDAO = clientesDAO;
        this.direccionesDAO = direccionesDAO;
        this.cuentasDAO = cuentasDAO;
        this.retirosDAO = retirosDAO;
        this.cliente = cliente;
        this.depositosDAO = depositosDAO;
        this.movimientosDAO = movimientosDAO;
        initComponents();
        this.setTitle("Administrar cliente");
        this.cargarCuentasCliente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jToolBar1 = new javax.swing.JToolBar();
        btnMovimientos = new javax.swing.JButton();
        btnTransferencia = new javax.swing.JButton();
        btnRetiroSinCuenta = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCancelarCuenta = new javax.swing.JButton();
        btnCrearCuenta = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbCuentas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);
        jToolBar1.setBackground(new java.awt.Color(192, 212, 193));
        jToolBar1.setEnabled(false);

        btnMovimientos.setText("Movimientos ");
        btnMovimientos.setBackground(new java.awt.Color(100, 156, 104));
        btnMovimientos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnMovimientos.setFocusable(false);
        btnMovimientos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnMovimientos.setForeground(new java.awt.Color(255, 255, 255));
        btnMovimientos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMovimientos.setMaximumSize(new java.awt.Dimension(1000, 50));
        btnMovimientos.setMinimumSize(new java.awt.Dimension(1000, 1000));
        btnMovimientos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosActionPerformed(evt);
            }
        });
        jToolBar1.add(btnMovimientos);

        btnTransferencia.setText("Transferencia");
        btnTransferencia.setBackground(new java.awt.Color(100, 156, 104));
        btnTransferencia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnTransferencia.setFocusable(false);
        btnTransferencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTransferencia.setForeground(new java.awt.Color(255, 255, 255));
        btnTransferencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTransferencia.setMaximumSize(new java.awt.Dimension(1000, 50));
        btnTransferencia.setMinimumSize(new java.awt.Dimension(1000, 1000));
        btnTransferencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnTransferencia);

        btnRetiroSinCuenta.setText("Retiro sin Cuenta");
        btnRetiroSinCuenta.setBackground(new java.awt.Color(100, 156, 104));
        btnRetiroSinCuenta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRetiroSinCuenta.setFocusable(false);
        btnRetiroSinCuenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRetiroSinCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnRetiroSinCuenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRetiroSinCuenta.setMaximumSize(new java.awt.Dimension(1000, 50));
        btnRetiroSinCuenta.setMinimumSize(new java.awt.Dimension(1000, 1000));
        btnRetiroSinCuenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRetiroSinCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroSinCuentaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRetiroSinCuenta);

        btnActualizar.setText("Actualizar Datos ");
        btnActualizar.setBackground(new java.awt.Color(100, 156, 104));
        btnActualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnActualizar.setFocusable(false);
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setMaximumSize(new java.awt.Dimension(1000, 50));
        btnActualizar.setMinimumSize(new java.awt.Dimension(1000, 1000));
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnActualizar);

        btnCancelarCuenta.setText("Cancelar Cuenta ");
        btnCancelarCuenta.setBackground(new java.awt.Color(100, 156, 104));
        btnCancelarCuenta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCancelarCuenta.setFocusable(false);
        btnCancelarCuenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelarCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarCuenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelarCuenta.setMaximumSize(new java.awt.Dimension(1000, 50));
        btnCancelarCuenta.setMinimumSize(new java.awt.Dimension(1000, 1000));
        btnCancelarCuenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCuentaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCancelarCuenta);

        btnCrearCuenta.setText("Crear Cuenta");
        btnCrearCuenta.setBackground(new java.awt.Color(100, 156, 104));
        btnCrearCuenta.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCrearCuenta.setFocusable(false);
        btnCrearCuenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCrearCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearCuenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCrearCuenta.setMaximumSize(new java.awt.Dimension(1000, 50));
        btnCrearCuenta.setMinimumSize(new java.awt.Dimension(1000, 1000));
        btnCrearCuenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCrearCuenta);

        btnSalir.setText("Salir");
        btnSalir.setBackground(new java.awt.Color(100, 156, 104));
        btnSalir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSalir.setFocusable(false);
        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setMaximumSize(new java.awt.Dimension(1000, 50));
        btnSalir.setMinimumSize(new java.awt.Dimension(1000, 1000));
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalir);

        jPanel1.setBackground(new java.awt.Color(192, 212, 193));

        jLabel1.setText("Cuenta");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(55, 81, 55));

        cmbCuentas.setBackground(new java.awt.Color(236, 196, 100));
        cmbCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCuentasActionPerformed(evt);
            }
        });

        jLabel2.setText("Saldo");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(55, 81, 55));

        txtSaldo.setBackground(new java.awt.Color(236, 196, 100));

        jLabel4.setBackground(new java.awt.Color(148, 116, 69));
        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cliente");
        jLabel4.setOpaque(true);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/rating.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cmbCuentas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel3)))
                .addGap(0, 17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método encargado de cargar las cuentas del cliente con la sesión
     * iniciada, en caso de un error se lanza un log.
     */
    private void cargarCuentasCliente() {
        try {
            cuentasCliente = this.cuentasDAO.consultarCuentasCliente(cliente.getId());
            for (Cuenta cuenta : cuentasCliente) {
                cmbCuentas.addItem(cuenta.getNumeroCuenta());
            }
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }

    /**
     * Método que obtiene el saldo de la cuenta seleccionada y llama al método
     * para cargarlo.
     *
     * @param numeroCuenta numero de la cuenta seleccionada para obtenerle el
     * saldo
     */
    private void obtenerSaldo(int numeroCuenta) {
        try {
            Cuenta cuenta = this.cuentasDAO.consultarCuenta(numeroCuenta);
            float saldo = cuenta.getMonto();
            this.cargarSaldo(saldo);
        } catch (PersistenciaException e) {
            this.mostrarMensajeErrorObtenerSaldo();
        }
    }

    /**
     * Método encargado de cargar el saldo en un cuadro de texto.
     *
     * @param saldo Saldo de la cuenta seleccionada
     */
    public void cargarSaldo(float saldo) {
        this.txtSaldo.setEditable(false);
        this.txtSaldo.setText("$" + saldo);
    }

    /**
     * Método que imprime mensaje de error al querer crear una cuenta.
     */
    public void mostrarMensajeErrorAlCrear() {
        JOptionPane.showMessageDialog(this, "Error al crear cuenta, intentar luego",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Método que imprime mensaje de error al querer obtener el saldo de la
     * cuenta.
     */
    public void mostrarMensajeErrorObtenerSaldo() {
        JOptionPane.showMessageDialog(this, "Error al obtener saldo, intentar luego",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Método que se acciona al dar click al botón para acceder a la ventana de
     * movimientos.
     *
     * @param evt Evento que se crea al dar click al botón.
     */
    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
        new MovimientosForm(clientesDAO, direccionesDAO, cuentasDAO, retirosDAO, cliente, cuentasCliente, depositosDAO, movimientosDAO).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMovimientosActionPerformed

    /**
     * Método que se acciona al dar click al botón para acceder a la ventana de
     * transferencias.
     *
     * @param evt Evento que se crea al dar click al botón.
     */
    private void btnTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciaActionPerformed
        new TransferenciasForm(clientesDAO, direccionesDAO, cuentasDAO, retirosDAO, cliente, cuentasCliente, depositosDAO, movimientosDAO).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTransferenciaActionPerformed

    /**
     * Método que se acciona al dar click al botón para salir de la ventana
     * actual y regresar al inicio.
     *
     * @param evt Evento que se crea al dar click al botón.
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new InicioForm(clientesDAO, direccionesDAO, cuentasDAO, retirosDAO, depositosDAO, movimientosDAO).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * Método encargado de llamar el método de la interfaz para crear una
     * cuenta, en caso de error se manda un mensaje de error.
     */
    private void crearCuenta() {
        try {
            this.cuentasDAO.crearCuenta(cliente.getId());
        } catch (PersistenciaException ex) {
            this.mostrarMensajeErrorAlCrear();
        }
    }

    /**
     * Método que imprime mensaje de error al querer crear un retiro sin cuenta.
     */
    public void mostrarMensajeErrorCrearRetiroSinCuenta() {
        JOptionPane.showMessageDialog(this, "Error no se pudo crear el retiro sin cuenta",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Método que imprime mensaje de error al querer cancelar una cuenta.
     */
    public void mostrarMensajeErrorAlCancelar() {
        JOptionPane.showMessageDialog(this, "Error no se pudo cancelar la cuenta",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Método que imprime mensaje con los datos de del retiro sin cuenta, es
     * decir, el folio y contraseña.
     *
     * @param informacion Variable que sirve para recibir el retiro sin cuenta y
     * usar su información
     */
    public void mostrarMensajeDatosParaRetiro(RetiroSinCuenta informacion) {
        JOptionPane.showMessageDialog(this, "El folio del retiro es: " + informacion.getFolio()
                + " La Contraseña para realizar el retiro es: " + informacion.getContraseña(),
                "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método que imprime mensaje cuando se elimina una cuenta.
     */
    public void mostrarMensajeCuentaEliminada() {
        JOptionPane.showMessageDialog(this, "Se ha eliminado la cuenta",
                "Hecho", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método que imprime mensaje para pedir confirmación al cancelar cuenta.
     *
     * @return Regresa un entero que representa la opción elegida.
     */
    public int mostrarMensajeConfirmacionCancelar() {
        return JOptionPane.showOptionDialog(this, "¿Esta seguro que desea eliminar la cuenta " + numeroCuenta + "? (Saldo: " + this.txtSaldo.getText() + ")",
                "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, new Object[]{"Sí", "No"}, JOptionPane.YES_OPTION);
    }

    /**
     * Método que genera un retiro sin cuenta apartir del número de cuenta,
     * después consulta ese retiro y muestra el mensaje para informar al
     * usuario.
     */
    private void retiroSinCuenta() {
        try {
            RetiroSinCuenta folioRetiro = this.retirosDAO.crearRetiro(numeroCuenta);
            RetiroSinCuenta datosConsultados = this.retirosDAO.consultar(folioRetiro.getFolio());
            this.mostrarMensajeDatosParaRetiro(datosConsultados);
        } catch (PersistenciaException ex) {
            this.mostrarMensajeErrorCrearRetiroSinCuenta();
        }
    }

    /**
     * Método que llama a la interfaz de las cuentas para cancelar una cuenta,
     * después de haber pedido confirmación, si hay un errror muestra un
     * mensaje.
     */
    private void cancelarCuenta() {
        try {
            if (this.mostrarMensajeConfirmacionCancelar() == (JOptionPane.YES_OPTION)) {
                this.cuentasDAO.cancelarCuenta(numeroCuenta);
            }
        } catch (PersistenciaException e) {
            this.mostrarMensajeErrorAlCancelar();
        }
    }

    /**
     * Método que se acciona al dar click al botón para llamar el método de
     * crear cuenta y remover los items del comboBox.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        this.crearCuenta();
        cmbCuentas.removeAllItems();
    }//GEN-LAST:event_btnCrearCuentaActionPerformed

    /**
     * Método que esta constantemente cargando las cuentas en el comboBox,
     * además obtiene saldo llamando al método correspondiente.
     *
     * @param evt Evento que se crea al realizar una acción
     */
    private void cmbCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCuentasActionPerformed
        if (cmbCuentas.getSelectedItem() == null) {
            this.cargarCuentasCliente();
            numeroCuenta = (Integer) cmbCuentas.getSelectedItem();
        } else {
            numeroCuenta = (Integer) cmbCuentas.getSelectedItem();
            this.obtenerSaldo(numeroCuenta);
        }

    }//GEN-LAST:event_cmbCuentasActionPerformed

    /**
     * Método que se acciona al dar click al botón para llamar al método de
     * retiro sin cuenta.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnRetiroSinCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroSinCuentaActionPerformed
        this.retiroSinCuenta();
    }//GEN-LAST:event_btnRetiroSinCuentaActionPerformed

    /**
     * Método que se acciona al dar click al botón para llamar el método de
     * cancelar la cuenta y remover los items del comboBox.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnCancelarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCuentaActionPerformed
        this.cancelarCuenta();
        cmbCuentas.removeAllItems();
    }//GEN-LAST:event_btnCancelarCuentaActionPerformed

    /**
     * Método que se acciona al dar clcik al botón para crear una ventana para
     * actualizar clientes.
     * 
     * @param evt Evento que se crea al dar clicl al botón
     */
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        new ClientesForm(clientesDAO, direccionesDAO, cuentasDAO, retirosDAO, depositosDAO, movimientosDAO, cliente.getCorreoElectronico()).setVisible(true);
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelarCuenta;
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JButton btnRetiroSinCuenta;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTransferencia;
    private javax.swing.JComboBox<Integer> cmbCuentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
