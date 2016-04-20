<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:useBean id="chat" class="br.ucsal.chat.Chat" scope="application"></jsp:useBean>
<jsp:useBean id="usuario" class="br.ucsal.chat.Usuario" scope="session"></jsp:useBean>
<jsp:useBean id="canal" class="java.lang.StringBuilder" scope="session"></jsp:useBean>

<title>Chat</title>
</head>
<body>
	Usuario:
	<c:out value=" ${usuario.nome}" />
	-
	<a href="chat.jsp">Atualizar </a>
	<br>
	<textarea rows="20" cols="40">
<c:out value="${canal}"></c:out>
</textarea>
	<form method="post" action="ChatServlet">
		Mensagem: <input type="text" name="mensagem" /> <select name="to">
			<option>TODOS</option>
			<c:forEach var="item" items="${chat.usuarios}">
				<option><c:out value="${item}" /></option>
			</c:forEach>
		</select> <input type="submit">
	</form>
</body>
</html>