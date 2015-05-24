package br.com.arvoreBinariaDeBusca;

public class PessoaMain {

	public static void main(String[] args) {
		
		ArvoreBinariaBusca<Pessoa> arvore = new ArvoreBinariaBusca<Pessoa>();
		
		Pessoa pessoa1 = new Pessoa(1, "Victor");
		Pessoa pessoa2 = new Pessoa(2, "Lucas");

		arvore.inserir(pessoa1.getCpf());
		arvore.inserir(pessoa2.getCpf());
		
		
		
	}

}
