<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="css/index.css">
  <link rel="stylesheet" href="css/formularios.css">
  <link rel="stylesheet" href="css/tablas.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Listado Asignaturas</h1>
<%@include file="/menu.html" %>


<div class="container">

<h2> Borrar Asignaturas</h2>
	<div class="form"> 
		<form action="http://localhost:8080/colegio/formularioborrarasignaturas" method="post">
		  
		  <label for="id">Id Asignatura</label>
		  <input type="text" id="id" name="id">
		  <label for="nombre">Nombre Asignatura</label>
		  <input type="text" id="nombre" name="nombre"><br>
		  <label for="curso"> curso</label>
		  <input type="curso" id="curso" name="curso">
		  <input type="submit" value="Enviar">
		</form> 
	</div>
	
	<c:forEach items="${lista}" var="asignatura">
	
		<div class="form">
			<form action="http://localhost:8080/colegio/borrarsignatura" method="post">
			
				<label for="id">Id Asignatura</label>
				<input readonly type="text" id="id" name="id" value="${asignatura.id }"/> 
				<label for="nombre">Nombre</label>
				<input readonly type="text" id="nombre" name="nombre" value="${asignatura.nombre}"/> </br>
				
				<label for="curso">Curso</label>
				<input readonly type="text" id="curso" name="curso" value="${asignatura.curso}"/> </br> 
				<input type="submit" value="borrar"/>
			</form>
		</div>
		
	</c:forEach>


</div> <!--  Fin container -->

</body>
</html>