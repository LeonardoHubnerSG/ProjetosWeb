package br.com.sgsistemas.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/olokoBicho")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Essa fera aí, meu");
		response.getWriter().println("<html>"
					+ "<head>"
					  + "<meta charset='win1252'>"
					+ "</head>"
					  +"<title>OI tio Cassio</title>"
					+ "<body bgcolor='#000000' text='#00FFFF'>"
					  + "ESSA FERAAA AÍ, MEUU! &#129411;"
					+ "</body>"
				  + "</html>");
	}

}
