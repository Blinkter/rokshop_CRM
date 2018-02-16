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
		<h1>Szczegóły naprawy</h1>
		<table class="table table-striped">
			<tr>
				<th>Data przyjęcia do naprawy</th>
				<td>${order.accepted}</td>
			</tr>
			<tr>
				<th>Planowana data rozpoczęcia naprawy</th>
				<td>${order.planned_begin}</td>
			</tr>
			<tr>
				<th>Data rozpoczęcia do naprawy</th>
				<td>${order.begin}</td>
			</tr>
			<tr>
				<th>Przypisany do naprawy pracownik problemu</th>
				<td>${order.order_employee_id}</td>
			</tr>
			<tr>
				<th>Opis problemu</th>
				<td>${order.problem_description}</td>
			</tr>
			<tr>
				<th>Opis naprawy</th>
				<td>${order.repair_description}</td>
			</tr>
			<tr>
				<th>Status</th>
				<td>${order.status}</td>
			</tr>
			<tr>
				<th>Samochód</th>
				<td>${order.order_vehicle_id}</td>
			</tr>
			<tr>
				<th>Koszt naprawy dla klienta</th>
				<td>${order.repair_cost_for_customer}</td>
			</tr>
			<tr>
				<th>Koszt wykorzystanych części</th>
				<td>${order.parts_cost}</td>
			</tr>
			<tr>
				<th>Ilość roboczogodzin</th>
				<td>${order.hours_amount}</td>
			</tr>

		</table>
		<%@ include file="../footer.jsp" %>
	</div>

</body>
</html>