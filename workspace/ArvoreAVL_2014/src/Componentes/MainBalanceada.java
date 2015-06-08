package Componentes;

import java.util.ArrayList;

public class MainBalanceada {

	public static void main(String[] args) {
			
			ArvoreAVL<Integer> ArvoreTeste = new ArvoreAVL<Integer>();
			
			ArvoreTeste.inserir(1);
			ArvoreTeste.inserir(2);
			ArvoreTeste.inserir(3);
			ArvoreTeste.inserir(4);
			ArvoreTeste.inserir(5);
			ArvoreTeste.inserir(6);
			
			ArrayList<Integer> ArvoreImpressa;
			ArvoreImpressa = (ArrayList)ArvoreTeste.emLargura();
			System.out.println(ArvoreImpressa);
			
			ArvoreTeste.balancearArvore();
			ArvoreImpressa = (ArrayList)ArvoreTeste.emLargura();
			System.out.println(ArvoreImpressa);
	}

}
