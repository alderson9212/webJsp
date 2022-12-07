<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Actualizar Alumno</title>
    </head>
    <body>
        <h1>Actualizar Datos Alumno</h1>
        <form action="alumnos?action=edit" method="post" >
            <table>
                <tr>
                    <td><label>Id</label></td>
                    <td><input type="text" name="id" value="<c:out value="${alumno.id}"></c:out>" ></td>
                    </tr>
                    <tr>
                         <td><label>Id Materia</label></td>
                        <td>
                            <select name="idmateria">
                            <c:forEach var="materia" items="${lista}">
                                <option><c:out value="${materia.id}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label>Username</label></td>
                    <td><input type="text" name="username" value='<c:out value="${alumno.username}"></c:out>' ></td>
                    </tr>
                    <tr>
                        <td><label>Nombre</label></td>
                        <td><input type="text" name="nombre" value='<c:out value="${alumno.nombre}"></c:out>' ></td>
                    </tr>
                    <tr>
                        <td><label>ApellidoPaterno</label></td>
                        <td><input type="text" name="appaterno" value='<c:out value="${alumno.apellidoPaterno}"></c:out>' ></td>
                    </tr>
                    <tr>
                        <td><label>ApellidoMaterno</label></td>
                        <td><input type="text" name="apmaterno" value='<c:out value="${alumno.apellidoMaterno}"></c:out>' ></td>
                    </tr>

                    <tr>
                        <td><label>Estatus</label></td>
                        <td><input type="text" name="estatus" value='<c:out value="${alumno.estatus}"></c:out>' ></td>
                </tr>
            </table>

            <input type="submit" name="registrar" value="Guardar"> 
        </form>

    </body>
</html>