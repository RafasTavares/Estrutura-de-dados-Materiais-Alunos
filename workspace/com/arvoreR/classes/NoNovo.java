package br.com.arvoreR.classes;

public class NoNovo<T extends Comparable<T>> {

	
	public NoNovo<T> filhoEsquerdo;
	public NoNovo<Long> hora;
	public NoNovo<T> filhoDireito;
	public NoNovo<T> pai;
	public T elemento;

	public NoNovo(T elemento ){
		
		this.filhoEsquerdo = null;
		this.filhoDireito = null;
		this.pai = null;
		this.elemento = elemento;
	}
	
	public NoNovo(T elemento, NoNovo<T> pai , NoNovo<T> filhoEsquerdo, NoNovo<T> filhoDireito){
		this.elemento = elemento;
		this.filhoEsquerdo = filhoEsquerdo;
		this.filhoDireito = filhoDireito;
		this.pai = pai ;
	}
	
	
	
	
	
	

	public NoNovo<Long> getHora() {
		return hora;
	}

	public void setHora(NoNovo<Long> hora) {
		this.hora = hora;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public NoNovo<T> getFilhoEsquerdo() {
		return filhoEsquerdo;
	}

	public void setFilhoEsquerdo(NoNovo<T> filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
	}

	public NoNovo<T> getFilhoDireito() {
		return filhoDireito;
	}

	public void setFilhoDireito(NoNovo<T> filhoDireito) {
		this.filhoDireito = filhoDireito;
	}

	public NoNovo<T> getPai() {
		return pai;
	}

	public void setPai(NoNovo<T> pai) {
		this.pai = pai;
	}


	
}
