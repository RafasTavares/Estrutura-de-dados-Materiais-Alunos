package br.com.medidadeeficiencia2.classes;


public class Paciente implements Comparable<Paciente> {

	private int codigo;
	private String nome;
	private int riscoVida;
	private int idade;
	
	public Paciente(int codigo, String nome, int riscoVida, int idade){
		this.idade = idade;
		this.riscoVida = riscoVida;
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public Paciente(int codigo){
		this.codigo = codigo;
	}
	public Paciente(int codigo, String nome){
		this.codigo = codigo;
		this.nome = nome;
	}
	public Paciente(String nome){
		this.nome = nome;
	}
	public Paciente(int codigo, String nome, int idade){
		this.codigo = codigo;
		this.nome = nome;
		this.idade = idade;
	}

	public int getRiscoVida() {
		return riscoVida;
	}

	public void setRiscoVida(int riscoVida) {
		this.riscoVida = riscoVida;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
	
	public int compareTo(Paciente o) {
		if(riscoVida == o.getRiscoVida()){
			return codigo - o.getCodigo();
		}
		return riscoVida - o.getRiscoVida();
	}

	@Override
	public String toString() {
		return "Paciente [codigo=" + codigo + ", nome=" + nome + ", riscoVida="
				+ riscoVida + ", idade=" + idade + "]";
	}
	
	
}
