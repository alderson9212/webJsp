/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemalega.dao;

import com.sistemalega.modelo.ConexionJDNI;
import com.sistemalega.modelo.Alumno;
import com.sistemalega.modelo.Grado;
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
public class GradosDao {

    ConexionJDNI conexion = new ConexionJDNI();
    Connection con;
    PreparedStatement ps;
    Statement st;
    
    public boolean nuevo(Grado grado){
        con = conexion.conector();
        boolean bandera = false;
        try {
             String sql = "INSERT INTO t_grados VALUES(?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, grado.getId());
            statement.setInt(2, grado.getIdCarrera());
            statement.setString(3, grado.getNombre());
            statement.setString(4, grado.getEstatus());

            bandera = statement.executeUpdate() > 0;
            statement.close();
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error al insertar:"+e.getMessage()); 
        }
        
        return bandera;
    }

    // listar todos grados
    public List<Grado> listarAlumnos() throws SQLException {
        con = conexion.conector();
        List<Grado> listaGrados = new ArrayList<Grado>();
        String sql = "SELECT * FROM t_grados";
        Statement statement = con.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);
        while (resulSet.next()) {
            int id = resulSet.getInt("id");
            int idCarrera = resulSet.getInt("id_carrera");
            String nombre = resulSet.getString("nombre");
            String estatus = resulSet.getString("estatus");
            Grado grado = new Grado(id, idCarrera,nombre,estatus);
            listaGrados.add(grado);
        }
        conexion.desconectar();
        return listaGrados;
    }

    //obtener por id
    public Grado obtenerPorId(int id) throws SQLException {
        con = conexion.conector();
        Grado grado = null;
        String sql = "SELECT * FROM t_grados WHERE id= ? ";
         
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            grado = new Grado(res.getInt("id"),
                    res.getInt("id_carrera"),
                    res.getString("nombre"),
                    res.getString("estatus"));
        }
        res.close();
        conexion.desconectar();
        return grado;
    }

    // actualizar
    public boolean actualizar(Grado grado) throws SQLException {
        con = conexion.conector();
        boolean rowActualizar = false;
        try {
            String sql = "UPDATE t_grados SET id=?,id_carrera=?,nombre=?,estatus=? WHERE id=?";
            
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, grado.getId());
            statement.setInt(2, grado.getIdCarrera());
            statement.setString(3, grado.getNombre());
            statement.setString(4, grado.getEstatus());
            statement.setInt(5, grado.getId());

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
            String sql = "DELETE FROM t_grados WHERE id=?";            
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
