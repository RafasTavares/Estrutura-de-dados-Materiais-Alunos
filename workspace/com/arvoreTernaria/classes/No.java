package br.com.arvoreTernaria.classes;

public class No<T> {

	private No<Object> pai;
	private No<Object> direita;
	private No<Object> esquerda;
	private No<Object> meio;
	public Object elemento;
	private boolean visitado = true;
	
	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public No(Object elemento, No<Object> pai, No<Object> direita, No<Object> esquerda, No<Object> meio){
		this.direita = direita;
		this.elemento = elemento;
		this.esquerda = esquerda;
		this.pai = pai;
		this.meio = meio;
	}
	
	public No(Object elemento){
		this.elemento = elemento;
		this.direita = null;
		this.esquerda = null;
		this.meio = null;
		this.pai = null;
	}
	
	public No(Object elemento, No<Object> pai ){
		this.pai = pai;
		this.elemento = elemento;
		this.direita = null;
		this.esquerda = null;
		this.meio = null;
	}
	
	public No<Object> getPai() {
		return pai;
	}

	public void setPai(No<Object> pai) {
		this.pai = pai;
	}

	public No<Object> getDireita() {
		return direita;
	}

	public void setDireita(No<Object> direita) {
		this.direita = direita;
	}

	public No<Object> getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No<Object> esquerda) {
		this.esquerda = esquerda;
	}

	public No<Object> getMeio() {
		return meio;
	}

	public void setMeio(No<Object> meio) {
		this.meio = meio;
	}

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

	

}
