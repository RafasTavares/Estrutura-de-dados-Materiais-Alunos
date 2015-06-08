package Componentes;

public class CidadeVizinha implements Comparable<CidadeVizinha> {

	private String Nome;
	private int Distancia;

	public CidadeVizinha(String Nome, int Distancia) {
		this.Nome = Nome;
		this.Distancia = Distancia;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public int getDistancia() {
		return Distancia;
	}

	public void setDistancia(int Distancia) {
		this.Distancia = Distancia;
	}

	public int compareTo(CidadeVizinha C) {

		if (C.getDistancia() > Distancia) {
			return 1;
		}

		if (C.getDistancia() < Distancia) {
			return -1;

		}

		if (C.getDistancia() == Distancia) {

			return C.getNome().compareTo(Nome);
		}

		return 0;
	}
}
