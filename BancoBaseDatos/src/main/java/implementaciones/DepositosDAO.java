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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julio
 */
public class DepositosDAO implements IDepositosDAO {

     private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES;

    public DepositosDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }
    
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
