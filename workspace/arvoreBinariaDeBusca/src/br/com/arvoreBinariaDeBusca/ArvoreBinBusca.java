package br.com.arvoreBinariaDeBusca;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;


public class ArvoreBinBusca<T extends Comparable<T>> {

	private NoNovo<T> raiz;
	private ArrayList<T> lista;
	private ArrayList<T> listPreOrdem;
	private ArrayList<T> listEmOrdem;
	private ArrayList<T> listPosOrdem;

//	public ArvoreBinBusca() {
//		this.raiz = null;
//		lista = new ArrayList<T>();
//		listPreOrdem = new ArrayList<T>();
//		listEmOrdem = new ArrayList<T>();
//		listPosOrdem = new ArrayList<T>();
//	}
//
//	public boolean inserir(T valor) {
//		NoNovo<T> novoNo = new NoNovo<T>(valor);
//		if (raiz == null) {
//			raiz = novoNo;
//			return true;
//		} else {
//			return inserir(novoNo, raiz);
//		}
//	}
//
//	public boolean inserir(NoNovo<T> novoNo, NoNovo<T> raizSub) {
//		// Compara se o no a ser inserido é menor que a raiz da subarvore...
//		if (raizSub.compareTo(novoNo.getValor()) > 0) {
//			NoBinBusca<T> esquerda = raizSub.getFilhoEsquerdo();
//			// Verifica se o no é nulo, se for adiciona, se nao chama a
//			// função
//			// recursiva
//			if (esquerda == null) {
//				raizSub.setFilhoEsquerdo(novoNo);
//				novoNo.setPai(raizSub);
//				return true;
//			} else {
//				return this.inserir(novoNo, esquerda);
//			}
//		} else if (raizSub.compareTo(novoNo.getValor()) < 0) {
//			// se for maior adiciona na direita
//			NoBinBusca<T> direita = raizSub.getFilhoDireito();
//			if (direita == null) {
//				raizSub.setFilhoDireito(novoNo);
//				novoNo.setPai(raizSub);
//				return true;
//			} else {
//				return this.inserir(novoNo, direita);
//			}
//		} else {
//			return false;
//		}
//	}
//
//	public boolean remover(T valor) {
//		if (this.buscar(valor)) {
//			this.remover(raiz, valor);
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	private NoBinBusca<T> remover(NoBinBusca<T> no, T valor) {
//		if (no == null) {
//			return null;
//		} else if (valor.compareTo(no.getValor()) == 0) {
//			if (no.getFilhoEsquerdo() == null) {
//				// muda o no pelo filho direito
//				return no.getFilhoDireito();
//			} else if (no.getFilhoDireito() == null) {
//				// muda pelo filho esquerdo
//				return no.getFilhoEsquerdo();
//			} else {
//				// substituir o valor neste nó com o valor do nó mais à direita
//				// da subárvore esquerda
//				no.valor = retrieveData(no.getFilhoEsquerdo());
//				// agora remove o nó mais à direita na subárvore esquerda,
//				// chamando "remover" de forma recursiva
//				no.filhoEsquerdo = remover(no.getFilhoEsquerdo(), no.getValor());
//			}
//		} else { // remover da subarvore direita ou esquerda
//			if (valor.compareTo(no.getValor()) < 0) {
//				// remover da subarvore esquerda
//				no.filhoEsquerdo = remover(no.getFilhoEsquerdo(), valor);
//			} else { // remover da subarvore direita
//				no.filhoDireito = remover(no.getFilhoDireito(), valor);
//			}
//		}
//		return no;
//	}
//
//	/*
//	 * Retorna o antecessor
//	 */
//	private T retrieveData(NoBinBusca<T> no) {
//		while (no.getFilhoDireito() != null) {
//			no = no.filhoDireito;
//		}
//		return no.getValor();
//	}
//
//	public boolean buscar(T valor) {
//		return buscar(valor, raiz);
//	}
//
//	/*
//	 * Primeiro ver se o valor passado é null, ou seja, nao contem na arvore.
//	 * Depois compara a raiz com o valor fornecido. Se for igual, é porque é a
//	 * raiz, retorna true. Se a raiz for menor procura do lado esquerdo. Se nao,
//	 * do lado direito. Retorna true caso ache. Se nao achar, false.
//	 */
//	private boolean buscar(T valor, NoBinBusca<T> raizSub) {
//		if (raizSub == null) {
//			return false;
//		} else if (valor.compareTo(raizSub.getValor()) == 0) {
//			return true;
//		} else if (valor.compareTo(raizSub.getValor()) < 0) {
//			return buscar(valor, raizSub.getFilhoEsquerdo());
//		} else {
//			return buscar(valor, raizSub.getFilhoDireito());
//		}
//	}
//
//	public NoBinBusca<T> buscarNo(T valor) {
//		NoBinBusca<T> auxiliar = raiz;
//		while (auxiliar != null) {
//			if (valor.compareTo(auxiliar.getValor()) == 0) {
//				return auxiliar;
//			} else if (valor.compareTo(auxiliar.getValor()) == 1) {
//				auxiliar = auxiliar.getFilhoDireito();
//			} else {
//				auxiliar = auxiliar.getFilhoEsquerdo();
//			}
//
//		}
//		return null;
//	}
//
//	public void limpar() {
//		raiz.filhoEsquerdo = null;
//		raiz.filhoDireito = null;
//		raiz = null;
//	}
//
//	public void listPreOrdem() {
//		preOrdem(raiz);
//	}
//
//	public void listEmOrdem() {
//		emOrdem(raiz);
//	}
//
//	public void listPosOrdem() {
//		posOrdem(raiz);
//	}
//
//	private void preOrdem(NoBinBusca<T> no) {
//		if (no != null) {
//			System.out.println(no.getValor());
//			preOrdem(no.getFilhoEsquerdo());
//			preOrdem(no.getFilhoDireito());
//		}
//	}
//
//	private void emOrdem(NoBinBusca<T> no) {
//		if (no != null) {
//			emOrdem(no.getFilhoEsquerdo());
//			System.out.println(no.getValor());
//			emOrdem(no.getFilhoDireito());
//		}
//	}
//
//	private void posOrdem(NoBinBusca<T> no) {
//		if (no != null) {
//			preOrdem(no.getFilhoEsquerdo());
//			preOrdem(no.getFilhoDireito());
//			System.out.println(no.getValor());
//		}
//	}
//
//	public NoBinBusca<T> getRaiz() {
//		return raiz;
//	}
//
//	public ArrayList<T> retornaLista() {
//		return (ArrayList<T>) obterTodosPreOrdemToString(raiz);
//	}
//
//	public ArrayList<T> retornaListaPreOrdem() {
//		return (ArrayList<T>) obterTodosPreOrdem(raiz);
//	}
//
//	public ArrayList<T> retornaListaEmOrdem() {
//		return (ArrayList<T>) obterTodosEmOrdem(raiz);
//	}
//
//	public ArrayList<T> retornaListaPosOrdem() {
//		return (ArrayList<T>) obterTodosPosOrdem(raiz);
//	}
//
//	public Collection<T> obterTodosPreOrdemToString(NoBinBusca<T> no) {
//		if (no != null) {
//			lista.add(no.getValor());
//			obterTodosPreOrdemToString(no.getFilhoEsquerdo());
//			obterTodosPreOrdemToString(no.getFilhoDireito());
//		}
//		return lista;
//	}
//
//	public Collection<T> obterTodosPreOrdem(NoBinBusca<T> no) {
//		if (no != null) {
//			listPreOrdem.add(no.getValor());
//			obterTodosPreOrdem(no.getFilhoEsquerdo());
//			obterTodosPreOrdem(no.getFilhoDireito());
//		}
//		return listPreOrdem;
//	}
//
//	public Collection<T> obterTodosEmOrdem(NoBinBusca<T> no) {
//		if (no != null) {
//			obterTodosEmOrdem(no.getFilhoEsquerdo());
//			listEmOrdem.add(no.getValor());
//			obterTodosEmOrdem(no.getFilhoDireito());
//		}
//		return listEmOrdem;
//	}
//
//	public Collection<T> obterTodosPosOrdem(NoBinBusca<T> no) {
//		if (no != null) {
//			obterTodosPosOrdem(no.getFilhoEsquerdo());
//			obterTodosPosOrdem(no.getFilhoDireito());
//			listPosOrdem.add(no.getValor());
//		}
//		return listPosOrdem;
//	}
//
//	public String toString() {
//		lista = retornaLista();
//		if (raiz == null) {
//			return "[]";
//		}
//		String saida = "[";
//		for (T item : lista) {
//			saida += item + ", ";
//		}
//		return saida.substring(0, saida.length() - 2) + "]";
//	}
//
//	public void balancear() {
//		if (raiz == null) {
//			return;
//		} else {
//			ArrayList<T> lista = retornaLista();
//			raiz = null;
//			balancear(lista);
//			return;
//		}
//	}
//
//	private void balancear(ArrayList<T> lista) {
//		int meio = 0;
//		if (lista.size() == 0) {
//			return;
//		}
//		if (lista.size() > 1) {
//			meio = lista.size() / (2 - 1);
//		}
//		inserir(lista.get(meio));
//		if (meio > 0) {
//			balancear((ArrayList<T>) lista.subList(0, meio));
//		} else if (meio < lista.size()) {
//			balancear((ArrayList<T>) lista.subList(meio + 1, lista.size()));
//		}
//	}
//
//	public int altura() {
//		return altura(this.raiz);
//	}
//
//	private int altura(NoBinBusca<T> no) {
//		if (no != null) {
//			int altEsq = altura(no.getFilhoEsquerdo());
//			int altDir = altura(no.getFilhoDireito());
//			if (altEsq < altDir) {
//				return altDir + 1;
//			} else {
//				return altEsq + 1;
//			}
//		} else {
//			return -1;
//		}
//	}
//
//	public int contFolhas() {
//		return contFolhas(raiz);
//	}
//
//	private int contFolhas(NoBinBusca<T> p) {
//		if (p == null) {
//			return 0;
//		} else if (p.getFilhoEsquerdo() == null && p.getFilhoDireito() == null) {
//			return 1;
//		} else {
//			return contFolhas(p.getFilhoEsquerdo())
//					+ contFolhas(p.getFilhoDireito());
//		}
//	}
//
//	public int diametro() {
//		return diametro(raiz);
//	}
//
//	private int diametro(NoBinBusca<T> p) {
//		if (p == null) {
//			return 0;
//		}
//		// the path goes through the root
//		int len1 = altura(p.getFilhoEsquerdo()) + altura(p.getFilhoDireito())
//				+ 3;
//
//		// the path does not pass the root
//		int len2 = Math.max(diametro(p.getFilhoEsquerdo()),
//				diametro(p.getFilhoDireito()));
//
//		return Math.max(len1, len2);
//	}
//
//	public int largura() {
//		int max = 0;
//		for (int k = 0; k <= altura(); k++) {
//			int tmp = largura(raiz, k);
//			if (tmp > max) {
//				max = tmp;
//			}
//		}
//		return max;
//	}
//
//	private int largura(NoBinBusca<T> p, int depth) {
//		if (p == null) {
//			return 0;
//		} else if (depth == 0) {
//			return 1;
//		} else {
//			return largura(p.getFilhoEsquerdo(), depth - 1)
//					+ largura(p.getFilhoDireito(), depth - 1);
//		}
//	}
//
//	public ArrayList<T> getLista() {
//		return lista;
//	}
//
//	public LinkedList<T> emLargura() {
//		LinkedList<T> lista1 = new LinkedList<T>();
//		LinkedList<NoBinBusca<T>> lista2;
//		lista2 = new LinkedList<NoBinBusca<T>>();
//
//		lista2.add(raiz);
//		NoBinBusca<T> no;
//
//		while (lista2.size() > 0) {
//			no = lista2.poll();
//			if (no != null) {
//				lista1.add(no.getValor());
//				if (no.getFilhoEsquerdo() != null) {
//					lista2.add(no.getFilhoEsquerdo());
//				}
//				if (no.getFilhoDireito() != null) {
//					lista2.add(no.getFilhoDireito());
//				}
//			}
//		}
//
//		return lista1;
//
//	}
//
//	// ---------------------METODO ME----------------------
//	public Collection<T> obterTodosEmLargura() {
//
//		LinkedList<T> lista1 = emLargura();
//		LinkedList<T> lista2 = new LinkedList<T>();
//
//		while (lista1.size() > 0) {
//			lista2.addFirst(lista1.getFirst());
//			lista1.removeFirst();
//
//		}
//		return lista2;
//	}
//	// -------------------FIM DA ARVORE--------------------
}

