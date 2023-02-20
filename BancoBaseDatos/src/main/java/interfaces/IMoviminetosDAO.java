/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Deposito;
import dominio.RetiroSinCuenta;
import dominio.Transferencia;
import excepciones.PersistenciaException;
import java.util.List;
import utils.ConfiguracionPaginado;

/**
 *
 * @author julio
 */
public interface IMoviminetosDAO {
    List<Transferencia> realizadas(Integer cuentaOrigen,ConfiguracionPaginado paginado) throws PersistenciaException;
    List<Transferencia> recibidas (Integer cuentaDestino,ConfiguracionPaginado paginado) throws PersistenciaException;
    List<RetiroSinCuenta> realizar (Integer cuentaOrigen,ConfiguracionPaginado paginado)throws PersistenciaException;
    List<Deposito> Depocitosrecibidos (Integer cuentaDestino,ConfiguracionPaginado paginado) throws PersistenciaException;;
}
