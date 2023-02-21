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
 * Implementación de la IRetirosSinCuentaDAO
 * @author julio
 */
public class RetirosSinCuentaDAO implements IRetirosSinCuentaDAO{
    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES; // Conexion a la base de datos

    /**
     * Metodo constructor que inicializa la variable GENERADOR_CONEXIONES
     * @param GENERADOR_CONEXIONES Conexion a la base de datos
     */
    public RetirosSinCuentaDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }
    
    /**
     * Metodo que recibe la cuenta origen para el retiro, regreando un objeto de 
     * tipo RetiroSinCuenta con la contraseña y el folio para realizar 
     * el retiro. Lanzado un objeto de tipo PersistenciaException en caso 
     * de no poder generarse el retiro.
     * @param cuentaOrigen cuenta origen para el retiro
     * @return objeto de tipo RetiroSinCuenta con la contraseña y el folio para realizar
     * @throws PersistenciaException PersistenciaException en caso 
     * de no poder generarse el retiro.
     */
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

     /**
     * Metodo que recibe el folio del retiro regresando un objeto de 
     * tipo RetiroSinCuenta con la contraseña, el folio, estado y la cuenta retirada.
     * Lanzado un objeto de tipo PersistenciaException en caso 
     * de no poder consultar el retiro.
     * @param folio folio del retiro
     * @return objeto de 
     * tipo RetiroSinCuenta con la contraseña, el folio, estado y la cuenta retirada
     * @throws PersistenciaException PersistenciaException en caso 
     * de no poder consultar el retiro.
     */
    @Override
    public RetiroSinCuenta consultar(Integer folio) throws PersistenciaException {
       String codigoSQL = "Select folio, aes_decrypt(contraseña,'hunter2'),cuenta_retirada,estado from "
               + "retirosSinCuenta where folio = ?";
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
           comando.setInt(1, folio);
           ResultSet resultado = comando.executeQuery();
           RetiroSinCuenta retiroSinCuenta = null;
           if (resultado.next()) {
               Integer folioRetiro = resultado.getInt("folio");
               Integer contraseña = resultado.getInt("aes_decrypt(contraseña,'hunter2')");
               String estado = resultado.getString("estado");
               Integer cuentaRetirada  = resultado.getInt("cuenta_retirada");
               retiroSinCuenta = new RetiroSinCuenta(folio, contraseña, estado,cuentaRetirada);
               return retiroSinCuenta;
           }
           throw new PersistenciaException("La cuenta no existe");
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("La cuenta no existe");
        }

    }

    /**
     * Metodo que actualiza el saldo de la cuenta en la cual se realizo el retiro 
     * @param folio folio del retiro 
     * @param numCuenta numero de cuenta de la cual se hizo el retiro 
     * @param monto monto retirado
     * @throws PersistenciaException PersistenciaException en caso 
     * de no poder actualizar el saldo de la cuenta.
     */
    @Override
    public void actualizarRetiro(Integer folio,Integer numeCuenta,Float monto) throws PersistenciaException {
       String codigoSQL = "call retiroSinCuenta(?,?,?)";
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
           comando.setInt(1, folio);
           comando.setInt(2, numeCuenta);
           comando.setFloat(3, monto);
           comando.executeUpdate();
       } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible hacer el retiro");
        }     

    }

    /**
     * Metodo que comprueba el estado del retiro para ver si el retiro aun puede 
     * llevarse acabo, consultado el retiro por el folio que recibe en su parametro
     * @param folio folio del retiro 
     * @throws PersistenciaException PersistenciaException en caso que no se pudo 
     * realizar la comprobacion del estado
     */
    @Override
    public void comprobarEstado(Integer folio) throws PersistenciaException {
      String codigoSQL = "call  cambiar_estado_retiro_sin_cuenta(?)";
      try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
          comando.setInt(1, folio);
          comando.executeUpdate();
      }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue consultar el estado");
        }  

    }
    
    
    
}
