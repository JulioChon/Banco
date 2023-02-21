/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;
import java.util.Objects;

/**
 * Clase que representa al deposito
 * @author esteb
 */
public class Deposito {

    private float monto; // monto del depósito
    private Integer id; // identificador del depósito
    private Date fecha; // fecha del depósito
    private Integer cuenta_depositada; // cuenta en la que se realizó el depósito

    /**
     *
     * Constructor por defecto
     */
    public Deposito() {
    }

    /**
     *
     * Constructor con parámetros
     *
     * @param monto monto del depósito
     * @param id identificador del depósito
     * @param fecha fecha del depósito
     * @param cuenta_depositada cuenta en la que se realizó el depósito
     */
    public Deposito(float monto, Integer id, Date fecha, Integer cuenta_depositada) {
        this.monto = monto;
        this.id = id;
        this.fecha = fecha;
        this.cuenta_depositada = cuenta_depositada;
    }

    /**
     *
     * Constructor con parámetros
     *
     * @param monto monto del depósito
     * @param fecha fecha del depósito
     * @param id identificador del depósito
     */
    public Deposito(float monto, Date fecha, Integer id) {
        this.monto = monto;
        this.fecha = fecha;
        this.id = id;
    }

    /**
     *
     * Método que devuelve el monto del depósito
     *
     * @return monto del depósito
     */
    public float getMonto() {
        return monto;
    }

    /**
     *
     * Método que establece el monto del depósito
     *
     * @param monto monto del depósito
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     *
     * Método que devuelve el identificador del depósito
     *
     * @return identificador del depósito
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * Método que establece el identificador del depósito
     *
     * @param id identificador del depósito
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * Método que devuelve la fecha del depósito
     *
     * @return fecha del depósito
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     *
     * Método que establece la fecha del depósito
     *
     * @param fecha fecha del depósito
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * Método que devuelve la cuenta en la que se realizó el depósito
     *
     * @return cuenta en la que se realizó el depósito
     */
    public Integer getCuenta_depositada() {
        return cuenta_depositada;
    }

    /**
     *
     * Método que establece la cuenta en la que se realizó el depósito
     *
     * @param cuenta_depositada cuenta en la que se realizó el depósito
     */
    public void setCuenta_depositada(Integer cuenta_depositada) {
        this.cuenta_depositada = cuenta_depositada;
    }

    /**
     *
     * Método que calcula el hash code del depósito
     *
     * @return hash code del depósito
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Método que comprueba si un objeto es igual al objeto Deposito.
     *
     * @param obj el objeto a comparar con el objeto Deposito.
     * @return true si el objeto es igual al objeto Deposito, false en caso
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
        final Deposito other = (Deposito) obj;
        return Objects.equals(this.id, other.id);
    }

     /**
     *
     * Método que devuelve una cadena de texto que representa al objeto Deposito.
     *
     * @return una cadena de texto que representa al objeto Deposito.
     */
    @Override
    public String toString() {
        return "Depositos{" + "monto=" + monto + ", id=" + id + ", fecha=" + fecha + ", cuenta_depositada=" + cuenta_depositada + '}';
    }

}
