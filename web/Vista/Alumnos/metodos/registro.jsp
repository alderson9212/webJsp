<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Administrar Alumnos</title>
    </head>
    <body>
        <h1>Registrar Alumno</h1>       
        <form action="alumnos?action=save" method="post">
            <table border="1" align="center">
                <tr>
                    <td>Id:</a></td>		
                    <td><input type="text" name="id" onKeypress="if (event.keyCode < 48 || event.keyCode > 57)
                                event.returnValue = false;"/></td>	
                </tr>
                <tr>
                    <td>Id Materia:</a></td>

                    <td>
                        <select>
                            <c:forEach var="materia" items="${lista}">
                                <option><c:out value="${materia.id}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Username:</a></td>		
                    <td><input type="text" name="username"/></td>	
                </tr>
                <tr>
                    <td>Nombre:</a></td>		
                    <td><input type="text" name="nombre"/></td>	
                </tr>
                <tr>
                    <td>Apellido Paterno:</a></td>		
                    <td><input type="text" name="appaterno"/></td>	
                </tr>
                <tr>
                    <td>Apellido Materno:</a></td>		
                    <td><input type="text" name="apmaterno"/></td>	
                </tr>

                <tr>
                    <td>Estatus:</a></td>		
                    <td><input type="text" name="estatus"/></td>	
                </tr>

            </table>
            <br>
            <table border="0" align="center">
                <tr>
                    <td><button onclick="window.history.go(-1)" >Registrar</button></td>	
                </tr>

        </form>
    </body>
</html>