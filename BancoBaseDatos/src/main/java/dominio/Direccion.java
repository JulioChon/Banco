/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;

/**
 * Clase que representa la dirección
 * @author julio
 */
public class Direccion {
    
    /**
     * El identificador de la dirección.
     */
    private Integer id;
    
    /**
     * La calle de la dirección.
     */
    private String calle;
    
    /**
     * La colonia de la dirección.
     */
    private String colonia;
    
    /**
     * El número de casa de la dirección.
     */
    private String numeroCasa;

    /**
     * Constructor vacío para la clase Direccion.
     */
    public Direccion() {
    }

    /**
     * Constructor para la clase Direccion.
     * @param calle La calle de la dirección.
     * @param colonia La colonia de la dirección.
     * @param numeroCasa El número de casa de la dirección.
     */
    public Direccion(String calle, String colonia, String numeroCasa) {
        this.calle = calle;
        this.colonia = colonia;
        this.numeroCasa = numeroCasa;
    }
    
    /**
     * Constructor para la clase Direccion.
     * @param id El identificador de la dirección.
     * @param calle La calle de la dirección.
     * @param colonia La colonia de la dirección.
     * @param numeroCasa El número de casa de la dirección.
     */
    public Direccion(Integer id, String calle, String colonia, String numeroCasa) {
        this.id = id;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroCasa = numeroCasa;
    }

    /**
     * Obtiene el identificador de la dirección.
     * @return El identificador de la dirección.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador de la dirección.
     * @param id El identificador de la dirección.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene la calle de la dirección.
     * @return La calle de la dirección.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la dirección.
     * @param calle La calle de la dirección.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene la colonia de la dirección.
     * @return La colonia de la dirección.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia de la dirección.
     * @param colonia La colonia de la dirección.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el número de casa de la dirección.
     * @return El número de casa de la dirección.
     */
    public String getNumeroCasa() {
        return numeroCasa;
    }

    /**
     * Establece el número de casa de la dirección.
     * @param numeroCasa El número de casa de la dirección.
     */
    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    /**
     * Devuelve el valor del hashcode de la dirección.
     * @return El valor del hashcode de la dirección.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Método que comprueba si un objeto es igual al objeto Dirección.
     *
     * @param obj el objeto a comparar con el objeto Dirección.
     * @return true si el objeto es igual al objeto Dirección, false en caso
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
        final Direccion other = (Direccion) obj;
        return Objects.equals(this.id, other.id);
    }

     /**
     *
     * Método que devuelve una cadena de texto que representa al objeto Dirección.
     *
     * @return una cadena de texto que representa al objeto Dirección.
     */
    @Override
    public String toString() {
        return "Direccion{" + "id=" + id + ", calle=" + calle + ", colonia=" + colonia + ", numeroCasa=" + numeroCasa + '}';
    }
    
    
    
}
