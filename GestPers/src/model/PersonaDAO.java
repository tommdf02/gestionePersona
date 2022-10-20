
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.Connessione;

public class PersonaDAO {

	public boolean InserimentoPersona (Persona p)
	{
		String sql = "INSERT INTO persona (eta, nome, cognome) VALUES ("+p.getEta()+", '"+p.getNome()+"', '"+p.getCognome()+"') ";
		
		Connection conn = Connessione.getConnessione(); 

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void CancellazionePersona (int id) throws SQLException
	{
		String sql = "DELETE FROM persona WHERE id = ?" ;
		
		Connection conn = Connessione.getConnessione(); 
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt (1, id);
		System.out.println(ps.toString());
		ps.executeUpdate(); 
	}
	
	public List<Persona> LetturaPersone (int pagina) throws SQLException
	{
		String sql = "SELECT * FROM persona LIMIT " + (pagina) + ", 3" ;
		
		List<Persona> listaPersona = new ArrayList<Persona>();
		
		Connection conn = Connessione.getConnessione(); 
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet resset = ps.executeQuery();
		
		while (resset.next())
		{
			String nome = resset.getString("nome");
			String cognome = resset.getString("cognome");
			int eta = resset.getInt("eta");
			int id = resset.getInt("id");

			Persona p = new Persona(eta, nome, cognome);
			p.setId(id);
			listaPersona.add(p);
			
			System.out.println("ID: " + id);
			System.out.println("Nome: " + nome);
			System.out.println("Cognome: " + cognome);
			System.out.println("Età: " + eta + "\n");
		}
		return listaPersona;	
	}
	
	public void Modifica (Persona p, int id) throws SQLException
	{
		String sql = "UPDATE persona SET eta= " + p.getEta() + ", cognome='" + p.getCognome() + "', nome='" + p.getNome() + "' WHERE id = " + id;
		Connection conn = Connessione.getConnessione(); 
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.executeUpdate();
	}
/*	
	public List<Persona> Paginazione (int inizio,int totale)
	{
        List<Persona> persona = new ArrayList<Persona>();
		
		String sql = "SELECT * FROM persona LIMIT 0, 3"+(inizio-1)+","+(totale);

		try {
			Connection conn = Connessione.getConnessione(); 
			
			PreparedStatement ps = conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();  
	            while(rs.next())
	            {  
	                Persona p = new Persona();  
	                p.setEta(rs.getInt(1));  
	                p.setCognome(rs.getString(2));  
	                p.setNome(rs.getString(3));  
	                persona.add(p);  
	            }  
	            conn.close();  
	        }catch(Exception p){System.out.println(p);}  
		return persona;
	  } */

	}
