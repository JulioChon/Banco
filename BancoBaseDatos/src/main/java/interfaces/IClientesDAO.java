
package interfaces;

import dominio.Cliente;
import excepciones.PersistenciaException;


/**
 * Interfaz de clientes
 * @author esteb
 */
public interface IClientesDAO {
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
   Cliente insertar(Cliente cliente) throws PersistenciaException;
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
   Cliente consultar(String correoCliente) throws PersistenciaException;
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
   Cliente actualizar(Cliente cliente, Integer id) throws PersistenciaException;
}

