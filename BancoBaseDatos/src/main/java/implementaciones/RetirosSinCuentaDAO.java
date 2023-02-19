/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IRetirosSinCuentaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julio
 */
public class RetirosSinCuentaDAO implements IRetirosSinCuentaDAO{
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES;

    public RetirosSinCuentaDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }
    
    @Override
    public RetiroSinCuenta crearRetiro(Integer cuentaOrigen) throws PersistenciaException {
     String codigoSQL = "Insert into retirosSinCuenta (cuenta_retirada) values (?)";
     try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
                PreparedStatement comando = conexion.prepareStatement(
                        codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
         comando.setInt(1, cuentaOrigen);
         comando.executeUpdate();
         RetiroSinCuenta retiroSinCuenta = new RetiroSinCuenta();
         ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                int posicionLlavePrimaria = 1;
                Integer llavePrimaria = llavesGeneradas.getInt(posicionLlavePrimaria);
                retiroSinCuenta.setFolio(llavePrimaria);
                return retiroSinCuenta;
            }    
            LOG.log(Level.WARNING, "Retiro sin cuenta registrado, pero id no genereado");
            throw new PersistenciaException("Retiro sin cuenta registrado, pero id no genereado");
     }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible registrar el retiro sin cuenta");
        }

    }

    @Override
    public RetiroSinCuenta consultar(Integer folio) throws PersistenciaException {
       String codigoSQL = "Select folio, aes_decrypt(contraseña,'hunter2'),cuenta_retirada from "
               + "retirosSinCuenta where folio = ?";
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
           comando.setInt(1, folio);
           ResultSet resultado = comando.executeQuery();
           RetiroSinCuenta retiroSinCuenta = null;
           if (resultado.next()) {
               Integer folioRetiro = resultado.getInt("folio");
               Integer contraseña = resultado.getInt(" aes_decrypt(contraseña,'hunter2')");
               String estado = resultado.getString("estado");
               retiroSinCuenta = new RetiroSinCuenta(folio, contraseña, estado);
               return retiroSinCuenta;
           }
           throw new PersistenciaException("La cuenta no existe");
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("La cuenta no existe");
        }

    }

    @Override
    public void actualizarRetiro(Integer folio,Float monto, String estado) throws PersistenciaException {
       String codigoSQL = "call retiroSinCuenta(?,?,?)";
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
           comando.setInt(1, folio);
           comando.setFloat(2, monto);
           comando.setString(3, estado);
           comando.executeUpdate();
       } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible hacer el retiro");
        }     

    }
    
}
