/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.PersistenciaException;

/**
 *
 * @author julio
 */
public interface IDepositosDAO {
    void insertarDeposito(Integer numeroCuenta,float monto)throws PersistenciaException;
}
