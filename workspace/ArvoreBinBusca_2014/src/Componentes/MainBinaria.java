package Componentes;

import java.util.ArrayList;

public class MainBinaria {

	public static void main(String[] args) {
	
		ArvoreBinBusca<Integer> ArvoreTeste = new ArvoreBinBusca<Integer>();
		
		ArvoreTeste.remover(28);
		
		ArvoreTeste.inserir(16);
		ArvoreTeste.inserir(8);
		ArvoreTeste.inserir(32);
		ArvoreTeste.inserir(4);
		ArvoreTeste.inserir(2);
		ArvoreTeste.inserir(11);
		ArvoreTeste.inserir(9);
		ArvoreTeste.inserir(24);
		ArvoreTeste.inserir(48);
		ArvoreTeste.inserir(20);
		ArvoreTeste.inserir(27);
		ArvoreTeste.inserir(17);
		ArvoreTeste.inserir(25);
		ArvoreTeste.inserir(26);
		ArvoreTeste.inserir(29);
		ArvoreTeste.inserir(30);
		
		ArrayList<Integer> ArvoreImpressa;
		ArvoreImpressa = (ArrayList)ArvoreTeste.emLargura();
		System.out.println(ArvoreImpressa);
		
		ArvoreTeste.balancearArvore();
		ArvoreImpressa = (ArrayList)ArvoreTeste.emLargura();
		System.out.println(ArvoreImpressa);
		
//		System.out.println(ArvoreTeste.remover(8));
//		System.out.println(ArvoreTeste.remover(32));
//		System.out.println(ArvoreTeste.remover(16));
//		ArvoreTeste.limpar();
//		System.out.println(ArvoreTeste.getRaiz());
		
	}

}
