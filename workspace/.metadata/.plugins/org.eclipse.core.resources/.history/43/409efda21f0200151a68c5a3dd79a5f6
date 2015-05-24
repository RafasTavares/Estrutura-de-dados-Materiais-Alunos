package br.com.heap.heapminimo.classes;

import java.util.ArrayList;
import java.util.Collection;

public class HeapBinarioMinimo <T extends Comparable<T>> {
	
		private T heap[];
		private int qtdElementosHeap;
		private int tamanho;

		public HeapBinarioMinimo(int tamanho) {
			this.tamanho = tamanho;
			heap =  (T[]) new Comparable[tamanho];
			qtdElementosHeap = 0;
		}

		public void inserir(T valor) {
			heap[qtdElementosHeap] = valor;
			int atual = qtdElementosHeap;
			qtdElementosHeap++;
			while (heap[atual].compareTo(heap[indicePai(atual)]) < 0) {
				BorbulharPraCima(atual, indicePai(atual));
				atual = indicePai(atual);
			}
			Redimensionar();
		}

		private void Redimensionar() {
			if (qtdElementosHeap == heap.length) {
				T[] vet = (T[]) new Comparable[this.tamanho + 10];
				for (int i = 0; i < qtdElementosHeap; i++) {
					vet[i] = heap[i];
				}
				heap = vet;
			}
		}

		public void remover() {
			System.out.println("Valor minimo - " + heap[0]);
			heap[0] = heap[qtdElementosHeap - 1];
			heap[qtdElementosHeap - 1] = null;
			qtdElementosHeap--;
			BorbulharParaBaixo(0);
		}

		public int tamanho() {
			return qtdElementosHeap;
		}

		public boolean vazio() {
			return qtdElementosHeap == 0;
		}

		private void BorbulharParaBaixo(int pos) {
			if (!folha(pos)) {
				if (heap[pos].compareTo(heap[indiceEsquerda(pos)]) > 0
						|| heap[pos].compareTo(heap[indiceDireita(pos)]) > 0) {
					if (heap[indiceEsquerda(pos)].compareTo(heap[indiceDireita(pos)]) < 0) {
						BorbulharPraCima(pos, indiceEsquerda(pos));
						BorbulharParaBaixo(indiceEsquerda(pos));
					} else {
						BorbulharPraCima(pos, indiceDireita(pos));
						BorbulharParaBaixo(indiceDireita(pos));
					}
				}
			}
		}

		private int indicePai(int pos) {
			return pos / 2;
		}

		private int indiceEsquerda(int pos) {
			return (2 * pos);
		}

		private int indiceDireita(int pos) {
			return (2 * pos) + 1;
		}

		private boolean folha(int pos) {
			if (pos >= (qtdElementosHeap / 2) && pos <= qtdElementosHeap) {
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

		public String toString() {
			String str = "[";
			int i = 0;
			for (i = 0; i < qtdElementosHeap - 1; i++) {
				str += heap[i] + ", ";
			}
			str += heap[i] + "]";
			return str;
		}

		public void print(){
			for (int i = 0; i < qtdElementosHeap / 2; i++) {
				System.out.print(" PAI : " + heap[i] + " FILHO ESQUERDO : "
						+ heap[2 * i] + " FILHO DIREITO :" + heap[2 * i + 1]);
				System.out.println();
			}
		}
		
		public HeapBinarioMinimo<T> Sort(HeapBinarioMinimo<T> heapAux){
			ArrayList<T> lista = new ArrayList<T>();
			for (int i = 0; i < heapAux.tamanho(); i++) {
			lista.add(heapAux.heap[i]);
			heapAux.remover();
			}
			for (int i = 0; i < lista.size(); i++) {
				heapAux.inserir(lista.get(i));
			}
			return heapAux;
		}
	}

