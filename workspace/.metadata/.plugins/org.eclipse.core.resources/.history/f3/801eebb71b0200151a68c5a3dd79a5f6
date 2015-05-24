package br.com.arvoreBinariaDeBusca;



import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;


public class MainCidade {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArvoreBinariaBuscaNova<Cidade> abb = new ArvoreBinariaBuscaNova<Cidade>();
		ArvoreBinariaBuscaNova<CidadeVizinha> abbvizinha;// = new ArvoreBinariaBuscaNova<CidadeVizinha>();
		TreeMap<Integer, CidadeVizinha> listaCidadesVizinhas = new TreeMap<Integer, CidadeVizinha>();
		TreeMap<String, Cidade> listaCidades = new TreeMap<String, Cidade>();
		int opcao = -1;
		String nome = "";
		String vizinha = "";
		int dist = 0;
		Cidade cidade = null;
		CidadeVizinha cidadeVizinha = null;

		while (opcao != 4) {

			System.out.println("1 - Inserir Cidade");
			System.out.println("2 - Inserir Cidade Vizinha");
			System.out.println("3 - Listar Cidades");
			System.out.println("4 - Sair");
			opcao = input.nextInt();
			input.nextLine();

			switch (opcao) {
			// Cadastro de cidades e cidades vizinhas
			case 1:
				int option = -1;
				System.out.println("Informe o nome da cidade: ");
				nome = input.nextLine();
				cidade = new Cidade(nome);
				abb.inserir(cidade);
				System.out.println("Adicionado com Sucesso");
			
				break;
			
			case 2:

				
				System.out.println("Informe o nome da cidade que você deseja que tenha cidade vizinha!");
				nome = input.nextLine();
				cidade = new Cidade(nome);
				
				Cidade aux = abb.buscar2(cidade);
					
					System.out.println("Informe o nome da cidade vizinha!");
					vizinha = input.nextLine();
					System.out.println("Informe a distancia entre as cidades!");
					dist = input.nextInt();
				
					abbvizinha = aux.getVizinhas();
					cidadeVizinha = new CidadeVizinha(vizinha, dist);
					abbvizinha.inserir(cidadeVizinha);
					//aux.setVizinhas(abbvizinha);
					
					
				break;

			case 3:
				
				
				if (abb.getpai() == null) {
					System.out.println("Arvore Vazia! Impossivel fazer a impressão!");
				} else {
					
					System.out.println(abb.toString2());
				}
				break;
			case 4:
				
				
				System.out.println("Programa finalizado com sucesso!");
				break;

			default:
				System.out.println("Opção inválida!!");
				break;					
			}
		}
			
	}
}
