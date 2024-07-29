/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author DUOC
 */
public class Vehiculo {
    
     private String patente,marca;
    private int anio_fabricacion,precio;
    private boolean es_nuevo;
    
    //contructor sin parametros.

    public Vehiculo() {
    }
//constructor con parametros.
    public Vehiculo(String patente, String marca, int anio_fabricacion, int precio, boolean es_nuevo) {
        this.patente = patente;
        this.marca = marca;
        this.anio_fabricacion = anio_fabricacion;
        this.precio = precio;
        this.es_nuevo = es_nuevo;
    }

  
    
    
    //getter y setter.

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio_fabricacion() {
        return anio_fabricacion;
    }

    public void setAnio_fabricacion(int anio_fabricacion) {
        this.anio_fabricacion = anio_fabricacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isEs_nuevo() {
        return es_nuevo;
    }

    public void setEs_nuevo(boolean es_nuevo) {
        this.es_nuevo = es_nuevo;
    }

    @Override
    public String toString() {
        return "ControladorAuto{" + "patente=" + patente + ", marca=" + marca + ", anio_fabricacion=" + anio_fabricacion + ", precio=" + precio + ", es_nuevo=" + es_nuevo + '}';
    }

    
    
}
