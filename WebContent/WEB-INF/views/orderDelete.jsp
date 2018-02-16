<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<%@ include file="../header.jsp" %>
		
		<h1>Czy chcesz usunąć zamówienie?</h1>
	
		<form action="orderDelete" method="post">
			<button class="btn btn-default" name="id" type="submit" value="${order.id }">Usuń</button>	
		</form>
		
		<%@ include file="../footer.jsp" %>
	</div>
</body>
</html>