<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Materias</title>
</head>
<body>
	      <h1>ADMINISTRACION MATERIAS</h1>
	<table>
		<tr>
                    <td><button onclick="window.history.go(-1)" >Ir al menú</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="materias?action=formregister">Insertar</a></td>
		</tr>
	</table>
	
	<table border="1" width="100%">
		<tr>
		 <td>ID</td>
		 <td>ID_GRUPO</td>
		 <td>NOMBRE</td>
		 <td>ESTATUS</td>
		 <td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="materia" items="${lista}">
			<tr>
				<td><c:out value="${materia.id}"/></td>
				<td><c:out value="${materia.idGrupo}"/></td>
				<td><c:out value="${materia.nombre}"/></td>
                                <td><c:out value="${materia.estatus}"/></td>
				<td><a href="materias?action=showedit&id=<c:out value="${materia.id}" />">Editar</a></td>
				<td><a href="materias?action=delete&id=<c:out value="${materia.id}"/>">Eliminar</a> </td>				
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>