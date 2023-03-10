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
 * Implementación de la IMovimientosDAO
 * @author julio
 */
public class MovimientosDAO implements IMoviminetosDAO {

    private static final Logger LOG = Logger.getLogger(ClientesDAO.class.getName());
    private final IConexionBD GENERADOR_CONEXIONES; // Conexion a la base de datos

    /**
     * Metodo constructor que inicializa la variable GENERADOR_CONEXIONES
     * @param GENERADOR_CONEXIONES Conexion a la base de datos
     */
    public MovimientosDAO(IConexionBD GENERADOR_CONEXIONES) {
        this.GENERADOR_CONEXIONES = GENERADOR_CONEXIONES;
    }

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
    @Override
    public List<Transferencia> realizadas(Integer cuentaOrigen,ConfiguracionPaginado paginado,Date fechaDesde,Date fechaHasta) throws PersistenciaException {
       String codigoSQL = "Call historialTransferenciasRealizadas(?,?,?,?,?)";
       List<Transferencia> transferenciasRealizadas = new LinkedList<>();
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
             comando.setInt(1, cuentaOrigen);
             comando.setInt(2, paginado.getElementoPorPagina());
             comando.setInt(3,paginado.getElementosASaltar() );
             comando.setDate(4, fechaDesde);
             comando.setDate(5, fechaHasta);
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
    @Override
    public List<Transferencia> recibidas(Integer cuentaDestino,ConfiguracionPaginado paginado,Date fechaDesde,Date fechaHasta) throws PersistenciaException {
     String codigoSQL = "Call historialTransferenciasRecibidas(?,?,?,?,?)";
       List<Transferencia> transferenciasRecibidas = new LinkedList<>();
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
             comando.setInt(1, cuentaDestino);
             comando.setInt(2, paginado.getElementoPorPagina());
             comando.setInt(3,paginado.getElementosASaltar() );
             comando.setDate(4, fechaDesde);
             comando.setDate(5, fechaHasta);
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
    @Override
    public List<RetiroSinCuenta> realizar(Integer cuentaOrigen,ConfiguracionPaginado paginado,Date fechaDesde,Date fechaHasta) throws PersistenciaException {
       String codigoSQL = "call historialRetirosSinCuenta(?,?,?,?,?)";
       List<RetiroSinCuenta> retirosSinCuentaRealizados = new LinkedList<>();
       try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
             comando.setInt(1, cuentaOrigen);
             comando.setInt(2, paginado.getElementoPorPagina());
             comando.setInt(3,paginado.getElementosASaltar() );
             comando.setDate(4, fechaDesde);
             comando.setDate(5, fechaHasta);
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

     /**
     * Metodo que recibe el numero de cuenta, el periodo de fechas de la cual 
     * se desean saber los depositos realizadas. Lanzando una excepcion de tipo
     * PersistenciaException en caso que ocurra un error en la consulta. 
     * @param cuentaDestino Cuenta a la que se le depósito
     * @param paginado Objeto de tipo paginado para saber como se presentaran los datos
     * @param fechaDesde fecha desde donde comienza la consulta
     * @param fechaHasta fecha hasta la cual llega la consulta
     * @return lista con los depositos realizados
     * @throws PersistenciaException PersistenciaException en caso que ocurra un error en la consulta
     */
    @Override
    public List<Deposito> Depocitosrecibidos(Integer cuentaDestino,ConfiguracionPaginado paginado,Date fechaDesde,Date fechaHasta) throws PersistenciaException {
        String codigoSQL = "call depositos(?,?,?,?,?)";
        List<Deposito> depostisos = new LinkedList<>();
        try (Connection conexion = this.GENERADOR_CONEXIONES.crearConexiones();
            PreparedStatement comando = conexion.prepareStatement(codigoSQL);) {
             comando.setInt(1, cuentaDestino);
             comando.setInt(2, paginado.getElementoPorPagina());
             comando.setInt(3,paginado.getElementosASaltar() );
             comando.setDate(4, fechaDesde);
             comando.setDate(5, fechaHasta);
             ResultSet resultado = comando.executeQuery();
             Deposito deposito = null;
             while (resultado.next()) {
                 Integer id = resultado.getInt("id");
                 float monto = resultado.getFloat("monto");
                 Date fecha = resultado.getDate("fecha");
                 deposito = new Deposito(monto, fecha, id);
                 depostisos.add(deposito);
            }
             
             return depostisos;
       }catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
            throw new PersistenciaException("No fue posible consultar la lista de depositos");
        }
        

    }
    
    
    
    
}
