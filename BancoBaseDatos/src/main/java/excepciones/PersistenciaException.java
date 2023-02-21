/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 * La clase PersistenciaException representa una excepción que se produce cuando hay errores en la capa de persistencia.
 * @author esteb
 */
public class PersistenciaException extends Exception {
    
    /**
     * Construye una nueva excepción con mensaje nulo.
     */
    public PersistenciaException() {
    }

    /**
     * Construye una nueva excepción con el mensaje especificado.
     * 
     * @param mensaje el mensaje que se mostrará con la excepción
     */
    public PersistenciaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Construye una nueva excepción con el mensaje y la causa especificados.
     * 
     * @param mensaje el mensaje que se mostrará con la excepción
     * @param cause la causa de la excepción
     */
    public PersistenciaException(String mensaje, Throwable cause) {
        super(mensaje, cause);
    }

    /**
     * Construye una nueva excepción con la causa especificada.
     * 
     * @param cause la causa de la excepción
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Construye una nueva excepción con el mensaje, la causa, el estado y la supresión especificados.
     * 
     * @param mensaje el mensaje que se mostrará con la excepción
     * @param cause la causa de la excepción
     * @param bln el estado de la excepción
     * @param bln1 el estado de la excepción
     */
    public PersistenciaException(String mensaje, Throwable cause, boolean bln, boolean bln1) {
        super(mensaje, cause, bln, bln1);
    }
    
}
