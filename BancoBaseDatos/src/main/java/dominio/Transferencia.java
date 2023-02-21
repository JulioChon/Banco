/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;

/**
 * Clase que representa las transferencias
 * @author esteb
 */
public class Transferencia {
    private float monto; // el monto de la transferencia
    private Integer codigo_emisor; // el código de cuenta del emisor
    private Integer codigo_receptor; // el código de cuenta del receptor
    private Date fecha; // la fecha de la transferencia
    private int id; // un identificador único para la transferencia

    /**
     * Crea una nueva instancia de Transferencia con los parámetros especificados.
     *
     * @param monto el monto de la transferencia
     * @param codigo_emisor el código de cuenta del emisor
     * @param codigo_receptor el código de cuenta del receptor
     * @param fecha la fecha de la transferencia
     * @param id un identificador único para la transferencia
     */
    public Transferencia(float monto, Integer codigo_emisor, Integer codigo_receptor, Date fecha, int id) {
        this.monto = monto;
        this.codigo_emisor = codigo_emisor;
        this.codigo_receptor = codigo_receptor;
        this.fecha = fecha;
        this.id = id;
    }

    /**
     * Crea una nueva instancia de Transferencia con los parámetros especificados.
     *
     * @param monto el monto de la transferencia
     * @param fecha la fecha de la transferencia
     */
    public Transferencia(float monto,Date fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }
    
    /**
     * Obtiene el monto de la transferencia.
     *
     * @return el monto de la transferencia
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Establece el monto de la transferencia.
     *
     * @param monto el nuevo monto de la transferencia
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * Obtiene el código de cuenta del emisor.
     *
     * @return el código de cuenta del emisor
     */
    public Integer getCodigo_emisor() {
        return codigo_emisor;
    }

    /**
     * Establece el código de cuenta del emisor.
     *
     * @param codigo_emisor el nuevo código de cuenta del emisor
     */
    public void setCodigo_emisor(Integer codigo_emisor) {
        this.codigo_emisor = codigo_emisor;
    }

    /**
     * Obtiene el código de cuenta del receptor.
     *
     * @return el código de cuenta del receptor
     */
    public Integer getCodigo_receptor() {
        return codigo_receptor;
    }

    /**
     * Establece el código de cuenta del receptor.
     *
     * @param codigo_receptor el nuevo código de cuenta del receptor
     */
    public void setCodigo_receptor(Integer codigo_receptor) {
        this.codigo_receptor = codigo_receptor;
    }

    /**
     * Regresa la fecha en la que realiza la transferencia 
     * @return fecha de la transferencia
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la transferencia 
     * @param fecha fecha de la transferencia
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Regresa el id de la transferencia 
     * @return id de la transferencia 
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id de la transferencia
     * @param id id de la transferencia
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el valor del hashcode de la Transferencia.
     * @return El valor del hashcode de la Transferencia.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        return hash;
    }

    /**
     * Método que comprueba si un objeto es igual al objeto Transferencia.
     *
     * @param obj el objeto a comparar con el objeto Transferencia.
     * @return true si el objeto es igual al objeto Transferencia, false en caso
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
        final Transferencia other = (Transferencia) obj;
        return this.id == other.id;
    }

     /**
     *
     * Método que devuelve una cadena de texto que representa al objeto Transferencia.
     *
     * @return una cadena de texto que representa al objeto Transferencia.
     */
    @Override
    public String toString() {
        return "Transferencia{" + "monto=" + monto + ", codigo_emisor=" + codigo_emisor + ", codigo_receptor=" + codigo_receptor + ", fecha=" + fecha + ", id=" + id + '}';
    }
    
    
}
