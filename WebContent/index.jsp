<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<title>Inicio</title>
<jsp:useBean id="chat" class="br.ucsal.chat.Chat" scope="application"></jsp:useBean>
</head>
<body>
<form action="LoginServlet" method="post">
Nome: <input type="text" name="nome" >
<input type="submit">
</form>
</body>
</html>