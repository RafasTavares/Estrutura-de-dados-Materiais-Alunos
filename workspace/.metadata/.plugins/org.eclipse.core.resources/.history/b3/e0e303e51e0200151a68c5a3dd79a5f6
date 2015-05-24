package br.com.arvoreBinariaDeBusca;



public class Cidade implements Comparable<Cidade> {

	private String nome;
	private final ArvoreBinariaBuscaNova<CidadeVizinha> vizinhas;// = new ArvoreBinariaBuscaNova<CidadeVizinha>();

	public Cidade(String nome) {
		this.nome = nome;
		vizinhas = new ArvoreBinariaBuscaNova<CidadeVizinha>();
	}

	
//	public Cidade(String nome, ArvoreBinariaBuscaNova<CidadeVizinha> vizinhas2) {
//		this.nome = nome;
//		vizinhas = vizinhas2;
//	}
//
//	public void setVizinhas(ArvoreBinariaBuscaNova<CidadeVizinha> vizinhas) {
//		this.vizinhas = vizinhas;
//	}

	public ArvoreBinariaBuscaNova<CidadeVizinha> getVizinhas() {
		return vizinhas;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		
	
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int compareTo(Cidade o) {
		if(o.nome.compareTo(nome) < 0){
			return -1;
		}else if(o.nome.compareTo(nome) > 0){
			return 1;
		}else if(o.nome.compareTo(nome) == 0){
			return o.getNome().compareTo(nome);
	}else{
		return 0;
	}
	}

	@Override
	public String toString() {
		return "Cidade [nome = " + nome + ", vizinhas = " + vizinhas.toString2() + "]";
	}
	

}
