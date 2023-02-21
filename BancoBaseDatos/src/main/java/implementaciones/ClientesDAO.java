
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

/**
 * Implementación de la IClientesDAO
 * @author esteb
 */
public class ClientesDAO implements IClientesDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES; // Conexion a la base de datos

    /**
     * Metodo constructor que inicializa la variable GENERADOR_CONEXIONES
     * @param generadorConexiones Conexion a la base de datos
     */
    public ClientesDAO(IConexionBD generadorConexiones) {
        this.GENERADOR_CONEXIONES = generadorConexiones;
    }

    /**
     * Metodo que recibe un objeto de tipo cliente, este lo agrega en la base de datos,
     * comprobando si este no existe, tomando en cuenta el correo, de igual forma
     * este metodo regresa un objeto de tipo cliente, el cliente regresado tiene 
     * todos los atributos de cliente, lanza una excepxion de tipo PersistenciaException,
     * si al agregar algo a la tabla cliente no se puede realizar
     * @param cliente cliente que se desea agregar a la tabla cliente
     * @return cliente registrado en la tabla clientes 
     * @throws PersistenciaException PersistenciaException si al agregar algo a 
     * la tabla cliente no se puede realizar
     */
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

    /**
    * Metodo que recibe el correo de un cliente, para luego consultar si existe un cliente 
    * con este correo registrado en la base de datos, regresando un cliente con el 
    * correo y la contraseña de la cuenta en caso de existir, en caso de no este lanza 
    * una excepcion de tipo PersistenciaException.
    * @param correoCliente correo del cliente que desea ser consultado 
    * @return Cliente con el correo y la contraseña del cliente consultado 
    * @throws PersistenciaException PersistenciaException si el cliente consultado
    * no existe
    */
    @Override
    public Cliente consultar(String correoCliente) throws PersistenciaException {
       String codigoSQL = "Select id,nombre,apellido_paterno,apellido_materno,"
               + "fecha_nacimiento,edad,correoElectronico,"
               + "aes_decrypt(contraseña,'hunter2'),codigo_direccion "
               + "from clientes where correoElectronico like ?";
        try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
                PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setString(1, correoCliente);
            ResultSet resultado = comando.executeQuery();
            Cliente cliente = null;
            if (resultado.next()) {
                Integer id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String apellidoPaterno = resultado.getString("apellido_paterno");
                String apellidoMaterno = resultado.getString("apellido_materno");
                Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
                Integer edad = resultado.getInt("edad");
                String correo = resultado.getString("correoElectronico");
                String contraseña = resultado.getString("aes_decrypt(contraseña,'hunter2')");
                Integer codigoDirección = resultado.getInt("codigo_direccion");
                cliente = new Cliente(id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, edad, correo, contraseña, codigoDirección);    
            }
            return cliente;
//            throw new PersistenciaException("No fue posible encontrar el cliente");
        }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible encontrar el cliente");
        }
    }

    /**
    * Metodo que actualiza el cliente de la tabla clientes, con la informacion 
    * del objeto de tipo cliente que recibe, actualizando el cliente del id 
    * que recibe en su parametro, regresando el cliente actualizado con toda su 
    * informacion, lanzando una excepcion de tipo PersistenciaException en caso, 
    * que el cliente que quiere actualizarse no existe
    * @param cliente Objjeto de tipo cliente con la nueva informacion del cliente 
    * @param id id del cliente que se desea actualizar 
    * @return Objeto de tipo cliente con toda la informacion del cliente actualizada
    * @throws PersistenciaException PersistenciaException si el cliente que se 
    * desea actualizar no existe
    */
    @Override
    public Cliente actualizar(Cliente cliente, Integer id) throws PersistenciaException {
        String codigoSQL = "update clientes set nombre = ?,apellido_paterno = ?,"
                + "apellido_materno = ?,fecha_nacimiento = ?,edad = ?,"
                + "correoElectronico = ?,contraseña = aes_encrypt(?,\"hunter2\"),"
                + "codigo_direccion = ? where id = ?";
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
            comando.setString(1, cliente.getNombre());
            comando.setString(2, cliente.getApellidoPaterno());
            comando.setString(3, cliente.getApellidoMaterno());
            comando.setDate(4, cliente.getFechaNacimiento());
            comando.setInt(5, cliente.getEdad());
            comando.setString(6, cliente.getCorreoElectronico());
            comando.setString(7, cliente.getContrasena());
            comando.setInt(8, cliente.getIdDireccion());
            comando.setInt(9, id);
            comando.executeUpdate();
            return consultar(cliente.getCorreoElectronico());
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            return null;
        }
    }
}
