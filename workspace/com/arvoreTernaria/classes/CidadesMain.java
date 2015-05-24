package br.com.arvoreTernaria.classes;

import java.util.Scanner;

public class CidadesMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String cidadesAux, lado, cidadeAnterior;
		//Cidade teste;
		ListaSimpEnc<String> outrasCidade = new ListaSimpEnc<String>();
		ListaSimpEnc<No> nosCidades = new ListaSimpEnc<No>();
		No aux, aux2, aux3;
		ArvoreTernaria<No> cidades = new ArvoreTernaria<No>();
		
		System.out.println("Informe a cidade inicial.");
		String cidadeInicial = input.nextLine();
		//Cidade cidade = new Cidade(cidadeInicial);
		
		//outrasc
		
		outrasCidade.InserirFim(cidadeInicial);
		aux = cidades.inserir(cidadeInicial, null, null);
		nosCidades.InserirFim(aux);
		
		System.out.println("Deseja inserir mais uma cidade?");
		String simOuNao = input.nextLine();
		
		while(!simOuNao.equalsIgnoreCase("nao")){
			
			System.out.println("Informe o nome da cidade que deseja inserir.");
			cidadesAux = input.nextLine();
			
			//cidade = new Cidade(cidadesAux);
			
			System.out.println("Informe qual a cidade será a cidade anterior.");
			cidadeAnterior = input.nextLine();
			
			//teste = new Cidade(cidadeAnterior);
			
			
			if(outrasCidade.contem(cidadeAnterior)){
			
			aux3 = cidades.buscarPrefixado(aux, cidadeAnterior);
				
			System.out.println("Informe onde deseja inserir, se na esquerda, ou meio, ou direita da cidade " );
			lado = input.nextLine();
			
			if(lado.equalsIgnoreCase("esquerda") || lado.equalsIgnoreCase("esquerdo")){
				aux2 = cidades.inserir(cidadesAux, aux3, Lado.Esquerdo);
				
			}else if(lado.equalsIgnoreCase("meio") || lado.equalsIgnoreCase("meia")){
				aux2 = cidades.inserir(cidadesAux, aux3, Lado.Meio);
				}else{
					aux2 = cidades.inserir(cidadesAux, aux3, Lado.Direito);
				}
			}
			System.out.println("Deseja inserir mais uma cidade?");
			simOuNao = input.nextLine();	
			
		}

		cidades.prefixado(aux);
		
	}

}
