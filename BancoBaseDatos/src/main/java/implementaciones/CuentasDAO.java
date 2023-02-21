/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cuenta;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de la ICuentasDAO
 * @author julio
 */
public class CuentasDAO implements ICuentasDAO {
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
   private final IConexionBD GENERADOR_CONEXIONES; // Conexion a la base de datos

    /**
     * Metodo constructor que inicializa la variable GENERADOR_CONEXIONES
     * @param GENERADOR_CONEXIONES Conexion a la base de datos
     */
    public CuentasDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    /**
     * Metodo que crea una cuenta, esta cuenta pertenece al cliente con el 
     * codigo de cliente que recibe en su parametro, regresa la cuenta creada 
     * y almacenada en la base de datos, la cuenta que regresa cuenta con 
     * el numero de la cuenta, este lanza una excepcion de tipo PersistenciaException
     * si la cuenta no puede ser creada. 
     * @param codigoCliente codigoCliente al cual pertenece la cuenta que acaba de ser creada 
     * @return cuenta que fue creada y almacenada en la base de datos, llevando solo 
     * el codigo del cliente y el numero de cuenta
     * @throws PersistenciaException PersistenciaException si no se puede crear la cuenta
     */
    @Override
    public Cuenta crearCuenta(Integer codigoCliente) throws PersistenciaException {
       String codigoSQL = "Insert into cuentas (codigo_cliente) values (?)";
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
                PreparedStatement comando = conexion.prepareStatement(
                        codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
           comando.setInt(1, codigoCliente);
           comando.executeUpdate();
           Cuenta cuenta = new Cuenta();
           ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                int posicionLlavePrimaria = 1;
                Integer llavePrimaria = llavesGeneradas.getInt(posicionLlavePrimaria);
                cuenta.setCodigoCliente(codigoCliente);
                cuenta.setNumeroCuenta(llavePrimaria);
                return cuenta;
            }    
            LOG.log(Level.WARNING, "Cuenta registrada, pero id no genereado");
            throw new PersistenciaException("Cuenta registrada, pero id no genereado");
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible registrar la cuenta");
        }
    }

    /**
     * Metodo que un numero de cuenta, consulta esta cuenta en la base de datos 
     * y regresa un objeto de tipo cuenta con los atributos codigo_cliente,
     * monto y estado de la cuenta 
     * @param numeroCuenta numero de cuenta la cual se quiere consultar
     * @return Objeto de tipo cuenta con los atributos codigo_cliente,
     * monto y estado de la cuenta
     * @throws PersistenciaException PersistenciaException si la consulta de la cuenta 
     * no puede ser realizada
     */
    @Override
    public Cuenta consultarCuenta(Integer numeroCuenta) throws PersistenciaException{
       String codigoSQL = "Select codigo_cliente,monto,estado from cuentas where numero_cuenta = ? ";
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
           comando.setInt(1, numeroCuenta);
            ResultSet resultado = comando.executeQuery();
            Cuenta cuenta = new Cuenta ();
             if (resultado.next()) {
                Integer cliente = resultado.getInt("codigo_cliente");
                float monto = resultado.getFloat("monto");
                String estado = resultado.getString("estado");
                cuenta.setCodigoCliente(cliente);
                cuenta.setNumeroCuenta(numeroCuenta);
                cuenta.setMonto(monto);
                cuenta.setEstado(estado);
             }
             return cuenta;
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
       
    }

    /**
     * Metodo que regresa una lista de cuentas con las cuentas que pertenece al cliente 
     * que recibe en su parametro
     * @param codigoCliente codigo del cliente el cual se desea consultar sus cuentas
     * @return lista de cuentas de cliente especificado 
     * @throws PersistenciaException PersistenciaException si al hacer la consulta en la 
     * base de datos no puede ser realizada
     */
    @Override
    public List<Cuenta> consultarCuentasCliente(Integer codigoCliente) throws PersistenciaException {
      String codigoSQL = "Select numero_cuenta from cuentas where codigo_cliente = ? and estado = ?";
       List<Cuenta> listaCuentas = new LinkedList<>();
        try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, codigoCliente);
            comando.setString(2,"Activa");
             ResultSet resultado = comando.executeQuery();
             Cuenta cuenta = null;
              while (resultado.next()) {
                  Integer numeroCuenta = resultado.getInt("numero_cuenta");
                  cuenta = new Cuenta (numeroCuenta);
                  listaCuentas.add(cuenta);
              }
              return listaCuentas;
        }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible consultar la lista de clientes");
        }

    }
    
    /**
     * Metodo que regresa una lista de cuentas con las cuentas que pertenece al cliente 
     * que recibe en su parametro
     * @param codigoCliente codigo del cliente el cual se desea consultar sus cuentas
     * @return lista de cuentas de cliente especificado 
     * @throws PersistenciaException PersistenciaException si al hacer la consulta en la 
     * base de datos no puede ser realizada
     */
    @Override
    public List<Cuenta> consultarCuentasClienteMovimientos(Integer codigoCliente) throws PersistenciaException {
      String codigoSQL = "Select numero_cuenta from cuentas where codigo_cliente = ?";
       List<Cuenta> listaCuentas = new LinkedList<>();
        try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, codigoCliente);
             ResultSet resultado = comando.executeQuery();
             Cuenta cuenta = null;
              while (resultado.next()) {
                  Integer numeroCuenta = resultado.getInt("numero_cuenta");
                  cuenta = new Cuenta (numeroCuenta);
                  listaCuentas.add(cuenta);
              }
              return listaCuentas;
        }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible consultar la lista de clientes");
        }

    }

    /**
     * Metodo que recibe el numero de cuenta y el monto, el monto se actualiza en el monto de 
     * la cuenta que recibe en su parametro, regresando un objeto de tipo cuenta con los atributos codigo_cliente,
     * monto y estado de la cuenta. Este se usa para los depositos
     * @param numeroCuenta numero de cuenta a la cual se le desea actulizar el saldo
     * @param monto monto el cual se vera reflejado en la actualizacion del saldo
     * @return Objeto de tipo cuenta con los atributos codigo_cliente,
     * monto y estado de la cuenta
     * @throws PersistenciaException PersistenciaException en caso que no se pueda 
     * realizar la actualizacion de saldo.
     */
    @Override
    public Cuenta actualizarSaldo(Integer numeroCuenta, float monto) throws PersistenciaException{
        String codigoSQL = "update cuentas set monto= monto + ? where numero_cuenta= ?";
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setFloat(1, monto);
            comando.setInt(2, numeroCuenta);
            comando.executeUpdate();
            return consultarCuenta(numeroCuenta);
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }
    
     /**
     * Metodo que recibe el numero de cuenta, para luego cambiar el estado de la 
     * cuenta a cancelado, regresando un objeto de tipo cuenta con los atributos codigo_cliente,
     * monto y estado de la cuenta
     * @param numeroCuenta numero de cuenta en la cual se desea el estado 
     * @return Objeto de tipo cuenta con los atributos codigo_cliente,
     * monto y estado de la cuenta
     * @throws PersistenciaException PersistenciaException en caso que no se pueda
     * actualizar el estado de la cuenta
     */
    @Override
    public Cuenta cancelarCuenta(Integer numeroCuenta) throws PersistenciaException {
        String codigoSQL = "update cuentas set estado = ? where numero_cuenta= ?";
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setString(1, "Cancelada");
            comando.setInt(2, numeroCuenta);
            comando.executeUpdate();
            return consultarCuenta(numeroCuenta);
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }

    /**
     * Metodo que realiza la transferencia entre dos cuentas, recibiendo primero la 
     * cuenta que envia el dinero, y despues la cuenta destino de la transferencia, 
     * ademas que recibe el monto de la transferencia. Lanzando una excepcion de 
     * tipo PersistenciaException en caso que la cuenta origen no tenga el saldo
     * suficiente para la transferencia 
     * @param cuentaEmisor cuenta emisor cuenta origen de la transferencia 
     * @param cuentaDestino cuenta origen de la transferencia
     * @param monto monto de la transferencia
     * @throws PersistenciaException PersistenciaException en caso que la cuenta origen no tenga el saldo
     * suficiente para la transferencia
     */
    @Override
    public void transferencia(Integer cuentaEmisor, Integer cuentaDestino, float monto) throws PersistenciaException {
       String codigoSQL = "call codigoTransferencia(?,?,?)";
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, cuentaEmisor);
            comando.setInt(2, cuentaDestino);
            comando.setFloat(3, monto);
            comando.executeUpdate();
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("La cuenta no tiene los fondos suficiente para realizar la transferencia ");
        }

    }
    
    
}
