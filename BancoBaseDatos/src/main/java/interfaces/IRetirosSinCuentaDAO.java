/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;

/**
 *
 * @author julio
 */
public interface IRetirosSinCuentaDAO {
    RetiroSinCuenta crearRetiro(Integer cuentaOrigen) throws PersistenciaException;
    RetiroSinCuenta consultar (Integer folio) throws PersistenciaException;
    void actualizarRetiro(Integer folio,Integer numCuenta,Float monto) throws PersistenciaException;
    void comprobarEstao(Integer folio) throws PersistenciaException;
}
