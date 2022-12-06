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
	      <h1>ADMINISTRACION ALUMNOS</h1>
	<table>
		<tr>
                    <td><button onclick="window.history.go(-1)" >Ir al menú</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="alumnos?action=formregister">Insertar</a></td>
		</tr>
	</table>
	
	<table border="1" width="100%">
		<tr>
		 <td>ID</td>
		 <td>ID_MATERIA</td>
                 <td>USERNAME</td>
		 <td>NOMBRE</td>
		 <td>APELLIDO_PATERNO</td>
		 <td>APELLIDO_MATERNO</td>
		 <td>ESTATUS</td>
		 <td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="alumno" items="${lista}">
			<tr>
				<td><c:out value="${alumno.id}"/></td>
				<td><c:out value="${alumno.idMateria}"/></td>
				<td><c:out value="${alumno.username}"/></td>
				<td><c:out value="${alumno.nombre}"/></td>
				<td><c:out value="${alumno.apellidoPaterno}"/></td>
				<td><c:out value="${alumno.apellidoMaterno}"/></td>
                                <td><c:out value="${alumno.estatus}"/></td>
				<td><a href="alumnos?action=showedit&id=<c:out value="${alumno.id}" />">Editar</a></td>
				<td><a href="alumnos?action=delete&id=<c:out value="${alumno.id}"/>">Eliminar</a> </td>				
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>