
package interfaces;

import dominio.Cliente;
import excepciones.PersistenciaException;



public interface IClientesDAO {
   Cliente insertar(Cliente cliente) throws PersistenciaException;
   Cliente consultar(String correoCliente) throws PersistenciaException;
}

