/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import implementaciones.CuentasDAO;
import implementaciones.DepositosDAO;
import implementaciones.DireccionesDAO;
import implementaciones.MovimientosDAO;
import implementaciones.RetirosSinCuentaDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
import interfaces.IDepositosDAO;
import interfaces.IDireccionesDAO;
import interfaces.IMoviminetosDAO;
import interfaces.IRetirosSinCuentaDAO;
import presentaciones.InicioForm;

/**
 * Main
 * @author julio
 */
public class Main {

    /**
     * Clase Main donde se ejecuta el programa
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IConexionBD generadorConexion = new ConexionBD("jdbc:mysql://localHost/banco", "root", "1234");
        
        IClientesDAO clientesDAO = new ClientesDAO(generadorConexion);
        IDireccionesDAO direccionesDAO = new DireccionesDAO(generadorConexion);
        ICuentasDAO cuentasDAO = new CuentasDAO(generadorConexion);
        IRetirosSinCuentaDAO retirosSinCuentaDAO = new RetirosSinCuentaDAO(generadorConexion);
        IDepositosDAO depositosDAO = new DepositosDAO(generadorConexion);
        IMoviminetosDAO movimientosDAO = new MovimientosDAO(generadorConexion);
        new InicioForm(clientesDAO,direccionesDAO,cuentasDAO,retirosSinCuentaDAO,depositosDAO,movimientosDAO).setVisible(true);

    }
    
}
