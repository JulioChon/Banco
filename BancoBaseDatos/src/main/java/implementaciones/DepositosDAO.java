/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IDepositosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementación de la IDepositosDAO
 * @author julio
 */
public class DepositosDAO implements IDepositosDAO {

     private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES; // Conexion a la base de datos

    /**
     * Metodo constructor que inicializa la variable GENERADOR_CONEXIONES
     * @param GENERADOR_CONEXIONES Conexion a la base de datos
     */public DepositosDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }
    
     /**
     * Metodo que inserta en la tabla depositosACuenta los depositos que se 
     * especifican en la cuenta que recibe como parametro y el monto que recibe 
     * en el mismo. PersistenciaException en caso que no se 
     * pueda realizar el deposito 
     * @param numeroCuenta numeroCuenta a la cual se realiza el deposito
     * @param monto monto del deposito
     * @throws PersistenciaException PersistenciaException en caso que no se 
     * pueda realizar el deposito
     */
    @Override
    public void insertarDeposito(Integer numeroCuenta, float monto) throws PersistenciaException {
       String codigoSQL = "Insert into depositosACuenta(monto,cuenta_depositada) "
               + "values (?,?)";

       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
           comando.setFloat(1, monto);
           comando.setInt(2, numeroCuenta);
           comando.executeUpdate();
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible registrar el deposito");
        }
    }
    
}
