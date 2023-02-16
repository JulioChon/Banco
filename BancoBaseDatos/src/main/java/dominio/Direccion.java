/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;

/**
 *
 * @author julio
 */
public class Direccion {
    
    private Integer id;
    private String calle;
    private String colonia;
    private String numeroCasa;

    public Direccion() {
    }

    public Direccion(String calle, String colonia, String numeroCasa) {
        this.calle = calle;
        this.colonia = colonia;
        this.numeroCasa = numeroCasa;
    }
    

    public Direccion(Integer id, String calle, String colonia, String numeroCasa) {
        this.id = id;
        this.calle = calle;
        this.colonia = colonia;
        this.numeroCasa = numeroCasa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

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

    @Override
    public String toString() {
        return "Direccion{" + "id=" + id + ", calle=" + calle + ", colonia=" + colonia + ", numeroCasa=" + numeroCasa + '}';
    }
    
    
    
}
