package br.com.arvoreTernaria.classes;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArvoreTernaria<T> implements Arvore {

	private No<Object> pai;
	private int totalElementos;
	private No<Object> folha;
	private int cont;
	LinkedList<Object> lista = new LinkedList<Object>();
	No no = this.pai;

	public ArvoreTernaria() {
		this.pai = null;
		this.totalElementos = 0;
	}

	public ArvoreTernaria(No pai) {
		this.pai = pai;
	}

	@Override
	public No<Object> inserir(Object valor, No pai, Lado lado) {
		// int contDir = 0, contEsq = 0, contMeio = 0;
		No<Object> novoNo = new No<Object>(valor);
		if (this.pai == null) {
			this.pai = this.folha = novoNo;
			return novoNo;
		}

		else if (lado == Lado.Esquerdo) {
			if (pai.getEsquerda() == null) {
				pai.setEsquerda(novoNo);
				novoNo.setPai(pai);
			} else {
				this.inserir(valor, pai.getEsquerda(), lado);
			}

		} else if (lado == Lado.Meio) {
			if (pai.getMeio() == null) {
				pai.setMeio(novoNo);
				novoNo.setPai(pai);
			} else {
				this.inserir(valor, pai.getMeio(), lado);
			}
		} else {
			if (pai.getDireita() == null) {
				pai.setDireita(novoNo);
				novoNo.setPai(pai);
			} else {
				this.inserir(valor, pai.getDireita(), lado);
			}

		}

		return novoNo;
	}

	@Override
	public No obterRaiz() {
		return this.pai;
	}

	@Override
	public No obterFilho(No pai, Lado lado) {
		if (this.pai == null) {
			return null;
		} else if (lado == Lado.Direito) {
			if (pai.getDireita() != null) {
				return pai.getDireita();
			} else {
				return this.obterFilho(pai, lado.Direito);
			}
		} else if (lado == Lado.Esquerdo) {
			if (pai.getEsquerda() != null) {
				return pai.getEsquerda();
			} else {
				return this.obterFilho(pai, lado.Esquerdo);
			}
		} else {
			if (pai.getMeio() != null) {
				return pai.getMeio();
			} else {
				return this.obterFilho(pai, lado.Meio);
			}
		}
	}

	/*
	 * No<Object> noAtual = pai; public Object buscar(Object value) { if
	 * (noAtual.getEsquerda() != null && noAtual.getEsquerda().isVisitado() !=
	 * true) { while (noAtual.getEsquerda() != null) { if
	 * (noAtual.equals(value)) { return noAtual.getElemento(); } noAtual =
	 * noAtual.getEsquerda(); } } else if (noAtual.getDireita() != null &&
	 * noAtual.getDireita().isVisitado() != true) { if (noAtual.equals(value)) {
	 * return noAtual.getElemento(); } noAtual = noAtual.getDireita();
	 * this.buscar(value); } noAtual.setVisitado(true); noAtual =
	 * noAtual.getPai(); this.buscar(value); return null; }
	 */

	/*
	 * public No removerFilho(No no, Lado lado) { if (no.getDireita() == null &&
	 * no.getEsquerda() == null && no.getMeio() == null) { if (no.getPai() ==
	 * null) { return null; } else if (lado == Lado.Esquerdo) {
	 * no.getPai().setEsquerda(null); } else if (lado == Lado.Meio) {
	 * no.getPai().setMeio(null); } else { no.getPai().setDireita(null); } }
	 * else if (no.getEsquerda() != null && no.getMeio() == null &&
	 * no.getDireita() == null || no.getEsquerda() == null && no.getMeio() !=
	 * null && no.getDireita() == null || no.getEsquerda() == null &&
	 * no.getMeio() == null && no.getDireita() != null) { if (lado ==
	 * Lado.Esquerdo) { no.getPai().setEsquerda(no.getEsquerda());
	 * no.getEsquerda().setPai(no.getPai()); } else if (lado == Lado.Meio) {
	 * no.getPai().setMeio(no.getMeio()); no.getMeio().setPai(no.getPai()); }
	 * else { no.getPai().setDireita(no.getDireita());
	 * no.getDireita().setPai(no.getPai()); } } else { No noAux = no; }
	 * 
	 * }
	 */
	
	public Object obterFilhoT(No pai, Lado lado) {
		if (this.pai == null) {
			return null;
		} else if (lado == Lado.Esquerdo) {
			if (pai.getEsquerda() != null) {
				return pai.getEsquerda().getElemento();
			} else {
				return this.obterFilhoT(pai, Lado.Esquerdo);
			}
		} else {
			if (pai.getDireita() != null) {
				return pai.getDireita().getElemento();
			} else {
				return this.obterFilhoT(pai, Lado.Direito);
			}
		}
	}

	public No removerNo(No no) {
		if (no == null) {
			return null;
		} else if (no.equals(this.pai)) {
			this.pai = null;
		} else if (no.getEsquerda() != null
				&& no.getDireita() != null 
				&& no.getMeio() != null) {
			if (no.equals(no.getEsquerda())) {
				no.setEsquerda(null);
			}else if(no.equals(no.getMeio())){
			    no.setMeio(null);
			}	
			else if (no.equals(no.getDireita())) {
				no.setDireita(null);	
			}
			else {
				if (no == no.getPai().getEsquerda()) {
					no.getEsquerda().setPai(no.getPai());
					no.setEsquerda(no.getMeio());
					no.setMeio(no.getDireita());
					no.getDireita().setPai(no.getMeio());
					no.getMeio().setPai(no.getEsquerda());
					no.getPai().setEsquerda(no.getEsquerda());
				}else if(no == no.getPai().getMeio()){
					no.getMeio().setPai(no.getPai());
					no.setMeio(no.getEsquerda());
					no.setEsquerda(no.getDireita());
					
				}
				else {
					no.getDireita().setPai(no.getPai());
					no.getDireita().setDireita(no.getEsquerda());
					no.getEsquerda().setPai(no.getDireita());
					no.getPai().setDireita(no.getDireita());
				}
			}
		} else if (no.getEsquerda() != null
				&& no.getDireita() == null) {
			no.setEsquerda(null);
		} else if (no.getEsquerda() == null
				&& no.getDireita() != null) {
			no.setDireita(null);
		} else {
			no.setElemento(null);
		}
		return no;
	}


	public LinkedList<Object> ImprimirPreOrdemLista(No no) {

		// lista.add(pai.getElemento());

		if (no != null) {
			lista.add(no.getElemento());
			ImprimirPreOrdemLista(no.getEsquerda());
			ImprimirPreOrdemLista(no.getMeio());
			ImprimirPreOrdemLista(no.getDireita());
		} else {
			return null;
		}
		return lista;
	}

	public Object Buscar(Object valor) {
		if (pai == null)
			return null;
		else
			return Buscar(valor, pai);
	}

	private Object Buscar(Object elemento, No pai) {

		No noAux = new No<T>(elemento);
		// No noAux2 = null;

		if (noAux.getElemento().equals(pai.getElemento())) {
			return pai.getElemento();
		} else if (noAux.getElemento().equals(pai.getEsquerda().getElemento())) {
			return Buscar(elemento, pai.getEsquerda());
		} else if (noAux.getElemento().equals(pai.getMeio().getElemento())) {
			return Buscar(elemento, pai.getMeio());
		} else {
			return Buscar(elemento, pai.getDireita());
		}
	}

	public void prefixado(No no) {
		if (no != null) {
			System.out.print(no.getElemento() + " ");
			prefixado(no.getEsquerda());
			prefixado(no.getMeio());
			prefixado(no.getDireita());

		}
	}

	public void prefixado2(Object elemento) {

		if (elemento != null) {

			System.out.print(no.getElemento() + " ");
			prefixado2(no.getEsquerda().getElemento());
			prefixado2(no.getMeio().getElemento());
			prefixado2(no.getDireita().getElemento());

		}
	}

	public No buscarPrefixado(No no, Object elemento) {
		No noAux = new No<T>(elemento);
		no = pai;
		if (no != null) {
			if (noAux.getElemento().equals(no.getEsquerda().getElemento())
					|| noAux.getElemento().equals(no.getMeio().getElemento())
					|| noAux.getElemento()
							.equals(no.getDireita().getElemento())) {
				return noAux;
			} else if (!noAux.getElemento().equals(
					no.getEsquerda().getElemento())) {
				return buscarPrefixado(no.getEsquerda(), elemento);
			} else if (!noAux.getElemento().equals(no.getMeio().getElemento())) {
				return buscarPrefixado(no.getMeio(), elemento);
			} else {
				return buscarPrefixado(no.getMeio(), elemento);
			}
		}
		return null;

	}

	@Override
	public No removerFilho(No pai, Lado lado) {

		return null;
	}

	/*public Object BuscaEmLargura(No no){
		No aux1, aux2, aux3;
	  
		LinkedList<No> lista = new LinkedList<No>();
	  
		lista.add(no);
	  
		while(lista != null){ 
			
			if(no.getEsquerda() != null){
	  
		  lista.add(no.getEsquerda());
		  
		  }
	  
	  if(no.getMeio() != null){ 
		  
		  lista.add(no.getMeio()); 
		  
	  }  
	  else{
		  lista.add(no.getDireita());
		  
	  
	  }
	  }
	  
	  }*/
}
