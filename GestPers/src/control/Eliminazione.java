package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonaDAO;

@WebServlet("/Eliminazione")
public class Eliminazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Eliminazione() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
PersonaDAO dao = new PersonaDAO();
		
		try {
			System.out.println("elimino "+request.getParameter("id"));
			dao.CancellazionePersona(Integer.parseInt(request.getParameter("id")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("Lettura?pagina=0");
		System.out.println("Hai appena eliminato l'ID numero: " + request.getParameter("id"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonaDAO dao = new PersonaDAO();
		
		try {
			System.out.println("elimino "+request.getParameter("iddelete"));
			dao.CancellazionePersona(Integer.parseInt(request.getParameter("iddelete")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");
		System.out.println("Hai appena eliminato l'ID numero: " + request.getParameter("iddelete"));
		//doGet (request, response);
	}

}
