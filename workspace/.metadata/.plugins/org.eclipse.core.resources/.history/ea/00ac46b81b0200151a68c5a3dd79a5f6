package br.com.arvoreBinariaDeBusca;



public class CidadeVizinha implements Comparable<CidadeVizinha> {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + distancia;
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
		CidadeVizinha other = (CidadeVizinha) obj;
		if (distancia != other.distancia)
			return false;
		return true;
	}

	private String nome;
	private int distancia;

	public CidadeVizinha(String nome, int distancia) {
		this.nome = nome;
		this.distancia = distancia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int compareTo(CidadeVizinha c) {
		if (c.getDistancia() > distancia) {
			return 1;
		}
		if (c.getDistancia() < distancia) {
			return -1;
		}
		if (c.getDistancia() == distancia) {
			return c.getNome().compareTo(nome);
		}
		return 0;
	}

	@Override
	public String toString() {
		return "CidadeVizinha [ nome = " + nome + ", distancia = " + distancia + "]";
	}

}
