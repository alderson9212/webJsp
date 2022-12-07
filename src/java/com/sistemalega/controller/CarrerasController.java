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
@WebServlet("/carreras")
public class CarrerasController extends HttpServlet {

    CarrerasDao carrerasDao = new CarrerasDao();

    public CarrerasController() {
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
                    System.out.println("Guardando");
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Carreras/carrerasPrincipal.jsp");
        List<Carrera> listaCarrera = carrerasDao.listarCarreras();
        request.setAttribute("lista", listaCarrera);
        dispatcher.forward(request, response);
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Carreras/metodos/registro.jsp");
        dispatcher.forward(request, response);
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Carrera carrera = new Carrera(Integer.parseInt(request.getParameter("id")),
                Integer.parseInt(request.getParameter("iduniversidad")),
                request.getParameter("nombre"),
                request.getParameter("estatus"));
                
        boolean bandera = carrerasDao.nuevo(carrera);
        principal(request, response);                
    }

    private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Carrera carrera = carrerasDao.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("carrera", carrera);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/Carreras/metodos/editar.jsp");
        dispatcher.forward(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Carrera carrera = new Carrera(Integer.parseInt(request.getParameter("id")),
                Integer.parseInt(request.getParameter("iduniversidad")),
                request.getParameter("nombre"),
                request.getParameter("estatus"));
        carrerasDao.actualizar(carrera);
        principal(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        carrerasDao.eliminar(id);
        principal(request, response);
    }
}
