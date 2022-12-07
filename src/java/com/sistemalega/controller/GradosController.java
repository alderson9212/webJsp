/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemalega.controller;

import com.sistemalega.dao.AlumnosDao;
import com.sistemalega.dao.CarrerasDao;
import com.sistemalega.dao.GradosDao;
import com.sistemalega.modelo.Alumno;
import com.sistemalega.modelo.Carrera;
import com.sistemalega.modelo.Grado;
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
@WebServlet("/grados")
public class GradosController extends HttpServlet {

    GradosDao gradosDao = new GradosDao();

    public GradosController() {
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
                    System.out.println("Legoofsdfodjf");
                    nuevo(request, response);
                    break;
                case "save":
                    save(request, response);
                    break;

                case "showedit":
                    System.out.println("accediooooooooooooooooo");
                    showEditar(request, response);
                    break;

                case "edit":
                    System.out.println("accediooooooooooooooooo edit");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Grados/gradosPrincipal.jsp");
        List<Grado> listaGrados = gradosDao.listarGrados();
        request.setAttribute("lista", listaGrados);
        dispatcher.forward(request, response);
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Grados/metodos/registro.jsp");
        List<Carrera>listaCarreras = new CarrerasDao().listarCarreras();
        request.setAttribute("lista",listaCarreras);
        dispatcher.forward(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Grado grado = new Grado(Integer.parseInt(request.getParameter("id")),
                Integer.parseInt(request.getParameter("idcarrera")),
                request.getParameter("nombre"),
                request.getParameter("estatus"));
        boolean bandera = gradosDao.nuevo(grado);
        principal(request, response);
    }

    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Grado grado = gradosDao.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("grado", grado);
        List<Carrera>listaCarreras = new CarrerasDao().listarCarreras();
        request.setAttribute("lista",listaCarreras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Grados/metodos/editar.jsp");
        dispatcher.forward(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Grado grado = new Grado(Integer.parseInt(request.getParameter("id")),
                Integer.parseInt(request.getParameter("idcarrera")),
                request.getParameter("nombre"),
                request.getParameter("estatus"));
        gradosDao.actualizar(grado);
        principal(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        gradosDao.eliminar(id);
        principal(request, response);
    }
}
