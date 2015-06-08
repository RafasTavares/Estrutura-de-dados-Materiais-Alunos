package Componentes;

public class Cidade implements Comparable<Cidade> {

	private String Nome;
	private int Cep;
	private ArvoreBinBusca<CidadeVizinha> Vizinhas;
	
	public Cidade(String Nome, int Cep) {
		this.Nome = Nome;
		this.Cep = Cep;
		Vizinhas = new ArvoreBinBusca<CidadeVizinha>();
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public int getCep() {
		return Cep;
	}
	public void setCep(int cep) {
		this.Cep = cep;
	}
	public int compareTo(Cidade C) {
		
		if (C.getCep() > Cep) {
			return 1;			
		}
		
		if (C.getCep() < Cep) {
			return -1;			
		
		} 
		
		if (C.getCep() == Cep) {
			
			return C.getNome().compareTo(Nome);
		}
		
		return 0;
	}

}
