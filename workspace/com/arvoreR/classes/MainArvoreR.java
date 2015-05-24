package br.com.arvoreR.classes;

public class MainArvoreR {

	public static void main(String[] args) {
		//ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<Integer>();

		ArvoreR<Integer> arvore2 = new ArvoreR<Integer>();
		
		arvore2.inserir(10);
		arvore2.inserir(10);
		arvore2.inserir(25);
		arvore2.inserir(25);

		System.out.println(arvore2.getPai().getFilhoDireito().getHora());
		arvore2.inserir(5);
		arvore2.inserir(12);
		arvore2.inserir(11);
        arvore2.inserir(26);
        arvore2.inserir(6);
		arvore2.inserir(4);
		
		/*arvore2.PreFixo(arvore2.getPai());
		
		System.out.println();
		
		System.out.println(arvore2.ImprimirEmLargura());
	
		arvore2.remover(10);
		arvore2.remover(6);
		arvore2.remover(25);
		
		//System.out.println();
		*/
		System.out.println(arvore2.ImprimirEmLargura());
		
		
		
		arvore2.imprimir();
	}

}
