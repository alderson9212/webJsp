/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemalega.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Elliot
 */
public class ConexionJDNI {

    Connection con;

    public Connection conector() {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc_oracle");
            con = ds.getConnection();
        } catch (NamingException ex) {
            Logger.getLogger(ConexionJDNI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDNI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }

    public void desconectar() throws SQLException {
        if (con != null && ! con.isClosed()) {
            con.close();
        }
    }
}
