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
		<h1>Edytuj pracownika:  ${employee.firstname} ${employee.surname}</h1>
	
		<div class="form-group">
			<form action="employeeEdit" method="post">
			
				<label for="firstname">Imię:</label>
				<input class="form-control" type="text" name="firstname" value="${employee.firstname}" />
				
				<label for="surname">Nazwisko:</label>
				<input class="form-control" type="text" name="surname" value="${employee.surname}" />
				
				<label for="address">Adres:</label>
				<input class="form-control" type="address" name="address" value="${employee.address}" />
				
				<label for="phoneNumber">Numer telefonu:</label>
				<input class="form-control" type="tel" name="phoneNumber" value="${employee.phone_number}" />
				
				<label for="note">Adnotacje:</label>
				<input class="form-control" type="text" name="note" value="${employee.note}">
				
				<label for="hourRate">Stawka godzinowa:</label>
				<input class="form-control" type="number" step="0.01" name="hourRate" value="${employee.hour_rate}" />
				
				<button class="btn btn-default" name="id" type="submit" value="${employee.id }">Zapisz zmiany</button>
			</form>
		</div>
		<%@ include file="../footer.jsp" %>
	</div>
</body>
</html>