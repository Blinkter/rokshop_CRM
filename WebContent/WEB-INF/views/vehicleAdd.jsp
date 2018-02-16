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
		
		<h1>Dodaj samochód  ${customerId}</h1>
		
		<div class="form-group">
			<form role="form" action="vehicleAdd?id=${customerId}" method="post" >
				<label for="brand">Marka:</label>
				<input class="form-control" type="text" name="brand">
				
				<label for="model">Model</label>
				<input class="form-control" type="text" name="model">
				
				<label for="year">Rok produkcji</label>
				<input class="form-control" type="number" name="year">
				
				<label for="regNumber">Numer rejestracyjny</label>
				<input class="form-control" type="text" name="regNumber">
	
				<label for="nextService">Następny przegląd</label>
				<input class="form-control" type="date" name="nextService">
	
				<button name="bt" type="submit" class="btn btn-default">Zapisz</button>
			</form>
		</div>
		<%@ include file="../footer.jsp" %>
	</div>

</body>
</html>