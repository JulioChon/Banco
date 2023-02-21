
package implementaciones;

import interfaces.IConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase conexión con la base de datos
 * @author esteb
 */
public class ConexionBD implements IConexionBD{
    private final String CADENA_CONEXION; // cadena para realizar la conexio
    private final String USUARIO; // usuario de la base de datos
    private final String PASSWORD; // contraeña de la base de datos

    /**
     * Metodo constructor que inicializa todos los atributo
     * @param cadenaConexion cadena para realizar la conexio
     * @param usuario usuario de la base de datos
     * @param password contraeña de la base de datos
     */
    public ConexionBD(String cadenaConexion, String usuario, String password) {
        this.CADENA_CONEXION = cadenaConexion;
        this.USUARIO = usuario;
        this.PASSWORD = password;
    }
     /**
     * Metodo que realiza la conexion con la base de datos, regreando un objeto 
     * de tipo connection con la conexion a la base de datos
     * @return connection con la conexion a la base de datos
     * @throws SQLException SQLException en caso que la conexion a la base de datos 
     * no se pueda realizar
     */
    @Override
    public Connection crearConexiones() throws SQLException {
          Connection conexion=DriverManager.getConnection(CADENA_CONEXION,USUARIO,PASSWORD);
          return conexion;
    }
    
}
