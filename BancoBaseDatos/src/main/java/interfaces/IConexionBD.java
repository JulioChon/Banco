
package interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interfaz de la conexión
 * @author esteb
 */
public interface IConexionBD {
    /**
     * Metodo que realiza la conexion con la base de datos, regreando un objeto 
     * de tipo connection con la conexion a la base de datos
     * @return connection con la conexion a la base de datos
     * @throws SQLException SQLException en caso que la conexion a la base de datos 
     * no se pueda realizar
     */
  Connection crearConexiones() throws SQLException;  
}
