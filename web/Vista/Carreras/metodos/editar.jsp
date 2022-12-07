<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Carrera</title>
</head>
<body>
<h1>Actualizar Datos Carrera</h1>
	<form action="carreras?action=edit" method="post" >
		<table>
			<tr>
				<td><label>Id</label></td>
				<td><input type="text" name="id" value="<c:out value="${carrera.id}"></c:out>" ></td>
			</tr>
			<tr>
				<td><label>Id_Universidad</label></td>
				<td><input type="text" name="iduniversidad" value='<c:out value="${carrera.idUniversidad}"></c:out>' ></td>
			</tr>
                        <tr>
				<td><label>Nombre</label></td>
				<td><input type="text" name="nombre" value='<c:out value="${carrera.nombre}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Estatus</label></td>
				<td><input type="text" name="estatus" value='<c:out value="${carrera.estatus}"></c:out>' ></td>
			</tr>
		</table>
	
		<input type="submit" name="registrar" value="Guardar"> 
	</form>

</body>
</html>