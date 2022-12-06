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
public class Grado {
    private int id;
    private int idCarrera;
    private String nombre;
    private String estatus;

    public Grado() {
    }

    public Grado(int id, int idCarrera, String nombre, String estatus) {
        this.id = id;
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
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
        return "GradosModelo{" + "id=" + id + ", idCarrera=" + idCarrera + ", nombre=" + nombre + ", estatus=" + estatus + '}';
    }
    
    
}
