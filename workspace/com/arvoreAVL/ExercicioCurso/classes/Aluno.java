package br.com.arvoreAVL.ExercicioCurso.classes;


public class Aluno implements Comparable<Aluno> {

	private int CPF;
	private String nome;
	private short anoNascimento;
	private double percDesconto;
	
	public Aluno(int CPF, String nome, short anoNascimento){
		this.CPF = CPF;
		this.nome = nome;
		this.anoNascimento = anoNascimento;
	}

	public double getPercDesconto() {
		return percDesconto;
	}

	@Override
	public String toString() {
		return "Aluno [CPF=" + CPF + ", nome=" + nome + ", anoNascimento="
				+ anoNascimento + ", percDesconto=" + percDesconto + "]";
	}

	public void setPercDesconto(double percDesconto) {
		this.percDesconto = percDesconto;
	}

	public int getCPF() {
		return CPF;
	}

	public String getNome() {
		return nome;
	}

	public short getAnoNascimento() {
		return anoNascimento;
	}

	@Override
	public int compareTo(Aluno aluno) {
		return CPF - aluno.getCPF();
	}
	
	
	
}
