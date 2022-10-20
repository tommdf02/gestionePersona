package model;

public class Persona {

	private int id;
	private int eta;
	private String nome;
	private String cognome;
	
	
	public Persona(int eta, String nome, String cognome) {
		super();
		this.eta = eta;
		this.nome = nome;
		this.cognome = cognome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Persona() {
		// TODO Auto-generated constructor stub
	}


	public int getEta() 
	{
		return eta;
	}
	public void setEta(int eta) 
	{
		this.eta = eta;
	}
	
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	
	public String getCognome() 
	{
		return cognome;
	}

	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}

}


