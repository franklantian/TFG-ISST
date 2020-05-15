<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form action="FormCreaProfesorServlet">
		<input type="text" name="email" placeholder="Email"> <input
			type="password" name="password" placeholder="Password"> <input
			type="text" name="name" placeholder="Nombre y apellidos">
		<button type="submit">Registrar profesor</button>
	</form>

</body>
</html>