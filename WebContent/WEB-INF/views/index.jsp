<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	
	<%@ include file="../header.jsp" %>
	<h1>Aktualnie prowadzone naprawy</h1>
	<table class="table table-striped">
		<tr>
			<th>Data przyjęcia do naprawy</th>
			<th>Data rozpoczęcia do naprawy</th>
			<th>Opis problemu</th>
		</tr>
		<c:forEach items="${orders}" var="order">
		<tr>
    		 <td>${order.accepted}</td>
    		 <td>${order.begin}</td>
    		 <td>${order.problem_description}</td>
		</tr>
 		</c:forEach>
	</table>
	<%@ include file="../footer.jsp" %>
	</div>
</body>
</html>