/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author julio
 */
public class Deposito {
    private float monto;
    private Integer id;
    private Date fecha;
    private Integer cuenta_depositada;

    public Deposito() {
    }

    public Deposito(float monto, Integer id, Date fecha, Integer cuenta_depositada) {
        this.monto = monto;
        this.id = id;
        this.fecha = fecha;
        this.cuenta_depositada = cuenta_depositada;
    }

    public Deposito(float monto, Date fecha, Integer id) {
        this.monto = monto;
        this.fecha = fecha;
        this.id = id;
    }
    

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCuenta_depositada() {
        return cuenta_depositada;
    }

    public void setCuenta_depositada(Integer cuenta_depositada) {
        this.cuenta_depositada = cuenta_depositada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Deposito other = (Deposito) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Depositos{" + "monto=" + monto + ", id=" + id + ", fecha=" + fecha + ", cuenta_depositada=" + cuenta_depositada + '}';
    }
    
    
}
