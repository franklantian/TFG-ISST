<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Admin</h2>
	<p>
		<b>Número de trabajos activos: </b>${fn:length(tfgs)}</p>
	<p>
		<b>Número de profesores activos: </b>${fn:length(profesores)}</p>
	<h2>Profesores</h2>
	<table border="1">
		<c:forEach items="${profesores}" var="profesori">
			<tr>
				<td>${profesori.name}</td>
				<td>${profesori.email}</td>
			</tr>
		</c:forEach>
	</table>
	<h2>Registrar un nuevo profesor</h2>
	<%@ include file="FormCreaProfesor.jsp"%>

	<h2>Salir de la aplicación</h2>
	<%@ include file="FormLogout.jsp"%>
</body>
</html>