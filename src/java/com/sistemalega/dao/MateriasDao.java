/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemalega.dao;

import com.sistemalega.modelo.ConexionJDNI;
import com.sistemalega.modelo.Alumno;
import com.sistemalega.modelo.Materia;
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
public class MateriasDao {

    ConexionJDNI conexion = new ConexionJDNI();
    Connection con;
    PreparedStatement ps;
    Statement st;
    
    public boolean nuevo(Materia materia){
        con = conexion.conector();
        boolean bandera = false;
        try {
             String sql = "INSERT INTO t_materias VALUES(?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, materia.getId());
            statement.setInt(2, materia.getIdGrupo());
            statement.setString(3, materia.getNombre());
            statement.setString(4, materia.getEstatus());

            bandera = statement.executeUpdate() > 0;
            statement.close();
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error al insertar:"+e.getMessage()); 
        }
        
        return bandera;
    }

    // listar todos Materias
    public List<Materia> listarMaterias() throws SQLException {
        con = conexion.conector();
        List<Materia> listaMaterias = new ArrayList<Materia>();
        String sql = "SELECT * FROM t_materias";
        Statement statement = con.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);
        while (resulSet.next()) {
            int id = resulSet.getInt("id");
            int idGrupo = resulSet.getInt("id_grupo");
            String nombre = resulSet.getString("nombre");
            String estatus = resulSet.getString("estatus");
            Materia materia = new Materia(id, idGrupo, nombre,estatus);
            listaMaterias.add(materia);
        }
        conexion.desconectar();
        return listaMaterias;
    }

    //obtener por id
    public Materia obtenerPorId(int id) throws SQLException {
        con = conexion.conector();
        Materia materia = null;
        String sql = "SELECT * FROM t_materias WHERE id= ? ";
         
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            materia = new Materia(res.getInt("id"),
                    res.getInt("id_grupo"),
                    res.getString("nombre"),
                    res.getString("estatus"));
        }
        res.close();
        conexion.desconectar();
        return materia;
    }

    // actualizar
    public boolean actualizar(Materia materia) throws SQLException {
        con = conexion.conector();
        boolean rowActualizar = false;
        try {
            String sql = "UPDATE t_materias SET id=?,id_grupo=?,nombre=?,estatus=? WHERE id=?";
            
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, materia.getId());
            statement.setInt(2, materia.getIdGrupo());
            statement.setString(3, materia.getNombre());
            statement.setString(4, materia.getEstatus());
            statement.setInt(5, materia.getId());

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
            String sql = "DELETE FROM t_materias WHERE id=?";
            
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
