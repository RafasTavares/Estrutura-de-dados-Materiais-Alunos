package br.com.arvoreAVL.ExercicioCurso.classes;

import br.com.arvoreAVL.classes.ArvoreAVL;

public class Curso {

	private int codigo;
	private String descricao;
	private double valorCurso;
	private ArvoreAVL<Aluno> listaAlunos;
	private int lotacaoCurso;
	
	public Curso(int codigo, String descricao, double valorCurso){
		this.codigo = codigo;
		this.descricao = descricao;
		this.valorCurso = valorCurso;
		this.listaAlunos = new ArvoreAVL<Aluno>();
	}
	
	private boolean ExisteAluno(Aluno aluno){
		if(listaAlunos.buscar(aluno)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean MatricularAluno(Aluno aluno){
		if(this.ExisteAluno(aluno) && this.lotacaoCurso > 11){
			this.listaAlunos.inserirBalanceado(aluno);
			if(2015 - aluno.getAnoNascimento() <= 14 ){
				aluno.setPercDesconto(15/100);
			}else if(2015 - aluno.getAnoNascimento() > 14 && 2015 - aluno.getAnoNascimento() <= 21){
				aluno.setPercDesconto(10/100);
			}else{
				aluno.setPercDesconto(5/100);
			}
			this.lotacaoCurso++;
			return true;
		}else{
			return false;
		}
	}
	
	/*public boolean CancelarMatricula(int cpf){
		
	}*/
	
}
