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
       String codigoSQL = "Select monto from cuentas where numero_cuenta = ? ";
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
           comando.setInt(1, numeroCuenta);
            ResultSet resultado = comando.executeQuery();
            Cuenta cuenta = new Cuenta ();
             if (resultado.next()) {
                float monto = resultado.getFloat("monto");
                cuenta.setMonto(monto);
                cuenta.setNumeroCuenta(numeroCuenta);
             }
             return cuenta;
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
       
    }

    @Override
    public List<Cuenta> consultarCuentasCliente(Integer codigoCliente) throws PersistenciaException {
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
    
    
}
