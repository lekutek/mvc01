<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title of the document</title>
</head>
<body>
	<h2>Trips</h2>

	<form method="POST" action="controller">
		Cel: <input type="text" name="destination" size="20"><br />
		Data poczatkowa: <input type="text" name="startDate" size="20"><br />
		Data koncowa: <input type="text" name="endDate" size="20"><br />
		Cena: <input type="text" name="price" size="20"><br /> Rabat:
		<input type="text" name="discount" size="20"><br /> <input
			type="Submit" name="Zapisz" /> <input type="hidden" name="form"
			value="trips"> <input type="hidden" name="page"
			value="trips">
	</form>
	<br />
	<c:forEach var="type" items="${trips}">
		<c:out value="${type.destination}" />
		<c:out value="${type.startDate}" />
		<c:out value="${type.endDate}" />
		<c:out value="${type.price}" />
		<c:out value="${type.discount}" />
		<a href="controller?id=${type.id}&delete=trip&page=trips">usu&#324;</a>
		<br />
	</c:forEach>
	<br/>
	<a href="index.jsp" >Index</a><br/>
</body>
</html>