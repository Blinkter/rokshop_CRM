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

		<h1>Nowe zamówienie</h1>
		<div class="form-group">
			<form role="form" action="orderAdd" method="post">
			
				<label for="accepted">Data przyjęcia do naprawy</label>
				<input class="form-control" type="date" name="accepted">
				
				<label for="planned_begin">Planowana data rozpoczęcia naprawy</label>
				<input class="form-control" type="date" name="planned_begin">
				
				<label for="begin">Data rozpoczęcia do naprawy</label>
				<input class="form-control" type="date" name="begin">
				
				<label for="order_employee_id">Przypisany do naprawy pracownik</label>
				<select class="form-control" name="order_employee_id">
					<option disabled selected value>Wybór pracownika</option>
					<c:forEach items="${employees}" var="employee">
						<option value="${employee.id}">${employee.firstname} ${employee.surname}</option>
					</c:forEach>
				</select>
	
				<label for="problem_description">Opis problemu</label>
				<input class="form-control" type="text" name="problem_description">
				
				<label for="repair_description">Opis naprawy</label>
				<input class="form-control" type="text" name="repair_description">
				
				<label for="status">Status</label>
				<select class="form-control" name="status">
					<option disabled selected value>Wybór statusu</option>
					<option value="Przyjęty">Przyjęty</option>
					<option value="Zatwierdzony">Zatwierdzone koszty naprawy</option>
					<option value="W_naprawie">W naprawie</option>
					<option value="Gotowy">Gotowy do odbioru</option>
					<option value="Rezygnacja">Rezygnacja</option>
				</select>
				
				<label for="order_vehicle_id">Pojazd którego dotyczy naprawa</label>
				<select class="form-control" name="order_vehicle_id">
					<option disabled selected value>Wybór samochodu</option>
					<c:forEach items="${vehicles}" var="vehicle">
						<option value="${vehicle.id}">${vehicle.brand} ${vehicle.model} nr rejestracyjny: ${vehicle.reg_number}</option>
					</c:forEach>
				</select>
				
				<label for="repair_cost_for_customer">Koszt naprawy dla klienta</label>
				<input class="form-control" type="number" step="0.01" name="repair_cost_for_customer">
				
				<label for="parts_cost">Koszt wykorzystanych części</label>
				<input class="form-control" type="number" step="0.01" name="parts_cost">
				
				<label for="hours_amount">Ilość roboczogodzin</label>
				<input class="form-control" type="number" name="hours_amount">
				
	
				<button type="submit" class="btn btn-default">Zapisz</button>
			</form>
		</div>
		<%@ include file="../footer.jsp" %>
	</div>

</body>
</html>