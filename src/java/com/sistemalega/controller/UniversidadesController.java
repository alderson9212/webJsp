/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemalega.controller;

import com.sistemalega.dao.AlumnosDao;
import com.sistemalega.dao.UniversidadesDao;
import com.sistemalega.modelo.Alumno;
import com.sistemalega.modelo.Universidad;
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

/**
 *
 * @author Elliot
 */
@WebServlet("/universidades")
public class UniversidadesController extends HttpServlet {

    UniversidadesDao universidadesDao = new UniversidadesDao();

    public UniversidadesController() {
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Universidades/universidadesPrincipal.jsp");
        List<Universidad> listaUniversidades = universidadesDao.listarUniversidades();
        request.setAttribute("lista", listaUniversidades);
        dispatcher.forward(request, response);
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Universidades/metodos/registro.jsp");
        dispatcher.forward(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Universidad universidad = new Universidad(Integer.parseInt(request.getParameter("id")),
                request.getParameter("nombre"),
                request.getParameter("estatus"));
        boolean bandera = universidadesDao.nuevo(universidad);
        PrintWriter out = response.getWriter();
        principal(request, response);
    }

    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Universidad universidad = universidadesDao.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("universidad", universidad);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Universidades/metodos/editar.jsp");
        dispatcher.forward(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Universidad universidad = new Universidad(Integer.parseInt(request.getParameter("id")),
                request.getParameter("nombre"),
                request.getParameter("estatus"));
        universidadesDao.actualizar(universidad);
        principal(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        universidadesDao.eliminar(id);
        principal(request, response);
    }
}
