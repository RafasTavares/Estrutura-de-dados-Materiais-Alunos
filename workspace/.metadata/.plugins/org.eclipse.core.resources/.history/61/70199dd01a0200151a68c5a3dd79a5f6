package br.com.arvoreAVL.classes;

public class No<T extends Comparable<T>> {
	
	public No<T> filhoEsquerdo;
	public No<T> filhoDireito;
	private No<T> pai;
	private int Balanceamento;
	public T elemento;

	public No(T elemento) {
		this.filhoDireito = null;
		this.filhoEsquerdo = null;
		this.pai = null;
		this.Balanceamento = 0;
		this.elemento = elemento;
	}
 
	public String toString(T t) {
		return toString(t);
	}
 
	public T getElemento() {
		return elemento;
	}
 
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
 
	public int getBalanceamento() {
		return Balanceamento;
	}
 
	public void setBalanceamento(int Balanceamento) {
		this.Balanceamento = Balanceamento;
	}
 
	public No<T> getPai() {
		return pai;
	}
 
	public No<T> setPai(No<T> pai) {
		this.pai = pai;
		return pai;
	}
 
	public No<T> getFilhoDireito() {
		return filhoDireito;
	}
 
	public No<T> setFilhoDireito(No<T> filhoDireito) {
		this.filhoDireito = filhoDireito;
		return filhoDireito;
	}
 
	public No<T> getFilhoEsquerdo() {
		return filhoEsquerdo;
	}
 
	public void setFilhoEsquerdo(No<T> filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
	}
	public int compareTo(T o) {
		return elemento.compareTo( o);
	}
}
