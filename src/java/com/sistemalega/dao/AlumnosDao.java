/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemalega.dao;

import com.sistemalega.modelo.ConexionJDNI;
import com.sistemalega.modelo.Alumno;
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
public class AlumnosDao {

    ConexionJDNI conexion = new ConexionJDNI();
    Connection con;
    PreparedStatement ps;
    Statement st;
    
    public boolean nuevo(Alumno alumno){
        con = conexion.conector();
        boolean bandera = false;
        try {
             String sql = "INSERT INTO t_alumnos VALUES(?,?,?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, alumno.getId());
            statement.setInt(2, alumno.getIdMateria());
            statement.setString(3, alumno.getUsername());
            statement.setString(4, alumno.getNombre());
            statement.setString(5, alumno.getApellidoPaterno());
            statement.setString(6, alumno.getApellidoMaterno());
            statement.setString(7, alumno.getEstatus());

            bandera = statement.executeUpdate() > 0;
            statement.close();
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error al insertar:"+e.getMessage()); 
        }
        
        return bandera;
    }

    // listar todos alumnos
    public List<Alumno> listarAlumnos() throws SQLException {
        con = conexion.conector();
        System.out.println("si llegf<");
        List<Alumno> listaAlumnos = new ArrayList<Alumno>();
        String sql = "SELECT * FROM t_alumnos";
        Statement statement = con.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);
        while (resulSet.next()) {
            int id = resulSet.getInt("id");
            int idMateria = resulSet.getInt("id_materia");
            String username = resulSet.getString("username");
            String nombre = resulSet.getString("nombre");
            String appaterno = resulSet.getString("apellido_paterno");
            String apmaterno = resulSet.getString("apellido_materno");
            String estatus = resulSet.getString("estatus");
            Alumno alumno = new Alumno(id, idMateria, username, nombre, appaterno, apmaterno, estatus);
            listaAlumnos.add(alumno);
        }
        conexion.desconectar();
        return listaAlumnos;
    }

    //obtener por id
    public Alumno obtenerPorId(int id) throws SQLException {
        con = conexion.conector();
        Alumno alumno = null;
        String sql = "SELECT * FROM t_alumnos WHERE id= ? ";
         
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            alumno = new Alumno(res.getInt("id"),
                    res.getInt("id_materia"),
                    res.getString("username"),
                    res.getString("nombre"),
                    res.getString("apellido_paterno"),
                    res.getString("apellido_materno"),
                    res.getString("estatus"));
        }
        res.close();
        conexion.desconectar();
        return alumno;
    }

    // actualizar
    public boolean actualizar(Alumno alumno) throws SQLException {
        con = conexion.conector();
        boolean rowActualizar = false;
        try {
            String sql = "UPDATE t_alumnos SET id=?,id_materia=?,username=?,nombre=?,apellido_paterno=?,apellido_materno=?,estatus=? WHERE id=?";
            System.out.println("Accedioooooooooooooo");
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, alumno.getId());
            statement.setInt(2, alumno.getIdMateria());
            statement.setString(3, alumno.getUsername());
            statement.setString(4, alumno.getNombre());
            statement.setString(5, alumno.getApellidoPaterno());
            statement.setString(6, alumno.getApellidoMaterno());
            statement.setString(7, alumno.getEstatus());
            statement.setInt(8, alumno.getId());

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
            String sql = "DELETE FROM t_alumnos WHERE id=?";
            System.out.println("Accedioooooooooooooo");
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
