/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemalega.controller;

import com.sistemalega.dao.AlumnosDao;
import com.sistemalega.dao.CarrerasDao;
import com.sistemalega.dao.GradosDao;
import com.sistemalega.dao.GruposDao;
import com.sistemalega.dao.MateriasDao;
import com.sistemalega.dao.UniversidadesDao;
import com.sistemalega.modelo.Alumno;
import com.sistemalega.modelo.Carrera;
import com.sistemalega.modelo.Grado;
import com.sistemalega.modelo.Grupo;
import com.sistemalega.modelo.Materia;
import com.sistemalega.modelo.Universidad;
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
                case "grados":
                    grados(request, response);
                    break;
                case "grupos":
                    grupos(request, response);
                    break;
                case "materias":
                    materias(request, response);
                    break;
                case "universidades":
                    universidades(request, response);
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

    private void grados(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Grados/gradosPrincipal.jsp");
        List<Grado> listaGrados = new GradosDao().listarGrados();
        request.setAttribute("lista", listaGrados);
        dispatcher.forward(request, response);
    }

    private void grupos(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Grupos/gruposPrincipal.jsp");
        List<Grupo> listaGrupos = new GruposDao().listarGrupos();
        request.setAttribute("lista", listaGrupos);
        dispatcher.forward(request, response);
    }

    private void materias(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Materias/materiasPrincipal.jsp");
        List<Materia> listaMaterias = new MateriasDao().listarMaterias();
        request.setAttribute("lista", listaMaterias);
        dispatcher.forward(request, response);
    }

    private void universidades(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Universidades/universidadesPrincipal.jsp");
        List<Universidad> listaUniversidades = new UniversidadesDao().listarUniversidades();
        request.setAttribute("lista", listaUniversidades);
        dispatcher.forward(request, response);
    }

}
