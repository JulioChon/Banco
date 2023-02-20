/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentaciones;

import dominio.Cliente;
import dominio.Direccion;
import excepciones.PersistenciaException;
import implementaciones.ClientesDAO;
import interfaces.IClientesDAO;
import interfaces.ICuentasDAO;
import interfaces.IDepositosDAO;
import interfaces.IDireccionesDAO;
import interfaces.IMoviminetosDAO;
import interfaces.IRetirosSinCuentaDAO;
import java.sql.Date;
import java.time.LocalDate;
import validaciones.Validadores;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author julio
 */
public class ClientesForm extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IClientesDAO clientesDAO;
    private final IDireccionesDAO direccionesDAO;
    private final ICuentasDAO cuentasDAO;
    private final IRetirosSinCuentaDAO retirosDAO;
    private final Validadores validadores = new Validadores();
    private final IDepositosDAO depositosDAO;
    private final IMoviminetosDAO movimientosDAO;
    private final String correoCliente;
    private Cliente cliente;
    private Integer id;

    /**
     * Creates new form ClientesForm
     */
    public ClientesForm(IClientesDAO clientesDAO, IDireccionesDAO direccionesDAO, ICuentasDAO cuentasDAO, IRetirosSinCuentaDAO retirosDAO, IDepositosDAO depositosDAO, IMoviminetosDAO movimientosDAO, String correoCliente) {
        this.clientesDAO = clientesDAO;
        this.direccionesDAO = direccionesDAO;
        this.cuentasDAO = cuentasDAO;
        this.retirosDAO = retirosDAO;
        this.depositosDAO = depositosDAO;
        this.movimientosDAO = movimientosDAO;
        this.correoCliente = correoCliente;
        initComponents();
        this.cargar();
        LocalDate fechaActual = LocalDate.now();
        LocalDate minFecha = LocalDate.of(1920, 01, 01);
        clpFechaNacimiento.getSettings().setDateRangeLimits(minFecha, fechaActual);
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        txtCalle = new javax.swing.JTextField();
        txtColonia = new javax.swing.JTextField();
        txtNumeroCasa = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCorreoElectonico = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        clpFechaNacimiento = new com.github.lgooddatepicker.components.CalendarPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido Paterno");

        jLabel3.setText("Apellido Materno");

        jLabel5.setText("Calle");

        jLabel6.setText("Colonia");

        jLabel7.setText("Numero de Casa");

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

        jLabel8.setText("Información Personal");
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        jLabel9.setText("Correo Electronico");

        jLabel10.setText("Contraseña");

        jLabel11.setText("Fecha de Nacimiento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(338, 338, 338))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtApellidoPaterno)
                            .addComponent(txtApellidoMaterno)
                            .addComponent(txtCalle)
                            .addComponent(txtColonia)
                            .addComponent(txtNumeroCasa)
                            .addComponent(txtCorreoElectonico)
                            .addComponent(txtContraseña))
                        .addGap(69, 69, 69)
                        .addComponent(clpFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel8)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumeroCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreoElectonico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(clpFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cargar() {
        if (this.validar()) {
            id = cliente.getId();
            btnAceptar.setText("Actualizar");
            this.txtNombre.setText(cliente.getNombre());
            this.txtApellidoPaterno.setText(cliente.getApellidoPaterno());
            this.txtApellidoMaterno.setText(cliente.getApellidoMaterno());
            this.txtCorreoElectonico.setText(cliente.getCorreoElectronico());
            this.txtContraseña.setText(cliente.getContrasena());
            this.cargarDireccion();
            this.clpFechaNacimiento.setSelectedDate(cliente.getFechaNacimiento().toLocalDate());
        }
    }

    private void cargarDireccion() {
        try {
            Direccion direccion = this.direccionesDAO.consultar(cliente.getIdDireccion());
            this.txtCalle.setText(direccion.getCalle());
            this.txtColonia.setText(direccion.getColonia());
            this.txtNumeroCasa.setText(direccion.getNumeroCasa());
        } catch (PersistenciaException e) {
            this.mensajeErrorDireccion();
        }
    }

    private boolean validar() {
        try {
            cliente = this.clientesDAO.consultar(correoCliente);
            return cliente != null;
        } catch (PersistenciaException e) {
            return false;
        }
    }

    private void mensajeErrorDireccion() {
        JOptionPane.showMessageDialog(this, "No se encontro la dirección");
    }

    private Direccion extraerDatosFormDireccion() {
        String calle = this.txtCalle.getText();
        String colonia = this.txtColonia.getText();
        String numeroCasa = this.txtNumeroCasa.getText();
        if (validarCalle(calle) && validarColonia(colonia) && validarNumCasa(numeroCasa)) {
            Direccion direccion = new Direccion(calle, colonia, numeroCasa);
            return direccion;
        }
        return null;
    }

    private boolean validarNombre(String nombre) {
        if (!validadores.validaNombre(nombre)) {
            JOptionPane.showMessageDialog(this, "El nombre no es válido\nSin acentos.");
        }
        return validadores.validaNombre(nombre);
    }

    private boolean validarApellidoP(String apellidoP) {
        if (!validadores.validaApellido(apellidoP)) {
            JOptionPane.showMessageDialog(this, "El apellido paterno no es válido\nSin acentos.");
        }
        return validadores.validaApellido(apellidoP);
    }

    private boolean validarApellidoM(String apellidoM) {
        if (!validadores.validaApellido(apellidoM)) {
            JOptionPane.showMessageDialog(this, "El apellido materno no es válido\nSin acentos.");
        }
        return validadores.validaApellido(apellidoM);
    }

    private boolean validarCorreo(String correo) {
        if (!validadores.validaCorreo(correo)) {
            JOptionPane.showMessageDialog(this, "El correo no es válido\nPuede usar (.'-_), use el formato Este@ejemplo");
        }
        return validadores.validaCorreo(correo);
    }

    private boolean validarContrasena(String contrasena) {
        if (!validadores.validaContrasena(contrasena)) {
            JOptionPane.showMessageDialog(this, "La contraseña no es válida\nUse una minúscula, una mayúscula, un número y un cáracter especial (8-16)");
        }
        return validadores.validaContrasena(contrasena);
    }

    private int validarEdad(Date fechaNacimiento) {
        if (validadores.validaEdad(fechaNacimiento) < 15) {
            JOptionPane.showMessageDialog(this, "La edad no es válida\nLa edad para crear una cuenta son 15 años en adelante");
        }
        return validadores.validaEdad(fechaNacimiento);
    }

    private boolean validarCalle(String calle) {
        if (!validadores.validaCalle(calle)) {
            JOptionPane.showMessageDialog(this, "La calle no es válida\nSin acentos");
        }
        return validadores.validaCalle(calle);
    }

    private boolean validarColonia(String colonia) {
        if (!validadores.validaColonia(colonia)) {
            JOptionPane.showMessageDialog(this, "La colonia no es válida\nSin acentos");
        }
        return validadores.validaColonia(colonia);
    }

    private boolean validarNumCasa(String numCasa) {
        if (!validadores.validaNumCasa(numCasa)) {
            JOptionPane.showMessageDialog(this, "El número de casa no es válido\n1-5 cáracteres");
        }
        return validadores.validaNumCasa(numCasa);
    }

    private void mensajeErrorFecha() {
        JOptionPane.showMessageDialog(this, "No seleccionaste ninguna fecha");

    }

    private Cliente extraerDatosFormCliente() {
        String nombre = this.txtNombre.getText();
        String apellidoPaterno = this.txtApellidoPaterno.getText();
        String apellidoMaterno = this.txtApellidoMaterno.getText();
        LocalDate seleccion = clpFechaNacimiento.getSelectedDate();
        Date fechaNacimiento;
        if (seleccion != null) {
            fechaNacimiento = new Date(seleccion.getYear() - 1900, seleccion.getMonthValue() - 1, seleccion.getDayOfMonth());
            Integer edad = validarEdad(fechaNacimiento);
            String correoElectronico = this.txtCorreoElectonico.getText();
            String contrasena = this.txtContraseña.getText();
            if (validarNombre(nombre) && edad >= 15 && validarApellidoP(apellidoPaterno) && validarApellidoM(apellidoMaterno) && validarCorreo(correoElectronico) && validarContrasena(contrasena)) {
                Integer idDireccion = this.guardarDireccion().getId();
                Cliente cliente = new Cliente(nombre, apellidoPaterno, apellidoMaterno,
                        fechaNacimiento, edad, correoElectronico, contrasena, idDireccion);
                return cliente;
            }
        } else {
            this.mensajeErrorFecha();
        }

        return null;
    }

    public void mostrarMensajeErrorAlGuardarDireccion() {
        JOptionPane.showMessageDialog(this, "NO fue posible agregar la dirrecion",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeErrorAlGuardarCliente() {
        JOptionPane.showMessageDialog(this, "NO fue posible agregar el cliente, ya que este ya existe",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeErrorAlActualizarCliente() {
        JOptionPane.showMessageDialog(this, "NO fue posible actualizar el cliente",
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeClienteGuardado() {
        JOptionPane.showMessageDialog(this, "Se agrego el cliente: ",
                "Informacion",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarMensajeClienteActualizado() {
        JOptionPane.showMessageDialog(this, "Se actualizo el cliente: ",
                "Informacion",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private Direccion guardarDireccion() {
        try {
            Direccion direccion = this.extraerDatosFormDireccion();
            Direccion direccionGuardada = this.direccionesDAO.insertar(direccion);
            return direccionGuardada;
        } catch (PersistenciaException ex) {
            this.mostrarMensajeErrorAlGuardarDireccion();
            return null;
        }
    }

    private void actualizarCliente() {
        try {
            Cliente cliente = this.extraerDatosFormCliente();
            if (cliente != null) {
                Cliente clienteGuardado = this.clientesDAO.actualizar(cliente,id);
                mostrarMensajeClienteActualizado();
                dispose();
            }

        } catch (PersistenciaException ex) {
            this.mostrarMensajeErrorAlActualizarCliente();
        }
    }

    private void guardarCliente() {
        try {
            Cliente cliente = this.extraerDatosFormCliente();
            if (cliente != null) {
                Cliente clienteGuardado = this.clientesDAO.insertar(cliente);
                mostrarMensajeClienteGuardado();
                new InicioForm(clientesDAO, direccionesDAO, cuentasDAO, retirosDAO, depositosDAO, movimientosDAO).setVisible(true);
                this.dispose();
            }

        } catch (PersistenciaException ex) {
            this.mostrarMensajeErrorAlGuardarCliente();
        }
    }

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (!this.validar()) {
            this.guardarCliente();
        } else {
            this.actualizarCliente();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (!this.validar()) {
            new InicioForm(clientesDAO, direccionesDAO, cuentasDAO, retirosDAO, depositosDAO, movimientosDAO).setVisible(true);
        }
        dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private com.github.lgooddatepicker.components.CalendarPanel clpFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreoElectonico;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumeroCasa;
    // End of variables declaration//GEN-END:variables
}
