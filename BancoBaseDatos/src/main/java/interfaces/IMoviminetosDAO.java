/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Deposito;
import dominio.RetiroSinCuenta;
import dominio.Transferencia;
import excepciones.PersistenciaException;
import java.sql.Date;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 * Interfaz de movimientos
 * @author esteb
 */
public interface IMoviminetosDAO {
    /**
     * Metodo que recibe el numero de cuenta, el periodo de fechas de la cual 
     * se desean saber las transferencias realizadas. Lanzando una excepcion de tipo
     * PersistenciaException en caso que ocurra un error en la consulta. 
     * @param cuentaOrigen cuenta de la cual se realizaron las transferencias
     * @param paginado Objeto de tipo paginado para saber como se presentaran los datos
     * @param fechaDesde fecha desde donde comienza la consulta
     * @param fechaHasta fecha hasta la cual llega la consulta
     * @return lista con las transferncias realizadas
     * @throws PersistenciaException PersistenciaException en caso que ocurra un error en la consulta
     */
    List<Transferencia> realizadas(Integer cuentaOrigen,ConfiguracionPaginado paginado,Date fechaDesde,Date fechaHasta) throws PersistenciaException;
    /**
     * Metodo que recibe el numero de cuenta, el periodo de fechas de la cual 
     * se desean saber las transferencias recibidas. Lanzando una excepcion de tipo
     * PersistenciaException en caso que ocurra un error en la consulta.
     * @param cuentaDestino cuenta la cual recibio las transferencias
     * @param paginado Objeto de tipo paginado para saber como se presentaran los datos
     * @param fechaDesde fecha desde donde comienza la consulta
     * @param fechaHasta fecha hasta la cual llega la consulta
     * @return lista con las transferncias recibidas
     * @throws PersistenciaException PersistenciaException PersistenciaException en caso que ocurra un error en la consulta
     */
    List<Transferencia> recibidas (Integer cuentaDestino,ConfiguracionPaginado paginado,Date fechaDesde,Date fechaHasta) throws PersistenciaException;
    /**
     * Metodo que recibe el numero de cuenta, el periodo de fechas de la cual 
     * se desean saber los retiros realizadas. Lanzando una excepcion de tipo
     * PersistenciaException en caso que ocurra un error en la consulta. 
     * @param cuentaOrigen cuenta de la cual se realizaron los retiros
     * @param paginado Objeto de tipo paginado para saber como se presentaran los datos
     * @param fechaDesde fecha desde donde comienza la consulta
     * @param fechaHasta fecha hasta la cual llega la consulta
     * @return lista con los retiros realizados
     * @throws PersistenciaException PersistenciaException en caso que ocurra un error en la consulta
     */
    List<RetiroSinCuenta> realizar (Integer cuentaOrigen,ConfiguracionPaginado paginado,Date fechaDesde,Date fechaHasta)throws PersistenciaException;
    /**
     * Metodo que recibe el numero de cuenta, el periodo de fechas de la cual 
     * se desean saber los depositos realizadas. Lanzando una excepcion de tipo
     * PersistenciaException en caso que ocurra un error en la consulta. 
     * @param cuentaDestino Cuenta destino del depósito
     * @param paginado Objeto de tipo paginado para saber como se presentaran los datos
     * @param fechaDesde fecha desde donde comienza la consulta
     * @param fechaHasta fecha hasta la cual llega la consulta
     * @return lista con los depositos realizados
     * @throws PersistenciaException PersistenciaException en caso que ocurra un error en la consulta
     */
    List<Deposito> Depocitosrecibidos (Integer cuentaDestino,ConfiguracionPaginado paginado,Date fechaDesde,Date fechaHasta) throws PersistenciaException;;
}
