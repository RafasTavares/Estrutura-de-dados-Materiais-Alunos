package br.com.arvoreTernaria.classes;

public class NoSimpEnc<T> {
	
	private NoSimpEnc<T> proximo;
	public T elemento;
	
	public NoSimpEnc(NoSimpEnc<T> proximo, T elemento){
		this.elemento = elemento;
		this.proximo = proximo;
	}
	
	public NoSimpEnc(T elemento){
		this.proximo = null;
		this.elemento = elemento;
	}
	
	public T getElemento() {
		return elemento;
	}
	
	public NoSimpEnc<T> getProximo() {
		return proximo;
	}
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	
	public void setProximo(NoSimpEnc<T> proximo) {
		this.proximo = proximo;
	}

}
