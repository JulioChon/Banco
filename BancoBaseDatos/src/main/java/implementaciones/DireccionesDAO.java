/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Direccion;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IDireccionesDAO;
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
public class DireccionesDAO implements IDireccionesDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES;

    public DireccionesDAO(IConexionBD generadorConexiones) {
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }

    @Override
    public Direccion consultar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Direccion insertar(Direccion direccion) throws PersistenciaException {
        String codigoSQL = "Insert into direcciones"
                + "(calle,colonia,numeroCasa) values"
                + "(?,?,?)";
        try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones(); PreparedStatement comando = conexion.prepareStatement(
                codigoSQL, Statement.RETURN_GENERATED_KEYS);) {
            comando.setString(1, direccion.getCalle());
            comando.setString(2, direccion.getColonia());
            comando.setString(3, direccion.getNumeroCasa());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                int posicionLlavePrimaria = 1;
                Integer llavePrimaria = llavesGeneradas.getInt(posicionLlavePrimaria);
                direccion.setId(llavePrimaria);
                return direccion;
            }
            LOG.log(Level.WARNING, "Direccion registrada, pero id no genereado");
            throw new PersistenciaException("Direccion registrada, pero id no genereado");
        } catch (SQLException ex) {
           LOG.log(Level.SEVERE, ex.getMessage());
           throw new PersistenciaException("No fue posible registrar la direccion");
        }

    }

}
