package br.com.heap.heapmaximo.classes;

import java.util.LinkedList;

/*
 * 1. Desenhe todos os passos para criar um heap binário considerando a seguinte ordem de inserção: 26, 31, 98, 15, 30, 84, 51, 27, 65, 29, 71
 2. Considerando o heap anterior, remova sucessivamente o elemento de maior prioridade
 3. Refaça os exercícios 1 e 2 utilizando lista (ordenada e não ordenada) e árvore AVL
 */

public class MainHeapMax {
	public static void main(String[] args) {
		HeapBinarioMaximo<Integer> heap = new HeapBinarioMaximo<Integer>(30);
		heap.inserir(26);
		heap.inserir(31);
		heap.inserir(98);
		heap.inserir(15);
		heap.inserir(30);
		heap.inserir(84);
		heap.inserir(51);
		heap.inserir(27);
		heap.inserir(65);
		heap.inserir(29);
		heap.inserir(71);
		// heap.remover();
		// heap.remover();
		// heap.remover();
		// heap.remover();
		// heap.remover();
		// heap.remover();
		// heap.remover();
		// heap.remover();
		// heap.remover();
		// heap.remover();
		System.out.println(heap.toString());
		heap.print();
		
		LinkedList<Integer> lista = new LinkedList<Integer>();
		
		lista.add(10);
		lista.add(5);
		lista.add(50);
		
		System.out.println(heap.HeapSort(lista));

		/*while(heap.tamanho() > 0){
			heap.remover();
		}
		
		//System.out.println(heap.Sort(heap));
	*/
	}
}
