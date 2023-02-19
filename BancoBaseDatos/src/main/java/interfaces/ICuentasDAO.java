/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cuenta;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author julio
 */
public interface ICuentasDAO {
    
    Cuenta crearCuenta(Integer codigoCliente) throws PersistenciaException;;
    Cuenta consultarCuenta(Integer numeroCuenta);
    List<Cuenta> consultarCuentasCliente(Integer codigoCliente) throws PersistenciaException;
    
}