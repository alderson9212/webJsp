/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemalega.dao;

import com.sistemalega.modelo.ConexionJDNI;
import com.sistemalega.modelo.Alumno;
import com.sistemalega.modelo.Universidad;
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
public class UniversidadesDao {

    ConexionJDNI conexion = new ConexionJDNI();
    Connection con;
    PreparedStatement ps;
    Statement st;
    
    public boolean nuevo(Universidad universidad){
        con = conexion.conector();
        boolean bandera = false;
        try {
             String sql = "INSERT INTO t_universidades VALUES(?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, universidad.getId());
            statement.setString(2, universidad.getNombre());
            statement.setString(3, universidad.getEstatus());

            bandera = statement.executeUpdate() > 0;
            statement.close();
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error al insertar:"+e.getMessage()); 
        }
        
        return bandera;
    }

    // listar todas universidades
    public List<Universidad> listarUniversidades() throws SQLException {
        con = conexion.conector();
        List<Universidad> listaUniversidades = new ArrayList<Universidad>();
        String sql = "SELECT * FROM t_universidades";
        Statement statement = con.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);
        while (resulSet.next()) {
            int id = resulSet.getInt("id");
            String nombre = resulSet.getString("nombre");
            String estatus = resulSet.getString("estatus");
            Universidad universidad = new Universidad(id,nombre,estatus);
            listaUniversidades.add(universidad);
        }
        conexion.desconectar();
        return listaUniversidades;
    }

    //obtener por id
    public Universidad obtenerPorId(int id) throws SQLException {
        con = conexion.conector();
        Universidad universidad = null;
        String sql = "SELECT * FROM t_universidades WHERE id= ? ";
         
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            universidad= new Universidad(res.getInt("id"),
                    res.getString("nombre"),
                    res.getString("estatus"));
        }
        res.close();
        conexion.desconectar();
        return universidad;
    }

    // actualizar
    public boolean actualizar(Universidad universidad) throws SQLException {
        con = conexion.conector();
        boolean rowActualizar = false;
        try {
            String sql = "UPDATE t_universidades SET id=?,nombre=?,estatus=? WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, universidad.getId());
            statement.setString(2, universidad.getNombre());
            statement.setString(3, universidad.getEstatus());
            statement.setInt(4, universidad.getId());

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
            String sql = "DELETE FROM t_universidades WHERE id=?";
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
