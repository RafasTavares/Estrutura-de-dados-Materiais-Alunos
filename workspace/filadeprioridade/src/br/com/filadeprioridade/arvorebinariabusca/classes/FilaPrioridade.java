package br.com.filadeprioridade.arvorebinariabusca.classes;

import br.com.arvoreBinariaDeBusca.ArvoreBinariaBuscaNova;

public class FilaPrioridade<T extends Comparable<T>> {

	ArvoreBinariaBuscaNova<T> arvore;

	public FilaPrioridade() {
		arvore = new ArvoreBinariaBuscaNova<T>();
	}

	public void Inserir(T elemento) {
		arvore.inserir(elemento);
	}

	public void Remover() {
		arvore.RemoverMaior();
	}

	public void RetornarMaior() {
		arvore.getMaior();
	}

	public String toString2() {
		return arvore.imprimir();
	}

	public String PrintPrioridade() {
		return arvore.ImprimirMaiorPrioridade();
	}

	public String toString() {
		return arvore.toString2();
	}

	public int tamanho() {
		return this.arvore.tamanho();
	}

	public boolean ehVazio() {
		return this.arvore.ehVazio();
	}

}
