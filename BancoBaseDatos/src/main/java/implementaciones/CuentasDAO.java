/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Cliente;
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
 *
 * @author julio
 */
public class CuentasDAO implements ICuentasDAO {
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES;

    public CuentasDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

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

    @Override
    public Cuenta consultarCuenta(Integer numeroCuenta){
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

    @Override
    public Cuenta actualizarSaldo(Integer numeroCuenta, float monto) {
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
    
    @Override
    public Cuenta cancelarCuenta(Integer numeroCuenta) {
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
