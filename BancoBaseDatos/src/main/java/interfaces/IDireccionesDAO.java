/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Direccion;
import excepciones.PersistenciaException;

/**
 *
 * @author julio
 */
public interface IDireccionesDAO {
    Direccion consultar(Integer id) throws PersistenciaException;
    Direccion insertar(Direccion direccion) throws PersistenciaException;
}
