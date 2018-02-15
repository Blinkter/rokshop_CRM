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
		<h1>Samochody klienta</h1>
		<table class="table table-striped">
			<tr>
				<th>Marka</th>
				<th>Model</th>
				<th>Rok produkcji</th>
				<th>Numer rejestracyjny</th>
				<th>Następny przegląd</th>
			</tr>
			<c:forEach items="${vehicles}" var="vehicle">
			<tr>
	    		 <td>${vehicle.brand}</td>
	    		 <td>${vehicle.model}</td>
	    		 <td>${vehicle.year}</td>
	    		 <td>${vehicle.reg_number}</td>
	    		 <td>${vehicle.next_service}</td>
			</tr>
	 		</c:forEach>
		</table>
			
		<%@ include file="../footer.jsp" %>
		</div>
		
	</div>

</body>
</html>