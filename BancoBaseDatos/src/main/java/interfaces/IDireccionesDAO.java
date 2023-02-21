/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Direccion;
import excepciones.PersistenciaException;

/**
 * Interfaz de direcciones
 * @author esteb
 */
public interface IDireccionesDAO {
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
    Direccion consultar(Integer id) throws PersistenciaException;
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
    Direccion insertar(Direccion direccion) throws PersistenciaException;
}
