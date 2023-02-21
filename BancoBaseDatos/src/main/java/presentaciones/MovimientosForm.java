/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentaciones;

import dominio.Cliente;
import dominio.Cuenta;
import dominio.Deposito;
import dominio.RetiroSinCuenta;
import dominio.Transferencia;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import interfaces.IDepositosDAO;
import interfaces.IDireccionesDAO;
import interfaces.IMoviminetosDAO;
import interfaces.IRetirosSinCuentaDAO;
import java.awt.event.ItemEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.ConfiguracionPaginado;

/**
 *
 * @author julio
 */
public class MovimientosForm extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IClientesDAO clientesDAO;
    private final IDireccionesDAO direccionesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IRetirosSinCuentaDAO retirosDAO;
    private Cliente cliente;
    private List<Cuenta> cuentasCliente;
    private int numeroCuenta;
    private final IDepositosDAO depositosDAO;
    private ConfiguracionPaginado configPaginado;
    private int tipoTransferencia;
    private int tipoOtroMovimiento;
    private final IMoviminetosDAO movimientosDAO;
    private Date fechaDesde;
    private Date fechaHasta;

    /**
     * Creates new form MovimientosForm
     */
    public MovimientosForm(IClientesDAO clientesDAO, IDireccionesDAO direccionesDAO, ICuentasDAO cuentasDAO, IRetirosSinCuentaDAO retirosDAO, Cliente cliente, List<Cuenta> cuentasCliente, IDepositosDAO depositosDAO, IMoviminetosDAO movimientosDAO) {
        this.clientesDAO = clientesDAO;
        this.direccionesDAO = direccionesDAO;
        this.cuentasDAO = cuentasDAO;
        this.retirosDAO = retirosDAO;
        this.cliente = cliente;
        this.cuentasCliente = cuentasCliente;
        this.depositosDAO = depositosDAO;
        this.movimientosDAO = movimientosDAO;
        initComponents();
        this.configPaginado = new ConfiguracionPaginado(0, 3);
        this.cargarCuentas();
        this.cargarTablaOtrosMovimientos();
        this.cargarTablaTransferencias();
        this.tipoOtroMovimiento = 1;
        this.tipoTransferencia = 1;
        this.fechaDesde = Date.valueOf(LocalDate.of(1920, 01, 01));
        this.fechaHasta = Date.valueOf(LocalDate.now().plusDays(1));
        LocalDate fechaActual = LocalDate.now();
        LocalDate minFecha = LocalDate.of(1920, 01, 01);
        dtpDesde.getSettings().setDateRangeLimits(minFecha, fechaActual);
        dtpHasta.getSettings().setDateRangeLimits(minFecha, fechaActual);
        this.setTitle("Movimientos");
    }

    private void cargarCuentas() {
        for (Cuenta cuenta : cuentasCliente) {
            cmbCuentas.addItem(cuenta.getNumeroCuenta());
        }
    }

    private void avanzarPagina() {
        this.configPaginado.avanzarPagina();
        this.cargarTablaOtrosMovimientos();
        this.cargarTablaTransferencias();

    }

    private void retrocederPagina() {
        this.configPaginado.retrocederPagina();
        this.cargarTablaOtrosMovimientos();
        this.cargarTablaTransferencias();
    }

    public void transferenciasRealizas() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // aqui es donde le mandas el periodo, primero la fecha inicio y despues la final
            List<Transferencia> transferenciasRealizadas = this.movimientosDAO.realizadas(numeroCuenta, configPaginado, fechaDesde, fechaHasta);
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblTransferencias.getModel();
            modeloTabla.setRowCount(0);
            for (Transferencia transferenciasRealizada : transferenciasRealizadas) {
                Object[] fila = {
                    transferenciasRealizada.getCodigo_receptor(),
                    transferenciasRealizada.getMonto(),
                    formatter.format(transferenciasRealizada.getFecha())
                };
                modeloTabla.addRow(fila);
            }
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }

    public void transferenciasRecibidas() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // aqui es donde le mandas el periodo, primero la fecha inicio y despues la final
            List<Transferencia> transferenciasRecibidas = this.movimientosDAO.recibidas(numeroCuenta, configPaginado, fechaDesde, fechaHasta);
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblTransferencias.getModel();
            modeloTabla.setRowCount(0);
            for (Transferencia transferenciasRecibida : transferenciasRecibidas) {
                Object[] fila = {
                    transferenciasRecibida.getCodigo_emisor(),
                    transferenciasRecibida.getMonto(),
                    formatter.format(transferenciasRecibida.getFecha())
                };
                modeloTabla.addRow(fila);
            }
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }

    public void retiros() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // aqui es donde le mandas el periodo, primero la fecha inicio y despues la final
            List<RetiroSinCuenta> retirosSinCuentaRealizados = this.movimientosDAO.realizar(numeroCuenta, configPaginado, fechaDesde, fechaHasta);
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblOtrosMovimientos.getModel();
            modeloTabla.setRowCount(0);
            for (RetiroSinCuenta retirosSinCuentaRealizado : retirosSinCuentaRealizados) {
                Object[] fila = {
                    retirosSinCuentaRealizado.getFolio(),
                    retirosSinCuentaRealizado.getMonto(),
                    formatter.format(retirosSinCuentaRealizado.getFecha())
                };
                modeloTabla.addRow(fila);
            }
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }

    public void depositos() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // aqui es donde le mandas el periodo, primero la fecha inicio y despues la final
            List<Deposito> depositos = this.movimientosDAO.Depocitosrecibidos(numeroCuenta, configPaginado, fechaDesde, fechaHasta);
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tblOtrosMovimientos.getModel();
            modeloTabla.setRowCount(0);
            for (Deposito deposito : depositos) {
                Object[] fila = {
                    deposito.getId(),
                    deposito.getMonto(),
                    formatter.format(deposito.getFecha())
                };
                modeloTabla.addRow(fila);
            }
        } catch (PersistenciaException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }

    public void cargarTablaTransferencias() {
        if (tipoTransferencia == 1) {
            this.transferenciasRealizas();
        } else {
            this.transferenciasRecibidas();
        }

    }

    public void cargarTablaOtrosMovimientos() {
        if (tipoOtroMovimiento == 1) {
            this.depositos();
        } else {
            this.retiros();
        }
    }

    public void filtrarPorFechas() {
        if (this.dtpDesde.getDate() == null || this.dtpHasta.getDate() == null) {
            this.mostrarMensajeErrorFechaVacia();
        } else {
            this.fechaDesde = Date.valueOf(this.dtpDesde.getDate());
            this.fechaHasta = Date.valueOf(this.dtpHasta.getDate().plusDays(1));
            this.cargarTablaTransferencias();
            this.cargarTablaOtrosMovimientos();
        }
    }

    public void mostrarMensajeErrorFechaVacia() {
        JOptionPane.showMessageDialog(this, "Favor de seleccionar una fecha válida",
                "Error", JOptionPane.ERROR_MESSAGE);
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
        btnDepositos = new javax.swing.JButton();
        btnRedroceder = new javax.swing.JButton();
        btnAvanzar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        lblFecha = new javax.swing.JLabel();
        dtpDesde = new com.github.lgooddatepicker.components.DatePicker();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dtpHasta = new com.github.lgooddatepicker.components.DatePicker();
        cmbCuentas = new javax.swing.JComboBox<>();
        pnlTablaTransferencias = new javax.swing.JScrollPane();
        tblTransferencias = new javax.swing.JTable();
        btnFiltrar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pnlTablaOtrosMovimientos = new javax.swing.JScrollPane();
        tblOtrosMovimientos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnTransferenciasRealizadas = new javax.swing.JButton();
        btnTransaferenciasRecibidas = new javax.swing.JButton();
        btnRetiros = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(192, 212, 193));

        btnDepositos.setText("Depositos");
        btnDepositos.setBackground(new java.awt.Color(100, 156, 104));
        btnDepositos.setBorder(null);
        btnDepositos.setBorderPainted(false);
        btnDepositos.setFocusable(false);
        btnDepositos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDepositos.setForeground(new java.awt.Color(255, 255, 255));
        btnDepositos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositosActionPerformed(evt);
            }
        });

        btnRedroceder.setText("Retrodecer");
        btnRedroceder.setBackground(new java.awt.Color(100, 156, 104));
        btnRedroceder.setBorder(null);
        btnRedroceder.setBorderPainted(false);
        btnRedroceder.setFocusable(false);
        btnRedroceder.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRedroceder.setForeground(new java.awt.Color(255, 255, 255));
        btnRedroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedrocederActionPerformed(evt);
            }
        });

        btnAvanzar.setText("Avanzar");
        btnAvanzar.setBackground(new java.awt.Color(100, 156, 104));
        btnAvanzar.setBorder(null);
        btnAvanzar.setBorderPainted(false);
        btnAvanzar.setFocusable(false);
        btnAvanzar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAvanzar.setForeground(new java.awt.Color(255, 255, 255));
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "5", "10" }));
        jComboBox1.setBackground(new java.awt.Color(236, 196, 100));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jSeparator1.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        lblFecha.setText("Buscar por fecha");
        lblFecha.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(55, 81, 55));

        jLabel5.setText("Desde");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(55, 81, 55));

        jLabel6.setText("Hasta");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(55, 81, 55));

        jLabel1.setText("Número de Cuenta");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(55, 81, 55));

        cmbCuentas.setBackground(new java.awt.Color(236, 196, 100));
        cmbCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCuentasActionPerformed(evt);
            }
        });

        pnlTablaTransferencias.setBackground(new java.awt.Color(192, 212, 193));

        tblTransferencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Numero Cuenta", "Monto", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTransferencias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlTablaTransferencias.setViewportView(tblTransferencias);

        btnFiltrar.setText("Filtrar");
        btnFiltrar.setBackground(new java.awt.Color(100, 156, 104));
        btnFiltrar.setBorder(null);
        btnFiltrar.setBorderPainted(false);
        btnFiltrar.setFocusable(false);
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.setBackground(new java.awt.Color(100, 156, 104));
        btnRegresar.setBorder(null);
        btnRegresar.setBorderPainted(false);
        btnRegresar.setFocusable(false);
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel3.setText("Transferencias");
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(55, 81, 55));

        pnlTablaOtrosMovimientos.setBackground(new java.awt.Color(192, 212, 193));

        tblOtrosMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Folio", "Monto", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOtrosMovimientos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnlTablaOtrosMovimientos.setViewportView(tblOtrosMovimientos);

        jLabel4.setText("Otros Movimientos");
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(55, 81, 55));

        btnTransferenciasRealizadas.setText("Realizadas");
        btnTransferenciasRealizadas.setBackground(new java.awt.Color(100, 156, 104));
        btnTransferenciasRealizadas.setBorder(null);
        btnTransferenciasRealizadas.setBorderPainted(false);
        btnTransferenciasRealizadas.setFocusable(false);
        btnTransferenciasRealizadas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTransferenciasRealizadas.setForeground(new java.awt.Color(255, 255, 255));
        btnTransferenciasRealizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciasRealizadasActionPerformed(evt);
            }
        });

        btnTransaferenciasRecibidas.setText("Recibidas");
        btnTransaferenciasRecibidas.setBackground(new java.awt.Color(100, 156, 104));
        btnTransaferenciasRecibidas.setBorder(null);
        btnTransaferenciasRecibidas.setBorderPainted(false);
        btnTransaferenciasRecibidas.setFocusable(false);
        btnTransaferenciasRecibidas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTransaferenciasRecibidas.setForeground(new java.awt.Color(255, 255, 255));
        btnTransaferenciasRecibidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaferenciasRecibidasActionPerformed(evt);
            }
        });

        btnRetiros.setText("Retiros");
        btnRetiros.setBackground(new java.awt.Color(100, 156, 104));
        btnRetiros.setBorder(null);
        btnRetiros.setBorderPainted(false);
        btnRetiros.setFocusable(false);
        btnRetiros.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRetiros.setForeground(new java.awt.Color(255, 255, 255));
        btnRetiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirosActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(236, 196, 100));
        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Movimientos");
        jLabel7.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblFecha)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(dtpDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(dtpHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnTransferenciasRealizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnTransaferenciasRecibidas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(pnlTablaTransferencias, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(btnRedroceder, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnRetiros, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnDepositos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(pnlTablaOtrosMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnAvanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(btnDepositos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTransferenciasRealizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTransaferenciasRecibidas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRetiros, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTablaTransferencias, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTablaOtrosMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRedroceder, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAvanzar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(dtpDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(lblFecha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        new AdministracionCuentaForm(clientesDAO, direccionesDAO, cuentasDAO, retirosDAO, cliente, depositosDAO, movimientosDAO).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cmbCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCuentasActionPerformed
        this.numeroCuenta = (Integer) cmbCuentas.getSelectedItem();
        this.cargarTablaOtrosMovimientos();
        this.cargarTablaTransferencias();
    }//GEN-LAST:event_cmbCuentasActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int elementoPorPagina = Integer.parseInt((String) evt.getItem());
            this.configPaginado.setElementoPorPagina(elementoPorPagina);
            this.cargarTablaOtrosMovimientos();
            this.cargarTablaTransferencias();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void btnTransferenciasRealizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciasRealizadasActionPerformed
        tipoTransferencia = 1;
        this.cargarTablaTransferencias();
    }//GEN-LAST:event_btnTransferenciasRealizadasActionPerformed

    private void btnTransaferenciasRecibidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaferenciasRecibidasActionPerformed
        tipoTransferencia = 2;
        this.cargarTablaTransferencias();
    }//GEN-LAST:event_btnTransaferenciasRecibidasActionPerformed

    private void btnRetirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirosActionPerformed
        tipoOtroMovimiento = 2;
        this.cargarTablaOtrosMovimientos();
    }//GEN-LAST:event_btnRetirosActionPerformed

    private void btnDepositosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositosActionPerformed
        tipoOtroMovimiento = 1;
        this.cargarTablaOtrosMovimientos();
    }//GEN-LAST:event_btnDepositosActionPerformed

    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        avanzarPagina();
    }//GEN-LAST:event_btnAvanzarActionPerformed

    private void btnRedrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedrocederActionPerformed
        retrocederPagina();
    }//GEN-LAST:event_btnRedrocederActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        this.filtrarPorFechas();
    }//GEN-LAST:event_btnFiltrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton btnDepositos;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnRedroceder;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRetiros;
    private javax.swing.JButton btnTransaferenciasRecibidas;
    private javax.swing.JButton btnTransferenciasRealizadas;
    private javax.swing.JComboBox<Integer> cmbCuentas;
    private com.github.lgooddatepicker.components.DatePicker dtpDesde;
    private com.github.lgooddatepicker.components.DatePicker dtpHasta;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JScrollPane pnlTablaOtrosMovimientos;
    private javax.swing.JScrollPane pnlTablaTransferencias;
    private javax.swing.JTable tblOtrosMovimientos;
    private javax.swing.JTable tblTransferencias;
    // End of variables declaration//GEN-END:variables
}
