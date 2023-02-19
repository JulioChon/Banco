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
public class RetiroSinCuenta {
    private Integer folio;
    private Integer contraseña;
    private float monto;
    private String estado;
    private Integer cuenta_retirada;
    
    public RetiroSinCuenta() {
    }

    public RetiroSinCuenta(Integer folio, Integer contraseña, float monto, String estado, Integer cuenta_retirada) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.monto = monto;
        this.estado = estado;
        this.cuenta_retirada = cuenta_retirada;
    }

    public RetiroSinCuenta(Integer folio, Integer contraseña, String estado) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public RetiroSinCuenta(Integer folio, Integer contraseña, float monto) {
        this.folio = folio;
        this.contraseña = contraseña;
        this.monto = monto;
    }

    
    public RetiroSinCuenta(Integer folio) {
        this.folio = folio;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public Integer getContraseña() {
        return contraseña;
    }

    public void setContraseña(Integer contraseña) {
        this.contraseña = contraseña;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCuenta_retirada() {
        return cuenta_retirada;
    }

    public void setCuenta_retirada(Integer cuenta_retirada) {
        this.cuenta_retirada = cuenta_retirada;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.folio);
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
        final RetiroSinCuenta other = (RetiroSinCuenta) obj;
        return Objects.equals(this.folio, other.folio);
    }

    @Override
    public String toString() {
        return "RetiroSinCuenta{" + "folio=" + folio + ", contrase\u00f1a=" + contraseña + ", monto=" + monto + ", estado=" + estado + ", cuenta_retirada=" + cuenta_retirada + '}';
    }

    
    
    
}
