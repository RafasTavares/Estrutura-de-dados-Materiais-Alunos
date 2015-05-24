package br.com.arvoreR.classes;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.TreeMap;

import br.com.arvoreBinariaDeBusca.ArvoreBinariaBuscaNova;
import br.com.arvoreBinariaDeBusca.Cidade;
import br.com.arvoreBinariaDeBusca.CidadeVizinha;

public class MainFuncionario {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		ArvoreR<Funcionario> abb = new ArvoreR<Funcionario>();
		int opcao = -1;
		String nome = "";
		int matricula = 0;
		Long hora = System.currentTimeMillis();
		String data = null;
		Long hora2 = System.currentTimeMillis();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyy hh:mm:ss");
		String dateToStr = format.format(hora2);
		Funcionario funcionario = null;
		boolean entradaSaida;
		
		while (opcao != 4) {

			System.out.println("1 - Inserir Funcionario");
			System.out.println("2 - Entrar na área restrita");
			System.out.println("3 - Remover histórico acesso!");
			System.out.println("3 - Listar Cidades");
			System.out.println("4 - Sair");
			opcao = input.nextInt();
			input.nextLine();

			switch (opcao) {
			// Cadastro de cidades e cidades vizinhas
			case 1:
				int option = -1;
				System.out.println("Informe o nome do funcionario: ");
				nome = input.nextLine();
				System.out.println("Informe a matricula dele: ");
				matricula = input.nextInt();
				funcionario = new Funcionario(nome, matricula);
				abb.inserir(funcionario);
				System.out.println("Adicionado com Sucesso");
			
				break;
			
			case 2:

				
				System.out.println("Informe o nome do funcionario que quer entrar na área restrita!");
				nome = input.nextLine();
				funcionario = new Funcionario(nome);
				
				Funcionario aux = abb.buscar2(funcionario);
				
				if(!aux.entradaSaida){
				
				aux.setEntradaSaida(true);
				
				aux.setHora(hora);
				
				
				aux.setData(dateToStr);
				
				System.out.println("A hora do acesso foi " +aux.getHora() + " e a data foi " +aux.getData());
				
				}
				else{
					System.out.println("Já está na área restrita!");
				}
					
					
				break;

			case 3:

				
				System.out.println("Informe o nome do funcionário que você deseja remover o histórico!");
				nome = input.nextLine();
				
				System.out.println("Informe a matrícula dele: ");
				matricula = input.nextInt();


                funcionario = new Funcionario(nome, matricula);
				
				Funcionario aux2 = abb.buscar2(funcionario);
				
				aux2.setData(null);
				aux2.data = null;
				aux2.setHora(null);
				aux2.hora = null;
				
				break;
				
			case 4:
				
				
				if (abb.getRaiz() == null) {
					System.out.println("Arvore Vazia! Impossivel fazer a impressão!");
				} else {
					
					System.out.println(abb.toString2());
				}
				break;
			case 5:
				
				
				System.out.println("Programa finalizado com sucesso!");
				break;

			default:
				System.out.println("Opção inválida!!");
				break;					
			}
		}

	}

}
