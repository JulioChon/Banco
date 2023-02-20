/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Date;

/**
 *
 * @author julio
 */
public class Transferencia {
    private float monto;
    private Integer codigo_emisor;
    private Integer codigo_receptor;
    private Date fecha;
    private int id;

    public Transferencia(float monto, Integer codigo_emisor, Integer codigo_receptor, Date fecha, int id) {
        this.monto = monto;
        this.codigo_emisor = codigo_emisor;
        this.codigo_receptor = codigo_receptor;
        this.fecha = fecha;
        this.id = id;
    }

    public Transferencia(float monto,Date fecha) {
        this.monto = monto;
        this.codigo_emisor = codigo_emisor;
        this.fecha = fecha;
    }
    
    
    

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Integer getCodigo_emisor() {
        return codigo_emisor;
    }

    public void setCodigo_emisor(Integer codigo_emisor) {
        this.codigo_emisor = codigo_emisor;
    }

    public Integer getCodigo_receptor() {
        return codigo_receptor;
    }

    public void setCodigo_receptor(Integer codigo_receptor) {
        this.codigo_receptor = codigo_receptor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
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
        final Transferencia other = (Transferencia) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Transferencia{" + "monto=" + monto + ", codigo_emisor=" + codigo_emisor + ", codigo_receptor=" + codigo_receptor + ", fecha=" + fecha + ", id=" + id + '}';
    }
    
    
}
