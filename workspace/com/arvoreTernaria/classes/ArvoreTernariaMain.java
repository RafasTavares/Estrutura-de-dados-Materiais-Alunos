package br.com.arvoreTernaria.classes;

public class ArvoreTernariaMain {

	public static void main(String[] args) {
		ArvoreTernaria<Integer> arvore = new ArvoreTernaria<Integer>();
		Lado direito = Lado.Direito;
		
		
		
		No pai = arvore.inserir(11, null, Lado.Esquerdo);
		
		
		
		
		/*No filhoEsquerdo = arvore.inserir(300, pai, Lado.Esquerdo);
		No filhoDireito = arvore.inserir(10, pai, direito);
		No filhoMeioPAIDireito = arvore.inserir(24, filhoDireito, Lado.Meio);
		No MeioSubstitutoMeio = arvore.inserir(500, pai, Lado.Meio);
		No filhoMeioSubstitutoMeioEsquerda = arvore.inserir(1000, MeioSubstitutoMeio, Lado.Esquerdo);
		No filhoMeio = arvore.inserir(100, pai, Lado.Meio);
		No filhoMeioMeio = arvore.inserir(79, filhoMeio, Lado.Meio);
		No filhoMeioDireito = arvore.inserir(86, filhoMeio, Lado.Direito);
		No filhoMeioDireitoMeio = arvore.inserir(87, filhoMeioDireito, Lado.Direito);*/
		
		No esquerdo = arvore.inserir(12, pai, Lado.Esquerdo);
		No meio = arvore.inserir(14, pai, Lado.Meio);
		No direita = arvore.inserir(15, pai, Lado.Direito);
		No substitutoEsquerdo = arvore.inserir(16, pai, Lado.Esquerdo);
		
		//System.out.println(arvore.buscar(12));
		
		System.out.println(arvore.obterRaiz().getEsquerda().getElemento());
		
		
		arvore.prefixado(pai);
		
		System.out.println();
		
		System.out.println(arvore.buscarPrefixado(pai, 12));
		
		//arvore.removerNo(substitutoEsquerdo);
		
		arvore.prefixado(pai);
		
		//System.out.println(arvore.toString());
		
		//System.out.println();
		
		//System.out.println(arvore.obterRaiz());
		
		System.out.println();

		//System.out.println(arvore.ImprimirPreOrdemLista(pai));
		
		//System.out.println(arvore.Buscar(10));
	}

}
