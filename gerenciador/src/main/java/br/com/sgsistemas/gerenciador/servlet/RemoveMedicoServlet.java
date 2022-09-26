package br.com.sgsistemas.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet("/removeMedico")
public class RemoveMedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		Integer id = Integer.parseInt(idParam);
		
		
		int resposta = JOptionPane.showConfirmDialog (null, "Confirma remoção do médico?", "Excluíndo cadastro do médico", JOptionPane.YES_NO_OPTION);
		if(resposta == JOptionPane.YES_OPTION){
			Banco.removeMedicoPeloId(id);
		}
		
		response.sendRedirect("listaMedicos");
	}

}
