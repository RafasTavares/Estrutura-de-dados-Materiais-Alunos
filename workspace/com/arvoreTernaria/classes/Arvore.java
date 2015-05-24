package br.com.arvoreTernaria.classes;

public interface Arvore {
	
	public No inserir(Object valor, No pai, Lado lado);

	  public No obterRaiz();

	  public No obterFilho(No pai, Lado lado);

	  public No removerNo(No no);

	  public No removerFilho(No pai, Lado lado);


}
