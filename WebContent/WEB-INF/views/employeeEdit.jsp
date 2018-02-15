<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<h1>Edytuj pracownika:  ${employee.firstname} ${employee.surname}</h1>

	<form action="employeeEdit" method="post">
		
		<input type="text" name="firstname" value="${employee.firstname}" /><br>
		<input type="text" name="surname" value="${employee.surname}" /><br>
		<input type="address" name="address" value="${employee.address}" /><br>
		<input type="tel" name="phoneNumber" value="${employee.phone_number}" /><br>
		<input type="text" name="note" value="${employee.note}"><br>
		<input type="number" step="0.01" name="hourRate" value="${employee.hour_rate}" /><br>
		<button name="id" type="submit" value="${employee.id }">Zapisz zmiany</button>
	
	</form>
	<%@ include file="../footer.jsp" %>

</body>
</html>