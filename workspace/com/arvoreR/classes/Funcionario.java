package br.com.arvoreR.classes;

import java.util.ArrayList;

import br.com.arvoreBinariaDeBusca.Cidade;

public class Funcionario implements Comparable<Funcionario> {

	boolean entradaSaida;
	String nome;
	int matricula;
	Long hora;
	String data;
	
	public Funcionario(String nome, int matricula, Long hora, String data){
		this.nome = nome;
		this.matricula= matricula;
		this.hora = hora;
		this.data = data;
	}
	
	
	public Funcionario(String nome){
		this.nome = nome;
	}
	
	public Funcionario(String nome2, int matricula2) {
		this.nome = nome2;
		this.matricula = matricula2;
	}

	public Funcionario(int matricula2) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", matricula=" + matricula + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public Long getHora() {
		return hora;
	}

	public void setHora(Long hora) {
		this.hora = hora;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isEntradaSaida() {
		return entradaSaida;
	}

	public void setEntradaSaida(boolean entradaSaida) {
		this.entradaSaida = entradaSaida;
	}

	@Override
	public int compareTo(Funcionario o) {
		if(o.nome.compareTo(nome) < 0){
			return -1;
		}else if(o.nome.compareTo(nome) > 0){
			return 1;
		}else if(o.nome.compareTo(nome) == 0){
			return o.getNome().compareTo(nome);
	}else{
		return 0;
	}
	}

}
