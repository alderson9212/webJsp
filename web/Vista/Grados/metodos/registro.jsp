<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Registrar Grado</title>
    </head>
    <body>
        <h1>Registrar Grado</h1>
        <form action="grados?action=save" method="post">
            <table border="1" align="center">
                <tr>
                    <td>Id:</a></td>		
                    <td><input type="text" name="id"/></td>	
                </tr>
                <tr>
                    <td>Id Carrera:</a></td>		
                    <td>
                        <select name="idcarrera">
                            <c:forEach var="carrera" items="${lista}">
                                <option><c:out value="${carrera.id}"/></option>
                            </c:forEach>
                        </select>
                    </td>	
                </tr>
                <tr>
                    <td>Nombre:</a></td>		
                    <td><input type="text" name="nombre"/></td>	
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