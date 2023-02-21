/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 * Configuración para paginar tablas
 * @author lv1013
 */
public class ConfiguracionPaginado {
    private int numeroPagina; // cantidad elemetos a saltar 
    private int elementoPorPagina; // numero de elementos por pagina

    /**
     * Constructor por defecto que inicializa la configuración de paginación con la página 
     * 0 y 5 elementos por página.
     */
    public ConfiguracionPaginado() {
        this.numeroPagina=0;
        this.elementoPorPagina=5;
    }

    /**
     * Constructor que permite configurar la paginación con una página específica
     * y un número de elementos por página.
     * @param numeroPagina el número de la página a configurar
     * @param elementoPorPagina el número de elementos por página
     */
    public ConfiguracionPaginado(int numeroPagina, int elementoPorPagina) {
        this.numeroPagina = numeroPagina;
        this.elementoPorPagina = elementoPorPagina;
    }

    /**
     * Método que devuelve el número de la página configurada.
     * @return el número de la página configurada
     */
    public int getNumeroPagina() {
        return numeroPagina;
    }

    /**
     * Método que permite configurar el número de la página.
     * @param numeroPagina el número de la página a configurar
     */
    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    /**
     * Método que devuelve el número de elementos por página configurado.
     * @return el número de elementos por página configurado
     */
    public int getElementoPorPagina() {
        return elementoPorPagina;
    }

    /**
     * Método que permite configurar el número de elementos por página.
     * @param elementoPorPagina el número de elementos por página a configurar
     */
    public void setElementoPorPagina(int elementoPorPagina) {
        this.elementoPorPagina = elementoPorPagina;
    }
    
    /**
     * Método que devuelve la cantidad de elementos a saltar en la lista, según la página configurada y el número de elementos por página.
     * @return la cantidad de elementos a saltar en la lista
     */
    public int getElementosASaltar(){
        return this.numeroPagina*this.elementoPorPagina;
    }
    
    /**
     * Método que permite avanzar a la siguiente página en la paginación.
     */
    public void avanzarPagina(){
        this.numeroPagina++;
    }
    
    /**
     * Método que permite retroceder a la página anterior en la paginación.
     */
    public void retrocederPagina(){
        if(numeroPagina>0){
            this.numeroPagina--;
        }
    }
    
}
