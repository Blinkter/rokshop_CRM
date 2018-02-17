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
	<h2>Generuj raport</h2>
		<form role="form" action="raport02" method="post">
			<label for="start">Od:</label>
			<input class="form-control" type="date" name="start">
			
			<label for="end">Do:</label>
			<input class="form-control" type="date" name="end">
				
		<button type="submit" class="btn btn-default" value="generate">Zatwierdź</button>
		</form>
	
	
	
		<h1>Zyski warsztatu w terminie od ${start} do ${end}</h1>
		
		<table class="table table-striped">
			<tr>
				<th>Koszt pracowników</th>
				<th>Koszt części</th>
				<th>Dochody</th>
				<th>Zysk</th>
			</tr>
			<tr>
				<td> ${employeesCost} </td>
				<td> ${partsCost} </td>
				<td> ${customerPayment} </td>
				<td> ${profit} </td>
			</tr>
		</table>
	<%@ include file="../footer.jsp" %>
	</div>

</body>
</html>