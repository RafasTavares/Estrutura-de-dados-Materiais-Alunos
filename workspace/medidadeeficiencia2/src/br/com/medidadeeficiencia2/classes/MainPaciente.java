package br.com.medidadeeficiencia2.classes;

import java.util.Scanner;

import br.com.arvoreAVL.classes.ArvoreAVL;
import br.com.arvoreBinariaDeBusca.NoNovo;
import br.com.filadeprioridade.arvorebinariabusca.classes.FilaPrioridade;


public class MainPaciente {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opcao = -1;
		ArvoreAVL<Paciente> arvore = new ArvoreAVL<Paciente>();
		FilaPrioridade<Paciente> fila = new FilaPrioridade<Paciente>();
		int codigo = 0, riscoVida, idade;
		String nome;
		Paciente paciente = null;
		while (opcao != 4) {

			System.out.println("1 - Incluir");
			System.out.println("2 - Remover");
			System.out.println("3 - Listar");
			System.out.println("4 - Terminar");
			opcao = input.nextInt();
			input.nextLine();

			switch (opcao) {
			// Cadastro de cidades e cidades vizinhas
			case 1:
				int option = -1;
				System.out.println("Informe o código do paciente: ");
				codigo = input.nextInt();
				System.out.println("Informe o nome do paciente: ");
				nome = input.nextLine();
				input.nextLine();
				System.out.println("Informe o risco de vida do paciente: ");
				riscoVida = input.nextInt();
				System.out.println("Informe a idade do paciente: ");
				idade = input.nextInt();
				
				paciente = new Paciente(codigo, nome, riscoVida, idade);
				arvore.inserirBalanceado(paciente);
				fila.Inserir(paciente);
			
				System.out.println("\n");
				
				break;
			
			case 2:

				
				fila.Remover();
				
				System.out.println("Removido o que tem maior prioridade!");	
					
				break;

			case 3:
				
				
				if (fila.tamanho() == 0 || arvore.obterTodosEmLargura().size() == 0) {
					System.out.println("Lista vazia");
				} else {
					
					System.out.println(fila.toString2());
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
