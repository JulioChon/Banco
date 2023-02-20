/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author lv1013
 */
public class ConfiguracionPaginado {
    private int numeroPagina;
    private int elementoPorPagina;

    public ConfiguracionPaginado() {
        this.numeroPagina=0;
        this.elementoPorPagina=5;
    }

    public ConfiguracionPaginado(int numeroPagina, int elementoPorPagina) {
        this.numeroPagina = numeroPagina;
        this.elementoPorPagina = elementoPorPagina;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public int getElementoPorPagina() {
        return elementoPorPagina;
    }

    public void setElementoPorPagina(int elementoPorPagina) {
        this.elementoPorPagina = elementoPorPagina;
    }
    
    public int getElementosASaltar(){
        return this.numeroPagina*this.elementoPorPagina;
    }
    
    public void avanzarPagina(){
        this.numeroPagina++;
    }
    public void retrocederPagina(){
        if(numeroPagina>0){
            this.numeroPagina--;
        }
    }
    
}
