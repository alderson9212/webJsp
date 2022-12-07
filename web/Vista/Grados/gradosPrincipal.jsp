<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Grados</title>
</head>
<body>
	      <h1>ADMINISTRACION GRADOS</h1>
	<table>
		<tr>
                    <td><button onclick="window.history.go(-1)" >Ir al menú</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="grados?action=formregister">Insertar</a></td>
		</tr>
	</table>
	
	<table border="1" width="100%">
		<tr>
		 <td>ID</td>
		 <td>ID_CARRERA</td>
                 <td>NOMBRE</td>
		 <td>ESTATUS</td>
		 <td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="grado" items="${lista}">
			<tr>
				<td><c:out value="${grado.id}"/></td>
				<td><c:out value="${grado.idCarrera}"/></td>
				<td><c:out value="${grado.nombre}"/></td>
				<td><c:out value="${grado.estatus}"/></td>
				<td><a href="grados?action=showedit&id=<c:out value="${grado.id}" />">Editar</a></td>
				<td><a href="grados?action=delete&id=<c:out value="${grado.id}"/>">Eliminar</a> </td>				
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>