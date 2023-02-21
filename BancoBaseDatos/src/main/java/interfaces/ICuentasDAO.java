/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Cuenta;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz de cuentas
 * @author esteb
 */
public interface ICuentasDAO {
    
    /**
     * Metodo que crea una cuenta, esta cuenta pertenece al cliente con el 
     * codigo de cliente que recibe en su parametro, regresa la cuenta creada 
     * y almacenada en la base de datos, la cuenta que regresa cuenta con 
     * el numero de la cuenta, este lanza una excepcion de tipo PersistenciaException
     * si la cuenta no puede ser creada. 
     * @param codigoCliente codigoCliente al cual pertenece la cuenta que acaba de ser creada 
     * @return cuenta que fue creada y almacenada en la base de datos, llevando solo 
     * el codigo del cliente y el numero de cuenta
     * @throws PersistenciaException PersistenciaException si no se puede crear la cuenta
     */
    Cuenta crearCuenta(Integer codigoCliente) throws PersistenciaException;;
    /**
     * Metodo que un numero de cuenta, consulta esta cuenta en la base de datos 
     * y regresa un objeto de tipo cuenta con los atributos codigo_cliente,
     * monto y estado de la cuenta 
     * @param numeroCuenta numero de cuenta la cual se quiere consultar
     * @return Objeto de tipo cuenta con los atributos codigo_cliente,
     * monto y estado de la cuenta
     * @throws PersistenciaException PersistenciaException si la consulta de la cuenta 
     * no puede ser realizada
     */
    Cuenta consultarCuenta(Integer numeroCuenta) throws PersistenciaException;
    /**
     * Metodo que regresa una lista de cuentas con las cuentas que pertenece al cliente 
     * que recibe en su parametro
     * @param codigoCliente codigo del cliente el cual se desea consultar sus cuentas
     * @return lista de cuentas de cliente especificado 
     * @throws PersistenciaException PersistenciaException si al hacer la consulta en la 
     * base de datos no puede ser realizada
     */
    List<Cuenta> consultarCuentasCliente(Integer codigoCliente) throws PersistenciaException;
     /**
     * Metodo que regresa una lista de cuentas con las cuentas que pertenece al cliente 
     * que recibe en su parametro
     * @param codigoCliente codigo del cliente el cual se desea consultar sus cuentas
     * @return lista de cuentas de cliente especificado 
     * @throws PersistenciaException PersistenciaException si al hacer la consulta en la 
     * base de datos no puede ser realizada
     */
    List<Cuenta> consultarCuentasClienteMovimientos(Integer codigoCliente) throws PersistenciaException;
    /**
     * Metodo que recibe el numero de cuenta y el monto, el monto se actualiza en el monto de 
     * la cuenta que recibe en su parametro, regresando un objeto de tipo cuenta con los atributos codigo_cliente,
     * monto y estado de la cuenta. Este se usa para los depositos
     * @param numeroCuenta numero de cuenta a la cual se le desea actulizar el saldo
     * @param monto monto el cual se vera reflejado en la actualizacion del saldo
     * @return Objeto de tipo cuenta con los atributos codigo_cliente,
     * monto y estado de la cuenta
     * @throws PersistenciaException PersistenciaException en caso que no se pueda 
     * realizar la actualizacion de saldo.
     */
    Cuenta actualizarSaldo(Integer numeroCuenta, float monto) throws PersistenciaException;
    /**
     * Metodo que recibe el numero de cuenta, para luego cambiar el estado de la 
     * cuenta a cancelado, regresando un objeto de tipo cuenta con los atributos codigo_cliente,
     * monto y estado de la cuenta
     * @param numeroCuenta numero de cuenta en la cual se desea el estado 
     * @return Objeto de tipo cuenta con los atributos codigo_cliente,
     * monto y estado de la cuenta
     * @throws PersistenciaException PersistenciaException en caso que no se pueda
     * actualizar el estado de la cuenta
     */
    Cuenta cancelarCuenta(Integer numeroCuenta) throws PersistenciaException;
    /**
     * Metodo que realiza la transferencia entre dos cuentas, recibiendo primero la 
     * cuenta que envia el dinero, y despues la cuenta destino de la transferencia, 
     * ademas que recibe el monto de la transferencia. Lanzando una excepcion de 
     * tipo PersistenciaException en caso que la cuenta origen no tenga el saldo
     * suficiente para la transferencia 
     * @param cuentaEmisor cuenta emisor cuenta origen de la transferencia 
     * @param cuentaDestino cuenta origen de la transferencia
     * @param monto monto de la transferencia
     * @throws PersistenciaException PersistenciaException en caso que la cuenta origen no tenga el saldo
     * suficiente para la transferencia
     */
    void transferencia(Integer cuentaEmisor,Integer cuentaDestino,float monto)throws PersistenciaException;
}
