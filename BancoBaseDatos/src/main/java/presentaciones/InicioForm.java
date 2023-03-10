/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentaciones;

import dominio.Cliente;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import interfaces.IDepositosDAO;
import interfaces.IDireccionesDAO;
import interfaces.IMoviminetosDAO;
import interfaces.IRetirosSinCuentaDAO;
import java.awt.Color;

/**
 * Frame inicial
 * @author julio
 */
public class InicioForm extends javax.swing.JFrame {

    private final IClientesDAO clientesDAO;//Interfaz de clientes
    private final IDireccionesDAO direccionesDAO;//Interfaz de direcciones
    private final ICuentasDAO cuentasDAO;//Interfaz de cuentas
    private final IRetirosSinCuentaDAO retirosDAO;//Interfaz de retiros
    private final IDepositosDAO depositosDAO;//Interfaz de depósitos
    private final IMoviminetosDAO movimientosDAO;//Interfaz de movimientos

    /**
     * Constructor del frame de inicio, incializa las interfaces.
     *
     * @param clientesDAO Interfaz de clientes
     * @param direccionesDAO Interfaz de direcciones
     * @param cuentasDAO Interfaz de cuentas
     * @param retirosDAO Interfaz de retiros
     * @param depositosDAO Interfaz de depósitos
     * @param movimientosDAO Interfaz de movimientos
     */
    public InicioForm(IClientesDAO clientesDAO, IDireccionesDAO direccionesDAO, ICuentasDAO cuentasDAO, IRetirosSinCuentaDAO retirosDAO, IDepositosDAO depositosDAO, IMoviminetosDAO movimientosDAO) {
        this.clientesDAO = clientesDAO;
        this.direccionesDAO = direccionesDAO;
        this.cuentasDAO = cuentasDAO;
        this.retirosDAO = retirosDAO;
        this.depositosDAO = depositosDAO;
        this.movimientosDAO = movimientosDAO;
        initComponents();
        this.setTitle("Bienvenido a BANUEVO");
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
        jLabel1 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnRetiro = new javax.swing.JButton();
        btnCrearUsuario = new javax.swing.JButton();
        btnDeposito = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(192, 212, 193));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(192, 212, 193));

        jLabel1.setBackground(new java.awt.Color(236, 196, 100));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BANUEVO");
        jLabel1.setOpaque(true);

        btnLogin.setBackground(new java.awt.Color(148, 116, 69));
        btnLogin.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Iniciar Sesión");
        btnLogin.setBorder(null);
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLoginMousePressed(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnRetiro.setBackground(new java.awt.Color(148, 116, 69));
        btnRetiro.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnRetiro.setForeground(new java.awt.Color(255, 255, 255));
        btnRetiro.setText("Retiro Sin Tarjeta");
        btnRetiro.setBorder(null);
        btnRetiro.setBorderPainted(false);
        btnRetiro.setFocusPainted(false);
        btnRetiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRetiroMousePressed(evt);
            }
        });
        btnRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetiroActionPerformed(evt);
            }
        });

        btnCrearUsuario.setBackground(new java.awt.Color(148, 116, 69));
        btnCrearUsuario.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnCrearUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearUsuario.setText("Crear Usuario");
        btnCrearUsuario.setBorder(null);
        btnCrearUsuario.setBorderPainted(false);
        btnCrearUsuario.setFocusPainted(false);
        btnCrearUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCrearUsuarioMousePressed(evt);
            }
        });
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        btnDeposito.setBackground(new java.awt.Color(148, 116, 69));
        btnDeposito.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnDeposito.setForeground(new java.awt.Color(255, 255, 255));
        btnDeposito.setText("Depositar a Cuenta");
        btnDeposito.setBorder(null);
        btnDeposito.setBorderPainted(false);
        btnDeposito.setFocusPainted(false);
        btnDeposito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDepositoMousePressed(evt);
            }
        });
        btnDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositoActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(55, 81, 55));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/telefono.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCrearUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                            .addComponent(btnRetiro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeposito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addContainerGap(51, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
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

    /**
     * Método que se acciona al dar click al botón para llevarnos a la ventana
     * de Login.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        new LoginForm(clientesDAO, direccionesDAO, cuentasDAO, retirosDAO, depositosDAO, movimientosDAO).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * Método que se acciona al dar click al botón para llevarnos a la ventana
     * de crear usuario.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        Cliente cliente = null;
        new ClientesForm(clientesDAO, direccionesDAO, cuentasDAO, retirosDAO, depositosDAO, movimientosDAO, null).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    /**
     * Método que se acciona al dar click al botón para llevarnos a la ventana
     * de Retiro sin tarjeta.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroActionPerformed
        new RetiroForm(clientesDAO, direccionesDAO, cuentasDAO, retirosDAO, depositosDAO, movimientosDAO).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRetiroActionPerformed

    /**
     * Método que se acciona al dar click al botón para llevarnos a la ventana
     * de depósitos.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositoActionPerformed
        new DepositosForm(clientesDAO, direccionesDAO, cuentasDAO, retirosDAO, depositosDAO, movimientosDAO).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDepositoActionPerformed

    /**
     * Evento que se acciona cuando se presiona el botón de crear usuario para
     * cambiar de color.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnCrearUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearUsuarioMousePressed
        this.btnCrearUsuario.setContentAreaFilled(false);
        this.btnCrearUsuario.setOpaque(true);
        this.btnCrearUsuario.setBackground(new Color(55, 81, 55));
    }//GEN-LAST:event_btnCrearUsuarioMousePressed

    /**
     * Evento que se acciona cuando se presiona el botón de login para
     * cambiar de color.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnLoginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMousePressed
        this.btnLogin.setContentAreaFilled(false);
        this.btnLogin.setOpaque(true);
        this.btnLogin.setBackground(new Color(55, 81, 55));
    }//GEN-LAST:event_btnLoginMousePressed

    /**
     * Evento que se acciona cuando se presiona el botón de depósitos para
     * cambiar de color.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnDepositoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDepositoMousePressed
        this.btnDeposito.setContentAreaFilled(false);
        this.btnDeposito.setOpaque(true);
        this.btnDeposito.setBackground(new Color(55, 81, 55));
    }//GEN-LAST:event_btnDepositoMousePressed

    /**
     * Evento que se acciona cuando se presiona el botón de retiros para
     * cambiar de color.
     *
     * @param evt Evento que se crea al dar click al botón
     */
    private void btnRetiroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiroMousePressed
        this.btnRetiro.setContentAreaFilled(false);
        this.btnRetiro.setOpaque(true);
        this.btnRetiro.setBackground(new Color(55, 81, 55));
    }//GEN-LAST:event_btnRetiroMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnDeposito;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRetiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
