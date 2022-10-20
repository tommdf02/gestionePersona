package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Persona;
import model.PersonaDAO;

@WebServlet("/Modifica")
public class Modifica extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Modifica() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		int eta = Integer.parseInt(request.getParameter("eta"));
		int id = Integer.parseInt(request.getParameter("id"));
		
	  	request.setAttribute("eta", eta);
		request.setAttribute("cognome", cognome);
		request.setAttribute("nome", nome);
		request.setAttribute("id", id);
		
		request.getRequestDispatcher("modifica.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		int eta = Integer.parseInt(request.getParameter("eta"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		PersonaDAO dao = new PersonaDAO();
		
		Persona p = new Persona (eta, cognome, nome);
		
		try {
			dao.Modifica(p, id);
			response.sendRedirect("Lettura?pagina=1");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}

}
