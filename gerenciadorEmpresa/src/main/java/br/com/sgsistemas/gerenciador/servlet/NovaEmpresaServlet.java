package br.com.sgsistemas.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	//Obriga a aceitação apenas do método POST
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("POST");
//		
//		String nomeEmpresa = req.getParameter("razaoSocial");
//		PrintWriter out = resp.getWriter();
//		
//		out.println("<html><body>Nova empresa " + nomeEmpresa + " cadastrada com sucesso!</body></html>");
//	}
	
//	//Obriga a aceitação apenas do método GET
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("get");
//		
//		String nomeEmpresa = req.getParameter("razaoSocial");
//		PrintWriter out = resp.getWriter();
//		
//		out.println("<html><body>Nova empresa " + nomeEmpresa + " cadastrada com sucesso!</body></html>");
//	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando empresa...");
		
		String nomeEmpresa = request.getParameter("razaoSocial");
		
		Empresa empresa = new Empresa(1,nomeEmpresa);
		//Banco banco = new Banco(); //todos od métodos dessa classe são estáticos
		Banco.adiciona(empresa);
		
		List<Empresa> listaEmpresas = new ArrayList<>();
		listaEmpresas = Banco.getEmpresas();
		Banco.getEmpresas().forEach(emp -> System.out.println(emp));
		
		//chama o JSP
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("empresa", empresa.getNome());
		rd.forward(request, response);
	}
	
}
