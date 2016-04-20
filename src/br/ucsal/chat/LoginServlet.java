package br.ucsal.chat;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		Object param = request.getSession().getAttribute("usuario");
		if(param==null){
			param = new  Usuario();
		}
		Usuario usuario = (Usuario) param;
		usuario.setNome(nome);
		Chat chat = (Chat) request.getSession().getServletContext().getAttribute("chat");
		chat.addUsuario(usuario.getNome());
		request.getSession().setAttribute("usuario",usuario);
		response.sendRedirect("chat.jsp"); 
	}

}
