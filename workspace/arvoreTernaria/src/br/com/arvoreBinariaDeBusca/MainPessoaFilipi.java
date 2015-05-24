package br.com.arvoreBinariaDeBusca;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class MainPessoaFilipi {

	public static void main(String[] args) {
		ArvoreBinariaBuscaNova<Pessoa> ap = new ArvoreBinariaBuscaNova<Pessoa>();
		TreeMap<Integer, Pessoa> listaMap = new TreeMap<Integer, Pessoa>();
		int Escolha = -1;
		Scanner Leitor = new Scanner(System.in);

		while (Escolha < 4) {
			System.out.println("\n1- Adicionar Pessoa");
			System.out.println("2- Remover Pessoa");
			System.out.println("3- Listar");
			System.out.println("4- Sair\n");
			Escolha = Leitor.nextInt();

			Leitor.nextLine();
			switch (Escolha) {
			case 1:
				System.out.println("\nInforme o nome da Pessoa: ");
				String Nome = Leitor.nextLine();
				System.out.println("\nInforme o CPF: ");
				int Cpf = Leitor.nextInt();

				Pessoa temp = new Pessoa(Cpf, Nome);
				ap.inserir(temp);
				listaMap.put(Cpf, temp);

				break;

			case 2:

				System.out.println("\nInforme o CPF: ");
				int Cpf2 = Leitor.nextInt();
				Pessoa temp2 = new Pessoa(Cpf2);
				
				

				ap.remover(temp2);

				break;
			case 3:
				System.out.println("Pessoas cadastradas: ");
				//System.out.println(listaMap.toString());
				System.out.println(ap.toString2());

				break;
			case 4:
				System.out.println("Programa encerrado!!!");
				break;
			}

		}

	}

}
