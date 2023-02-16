
package interfaces;

import dominio.Cliente;
import excepciones.PersistenciaException;



public interface IClientesDAO {
   Cliente insertar(Cliente cliente) throws PersistenciaException;
}

