package br.com.arvoreBinariaDeBusca;

public class Pessoa implements Comparable<Pessoa> {

	public int cpf;
	private String nome;
	public Pessoa(int cpf, String nome) {
		
		this.cpf = cpf;
		this.nome = nome;
	}
	public Pessoa(int cpf2) {
		this.cpf = cpf2;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int compareTo(Pessoa o) {
		
		return cpf - o.getCpf();
	}
	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + "]";
	}
	
	

	
	
}
