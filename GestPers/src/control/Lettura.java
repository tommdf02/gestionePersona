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

@WebServlet("/Lettura")
public class Lettura extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Lettura() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PersonaDAO dao = new PersonaDAO();
		int pagina = Integer.parseInt(request.getParameter("pagina"));
		int persone=0;
		
		try {
			List<Persona> listaPersone = new ArrayList <Persona>();
			listaPersone = dao.LetturaPersone(pagina);
			request.setAttribute("lista", listaPersone);
			
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		request.getRequestDispatcher("visualizzazioneTabella.jsp").forward(request, response);
		
		int pagineTotali = persone / 3;
		float pagineTotaliFloat = (float) persone / 3;
		
		request.setAttribute("pagineTotali", pagineTotali);
		request.setAttribute("pagineTotaliFloat", pagineTotaliFloat);
		request.setAttribute("pagina", pagina);
		
		pagina -= 1;
		
		if (pagina>0)
		{
			pagina = pagina*3;
		}
	}

		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
