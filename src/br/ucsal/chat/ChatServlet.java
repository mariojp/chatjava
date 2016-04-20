package br.ucsal.chat;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ChatServlet")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Chat chat = (Chat) request.getSession().getServletContext().getAttribute("chat");
		String mensagem = request.getParameter("mensagem");
		String to = request.getParameter("to");
		chat.enviaMensagem(usuario.getNome(),to, mensagem);
		
		request.getSession().setAttribute("canal",chat.getCanal(usuario.getNome()));
		response.sendRedirect("chat.jsp");
	}

}
