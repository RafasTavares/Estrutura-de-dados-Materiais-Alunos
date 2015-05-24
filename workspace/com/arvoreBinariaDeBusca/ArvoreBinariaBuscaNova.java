package br.com.arvoreBinariaDeBusca;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeMap;

import br.com.arvoreTernaria.classes.No;

public class ArvoreBinariaBuscaNova<T extends Comparable<T>> {

	 private NoNovo<T> pai;
	LinkedList<T> listaPreOrdem = new LinkedList<T>();
	
	LinkedList<T> listaPosOrdem = new LinkedList<T>();
	LinkedList<T> listaEmOrdem = new LinkedList<T>();
	LinkedList<T> listaContem = new LinkedList<T>();

	public ArvoreBinariaBuscaNova() {
		this.pai = null;
	}

	public ArvoreBinariaBuscaNova(NoNovo<T> pai) {
		this.pai = pai;
	}

	public NoNovo<T> getPai() {
		return this.pai;
	}

	public boolean inserir(T elemento) {
		NoNovo<T> noAux = new NoNovo<T>(elemento);
		if (this.pai == null) {
			this.pai = noAux;
			return true;
		} else {
			return inserir(noAux, this.pai);
		}
	}
	
	
	
	private boolean inserir(NoNovo<T> noAux, NoNovo<T> pai) {
		
		if (pai.getElemento().compareTo(noAux.getElemento()) > 0) {
			NoNovo<T> esquerda = pai.getFilhoEsquerdo();
			if (esquerda == null) {
				pai.setFilhoEsquerdo(noAux);
				noAux.setPai(pai);
				return true;
			} else {
				return this.inserir(noAux, esquerda);
			}
		} else if(pai.getElemento().compareTo(noAux.getElemento()) < 0){
			NoNovo<T> direita = pai.getFilhoDireito();
			if (direita == null) {
				pai.setFilhoDireito(noAux);
				noAux.setPai(pai);
				return true;
			} else {
				return this.inserir(noAux, direita);
			}
		}else{
			return false;
		}
	}

	

	
	/*public boolean Inserir(NoNovo valor) {
		NoNovo noAux = new NoNovo(valor);

		if (this.pai == null) {
			this.pai = noAux;
			return true;
		} else {
			if (this.pai.getElemento().compareTo(valor) >= 0) {
				if (noAux.getFilhoEsquerdo() == null) {
					this.pai.setFilhoEsquerdo(noAux);
					noAux.setPai(this.pai);
					return true;
				} else {
					return this.Inserir(noAux.getFilhoEsquerdo().getElemento());
				}
			} else {
				if (noAux.getFilhoDireito() == null) {
					this.pai.setFilhoDireito(noAux);
					noAux.setPai(this.pai);
					return true;
				} else {
					return this.Inserir(noAux.getFilhoDireito().getElemento());
				}
			}

		}

	}

	public boolean remover(Comparable valor){
		No noAux = new No(valor);
		if(noAux.getPai() == null){
			noAux = null;
			return false;
		}else
		if(noAux.getFilhoEsquerdo() == null && noAux.getFilhoDireito() == null){
			
			if(noAux.getPai().compareTo(noAux.getElemento()) > 0){
				noAux.getPai().setFilhoEsquerdo(null);
				noAux.setPai(null);
			}else{
				noAux.getPai().setFilhoDireito(null);
				noAux.setPai(null);
			}
		}
		else if(noAux.getFilhoEsquerdo() != null && noAux.getFilhoEsquerdo() == null ||
				noAux.getFilhoEsquerdo() == null && noAux.getFilhoDireito() != null){
			if(noAux.getFilhoEsquerdo() != null && noAux.getFilhoDireito() == null){
				if(this.pai.compareTo(noAux.getElemento()) < 0){
					noAux.getPai().setFilhoDireito(noAux.getFilhoEsquerdo());
				}else{
					noAux.getPai().setFilhoEsquerdo(noAux.getFilhoDireito());
				}
				noAux.getFilhoEsquerdo().setPai(noAux.getPai());
			}else if(noAux.getFilhoDireito() != null && noAux.getFilhoEsquerdo() == null){
				if(this.pai.compareTo(noAux.getElemento()) < 0){
					noAux.getPai().setFilhoDireito(noAux.getFilhoDireito());
				}else{
					noAux.getPai().setFilhoEsquerdo(noAux.getFilhoEsquerdo());
				}
				noAux.getFilhoDireito().setPai(noAux.getPai());
			}
		}else{
		}
		return true;
	}
	
	public boolean inserir2(Comparable Valor) {

		No NovoNo = new No(Valor);

		if (this.pai == null) {
			this.pai = NovoNo;
			System.out.println("this.pai: " + this.pai.getElemento());
			return true;

		} else {
			No NoAtual = this.pai;

			if (NoAtual.getElemento().compareTo(NovoNo.getElemento()) == -1) {

				if (NovoNo.getFilhoDireito() == null) {
					this.pai.setFilhoDireito(NovoNo);
					NovoNo.setPai(this.pai);
					return true;

				} else {
					Valor = NovoNo.getFilhoDireito().getElemento();
					this.inserir2(Valor);
				}

			} else {

				if (NovoNo.getFilhoEsquerdo() == null) {
					this.pai.setFilhoEsquerdo(NovoNo);
					NovoNo.setPai(this.pai);
					return true;

				} else {
					Valor = NovoNo.getFilhoEsquerdo().getElemento();
					this.inserir2(Valor);
				}

			}

			return true;
		}
	}
*/
	public boolean remover(T elemento) {
		if (this.buscar( elemento)) {
			this.remover(this.pai, elemento);
			return true;
			} else {
				return false;
				} 
		}
	

	private NoNovo<T> remover(NoNovo<T> no, T elemento) {
		if (no == null) {
			return null;
			} else if (elemento.compareTo(no.getElemento()) == 0) {
				if (no.getFilhoEsquerdo() == null) {
					// muda o no pelo filho direito
					return no.getFilhoDireito();
					} else if (no.getFilhoDireito() == null) {
						// muda pelo filho esquerdo
						return no.getFilhoEsquerdo();
						} else {
							// substituir o valor neste nó com o valor do nó mais à direita 
							// da subárvore esquerda
							no.elemento = Sucessor(no.getFilhoEsquerdo());
							// agora remove o nó mais à direita na subárvore esquerda, 
							// chamando "remover" de forma recursiva
							no.filhoEsquerdo = remover(no.getFilhoEsquerdo(), no.getElemento());
							}
				} else { 
					// remover da subarvore direita ou esquerda
					if (elemento.compareTo(no.getElemento()) < 0) {
					// remover da subarvore esquerda
					//no.filhoEsquerdo =
						no.filhoEsquerdo = remover(no.getFilhoEsquerdo(), elemento);
					} else { 
						// remover da subarvore direita
						//no.filhoDireito = 
							no.filhoDireito = remover(no.getFilhoDireito(), elemento);
						}
					}
	return no;
	}
	

	public T getMaior(){
		NoNovo<T> aux;
		for (aux = this.pai; aux.getFilhoDireito() != null; aux = aux.getFilhoDireito()) {		}	
		
		T elemento;
		
		elemento = aux.elemento;	
		return elemento;
		
	
	}
	
public void RemoverMaior(){
	NoNovo<T> aux;
	for (aux = this.pai; aux.getFilhoDireito() != null; aux = aux.getFilhoDireito()) {		
	}	
	T elemento;
	
	elemento = aux.elemento;
	
	this.remover(elemento);
	
	}
	
	private T Sucessor(NoNovo<T> noAux) {
		while (noAux.getFilhoDireito() != null) {
			noAux = noAux.filhoDireito;
		}
		return  noAux.getElemento();
	}
	
	private T Antecessor(NoNovo<T> no){
		NoNovo<T>  noAux;
		
		for (noAux = no; noAux.getFilhoEsquerdo() != null; noAux = noAux.getFilhoEsquerdo()) {
		}
		no = noAux;
		return no.getElemento();
	}
	
	

	public boolean buscar(T elemento) {
		return buscar(elemento, this.pai);
	}
	
	private boolean buscar(T elemento, NoNovo<T> pai) {
		if (pai == null) {
			return false;
		} else if ( elemento.compareTo(pai.getElemento()) == 0) {
			return true;
		} else if (elemento.compareTo(pai.getElemento()) < 0) {
			return buscar(elemento, pai.getFilhoEsquerdo());
		} else {
			return buscar(elemento, pai.getFilhoDireito());
		}
	}
	
	public T buscar2(T elemento) {
		return buscar2(elemento, this.pai);
	}
	
	private T buscar2(T elemento, NoNovo<T> pai) {
		if (pai == null) {
			return null;
		} else if ( elemento.compareTo(pai.getElemento()) == 0) {
			return pai.getElemento();
		} else if (elemento.compareTo(pai.getElemento()) < 0) {
			return buscar2(elemento, pai.getFilhoEsquerdo());
		} else {
			return buscar2(elemento, pai.getFilhoDireito());
		}
	}
	
	/*public Collection<Comparable> emLargura() {

    	ArrayList<Comparable> lista = new ArrayList<Comparable>();
    	Queue<No> listaAtual;
    	listaAtual = new ArrayDeque<No>();
    	
    	listaAtual.add(this.pai);
    	No noAux;
    	
    	while (listaAtual.size() > 0) {
    		
    		noAux = listaAtual.poll();
    		
    		if (noAux != null) {
    			lista.add(noAux.getElemento());
    			
    			if (noAux.getFilhoEsquerdo() != null) 
    				listaAtual.add(noAux.getFilhoEsquerdo());	
    			
    			if (noAux.getFilhoDireito() != null) 
    				listaAtual.add(noAux.getFilhoDireito());
    		}
    	}
    	
    	return lista;
    }
	*/
	
	
	public LinkedList<NoNovo<T>> obterTodosEmLargura() {
		LinkedList<NoNovo<T>> lista = new LinkedList<NoNovo<T>>();
		LinkedList listaRetorno = new LinkedList();

		lista.addFirst(this.pai);
		while (lista.size() != 0) {
			NoNovo<T> noAux = lista.get(0);
			listaRetorno.addFirst(noAux.getElemento());
			lista.remove(0);
			boolean visitou = true;
			if (visitou) {
				if (noAux.getFilhoEsquerdo() != null) {
					lista.addFirst(noAux.getFilhoEsquerdo());
				}

					if (noAux.getFilhoDireito() != null) {
						lista.addFirst(noAux.getFilhoDireito());
					}
					visitou = false;
				}
			}

		
		return listaRetorno;
	}

	public int tamanho(){
		return this.obterTodosEmLargura().size();
	}
	
	public boolean ehVazio(){
		if(this.obterTodosEmLargura().size() == 0){
			return false;
		}else{
			return true;
		}
	}
	
public LinkedList<T> ImprimirEmLargura(){
		
		LinkedList<T> lista = new LinkedList<T>();
    	LinkedList<NoNovo<T>> listaAtual;
    	listaAtual = new LinkedList<NoNovo<T>>();
    	
    	listaAtual.add(this.pai);
    	NoNovo<T> noAux;
    	
    	while (listaAtual.size() > 0) {
    		
    		
    		noAux = listaAtual.poll();
    		
    		if (noAux != null) {
    			lista.add(noAux.getElemento());
    			
    			if (noAux.getFilhoEsquerdo() != null) 
    				listaAtual.add(noAux.getFilhoEsquerdo());	
    			
    			if (noAux.getFilhoDireito() != null) 
    				listaAtual.add(noAux.getFilhoDireito());
    		}
    	}
    	
    	return lista;
		
	}

public void imprimirCerto() {
	
	String string = "";
	
	LinkedList<T> lista = new LinkedList<T>();
	 lista = this.ImprimirEmLargura();
	
	if (lista.size() > 0) {
		string = "[";
	}
	
	for (int i = 0; i < lista.size(); i++) {
		string += lista.get(i);
		
		if (lista.size() < i-1) {
			string += ", ";
		}
	}
	
	if (lista.size() > 0) {
		string = "]";
	}
	
	
}


	
public void imprimir2(){
	LinkedList<NoNovo<T>> lista = new LinkedList<NoNovo<T>>();
	LinkedList<NoNovo<T>> listaAtual;
	listaAtual = new LinkedList<NoNovo<T>>();
	
	listaAtual.add(this.pai);
	NoNovo<T> noAux;
	
	while (listaAtual.size() > 0) {
		
		
		noAux = listaAtual.poll();
		
		if (noAux != null) {
			lista.add((NoNovo<T>) noAux.getElemento());
			
			if (noAux.getFilhoEsquerdo() != null) 
				listaAtual.add(noAux.getFilhoEsquerdo());	
			
			if (noAux.getFilhoDireito() != null) 
				listaAtual.add(noAux.getFilhoDireito());
			
		}
	}
	
	}


public Collection<T> ObterTodosEmLargura(){
	
		LinkedList<T> listaAux =  ImprimirEmLargura();
		LinkedList<T> listaNova = new LinkedList<T>();
		//Comparable aux = listaAux.getFirst();
		
		
	
	while (listaAux.size() > 0) {
		
		listaNova.addFirst(listaAux.getFirst());
		listaAux.removeFirst();
		
	}
	
	return listaNova;
		
	}


	public void EmOrdem(NoNovo<T> no) {
		if (no != null) {
			EmOrdem(no.getFilhoEsquerdo());
			System.out.print(no.getElemento() + " ");
			EmOrdem(no.getFilhoDireito());
		}
		
	}
	
	

	public void PosFixo(NoNovo<T> no) {
		if (no != null) {
			PosFixo(no.getFilhoEsquerdo());
			PosFixo(no.getFilhoDireito());
			System.out.print(no.getElemento() + " ");
		}
	}

	
	public void PreFixo(NoNovo<T> no) {
		if (no != null) {
			System.out.print(no.getElemento() + " ");
			PreFixo(no.getFilhoEsquerdo());
			PreFixo(no.getFilhoDireito());
		}
	}
	
	public NoNovo<T> getpai() {
		return this.pai;
	}
	
	public T getpaiElemento(){
		return this.pai.getElemento();
	}

	public Collection<T> obterTodosPreOrdem(NoNovo<T> no) {
		if (no != null) {
			listaPreOrdem.add(no.getElemento());
			obterTodosPreOrdem(no.getFilhoEsquerdo());
			obterTodosPreOrdem(no.getFilhoDireito());
		}
		else{
			return null;
		}
		return listaPreOrdem;
	}
	
	public boolean Contem(T elemento){
		listaContem = this.retornaLista();
		if(listaContem.contains(elemento)){
			return true;
		}else
		return false;
	}

	public Collection<T> obterTodosPosOrdem(NoNovo<T> no) {
		if (no != null) {
			obterTodosPosOrdem(no.getFilhoEsquerdo());
			obterTodosPosOrdem(no.getFilhoDireito());
			listaPosOrdem.add(no.getElemento());
		}else{
			return null;
		}
		return listaPosOrdem;
	}
	
	public Collection<T> obterTodosEmOrdem(NoNovo<T> no) {
		if (no != null) {
			obterTodosEmOrdem(no.getFilhoEsquerdo());
			listaEmOrdem.add(no.getElemento());
			obterTodosEmOrdem(no.getFilhoDireito());
		}
		else{
			return null;
		}
		return listaEmOrdem;
	}
	
	
	
	private LinkedList<T> retornaLista() {
		return (LinkedList<T>) obterTodosPreOrdem(this.pai);
	}

	private LinkedList<T> retornaLista2() {
		return  (LinkedList<T>) obterTodosEmLargura();
	}
	
	/*public String toString() {
		listaPreOrdem = retornaLista();
		String saida = "[";
		for (Object item : listaPreOrdem) {
			saida += item + ", ";
		}
		return saida.substring(0, saida.length() - 2) + "]";
	}
	
	
	
*/
	
	public NoNovo<T> buscarPrefixado(NoNovo<T> no, T elemento) {
		NoNovo<T> noAux = new NoNovo<T>(elemento);
		no = pai;
		if (no != null) {
			if (noAux.getElemento().equals(no.getFilhoEsquerdo().getElemento())
					|| noAux.getElemento()
							.equals(no.getFilhoDireito().getElemento())) {
				return noAux;
			} else if (!noAux.getElemento().equals(
					no.getFilhoEsquerdo().getElemento())) {
				return buscarPrefixado(no.getFilhoEsquerdo(), elemento);
			} else {
				return buscarPrefixado(no.getFilhoDireito(), elemento);
			}
		}
		return null;

	}
	
	public String toString2() {
		
		String string = "";
		
		ArrayList<T> lista = new ArrayList<T>();
		 EmOrdem(this.pai);
		
		if (lista.size() > 0) {
			string = "[";
		}
		
		for (int i = 0; i < lista.size(); i++) {
			string += lista.get(i);
			
			if (lista.size() < i-1) {
				string += ", ";
			}
		}
		
		if (lista.size() > 0) {
			string = "]";
		}
		
		return string;
	}
	




	public String imprimir() {
		LinkedList<T> nova = new LinkedList<T>();
		nova = (LinkedList<T>) this.ImprimirEmLargura();
		if (pai == null) {
			return "[]";
		}
		String saida = "[";
		for (T item : nova) {
			saida += item + "\t ";
			
			
		}
		return saida.substring(0, saida.length() - 2) + "]";
	}

	
	public void limpar() {
		
		while (this.pai != null) {
			remover(this.pai.getElemento());
		}
	}



	public void BalancearArvore(NoNovo<T> no) {
		this.NumeroBalanceamentoNo(no);
		
		if(no.getFB() == -2){
			if(this.AlturaArvore(no.getFilhoEsquerdo().getFilhoEsquerdo()) >= this.AlturaArvore(no.getFilhoEsquerdo().getFilhoDireito())){
				no = this.rotacaoDireita(no);
			}else{
				no = this.RotacaoEsquerdaDireita(no);
			}
		}else if(no.getFB() == 2){
			if(this.AlturaArvore(no.getFilhoDireito().getFilhoDireito()) >= this.AlturaArvore(no.getFilhoDireito().getFilhoEsquerdo())){
			    no = this.rotacaoEsquerda(no);
			}else{
				no = this.RotacaoDireitaEsquerda(no);
			}
		}
		if (no.getPai() != null) {
			this.BalancearArvore(no.getPai());
		} else {
			this.pai = no;
		}
	}

	private int AlturaArvore(NoNovo<T> aux) {
		if (aux == null) {
			return -1;
		}
 
		if (aux.getFilhoEsquerdo() == null && aux.getFilhoDireito() == null) {
			return 0;
		
		} else if (aux.getFilhoEsquerdo() == null) {
			return 1 + AlturaArvore(aux.getFilhoDireito());
		
		} else if (aux.getFilhoDireito() == null) {
			return 1 + AlturaArvore(aux.getFilhoEsquerdo());
		
		} else {
			return 1 + Math.max(AlturaArvore(aux.getFilhoEsquerdo()), AlturaArvore(aux.getFilhoDireito()));
		}
	}
 
	private void NumeroBalanceamentoNo(NoNovo<T> no) {
		no.setFB(AlturaArvore(no.getFilhoDireito()) - AlturaArvore(no.getFilhoEsquerdo()));
	}
	
	private NoNovo<T> rotacaoEsquerda(NoNovo<T> no) {
		 
		NoNovo<T> direita = no.getFilhoDireito();
		direita.setPai(no.getPai());
 
		no.setFilhoDireito(direita.getFilhoEsquerdo());
 
		if (no.getFilhoDireito() != null) {
			no.getFilhoDireito().setPai(no);
		}
 
		direita.setFilhoEsquerdo(no);
		no.setPai(direita);
 
		if (direita.getPai() != null) {
 
			if (direita.getPai().getFilhoDireito() == no) {
				direita.getPai().setFilhoDireito(direita);
			
			} else if (direita.getPai().getFilhoEsquerdo() == no) {
				direita.getPai().setFilhoEsquerdo(direita);
			}
		}
 
		NumeroBalanceamentoNo(no);
		NumeroBalanceamentoNo(direita);
 
		return direita;
	}
	
	private NoNovo<T> rotacaoDireita(NoNovo<T> no){
		NoNovo<T> esquerda = no.getFilhoEsquerdo();
		esquerda.setPai(no.getPai());
		no.setFilhoEsquerdo(esquerda.getFilhoDireito());
		if(no.getFilhoEsquerdo() != null){
			no.getFilhoEsquerdo().setPai(no);
		}
		
		esquerda.setFilhoDireito(no);
		no.setPai(esquerda);
		
		if(esquerda.getPai() != null){
			if(esquerda.getPai().getFilhoEsquerdo() == no){
				esquerda.getPai().setFilhoEsquerdo(esquerda);
			}else if(esquerda.getPai().getFilhoDireito() == no){
				esquerda.getPai().setFilhoDireito(esquerda);
			}
		}
		this.NumeroBalanceamentoNo(no);
		this.NumeroBalanceamentoNo(esquerda);
	return esquerda;
	}
	
	
	
	private NoNovo<T> RotacaoEsquerdaDireita(NoNovo<T> no) {
		no.setFilhoEsquerdo(rotacaoEsquerda(no.getFilhoEsquerdo()));
		return rotacaoDireita(no);
	}
 
	private NoNovo<T> RotacaoDireitaEsquerda(NoNovo<T> no) {
		no.setFilhoDireito(rotacaoDireita(no.getFilhoDireito()));
		return rotacaoEsquerda(no);
	}

	private ArrayList<T> RetornaLista(){	//Metodo retorna lista em Pré-Ordem.
		ArrayList<T> lista = new ArrayList<T>(); //Criação da lista que ira receber os valores
		if (this.pai == null) {	//Verifica se a raiz é nula
			return null;
		}else {
			return RetornaLista(this.pai, lista);	//Chamando a função reculsiva, passando a raiz e a lista
		}
	}
	
	private ArrayList<T> RetornaLista(NoNovo<T> no, ArrayList<T> lista) {	//Função reculsivo do RetornarLista
		if (no == null) {	//Verifica e o no fornecido é nulo
			return null;
		}
		if (!lista.contains(no.elemento)) {	//Verifica se o valor a ser adicionado já está contido na lista
			lista.add(no.elemento);	//Adiciona na lista
		}
		RetornaLista(no.filhoEsquerdo, lista);	//Chama a função reculsiva passando o filho esquerdo
		RetornaLista(no.filhoDireito, lista);	//Chama a função reculsiva passando o filho Direito
		
		return lista;	//Retorna a lista
	}
	

	
}
