package br.com.sgsistemas.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alteraMedico")
public class AlteraMedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idParam = request.getParameter("id");
		Integer id = Integer.parseInt(idParam);
		String nomeMedico = request.getParameter("nomeMedico");
		String crm = request.getParameter("crm");
		String dataNascMedico = request.getParameter("dataNascMedico");

		Medico medico = Banco.buscaMedicoPeloId(id);
			
		medico.setNome(nomeMedico);
		medico.setDataNascimento(dataNascMedico);
		medico.setCrm(crm);
		
		//request.setAttribute("medico", medico.getNome());

		response.sendRedirect("listaMedicos");

	}

}
