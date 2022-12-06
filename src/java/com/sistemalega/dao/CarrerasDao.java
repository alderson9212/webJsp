/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemalega.dao;

import com.sistemalega.modelo.ConexionJDNI;
import com.sistemalega.modelo.Alumno;
import com.sistemalega.modelo.Carrera;
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
public class CarrerasDao {

    ConexionJDNI conexion = new ConexionJDNI();
    Connection con;
    PreparedStatement ps;
    Statement st;
    
    public boolean nuevo(Carrera carrera){
        con = conexion.conector();
        boolean bandera = false;
        try {
             String sql = "INSERT INTO t_carrerass VALUES(?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, carrera.getId());
            statement.setInt(2, carrera.getIdUniversidad());
            statement.setString(3, carrera.getNombre());
            statement.setString(4, carrera.getEstatus());

            bandera = statement.executeUpdate() > 0;
            statement.close();
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error al insertar:"+e.getMessage()); 
        }
        
        return bandera;
    }

    // listar todas carreras
    public List<Carrera> listarCarreras() throws SQLException {
        con = conexion.conector();
        List<Carrera> listaCarreras = new ArrayList<Carrera>();
        String sql = "SELECT * FROM t_carreras";
        Statement statement = con.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);
        while (resulSet.next()) {
            int id = resulSet.getInt("id");
            int idUniversidad = resulSet.getInt("id_universidad");
            String nombre = resulSet.getString("nombre");
            String estatus = resulSet.getString("estatus");
            Carrera carrera = new Carrera(id, idUniversidad,nombre,estatus);
            listaCarreras.add(carrera);
        }
        conexion.desconectar();
        return listaCarreras;
    }

    //obtener por id
    public Carrera obtenerPorId(int id) throws SQLException {
        con = conexion.conector();
        Carrera carrera = null;
        String sql = "SELECT * FROM t_carreras WHERE id= ? ";
         
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            carrera = new Carrera(res.getInt("id"),
                    res.getInt("id_universidad"),
                    res.getString("nombre"),
                    res.getString("estatus"));
        }
        res.close();
        conexion.desconectar();
        return carrera;
    }

    // actualizar
    public boolean actualizar(Carrera carrera) throws SQLException {
        con = conexion.conector();
        boolean rowActualizar = false;
        try {
            String sql = "UPDATE t_carreras SET id=?,id_universidad=?,nombre=?,estatus=? WHERE id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, carrera.getId());
            statement.setInt(2, carrera.getIdUniversidad());
            statement.setString(3, carrera.getNombre());
            statement.setString(4, carrera.getEstatus());
            statement.setInt(5, carrera.getId());

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
            String sql = "DELETE FROM t_carreras WHERE id=?";
            
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
