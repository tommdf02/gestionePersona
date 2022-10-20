package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import config.Connessione;
import model.Persona;
import model.PersonaDAO;

@WebServlet("/Inserimento")
public class Inserimento extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Inserimento() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Persona p = new Persona();
		
		System.out.println("Età:   "+request.getParameter("eta"));
		System.out.println("Nome:   "+request.getParameter("nome"));
		System.out.println("Cognome:   "+request.getParameter("cognome"));
		
		p.setEta(Integer.parseInt(request.getParameter("eta")));
		p.setCognome(request.getParameter("nome"));
		p.setNome(request.getParameter("cognome"));
		
		PersonaDAO dao = new PersonaDAO();
		
		boolean inserimento = dao.InserimentoPersona(p);
		 
		HttpSession session = request.getSession();  
		session.setAttribute("inserimento", inserimento);
 
 
		System.out.print("Operazione completata!");
		response.sendRedirect("index.jsp");
	}
}