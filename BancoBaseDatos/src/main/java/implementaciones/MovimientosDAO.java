/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dominio.Deposito;
import dominio.RetiroSinCuenta;
import dominio.Transferencia;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IMoviminetosDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConfiguracionPaginado;

/**
 *
 * @author julio
 */
public class MovimientosDAO implements IMoviminetosDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES;

    public MovimientosDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

    // falta poner las fechas en el parametro y en donde se la asigna el valor al signo de interrogacion
    // primero va la fecha inicio y despues de la fecha final
    @Override
    public List<Transferencia> realizadas(Integer cuentaOrigen,ConfiguracionPaginado paginado) throws PersistenciaException {
       String codigoSQL = "Call historialTransferenciasRealizadas(?,?,?)";
       List<Transferencia> transferenciasRealizadas = new LinkedList<>();
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
             comando.setInt(1, cuentaOrigen);
             comando.setInt(2, paginado.getElementoPorPagina());
             comando.setInt(3,paginado.getElementosASaltar() );
             ResultSet resultado = comando.executeQuery();
             Transferencia transferencia = null;
             while (resultado.next()) {
                 Integer codigo_receptor = resultado.getInt("codigo_receptor");
                 float monto = resultado.getFloat("monto");
                 Date fecha = resultado.getDate("fecha");
                 transferencia = new Transferencia(monto,  fecha);
                 transferencia.setCodigo_receptor(codigo_receptor);
                 transferenciasRealizadas.add(transferencia);
            }
             return transferenciasRealizadas;
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible consultar la lista de transferencias");
        }
    }

    // falta poner las fechas en el parametro y en donde se la asigna el valor al signo de interrogacion
    // primero va la fecha inicio y despues de la fecha final
    @Override
    public List<Transferencia> recibidas(Integer cuentaDestino,ConfiguracionPaginado paginado) throws PersistenciaException {
     String codigoSQL = "Call historialTransferenciasRecibidas(?,?,?)";
       List<Transferencia> transferenciasRecibidas = new LinkedList<>();
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
             comando.setInt(1, cuentaDestino);
             comando.setInt(2, paginado.getElementoPorPagina());
             comando.setInt(3,paginado.getElementosASaltar() );
             ResultSet resultado = comando.executeQuery();
             Transferencia transferencia = null;
             while (resultado.next()) {
                 Integer codigo_emiros = resultado.getInt("codigo_emisor");
                 float monto = resultado.getFloat("monto");
                 Date fecha = resultado.getDate("fecha");
                 transferencia = new Transferencia(monto, fecha);
                 transferencia.setCodigo_emisor(codigo_emiros);
                 transferenciasRecibidas.add(transferencia);
            }
             return transferenciasRecibidas;
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible consultar la lista de transferencias");
        }

    }
    // falta poner las fechas en el parametro y en donde se la asigna el valor al signo de interrogacion
    // primero va la fecha inicio y despues de la fecha final
    @Override
    public List<RetiroSinCuenta> realizar(Integer cuentaOrigen,ConfiguracionPaginado paginado) throws PersistenciaException {
       String codigoSQL = "call historialRetirosSinCuenta(?,?,?)";
       List<RetiroSinCuenta> retirosSinCuentaRealizados = new LinkedList<>();
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
             comando.setInt(1, cuentaOrigen);
             comando.setInt(2, paginado.getElementoPorPagina());
             comando.setInt(3,paginado.getElementosASaltar() );
             ResultSet resultado = comando.executeQuery();
             RetiroSinCuenta retiroSinCuenta = null;
             while (resultado.next()) {
                 Integer folio = resultado.getInt("folio");
                 float monto = resultado.getFloat("monto");
                 Date fecha = resultado.getDate("fecha");
                 retiroSinCuenta = new RetiroSinCuenta(monto, folio, fecha);
                 retirosSinCuentaRealizados.add(retiroSinCuenta);
            }
             return retirosSinCuentaRealizados;
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible consultar la lista de retiros");
        }

    }

    // falta poner las fechas en el parametro y en donde se la asigna el valor al signo de interrogacion
    // primero va la fecha inicio y despues de la fecha final
    @Override
    public List<Deposito> Depocitosrecibidos(Integer cuentaDestino,ConfiguracionPaginado paginado) throws PersistenciaException {
       String codigoSQL = "call depositos(?,?,?)";
       List<Deposito> depostisos = new LinkedList<>();
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
             comando.setInt(1, cuentaDestino);
             comando.setInt(2, paginado.getElementoPorPagina());
             comando.setInt(3,paginado.getElementosASaltar() );
             ResultSet resultado = comando.executeQuery();
             Deposito deposito = null;
             while (resultado.next()) {
                 Integer folio = resultado.getInt("id");
                 float monto = resultado.getFloat("monto");
                 Date fecha = resultado.getDate("fecha");
                 deposito = new Deposito(monto, fecha,folio);
                 depostisos.add(deposito);
            }
             
             return depostisos;
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible consultar la lista de depositos");
        }
        

    }
    
    
    
    
}
