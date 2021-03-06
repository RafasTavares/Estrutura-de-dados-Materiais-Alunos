package Componentes;

public class NoArvoreBinBusca <T extends Comparable<T>> {
	
	private T Valor;
	private String Nome;	
	private int Nivel;
	private NoArvoreBinBusca<T> Pai;
	private NoArvoreBinBusca<T> Filho1, Filho2;
	
	public NoArvoreBinBusca(T Valor) {
		this.Valor = Valor;
	}
	
	public T getValor() {
		return Valor;
	}
	
	public void setValor(T valor) {
		Valor = valor;
	}
	
	public NoArvoreBinBusca<T> getPai() {
		return Pai;
	}
	
	public void setPai(NoArvoreBinBusca<T> pai) {
		Pai = pai;
	}
	
	public NoArvoreBinBusca<T> getFilho1() {
		return Filho1;
	}
	
	public int getNivel() {
		return Nivel;
	}

	public void setNivel(int nivel) {
		Nivel = nivel;
	}

	public void setFilho1(NoArvoreBinBusca<T> filho1) {
		Filho1 = filho1;
	}
	
	public NoArvoreBinBusca<T> getFilho2() {
		return Filho2;
	}
	
	public void setFilho2(NoArvoreBinBusca<T> filho2) {
		Filho2 = filho2;
	}
	

}
