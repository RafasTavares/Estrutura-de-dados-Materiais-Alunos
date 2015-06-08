package Componentes;

public class Cidade implements Comparable<Cidade> {

	private String Nome;
	private int Cep;
	
	public Cidade(String Nome, int Cep) {
		this.Nome = Nome;
		this.Cep = Cep;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getCep() {
		return Cep;
	}
	public void setCep(int cep) {
		Cep = cep;
	}
	public int compareTo(Cidade C) {
		
		if (C.getCep() > Cep) {
			return 1;			
		}
		
		if (C.getCep() < Cep) {
			return -1;			
		
		} else 	
		return 0;
	}

}
