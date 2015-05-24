package br.com.arvoreAVL.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;


public class ArvoreAVL<T extends Comparable<T>> {
	
	private No<T> pai;
	private int local; 
    LinkedList<T> listaPreOrdem = new LinkedList<T>();
	LinkedList<T> listaPosOrdem = new LinkedList<T>();
	LinkedList<T> listaEmOrdem = new LinkedList<T>();
	LinkedList<T> listaContem = new LinkedList<T>();
	
	public boolean inserirBalanceado(T elemento) {
		No<T> noAux = new No<T>(elemento);
		if (this.pai == null) {
			this.pai = noAux;
			return true;
		} else {
			return inserirBalanceado(noAux, this.pai);
		}
	}
	
	private boolean inserirBalanceado(No<T> noAux, No<T> pai) {
		
		if (pai.getElemento().compareTo(noAux.getElemento()) > 0) {
			No<T> esquerda = pai.getFilhoEsquerdo();
			if (esquerda == null) {
				pai.setFilhoEsquerdo(noAux);
				noAux.setPai(pai);
				BalancearArvore(pai);
				return true;
			} else {
				return this.inserirBalanceado(noAux, esquerda);
			}
		} else if(pai.getElemento().compareTo(noAux.getElemento()) < 0){
			No<T> direita = pai.getFilhoDireito();
			if (direita == null) {
				pai.setFilhoDireito(noAux);
				noAux.setPai(pai);
				BalancearArvore(pai);
				return true;
			} else {
				return this.inserirBalanceado(noAux, direita);
			}
		}else{
			return false;
		}
	}
	
	private void BalancearArvore(No<T> no) {
		this.NumeroBalanceamentoNo(no);
		
		if(no.getBalanceamento() == -2){
			if(this.AlturaArvore(no.getFilhoEsquerdo().getFilhoEsquerdo()) >= this.AlturaArvore(no.getFilhoEsquerdo().getFilhoDireito())){
				no = this.rotacaoDireita(no);
			}else{
				no = this.RotacaoEsquerdaDireita(no);
			}
		}else if(no.getBalanceamento() == 2){
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

	private int AlturaArvore(No<T> aux) {
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
 
	private void NumeroBalanceamentoNo(No<T> no) {
		no.setBalanceamento(AlturaArvore(no.getFilhoDireito()) - AlturaArvore(no.getFilhoEsquerdo()));
	}
	
	private No<T> rotacaoEsquerda(No<T> no) {
		 
		No<T> direita = no.getFilhoDireito();
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
	
	private No<T> rotacaoDireita(No<T> no){
		No<T> esquerda = no.getFilhoEsquerdo();
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
	
	
	
	private No<T> RotacaoEsquerdaDireita(No<T> no) {
		no.setFilhoEsquerdo(rotacaoEsquerda(no.getFilhoEsquerdo()));
		return rotacaoDireita(no);
	}
 
	private No<T> RotacaoDireitaEsquerda(No<T> no) {
		no.setFilhoDireito(rotacaoDireita(no.getFilhoDireito()));
		return rotacaoEsquerda(no);
	}
	
	private No<T> buscarNo(T valor) {
		No<T> no = pai;
		while (no != null) {
			if (no.getElemento().compareTo(valor) > 0) {
				no = no.getFilhoEsquerdo();
			} else if (no.getElemento().compareTo(valor) < 0) {
				no = no.getFilhoDireito();
			} else {
				return no;
			}
		}
		return null;
	}

	public T antecessor(T valor) {
		No<T> no = Antecessor(valor);
		if (no != null)
			return no.getElemento();
		else
			return null;
	}

	private No<T> Antecessor(T valor) {
		No<T> no = buscarNo(valor);
		if (no != null) {
			if (no.getFilhoEsquerdo() != null) {
				no = no.getFilhoEsquerdo();
				while (no.getFilhoDireito() != null) {
					no = no.getFilhoDireito();
				}
				return no;
			} else {
				no = no.getPai();
				while (no != null && valor.compareTo(no.getElemento()) > 0) {
					no = no.getPai();
				}
				return no;
			}
		}
		return null;
	}
	
	/*public boolean removerBalanceado(T elemento){
		No<T> noAux = buscarNo(elemento);
		return false;
	}*/
	
	public boolean remover(T valor) {
		No<T> no = buscarNo(valor);
		if (no != null) {
			if (no.getFilhoEsquerdo() != null && no.getFilhoDireito() != null) {
				T suc = antecessor(valor);
				remover(suc);
				no.setElemento(suc);
			} else if (no.getPai() != null) {
				boolean side;
				if (no.getPai().getFilhoEsquerdo() == no) {
					side = false;
				} else {
					side = true;
				}
				if (no.getFilhoEsquerdo() != null) {
					if (side) {
						no.getPai().setFilhoDireito(no.getFilhoEsquerdo());
						no.setPai(null);
					} else {
						no.getPai().setFilhoEsquerdo(no.getFilhoEsquerdo());
						no.setPai(null);
					}
				} else if (no.getFilhoDireito() != null) {
					if (side) {
						no.getPai().setFilhoDireito(no.getFilhoDireito());
						no.setPai(null);
					} else {
						no.getPai().setFilhoEsquerdo(no.getFilhoDireito());
						no.setPai(null);
					}
				} else {
					if (side) {
						no.getPai().setFilhoDireito(null);
					} else {
						no.getPai().setFilhoEsquerdo(null);
					}
				}
			} else {
				if (pai.getFilhoEsquerdo() != null) {
					pai = pai.getFilhoEsquerdo();
					pai.getPai().setFilhoEsquerdo(null);
					pai.setPai(null);
				} else if (pai.getFilhoDireito() != null) {
					pai = pai.getFilhoDireito();
					pai.getPai().setFilhoDireito(null);
					pai.setPai(null);
				} else {
					pai = null;
				}
			}
		}
		this.BalancearArvore(no);
		return true;
	}
	
	public boolean removerBalanceado2(T elemento) {
		if (this.buscar( elemento)) {
			this.removerBalanceado2(this.pai, elemento);
			return true;
			} else {
				return false;
				} 
		}

	
	private No<T> removerBalanceado2(No<T> no, T elemento) {
		if (no == null) {
			return null;
			}
			 else if (elemento.compareTo(no.getElemento()) == 0) {
				if (no.getFilhoEsquerdo() == null) {
					// muda o no pelo filho direito
					return no.getFilhoDireito();
					} else if (no.getFilhoDireito() == null) {
						// muda pelo filho esquerdo
						return no.getFilhoEsquerdo();
						} else{
							// substituir o valor neste nó com o valor do nó mais à direita 
							// da subárvore esquerda
							no.elemento = Antecessor(no.getFilhoEsquerdo());
							// agora remove o nó mais à direita na subárvore esquerda, 
							// chamando "remover" de forma recursiva
							no.filhoEsquerdo = removerBalanceado2(no.getFilhoEsquerdo(), no.getElemento());
							this.BalancearArvore(pai);
						}
				} else { 
					// remover da subarvore direita ou esquerda
					if (elemento.compareTo(no.getElemento()) < 0) {
					// remover da subarvore esquerda
					//no.filhoEsquerdo =
						no.filhoEsquerdo = removerBalanceado2(no.getFilhoEsquerdo(), elemento);
						this.BalancearArvore(pai);
					} else { 
						// remover da subarvore direita
						//no.filhoDireito = 
							no.filhoDireito = removerBalanceado2(no.getFilhoDireito(), elemento);
							this.BalancearArvore(pai);
						}
					}
	return no;
	}
	
	public void remover3(T k) {
		removerAVL(this.pai, k);
	}
 
	public void removerAVL(No<T> atual, T k) {
		if (atual == null) {
			return;
 
		} else {
 
			if (k.compareTo(atual.getElemento()) < 0) {
				removerAVL(atual.getFilhoEsquerdo(), k);
 
			} else if (k.compareTo(atual.getElemento()) > 0) {
				removerAVL(atual.getFilhoDireito(), k);
 
			} else if (atual.getElemento() == k) {
				removerNoEncontrado(atual);
			}
		}
	}
	
	public void removerNoEncontrado(No<T> aRemover) {
		No<T> r;
 
		if (aRemover.getFilhoEsquerdo() == null || aRemover.getFilhoDireito() == null) {
 
			if (aRemover.getPai() == null) {
				this.pai = null;
				aRemover = null;
				return;
			}
			r = aRemover;
 
		} else {
			r = (No<T>)  (aRemover);
			aRemover.setElemento(r.getElemento());
		}
 
		No<T> p;
		if (r.getFilhoEsquerdo() != null) {
			p = r.getFilhoEsquerdo();
		} else {
			p = r.getFilhoDireito();
		}
 
		if (p != null) {
			p.setPai(r.getPai());
		}
 
		if (r.getPai() == null) {
			this.pai = p;
		} else {
			if (r == r.getPai().getFilhoEsquerdo()) {
				r.getPai().setFilhoEsquerdo(p);
			} else {
				r.getPai().setFilhoDireito(p);
			}
			BalancearArvore(r.getPai());
		}
		r = null;
	}
	
	private T Sucessor(No<T> noAux) {
		while (noAux.getFilhoDireito() != null) {
			noAux = noAux.filhoDireito;
		}
		return  noAux.getElemento();
	}
	
	private T Antecessor(No<T> no){
		No<T>  noAux;
		
		for (noAux = no; noAux.getFilhoEsquerdo() != null; noAux = noAux.getFilhoEsquerdo()) {
		}
		no = noAux;
		return no.getElemento();
	}
	
	

	public boolean buscar(T elemento) {
		return buscar(elemento, this.pai);
	}
	
	private boolean buscar(T elemento, No<T> pai) {
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
	
	private T buscar2(T elemento, No<T> pai) {
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
	
	public No<T> getpai() {
		return this.pai;
	}
	
	public T getpaiElemento(){
		return this.pai.getElemento();
	}

	public Collection<T> obterTodosPreOrdem(No<T> no) {
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

	public Collection<T> obterTodosPosOrdem(No<T> no) {
		if (no != null) {
			obterTodosPosOrdem(no.getFilhoEsquerdo());
			obterTodosPosOrdem(no.getFilhoDireito());
			listaPosOrdem.add(no.getElemento());
		}else{
			return null;
		}
		return listaPosOrdem;
	}
	
	public Collection<T> obterTodosEmOrdem(No<T> no) {
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
	
	public No<T> buscarPrefixado(No<T> no, T elemento) {
		No<T> noAux = new No<T>(elemento);
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
			removerBalanceado2(this.pai.getElemento());
		}
	}
	
	public LinkedList<No<T>> obterTodosEmLargura() {
		LinkedList<No<T>> lista = new LinkedList<No<T>>();
		LinkedList listaRetorno = new LinkedList();

		lista.addFirst(this.pai);
		while (lista.size() != 0) {
			No<T> noAux = lista.get(0);
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

	
	
public LinkedList<T> ImprimirEmLargura(){
		
		LinkedList<T> lista = new LinkedList<T>();
    	LinkedList<No<T>> listaAtual;
    	listaAtual = new LinkedList<No<T>>();
    	
    	listaAtual.add(this.pai);
    	No<T> noAux;
    	
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
	LinkedList<No<T>> lista = new LinkedList<No<T>>();
	LinkedList<No<T>> listaAtual;
	listaAtual = new LinkedList<No<T>>();
	
	listaAtual.add(this.pai);
	No<T> noAux;
	
	while (listaAtual.size() > 0) {
		
		
		noAux = listaAtual.poll();
		
		if (noAux != null) {
			lista.add((No<T>) noAux.getElemento());
			
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


	public void EmOrdem(No<T> no) {
		if (no != null) {
			EmOrdem(no.getFilhoEsquerdo());
			System.out.print(no.getElemento() + " ");
			EmOrdem(no.getFilhoDireito());
		}
		
	}
	
	

	public void PosFixo(No<T> no) {
		if (no != null) {
			PosFixo(no.getFilhoEsquerdo());
			PosFixo(no.getFilhoDireito());
			System.out.print(no.getElemento() + " ");
		}
	}

	
	public void PreFixo(No<T> no) {
		if (no != null) {
			System.out.print(no.getElemento() + " ");
			PreFixo(no.getFilhoEsquerdo());
			PreFixo(no.getFilhoDireito());
		}
	}

}
