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
		
		<h1>Dodaj pracownika</h1>
		<div class="form-group">
			<form role="form" action="employeeAdd" method="post">
				<label for="firstname">Imię:</label>
				<input class="form-control" type="text" name="firstname">
				
				<label for="surname">Nazwisko</label>
				<input class="form-control" type="text" name="surname">
				
				<label for="address">Ardes</label>
				<input class="form-control" type="text" name="address">
				
				<label for="phoneNumber">Numer telefonu</label>
				<input class="form-control" type="tel" name="phoneNumber">
	
				<label for="note">Adnotacje</label>
				<input class="form-control" type="text" name="note">
				
				<label for="hour_rate">Stawka godzinowa</label>
				<input class="form-control" type="number" step="0.01" name="hourRate">
	
				<button type="submit" class="btn btn-default">Zapisz</button>
			</form>
		</div>
		<%@ include file="../footer.jsp" %>
	</div>
</body>
</html>