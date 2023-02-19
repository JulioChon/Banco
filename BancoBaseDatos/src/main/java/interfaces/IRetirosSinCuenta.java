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
public interface IRetirosSinCuenta {
    RetiroSinCuenta crearRetiro(Integer cuentaOrigen) throws PersistenciaException;
    RetiroSinCuenta consultar (Integer folio) throws PersistenciaException;
    void actualizarRetiro(Integer folio,Float monto,String estado) throws PersistenciaException;
}
