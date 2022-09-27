package br.com.sgsistemas.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sgsistemas.gerenciador.modelo.Banco;
import br.com.sgsistemas.gerenciador.modelo.Medico;

@WebServlet("/listaMedicos")
public class ListaMedicosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Medico> lista = Banco.getMedicos();
		
		request.setAttribute("medicos", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaMedicos.jsp");
		rd.forward(request, response);
	}

}
