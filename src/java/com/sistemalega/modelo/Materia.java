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
public class Materia {
    private int id;
    private int idGrupo;
    private String nombre;
    private String estatus;

    public Materia() {
    }

    public Materia(int id, int idGrupo, String nombre, String estatus) {
        this.id = id;
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
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
        return "Materia{" + "id=" + id + ", idGrupo=" + idGrupo + ", nombre=" + nombre + ", estatus=" + estatus + '}';
    }
    
    
    
}
