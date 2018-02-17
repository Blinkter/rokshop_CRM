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
		<h1>Raporty</h1>
		<h2>Wybierz typ raportu:</h2>
		<p>
			<a href="raport01">Ilość godzin przepracowana przez pracowników</a><br>
			<a href="raport02">Zyski dla zakładu</a>
		</p>
		
		
	<%@ include file="../footer.jsp" %>
	</div>
</body>
</html>