/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemalega.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Elliot
 */
@WebServlet("/inicio")
public class LoginController extends HttpServlet {

    public LoginController() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hola Servlet login..");
        String action = request.getParameter("action");
        System.out.println(action);
        try {
            switch (action) {
                case "acceso":
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    if (username.equals("root") && password.equals("root")) {
                        Context ctx = new InitialContext();
                        DataSource ds = (DataSource) ctx.lookup("jdbc_oracle");
                        Connection cn = ds.getConnection();
                        Statement st = cn.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM t_alumnos");
                        while (rs.next()) {
                            System.out.println("nombre:" + rs.getString(1));
                        }

                        principal(request, response);
                    } else {
                        index(request, response);
                    }

                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void principal(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        //mostrar(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Vista/principal.jsp");
        dispatcher.forward(request, response);
    }

}
