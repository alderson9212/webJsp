/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemalega.controller;

import com.sistemalega.dao.AlumnosDao;
import com.sistemalega.dao.MateriasDao;
import com.sistemalega.modelo.Alumno;
import com.sistemalega.modelo.Materia;
import com.sun.tools.xjc.api.Mapping;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.taglibs.standard.tag.el.core.OutTag;

/**
 *
 * @author Elliot
 */
@WebServlet("/alumnos")
public class AlumnosController extends HttpServlet {

    AlumnosDao alumnosDao = new AlumnosDao();

    public AlumnosController() {
    }

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
        try {
            switch (action) {
                case "index":
                    index(request, response);
                    break;
                case "formregister":
                    nuevo(request, response);
                    break;
                case "save":
                    save(request, response);
                    break;

                case "showedit":
                    showEditar(request, response);
                    break;

                case "edit":
                    editar(request, response);
                    break;

                case "delete":
                    eliminar(request, response);
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

    private void index(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        //mostrar(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/principal.jsp");
        dispatcher.forward(request, response);
    }

    private void principal(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Alumnos/alumnosPrincipal.jsp");
        List<Alumno> listAlumnos = alumnosDao.listarAlumnos();
        request.setAttribute("lista", listAlumnos);
        dispatcher.forward(request, response);
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Alumnos/metodos/registro.jsp");
        List<Materia> listaMaterias = new MateriasDao().listarMaterias();
        request.setAttribute("lista", listaMaterias);
        dispatcher.forward(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Alumno alumno = new Alumno(Integer.parseInt(request.getParameter("id")),
                Integer.parseInt(request.getParameter("idmateria")),
                request.getParameter("username"),
                request.getParameter("nombre"),
                request.getParameter("appaterno"),
                request.getParameter("apmaterno"),
                request.getParameter("estatus"));
        boolean bandera = alumnosDao.nuevo(alumno);
        principal(request, response);
    }

    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Alumno alumno = alumnosDao.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("alumno", alumno);
        List<Materia> listaMaterias = new MateriasDao().listarMaterias();
        request.setAttribute("lista", listaMaterias);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Alumnos/metodos/editar.jsp");
        dispatcher.forward(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Alumno alumno = new Alumno(Integer.parseInt(request.getParameter("id")),
                Integer.parseInt(request.getParameter("idmateria")),
                request.getParameter("username"),
                request.getParameter("nombre"),
                request.getParameter("appaterno"),
                request.getParameter("apmaterno"),
                request.getParameter("estatus"));
        alumnosDao.actualizar(alumno);
        principal(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        alumnosDao.eliminar(id);
        principal(request, response);
    }
}
