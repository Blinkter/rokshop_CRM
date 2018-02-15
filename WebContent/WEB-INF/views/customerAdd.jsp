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
		
		<h1>Dodaj klienta</h1>
		<div class="form-group">
			<form role="form" action="customerAdd" method="post">
				<label for="firstname">Imię:</label>
				<input class="form-control" type="text" name="firstname">
				
				<label for="surname">Nazwisko</label>
				<input class="form-control" type="text" name="surname">
				
				<label for="birthday">Data urodzin</label>
				<input class="form-control" type="date" name="birthday" placeholder="dd-mm-rrrr">
				
				<button type="submit" class="btn btn-default">Zapisz</button>
			</form>
		</div>
		<%@ include file="../footer.jsp" %>
	</div>

</body>
</html>