package br.com.arvoreBinariaDeBusca;

import java.util.LinkedList;

public class PessoaMetodos {
	
	private ArvoreBinariaBusca<Pessoa> arvore;
	private Pessoa pessoa;
	
	public PessoaMetodos(Pessoa pessoa){
		pessoa = pessoa;
		arvore = new ArvoreBinariaBusca<Pessoa>();
	}
	
	public PessoaMetodos(){
		arvore = new ArvoreBinariaBusca<Pessoa>();	
	}
	
	public String BuscarPessoa(int cpf){
		Pessoa aux = null;
		aux.cpf = cpf;
		if(arvore.buscar(aux.getCpf())){
			return aux.getNome();
		}else
		return null;
	}
	
	public void InserirPessoa(Pessoa pessoa){
		if(!arvore.buscar(pessoa.getCpf())){
			arvore.inserir(pessoa.getCpf());
		}
		
	}
	
	public boolean RemoverPessoa(Pessoa pessoa){
		if(arvore.Contem(pessoa.getCpf())){
			arvore.remover(pessoa.getCpf());
			return true;
		}else
		return false;
	}
	
	public LinkedList<Comparable> ListarTodosEmOrdem(){
		LinkedList<Comparable> novaArvore;
		novaArvore = arvore.listaEmOrdem;
		if(novaArvore.size() == 0){
			return null;
		}else
		return novaArvore;
		
	}

}
