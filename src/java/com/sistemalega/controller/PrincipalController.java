/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemalega.controller;

import com.sistemalega.dao.AlumnosDao;
import com.sistemalega.dao.CarrerasDao;
import com.sistemalega.modelo.Alumno;
import com.sistemalega.modelo.Carrera;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elliot
 */
@WebServlet("/principal")
public class PrincipalController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        try {
            switch (action) {
                case "alumnos":
                    alumnos(request, response);
                    break;
                case "carreras":
                    carreras(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void alumnos(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        //mostrar(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Alumnos/alumnosPrincipal.jsp");
        List<Alumno> listaArticulos = new AlumnosDao().listarAlumnos();
        request.setAttribute("lista", listaArticulos);
        dispatcher.forward(request, response);
    }
    
     private void carreras(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Carreras/carrerasPrincipal.jsp");
        List<Carrera> listaCarreras = new CarrerasDao().listarCarreras();
        request.setAttribute("lista", listaCarreras);
        dispatcher.forward(request, response);
    }

}
