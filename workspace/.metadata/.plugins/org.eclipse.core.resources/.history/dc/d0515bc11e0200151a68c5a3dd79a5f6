package br.com.arvoreBinariaDeBusca;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinariaBusca<T> {

	private No pai;
	LinkedList<Comparable> listaPreOrdem = new LinkedList<Comparable>();
	LinkedList<Comparable> listaPosOrdem = new LinkedList<Comparable>();
	LinkedList<Comparable> listaEmOrdem = new LinkedList<Comparable>();
	LinkedList<Comparable> listaContem = new LinkedList<Comparable>();

	public ArvoreBinariaBusca() {
		this.pai = null;
	}

	public ArvoreBinariaBusca(No pai) {
		pai = pai;
	}

	public No getPai() {
		return pai;
	}

	public boolean inserir(Comparable elemento) {
		No noAux = new No( elemento);
		if (this.pai == null) {
			this.pai = noAux;
			return true;
		} else {
			return inserir(noAux, this.pai);
		}
	}
	
	private boolean inserir(No noAux, No pai) {
		
		if (pai.compareTo(noAux.getElemento()) >= 0) {
			No esquerda = pai.getFilhoEsquerdo();
			if (esquerda == null) {
				pai.setFilhoEsquerdo(noAux);
				noAux.setPai(pai);
				return true;
			} else {
				return this.inserir(noAux, esquerda);
			}
		} else {
			No direita = pai.getFilhoDireito();
			if (direita == null) {
				pai.setFilhoDireito(noAux);
				noAux.setPai(pai);
				return true;
			} else {
				return this.inserir(noAux, direita);
			}
		}
	}


	
	/*public boolean Inserir(Comparable valor) {
		No noAux = new No(valor);

		if (this.pai == null) {
			this.pai = noAux;
			return true;
		} else {
			if (this.pai.compareTo(valor) >= 0) {
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
			System.out.println("Raiz: " + this.pai.getElemento());
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
	public boolean remover(Comparable elemento) {
		if (this.buscar(elemento)) {
			this.remover(this.pai, elemento);
			return true;
			} else {
				return false;
				} 
		}
	

	private No remover(No no, Comparable elemento) {
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
					no.filhoEsquerdo = remover(no.getFilhoEsquerdo(), elemento);
					} else { 
						// remover da subarvore direita
						no.filhoDireito = remover(no.getFilhoDireito(), elemento);
						}
					}
	return no;
	}
	

	private Comparable Sucessor(No noAux) {
		while (noAux.getFilhoDireito() != null) {
			noAux = noAux.filhoDireito;
		}
		return  noAux.getElemento();
	}
	
	private Comparable Antecessor(No no){
		No  noAux;
		
		for (noAux = no; noAux.getFilhoEsquerdo() != null; noAux = noAux.getFilhoEsquerdo()) {
		}
		no = noAux;
		return no.getElemento();
	}
	
	

	public boolean buscar(Comparable elemento) {
		return buscar(elemento, this.pai);
	}
	
	private boolean buscar(Comparable elemento, No pai) {
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
	public LinkedList<Comparable> ImprimirEmLargura(){
		
		LinkedList<Comparable> lista = new LinkedList<Comparable>();
    	LinkedList<No> listaAtual;
    	listaAtual = new LinkedList<No>();
    	
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
	
	public LinkedList<No> obterTodosEmLargura() {
		LinkedList<No> lista = new LinkedList<No>();
		LinkedList listaRetorno = new LinkedList();

		lista.addFirst(this.pai);
		while (lista.size() != 0) {
			No noAux = lista.get(0);
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

	
public Collection<Comparable> ObterTodosEmLargura(){
	
		LinkedList<Comparable> listaAux =  ImprimirEmLargura();
		LinkedList<Comparable> listaNova = new LinkedList<Comparable>();
		//Comparable aux = listaAux.getFirst();
		
		
	
	while (listaAux.size() > 0) {
		
		listaNova.addFirst(listaAux.getFirst());
		listaAux.removeFirst();
		
	}
	
	return listaNova;
		
	}

	public void EmOrdem(No no) {
		if (no != null) {
			EmOrdem(no.getFilhoEsquerdo());
			System.out.print(no.getElemento() + " ");
			EmOrdem(no.getFilhoDireito());
		}
		
	}

	public void PosFixo(No no) {
		if (no != null) {
			PosFixo(no.getFilhoEsquerdo());
			PosFixo(no.getFilhoDireito());
			System.out.print(no.getElemento() + " ");
		}
	}

	
	public void PreFixo(No no) {
		if (no != null) {
			System.out.print(no.getElemento() + " ");
			PreFixo(no.getFilhoEsquerdo());
			PreFixo(no.getFilhoDireito());
		}
	}
	
	public No getRaiz() {
		return this.pai;
	}
	
	public Comparable getRaizElemento(){
		return this.pai.getElemento();
	}

	public Collection<Comparable> obterTodosPreOrdem(No no) {
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
	
	public boolean Contem( Comparable elemento){
		listaContem = this.retornaLista();
		if(listaContem.contains(elemento)){
			return true;
		}else
		return false;
	}

	public Collection<Comparable> obterTodosPosOrdem(No no) {
		if (no != null) {
			obterTodosPosOrdem(no.getFilhoEsquerdo());
			obterTodosPosOrdem(no.getFilhoDireito());
			listaPosOrdem.add(no.getElemento());
		}else{
			return null;
		}
		return listaPosOrdem;
	}
	
	public Collection<Comparable> obterTodosEmOrdem(No no) {
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
	
	private LinkedList<Comparable> retornaLista() {
		return (LinkedList<Comparable>) obterTodosPreOrdem(this.pai);
	}

	
	public String toString() {
		listaPreOrdem = retornaLista();
		String saida = "[";
		for (Object item : listaPreOrdem) {
			saida += item + ", ";
		}
		return saida.substring(0, saida.length() - 2) + "]";
	}

	public String toString2() {
		
		String string = "";
		
		ArrayList<Comparable> lista = new ArrayList<Comparable>();
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
	
	public void limpar() {
		
		while (this.pai != null) {
			remover(this.pai.getElemento());
		}
	}



}
