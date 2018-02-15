<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<%@ include file="../header.jsp" %>
		
		<div class=class="table-responsive">
		<h1>Pracownicy</h1>
		<table class="table table-striped">
			<tr>
				<th>Imię</th>
				<th>Nazwisko</th>
				<th>Adres</th>
				<th>Numer telefonu</th>
				<th>Adnotacje</th>
				<th>Stawka godzinowa</th>
				<th>Opcje</th>
			</tr>
			<c:forEach items="${employees}" var="employee">
			<tr>
	    		 <td>${employee.firstname}</td>
	    		 <td>${employee.surname}</td>
	    		 <td>${employee.address}</td>
	    		 <td>${employee.phone_number}</td>
	    		 <td>${employee.note}</td>
	    		 <td>${employee.hour_rate}</td>
	    		 <td>
		    		 <a href="employeeEdit?id=${employee.id }">Edytuj</a>
		    		 /
		    		 <a href="employeeDelete?id=${employee.id }">Usuń</a>
		    		 /
		    		 <a href="">Zlecenia</a>
	    		 </td>
			</tr>
	 		</c:forEach>
		</table>
			<a href="employeeAdd">Dodaj pracownika</a>
		</div>
		<%@ include file="../footer.jsp" %>
		
	</div>
</body>
</html>