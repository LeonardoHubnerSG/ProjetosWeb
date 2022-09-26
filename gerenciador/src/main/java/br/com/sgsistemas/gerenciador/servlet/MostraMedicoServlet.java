package br.com.sgsistemas.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostraMedico")
public class MostraMedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		Integer id = Integer.parseInt(idParam);
		
		Medico medico = Banco.buscaMedicoPeloId(id);
		
//		request.setAttribute("nomeMedico", medico.getNome());
//		request.setAttribute("dataNascMedico", medico.getDataNascimento());
//		request.setAttribute("crm", medico.getCrm());
		request.setAttribute("medico", medico);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraMedico.jsp");
		rd.forward(request, response);
	}

}
