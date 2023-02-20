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
public class Cuenta {
    private Integer numeroCuenta;
    private float monto;
    private Integer codigoCliente;
    private String estado;

    public Cuenta() {
    }

    public Cuenta(Integer numeroCuenta, float monto, Integer codigoCliente) {
        this.numeroCuenta = numeroCuenta;
        this.monto = monto;
        this.codigoCliente = codigoCliente;
    }

    public Cuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.codigoCliente);
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
        final Cuenta other = (Cuenta) obj;
        return Objects.equals(this.codigoCliente, other.codigoCliente);
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", monto=" + monto + ", codigoCliente=" + codigoCliente + ", estado=" + estado + '}';
    }

}
