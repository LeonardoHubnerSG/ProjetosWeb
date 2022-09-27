package br.com.sgsistemas.gerenciador.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sgsistemas.gerenciador.modelo.Banco;
import br.com.sgsistemas.gerenciador.modelo.Medico;

@WebServlet("/novoMedico")
public class NovoMedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeMedico = request.getParameter("nomeMedico");
		String crm = request.getParameter("crm");
		String paramDataNasc = request.getParameter("dataNascMedico");
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataNascMedico = LocalDate.parse(paramDataNasc, fmt);

		Medico medico = new Medico(nomeMedico, dataNascMedico, crm);
		Banco.adicionaMedico(medico);
		
		request.setAttribute("medico", medico.getNome());
		
		response.sendRedirect("listaMedicos");
	}

}
