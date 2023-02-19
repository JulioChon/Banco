/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import implementaciones.ClientesDAO;
import implementaciones.ConexionBD;
import implementaciones.CuentasDAO;
import implementaciones.DireccionesDAO;
import interfaces.IClientesDAO;
import interfaces.IConexionBD;
import interfaces.ICuentasDAO;
import interfaces.IDireccionesDAO;
import presentaciones.InicioForm;

/**
 *
 * @author julio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IConexionBD generadorConexion = new ConexionBD("jdbc:mysql://localHost/banco", "root", "1234");
        
        IClientesDAO clientesDAO = new ClientesDAO(generadorConexion);
        IDireccionesDAO direccionesDAO = new DireccionesDAO(generadorConexion);
        ICuentasDAO cuentasDAO = new CuentasDAO(generadorConexion);
        new InicioForm(clientesDAO,direccionesDAO,cuentasDAO).setVisible(true);

    }
    
}
