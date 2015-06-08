package br.com.filadeprioridade.arvorebinariabusca.classes;

public class main {

	public static void main(String[] args) {

		FilaPrioridade<Integer> fila = new FilaPrioridade<Integer>();

		fila.Inserir(11);
		fila.Inserir(1);
		fila.Inserir(2);
		fila.Inserir(14);
		fila.Inserir(43);
		fila.Inserir(44);
		fila.Inserir(12);

		// System.out.println("Tamanho: " + fila.tamanho());
		// System.out.println("To String 2: " + fila.toString2());
		String a = "";
		System.out.println("Prioridade: " + fila.PrintPrioridade());

		// System.out.println(fila.toString());
		
		/*
		 * lista nao ordenada - inclusao - no final
		 * 						remocao - a partir da busca sequencial
		 * 
		 * lista ordenada - inclusao - da maneira correta para manter a lista ordenada
		 * 					remocao - ultimo da lista
		 * 
		 * AB Busca - inclusao - normal na arvore
		 * 			  remocao - pegando o elemento mais a direita da arvore
		 * 
		 * heap binario, mais eficiente
		 *    arvore completa
		 * */

	}

}
