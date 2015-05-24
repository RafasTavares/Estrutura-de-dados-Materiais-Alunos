package br.com.arvoreBinariaDeBusca;

public class No<T extends Comparable<T>> {

	private T elementoT;
	 Comparable elemento;
	 No pai;
	No filhoEsquerdo;
	 No filhoDireito;
	
	
	
	public No(Comparable elemento){
		this.elemento = elemento;
		this.pai = null;
		this.filhoEsquerdo = null;
		this.filhoDireito = null;
	}
	
	public No(Comparable elemento, No pai){
		this.elemento = elemento;
		this.pai = pai;
		this.filhoDireito = null;
		this.filhoEsquerdo = null;
	}
	
	public No(Comparable elemento, No pai, No filhoEsquerdo, No filhoDireito){
		this.elemento = elemento;
		this.pai = pai;
		this.filhoEsquerdo = filhoEsquerdo;
		this.filhoDireito = filhoDireito;
	}

	public Comparable getElemento() {
		return elemento;
	}

	public void setElemento(Comparable elemento) {
		this.elemento = elemento;
	}

	public No getPai() {
		return pai;
	}

	public void setPai(No pai) {
		this.pai = pai;
	}

	public No getFilhoEsquerdo() {
		return filhoEsquerdo;
	}

	public void setFilhoEsquerdo(No filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
	}

	public No getFilhoDireito() {
		return filhoDireito;
	}

	public void setFilhoDireito(No filhoDireito) {
		this.filhoDireito = filhoDireito;
	}
	
	public int compareTo(Comparable o) {
		return elemento.compareTo(o);
	}

	
}
