/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.PersistenciaException;

/**
 * Interfaz de depósitos
 * @author esteb
 */
public interface IDepositosDAO {
    /**
     * Metodo que inserta en la tabla depositosACuenta los depositos que se 
     * especifican en la cuenta que recibe como parametro y el monto que recibe 
     * en el mismo. PersistenciaException en caso que no se 
     * pueda realizar el deposito 
     * @param numeroCuenta numeroCuenta a la cual se realiza el deposito
     * @param monto monto del deposito
     * @throws PersistenciaException PersistenciaException en caso que no se 
     * pueda realizar el deposito
     */
    void insertarDeposito(Integer numeroCuenta,float monto)throws PersistenciaException;
}
