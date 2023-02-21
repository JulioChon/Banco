/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;

/**
 * Clase que representa la cuenta
 * @author julio
 */
public class Cuenta {
   private Integer numeroCuenta; // número de cuenta
    private float monto; // monto de la cuenta
    private Integer codigoCliente; // código del cliente
    private String estado; // estado de la cuenta

    /**
     * Constructor vacío de la clase Cuenta.
     */
    public Cuenta() {
    }

    /**
     * Constructor de la clase Cuenta.
     *
     * @param numeroCuenta   el número de la cuenta
     * @param monto          el monto de la cuenta
     * @param codigoCliente  el código del cliente
     */
    public Cuenta(Integer numeroCuenta, float monto, Integer codigoCliente) {
        this.numeroCuenta = numeroCuenta;
        this.monto = monto;
        this.codigoCliente = codigoCliente;
    }

    /**
     * Constructor de la clase Cuenta.
     *
     * @param numeroCuenta  el número de la cuenta
     */
    public Cuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Obtiene el número de cuenta de la instancia de Cuenta.
     *
     * @return el número de cuenta
     */
    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Establece el número de cuenta de la instancia de Cuenta.
     *
     * @param numeroCuenta el número de cuenta
     */
    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * Obtiene el monto de la cuenta de la instancia de Cuenta.
     *
     * @return el monto de la cuenta
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Establece el monto de la cuenta de la instancia de Cuenta.
     *
     * @param monto el monto de la cuenta
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * Obtiene el código del cliente de la instancia de Cuenta.
     *
     * @return el código del cliente
     */
    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    /**
     * Establece el código del cliente de la instancia de Cuenta.
     *
     * @param codigoCliente el código del cliente
     */
    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    /**
     * Obtiene el estado de la cuenta de la instancia de Cuenta.
     *
     * @return el estado de la cuenta
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la cuenta de la instancia de Cuenta.
     *
     * @param estado el estado de la cuenta
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Devuelve el valor hash del objeto.
     *
     * @return el valor hash del objeto
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.codigoCliente);
        return hash;
    }

    /**
     * Método que comprueba si un objeto es igual al objeto Cuenta.
     * @param obj el objeto a comparar con el objeto Cuenta.
     * @return true si el objeto es igual al objeto Cuenta, false en caso
     * contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cuenta other = (Cuenta) obj;
        return Objects.equals(this.codigoCliente, other.codigoCliente);
    }

     /**
     *
     * Método que devuelve una cadena de texto que representa al objeto Cuenta.
     *
     * @return una cadena de texto que representa al objeto Cuenta.
     */
    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", monto=" + monto + ", codigoCliente=" + codigoCliente + ", estado=" + estado + '}';
    }

}
