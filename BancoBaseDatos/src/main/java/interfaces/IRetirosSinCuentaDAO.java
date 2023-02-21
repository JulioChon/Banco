/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.RetiroSinCuenta;
import excepciones.PersistenciaException;

/**
 * Interfaz de retiros sin cuenta
 * @author esteb
 */
public interface IRetirosSinCuentaDAO {
    /**
     * Metodo que recibe la cuenta origen para el retiro, regreando un objeto de 
     * tipo RetiroSinCuenta con la contraseña y el folio para realizar 
     * el retiro. Lanzado un objeto de tipo PersistenciaException en caso 
     * de no poder generarse el retiro.
     * @param cuentaOrigen cuenta origen para el retiro
     * @return objeto de tipo RetiroSinCuenta con la contraseña y el folio para realizar
     * @throws PersistenciaException PersistenciaException en caso 
     * de no poder generarse el retiro.
     */
    RetiroSinCuenta crearRetiro(Integer cuentaOrigen) throws PersistenciaException;
    /**
     * Metodo que recibe el folio del retiro regresando un objeto de 
     * tipo RetiroSinCuenta con la contraseña, el folio, estado y la cuenta retirada.
     * Lanzado un objeto de tipo PersistenciaException en caso 
     * de no poder consultar el retiro.
     * @param folio folio del retiro
     * @return objeto de 
     * tipo RetiroSinCuenta con la contraseña, el folio, estado y la cuenta retirada
     * @throws PersistenciaException PersistenciaException en caso 
     * de no poder consultar el retiro.
     */
    RetiroSinCuenta consultar (Integer folio) throws PersistenciaException;
    /**
     * Metodo que actualiza el saldo de la cuenta en la cual se realizo el retiro 
     * @param folio folio del retiro 
     * @param numCuenta numero de cuenta de la cual se hizo el retiro 
     * @param monto monto retirado
     * @throws PersistenciaException PersistenciaException en caso 
     * de no poder actualizar el saldo de la cuenta.
     */
    void actualizarRetiro(Integer folio,Integer numCuenta,Float monto) throws PersistenciaException;
    /**
     * Metodo que comprueba el estado del retiro para ver si el retiro aun puede 
     * llevarse acabo, consultado el retiro por el folio que recibe en su parametro
     * @param folio folio del retiro 
     * @throws PersistenciaException PersistenciaException en caso que no se pudo 
     * realizar la comprobacion del estado
     */
    void comprobarEstado(Integer folio) throws PersistenciaException;
}
