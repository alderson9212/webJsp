/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemalega.dao;

import com.sistemalega.modelo.ConexionJDNI;
import com.sistemalega.modelo.Alumno;
import com.sistemalega.modelo.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elliot
 */
public class GruposDao {

    ConexionJDNI conexion = new ConexionJDNI();
    Connection con;
    PreparedStatement ps;
    Statement st;
    
    public boolean nuevo(Grupo grupo){
        con = conexion.conector();
        boolean bandera = false;
        try {
             String sql = "INSERT INTO t_grupos VALUES(?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, grupo.getId());
            statement.setInt(2, grupo.getIdGrado());
            statement.setString(3, grupo.getNombre());
            statement.setString(4, grupo.getEstatus());
            bandera = statement.executeUpdate() > 0;
            statement.close();
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error al insertar:"+e.getMessage()); 
        }
        
        return bandera;
    }

    // listar todos grupos
    public List<Grupo> listarGrupos() throws SQLException {
        con = conexion.conector();
        List<Grupo> listaGrupos = new ArrayList<Grupo>();
        String sql = "SELECT * FROM t_grupos";
        Statement statement = con.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);
        while (resulSet.next()) {
            int id = resulSet.getInt("id");
            int idGrado = resulSet.getInt("id_grado");
            String nombre = resulSet.getString("nombre");
            String estatus = resulSet.getString("estatus");
            Grupo grupo = new Grupo(id, idGrado,nombre,estatus);
            listaGrupos.add(grupo);
        }
        conexion.desconectar();
        return listaGrupos;
    }

    //obtener por id
    public Grupo obtenerPorId(int id) throws SQLException {
        con = conexion.conector();
        Grupo grupo = null;
        String sql = "SELECT * FROM t_grupos WHERE id= ? ";
         
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
           grupo = new Grupo(res.getInt("id"),
                    res.getInt("id_grado"),
                    res.getString("nombre"),
                    res.getString("estatus"));
        }
        res.close();
        conexion.desconectar();
        return grupo;
    }

    // actualizar
    public boolean actualizar(Grupo grupo) throws SQLException {
        con = conexion.conector();
        boolean rowActualizar = false;
        try {
            String sql = "UPDATE t_grupos SET id=?,id_grado=?,nombre=?,estatus=? WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, grupo.getId());
            statement.setInt(2, grupo.getIdGrado());
            statement.setString(3, grupo.getNombre());
            statement.setString(4, grupo.getEstatus());
            statement.setInt(5, grupo.getId());

            rowActualizar = statement.executeUpdate() > 0;
            statement.close();
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar:"+e.getMessage());
        }

        return rowActualizar;
    }
    
     public boolean eliminar(int id) throws SQLException {
        con = conexion.conector();
        boolean rowEliminar = false;
        try {
            String sql = "DELETE FROM t_grupos WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);

            rowEliminar = statement.executeUpdate() > 0;
            statement.close();
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error al eliminar:"+e.getMessage());
        }

        return rowEliminar;
     }

}
