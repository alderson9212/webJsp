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
public class Grupo {
    private int id;
    private int idGrado;
    private String nombre;
    private String estatus;

    public Grupo() {
    }

    public Grupo(int id, int idGrado, String nombre, String estatus) {
        this.id = id;
        this.idGrado = idGrado;
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
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
        return "Grupo{" + "id=" + id + ", idGrado=" + idGrado + ", nombre=" + nombre + ", estatus=" + estatus + '}';
    }
    
    
    
}
