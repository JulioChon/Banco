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
 * Implementación de la IDireccionesDAO
 * @author julio
 */
public class DireccionesDAO implements IDireccionesDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES; // Conexion a la base de datos

    /**
     * Metodo constructor que inicializa la variable GENERADOR_CONEXIONES
     * @param generadorConexiones Conexion a la base de datos
     */
    public DireccionesDAO(IConexionBD generadorConexiones) {
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }

    /**
     * Metodo que consulta en la tabla direcciones la direccion, esta consulta
     * se hace mediante el id de la direccion que recibe en su parametro, regresando 
     * un objeto de tipo direccion con todos sus parametros. Lanzando
     * una excepcion de tipo PersistenciaException en caso que no se pueda realizar 
     * la consulta
     * @param id id de la direccion que se desea consultar
     * @return  objeto de tipo direccion con todos sus parametros
     * @throws PersistenciaException PersistenciaException en caso que no se pueda realizar 
     * la consulta
     */
    @Override
    public Direccion consultar(Integer id)  throws PersistenciaException{
        String codigoSQL = "Select id,calle,colonia,numeroCasa "
                + "from direcciones where id like ?";
        try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();
            Direccion direccion = null;
            if (resultado.next()) {
                String calle = resultado.getString("calle");
                String colonia = resultado.getString("colonia");
                String numeroCasa = resultado.getString("numeroCasa");
                direccion = new Direccion(id, calle, colonia, numeroCasa);
                return direccion;
            }
            throw new PersistenciaException("No fue posible encontrar la dirección");
        }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible encontrar la dirección");
        }
    }

    /**
     * Metodo que inserta en la tabla de cliente la direccion que recibe en su parametro,
     * regresando un objeto de tipo direccion con todos sus parametros. Lanzando
     * una excepcion de tipo PersistenciaException en caso que no se pueda insertar la 
     * dirección
     * @param direccion objeto de tipo direccion, la informacion de la direccion 
     * que sea insertar
     * @return objeto de tipo direccion con todos sus parametros
     * @throws PersistenciaException ersistenciaException en caso que no se pueda insertar la 
     * dirección
     */
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
