package implementaciones;

import dominio.Cliente;
import excepciones.PersistenciaException;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientesDAO implements IClientesDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES;

    public ClientesDAO(IConexionBD generadorConexiones) {
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }

    @Override
    public Cliente insertar(Cliente cliente) throws PersistenciaException {
        String codigoSQL = "Insert into clientes"
                + "(nombre,apellido_paterno,apellido_materno,fecha_nacimiento,"
                + "edad,correoElectronico,contraseña,codigo_direccion) values"
                + " (?,?,?,?,?,?,aes_encrypt(?,\"hunter2\"),?)";

        try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
                PreparedStatement comando = conexion.prepareStatement(
                        codigoSQL, Statement.RETURN_GENERATED_KEYS);) {

            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellidoPaterno());
            comando.setString(3, cliente.getApellidoMaterno());
            comando.setDate(4, cliente.getFechaNacimiento());
            comando.setInt(5, cliente.getEdad());
            comando.setString(6, cliente.getCorreoElectronico());
            comando.setString(7, cliente.getContrasena());
            comando.setInt(8, cliente.getIdDireccion());
            comando.executeUpdate();
            ResultSet llavesGeneradas = comando.getGeneratedKeys();
            if (llavesGeneradas.next()) {
                int posicionLlavePrimaria = 1;
                Integer llavePrimaria = llavesGeneradas.getInt(posicionLlavePrimaria);
                cliente.setId(llavePrimaria);
                return cliente;
            }
            LOG.log(Level.WARNING, "Cliente registrado, pero id no genereado");
            throw new PersistenciaException("Cliente registrado, pero id no genereado");
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible registrar cliente");
        }
    }

 

    

}
