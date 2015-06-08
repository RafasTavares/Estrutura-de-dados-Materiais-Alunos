package Componentes;

import java.util.Scanner;

public class MainCidades {

	public static void main(String[] args) {
		
		ArvoreBinBusca<Cidade> ArvoreCidades = new ArvoreBinBusca<Cidade>(); 
		int Escolha = -1;
		Scanner Leitor = new Scanner(System.in);
		
	    while (Escolha < 4) {
	    	
	    	System.out.println("\n1 - Adicionar Cidade");
	    	System.out.println("2 - Adicionar Cidade Vizinha");
	    	System.out.println("3 - Listar");
	    	System.out.println("4 - Sair\n");
	    	Escolha = Leitor.nextInt();
	    	Leitor.nextLine();
	    	
	    	switch (Escolha) {
	    	
	    	case 1:
	    		System.out.println("\nInforme o nome da cidade: ");
	    		String Nome = Leitor.nextLine();
	    		System.out.println("\nInforme o CEP da cidade: ");
	    		int Cep = Leitor.nextInt();
	    		Leitor.nextLine();
	    		Cidade Temp = new Cidade(Nome, Cep);
	    		ArvoreCidades.inserir(Temp);	    		
	    		break;
	    		
	    	case 2:
	    		break;
	    	case 3:
	    		break;
	    	}
	    }
    }
}
