/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemalega.modelo;

/**
 *
 * @author Elliot
 */
public class Carrera {
    private int id;
    private int idUniversidad;
    private String nombre;
    private String estatus;

    public Carrera() {
    }

    public Carrera(int id, int idUniversidad, String nombre, String estatus) {
        this.id = id;
        this.idUniversidad = idUniversidad;
        this.nombre = nombre;
        this.estatus = estatus;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(int idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "CarreraModelo{" + "id=" + id + ", idUniversidad=" + idUniversidad + ", nombre=" + nombre + ", estatus=" + estatus + '}';
    }
    
    
            
}
