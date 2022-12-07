<%-- 
    Document   : principal
    Created on : 4/12/2022, 03:35:09 PM
    Author     : Elliot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            .div_center{
                align-content: center;
                text-align: center;
            }

            .div_center h1{
                text-align: center;
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="div_center">
            <h1>PANEL DE ADMINSTRACION</h1>
            <br>
            <a href="principal?action=alumnos">Alumnos</a><br>
            <a href="principal?action=carreras">Carreras</a><br>
            <a href="principal?action=grados">Grados</a><br>
            <a href="principal?action=grupos">Grupos</a><br>
            <a href="principal?action=materias">Materias</a><br>
            <a href="principal?action=universidades">Universidades</a><br>
            
          
        </div>       
    </body>
</html>
