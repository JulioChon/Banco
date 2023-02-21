/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;
import java.util.Objects;

/**
 * Clase que representa los retiros sin cuenta
 * @author esteb
 */
public class RetiroSinCuenta {
    private Integer folio; // Folio del retiro sin cuenta 
    private Integer contraseña; // Contraseña del retiro sin cuenta 
    private float monto; // Monto del retiro sin cuenta
    private String estado; // Estado del retiro sin cuenta 
    private Integer cuenta_retirada; // Cuenta de la cual se hace el retiro 
    private Date fecha; // Fecha en la que se genero el retiro
   /**
     * Crea una instancia de RetiroSinCuenta.
     */
    public RetiroSinCuenta() {
    }

    /**
     * Crea una instancia de RetiroSinCuenta con los parámetros especificados.
     *
     * @param folio el folio del retiro
     * @param contraseña la contraseña del retiro
     * @param monto el monto del retiro
     * @param estado el estado del retiro
     * @param cuenta_retirada la cuenta retirada del retiro
     */
    public RetiroSinCuenta(Integer folio, Integer contraseña, float monto, String estado, Integer cuenta_retirada) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.monto = monto;
        this.estado = estado;
        this.cuenta_retirada = cuenta_retirada;
    }

    /**
     * Crea una instancia de RetiroSinCuenta con los parámetros especificados.
     *
     * @param folio el folio del retiro
     * @param contraseña la contraseña del retiro
     * @param estado el estado del retiro
     * @param cuenta_retirada la cuenta retirada del retiro
     */
    public RetiroSinCuenta(Integer folio, Integer contraseña, String estado, Integer cuenta_retirada) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.estado = estado;
        this.cuenta_retirada = cuenta_retirada;
    }

    /**
     * Crea una instancia de RetiroSinCuenta con los parámetros especificados.
     *
     * @param monto el monto del retiro
     * @param folio el folio del retiro
     * @param fecha la fecha del retiro
     */
    public RetiroSinCuenta(float monto, Integer folio, Date fecha) {
        this.monto = monto;
        this.folio = folio;
        this.fecha = fecha;
    }

    /**
     * Crea una instancia de RetiroSinCuenta con los parámetros especificados.
     *
     * @param folio el folio del retiro
     * @param contraseña la contraseña del retiro
     * @param monto el monto del retiro
     */
    public RetiroSinCuenta(Integer folio, Integer contraseña, float monto) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.monto = monto;
    }

    /**
     * Crea una instancia de RetiroSinCuenta con los parámetros especificados.
     *
     * @param folio el folio del retiro
     */
    public RetiroSinCuenta(Integer folio) {
        this.folio = folio;
    }

    /**
     * Devuelve el folio del retiro.
     *
     * @return el folio del retiro
     */
    public Integer getFolio() {
        return folio;
    }
    
    /**
     * Establece el Folio del retiro sin cuenta
     * @param folio Folio del retiro sin cuenta
     */
    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    /**
     * Regresa la contraseña del retiro 
     * @return contraseña del retiro 
     */
    public Integer getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del retiro 
     * @param contraseña contraseña del retiro 
     */
    public void setContraseña(Integer contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Regresa el monto del retiro
     * @return monto del retiro
     */
    public float getMonto() {
        return monto;
    }

    /**
     * Regresa la fecha en que se genera el retiro
     * @return fecha en la que se genera el retiro
     */
    public Date getFecha() {
        return fecha;
    }
    
    /**
     *  Estable la fecha en que se genera el retiro
     * @param fecha fecha en la que se genera el retiro
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece el monto del retiro 
     * @param monto monto del retiro
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * Regresa el estado del retiro
     * @return estado del retiro
     */
    public String getEstado() {
        return estado;
    }
    
    /**
     * Establece el estado del retiro
     * @param estado estado del retiro
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Regresa la cuenta de la cual se hizo el retiro
     * @return cuenta de la cual se hace el retiro
     */
    public Integer getCuenta_retirada() {
        return cuenta_retirada;
    }
    
    /**
     * Establece la cuenta de la cual se hizo el retiro
     * @param cuenta_retirada cuenta de la cual se hizo el retiro
     */
    public void setCuenta_retirada(Integer cuenta_retirada) {
        this.cuenta_retirada = cuenta_retirada;
    }

    /**
     * Devuelve el valor del hashcode de la RetiroSinCuenta.
     * @return El valor del hashcode de la RetiroSinCuenta.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.folio);
        return hash;
    }

    /**
     * Método que comprueba si un objeto es igual al objeto RetiroSinCuenta.
     *
     * @param obj el objeto a comparar con el objeto RetiroSinCuenta.
     * @return true si el objeto es igual al objeto RetiroSinCuenta, false en caso
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
        final RetiroSinCuenta other = (RetiroSinCuenta) obj;
        return Objects.equals(this.folio, other.folio);
    }

    /**
     *
     * Método que devuelve una cadena de texto que representa al objeto RetiroSinCuenta.
     *
     * @return una cadena de texto que representa al objeto RetiroSinCuenta.
     */
    @Override
    public String toString() {
        return "RetiroSinCuenta{" + "folio=" + folio + ", contrase\u00f1a=" + contraseña + ", monto=" + monto + ", estado=" + estado + ", cuenta_retirada=" + cuenta_retirada + '}';
    }

    
    
    
}
