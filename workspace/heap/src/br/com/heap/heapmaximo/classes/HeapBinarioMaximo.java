package br.com.heap.heapmaximo.classes;

import java.util.ArrayList;
import java.util.LinkedList;


public class HeapBinarioMaximo<T extends Comparable<T>> {
	private T heap[];
	private int qtdElementos;
	private int tamanho;

	public HeapBinarioMaximo(int tamanho) {
		this.tamanho = tamanho;
		heap = (T[]) new Comparable[tamanho];
		qtdElementos = 0;
	}

	public void inserir(T element) {
		heap[qtdElementos] = element;
		int atual = qtdElementos;
		qtdElementos++;
		while (heap[atual].compareTo(heap[indicePai(atual)]) > 0) {
			BorbulharPraCima(atual, indicePai(atual));
			atual = indicePai(atual);
		}
		Redimensionar();
	}

	public void remover() {
		System.out.println("Valor maximo - " + heap[0]);
		heap[0] = heap[qtdElementos - 1];
		heap[qtdElementos - 1] = null;
		qtdElementos--;
		BorbulharPraBaixo(0);
	}

	private void Redimensionar() {
		if (qtdElementos == heap.length) {
			T[] vet = (T[]) new Comparable[this.tamanho + 10];
			for (int i = 0; i < qtdElementos; i++) {
				vet[i] = heap[i];
			}
			heap = vet;
		}
	}

	private int indicePai(int pos) {
		return pos / 2;
	}

	private int indiceEsq(int pos) {
		return (2 * pos);
	}

	private int indiceDir(int pos) {
		return (2 * pos) + 1;
	}

	private boolean folha(int pos) {
		if (pos >= (qtdElementos / 2) && pos <= qtdElementos) {
			return true;
		}
		return false;
	}

	private void BorbulharPraCima(int fpos, int spos) {
		T tmp;
		tmp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = tmp;
	}

	private void BorbulharPraBaixo(int pos) {
		if (!folha(pos)) {
			if (heap[pos].compareTo(heap[indiceEsq(pos)]) < 0
					|| heap[pos].compareTo(heap[indiceDir(pos)]) < 0) {
				if (heap[indiceEsq(pos)].compareTo(heap[indiceDir(pos)]) > 0) {
					BorbulharPraCima(pos, indiceEsq(pos));
					BorbulharPraBaixo(indiceEsq(pos));
				} else {
					BorbulharPraCima(pos, indiceDir(pos));
					BorbulharPraBaixo(indiceDir(pos));
				}
			}
		}
	}
	
	public String toString() {
		String str = "[";
		int i = 0;
		for (i = 0; i < qtdElementos - 1; i++) {
			str += heap[i] + ", ";
		}
		str += heap[i] + "]";
		return str;
	}

	public void print() {
		for (int i = 0; i <= qtdElementos / 2; i++) {
			//System.out.print(" PAI : " + heap[i] + " FILHO ESQUERDO : "+ heap[2 * i] + " FILHO DIREITO :" + heap[2 * i + 1]);
			System.out.println();
		}
	}
	
	public int tamanho() {
		return qtdElementos;
	}
	
	public HeapBinarioMaximo<T> RemoveAll(HeapBinarioMaximo<T> heapAux){
		for (int i = 0; i <= qtdElementos - 1; i++) {
			heapAux.remover();
		}
		return heapAux;
	}
	
	public HeapBinarioMaximo<T> HeapSort(LinkedList<T> lista){
		HeapBinarioMaximo<T> aux = new HeapBinarioMaximo<T>(lista.size());
		
		for (int i = 0; i < lista.size(); i++) {
			aux.inserir(lista.get(i));
		}
		return aux;
	}
	
	public HeapBinarioMaximo<T> Sort(HeapBinarioMaximo<T> heapAux){
		HeapBinarioMaximo<T> aux = new HeapBinarioMaximo<T>(qtdElementos);
		LinkedList<T> lista = new LinkedList<T>();
		for (int i = 0; i <= qtdElementos - 1 ; i++) {
		lista.add(heapAux.heap[i]);
		}
		this.RemoveAll(heapAux);
		for (int i = 0; i < lista.size() - 1 ; i++) {
			aux.inserir(lista.get(i));
		}
		return aux;
	}
}
