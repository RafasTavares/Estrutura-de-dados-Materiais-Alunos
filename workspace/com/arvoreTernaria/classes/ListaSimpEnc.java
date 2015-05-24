package br.com.arvoreTernaria.classes;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ListaSimpEnc<T> implements IListaSimpEnc<T> {
	
	private NoSimpEnc<T> inicio;
	private NoSimpEnc<T> fim;
	private int totalElementos;
    private Iterator<T> myIterator = new Iterator<T>(){
		
		private NoSimpEnc<T> posAtual = inicio;

		public boolean hasNext() {
			if(this.posAtual.getProximo() == null){
				return false;
			}
			return true;
			
			}

		public T next() {
			if(hasNext()== false){
				throw new IllegalArgumentException("Posição inválida!");
			}else{
				
			T elemento = this.posAtual.getElemento();
			this.posAtual = this.posAtual.getProximo();
			return elemento;
			}
		}

		public void remove() {
		}
		
	};
	
        public Iterator<T> iterator(){
		
		
		
		return myIterator;
	}

        public ListaSimpEnc() {
    		this.inicio = null;
    		this.totalElementos = 0;
    	}
        
	public void Inserir(int pos, T elemento) {
		if(pos == 1){
			this.InserirInicio(elemento);
		}else if(pos == this.totalElementos + 1){
			this.InserirFim(elemento);
		}else if(pos > this.totalElementos + 1 || pos < 1){
			throw new IndexOutOfBoundsException("Posição inválida!");
		}else{
			NoSimpEnc<T> noAnterior = this.AcharPosicao(pos - 1);
			NoSimpEnc<T> novoNo = new NoSimpEnc(noAnterior.getProximo(), elemento );
			novoNo.setProximo(noAnterior.getProximo());
			noAnterior.setProximo(novoNo);
			this.totalElementos++;
			
		}
	}
	
	private NoSimpEnc<T> AcharPosicao(int pos){
		if(pos > this.totalElementos && pos < 1){
			throw new IllegalArgumentException("Posição inválida!");
		}else{
			NoSimpEnc<T> noAtual = this.inicio;
			for (int i = 1; i < pos; i++) {
				noAtual = noAtual.getProximo();
			}
			return noAtual;
		}
	}

	public void InserirFim(T elemento) {
		NoSimpEnc<T> novoNo = new NoSimpEnc(elemento);
		if(this.fim == null){
			this.inicio = this.fim = novoNo;
		}else{
		
			fim.setProximo(novoNo);
			this.fim = novoNo;
		}
		this.totalElementos++;
		
	}

	public void InserirInicio(T elemento) {
		NoSimpEnc<T> novoNo = new NoSimpEnc(elemento);
		if(this.inicio == null){
			this.inicio = this.fim = novoNo;
		}else{
			novoNo.setProximo(this.inicio);
			this.inicio = novoNo;
		
		}
			
			this.totalElementos++;
		
		
	}
	
	
	private boolean posicaoOcupada(int pos){
		return pos > 0 && pos <= this.totalElementos;
	}


	public void RemoverFim() {
		if(!this.posicaoOcupada(this.totalElementos)){
			throw new IllegalArgumentException("Posição inválida!");
		}else if(this.totalElementos == 1){
			this.RemoverInicio();
		}else{
			NoSimpEnc<T> noAux = this.AcharPosicao(this.totalElementos - 1);
		    this.fim = noAux;
		    this.fim.setProximo(null);
		    this.totalElementos--;
		}
	}

	public void RemoverInicio() {
		if(this.totalElementos < 1){
			throw new IllegalArgumentException("Posição Inválida!");
		}else if(this.inicio == null){
			this.fim = null;
		}else{
			NoSimpEnc<T> noAux = this.inicio;
			this.inicio = this.inicio.getProximo();
			noAux.setProximo(null);
			this.totalElementos--;
		}
			
	}

	public void clear() {
		
		NoSimpEnc<T> noAux = this.inicio;
		NoSimpEnc<T> noAux2 = null;
		
		for (int i = 1; i < this.totalElementos; i++) {
			noAux2 = noAux.getProximo();
			noAux.setProximo(null);
			noAux = noAux2;
		}
		
		this.inicio = null;
		this.fim = null;
		this.totalElementos = 0;
		
	}

	public boolean contem(T elemento) {
		
		NoSimpEnc<T> noAux = this.inicio;
		
		for (int i = 1; i < this.totalElementos + 1 ; i++) {
			if(noAux.getElemento().equals(elemento)){
				return true;
			}else{
				noAux = noAux.getProximo();
			}
		}
		
		return false;
	}

	public boolean estaVazia() {
		if (this.totalElementos == 0) {
			return true;
		}
		return false;
	}

	public NoSimpEnc<T> getFim() {
		return this.fim;
	}

	public NoSimpEnc<T> getInicio() {
		return this.inicio;
	}

	public int size() {
		return this.totalElementos;
	}
	
	public String toString(){
		if(this.totalElementos == 0){
			return " [] ";
		}else{
			StringBuilder builder = new StringBuilder("[");
			
			NoSimpEnc<T> noAtual = this.inicio;
			
			for (int i = 1; i < this.totalElementos; i++) {
				builder.append(noAtual.getElemento());
				builder.append(", ");
				noAtual = noAtual.getProximo();
			}
			builder.append(noAtual.getElemento());
			builder.append("]");
			
			return builder.toString();
		}
	}
	public void InserirLista(int pos, ListaSimpEnc<T> lista) {
		int aux = this.totalElementos;
		if (pos == 1) {
			NoSimpEnc<T> noAux = inicio;
			inicio = lista.inicio;
			lista.fim.setProximo(noAux);
			this.totalElementos = this.totalElementos + aux;
		} else {
			NoSimpEnc<T> noAux = this.AcharPosicao(pos);
			NoSimpEnc<T> noAux2 = this.inicio;
			//NoSimpEnc<T> noPro = this.AcharPosicao(pos - 1);
			noAux.setProximo(lista.inicio);
			for(NoSimpEnc<T> no = inicio; no.getProximo() != null; no = no.getProximo()) {
				
			}
			
			//lista.fim.setProximo(noAux);
			this.totalElementos = this.totalElementos + aux;
		}
	}
	
	public void InserirLista2(int pos, ListaSimpEnc<T> lista){
		
		int aux = this.totalElementos;
		
		
		this.totalElementos = this.totalElementos + aux;
	}
	
	public void RemoverPosicao(int pos){
		if(!this.posicaoOcupada(pos)){
			throw new IllegalArgumentException("Posição inválida!");
		}else if(pos == 1){
			this.RemoverInicio();
		}
			else if(pos == this.totalElementos ){
			this.RemoverFim();
		}else{
		NoSimpEnc<T> noAnterior = this.AcharPosicao(pos - 1);
		NoSimpEnc<T> noAtual = noAnterior.getProximo();
		
		noAnterior.setProximo(noAtual.getProximo());
		noAtual.setProximo(null);
		
		this.totalElementos--;
		}
		
	}
	
	public void RemoverIntervalo(int posInicial, int posFinal){
		if(!this.posicaoOcupada(posInicial) && !this.posicaoOcupada(posFinal) && posInicial > posFinal){
			throw new IllegalArgumentException("Posição inválida!");
		}else{
			for (int i = posInicial; i <= posFinal; i++) {
				this.RemoverPosicao(i);
			}
		}
	}
	
	public void InserirObjeto(T objeto, T elemento){
		int cont = 1;
		if(this.contem(objeto)){
			for(NoSimpEnc<T> no = inicio; no.getProximo() != null; no = no.getProximo()) {
				
				if(no.getElemento().equals(objeto)){
			
					this.Inserir(cont + 1, elemento);
					
				break;	
					
				}
				cont++;
			}
			}
	}
	
	
	
	public Object getElemento(int posicao) {
		  return this.AcharPosicao(posicao).getElemento();
	}
	public void RemoverElemento(T elemento) {
		NoSimpEnc<T> atual = this.inicio;
		for (int i = 1; i < totalElementos; i++) {
			if (this.inicio.getElemento().equals(elemento)) {
				this.RemoverInicio();
				break;
			} else if (this.fim.getElemento().equals(elemento)) {
				this.RemoverFim();
				break;
			} else if (atual.getElemento().equals(elemento)) {
				this.RemoverPosicao(i);
			}
			atual = atual.getProximo();
		}
	}
	
	public ListaSimpEnc<T> subLista(int indiceInicial, int indiceFinal){
		NoSimpEnc<T> noAux = this.AcharPosicao(indiceInicial);
		NoSimpEnc<T> noAux2 = this.AcharPosicao(indiceFinal + 1);
		ListaSimpEnc<T> lista = new ListaSimpEnc<T>();
		if(indiceInicial < 1 || indiceFinal > this.totalElementos || indiceInicial > indiceFinal){
			throw new IndexOutOfBoundsException("Posição Inválida!");
		}else{
		for(NoSimpEnc<T> no = noAux; no.getProximo() != noAux2.getProximo(); no = no.getProximo()){
			lista.InserirFim(no.getElemento());
		}
		return lista;
		}
	}
	
	public void selectionSort(){
		for(NoSimpEnc<T> no = this.inicio; no.getProximo() != null; no = no.getProximo()){
			NoSimpEnc<T> menor = no;
			for (NoSimpEnc<T> noOutro = no; noOutro.getProximo() != null; noOutro.getProximo()) {
				if ((Integer) noOutro.getElemento() < (Integer) menor.getElemento()) {
					menor = noOutro;
				}
				NoSimpEnc<T> aux = new NoSimpEnc<T>(no.getElemento());
				menor.elemento = no.getElemento();
				no.elemento = aux.getElemento();
				}
		}
	}
	
	/*public void selectionSort() {
		for (NoDupEnc<T> no1 = inicio; no1 != null; no1 = no1.getProximo()) {
			NoDupEnc<T> menor = no1;
			for (NoDupEnc<T> no2 = no1; no2 != null; no2 = no2.getProximo()) {
				if ((Integer) menor.getElemento() > (Integer) no2.getElemento()) {
					menor = no2;
				}
			}
			NoDupEnc<T> aux = new NoDupEnc<T>(no1.getElemento());
			no1.elemento = menor.elemento;
			menor.elemento = aux.elemento;
		}
	}
	*/
	
	public int posicaoNo(NoSimpEnc<T> no){
		NoSimpEnc<T> aux = this.inicio;
		int i = 1;
		while(no != aux){
			aux = aux.getProximo();
			i++;
		}
		return i;
	}
	
	public  void quicksort(NoSimpEnc<T> ini, NoSimpEnc<T> fim) {
        NoSimpEnc<T> meio;
       
        if(ini != null && fim != null){
        	  if (this.posicaoNo(ini) < this.posicaoNo(fim)) { 
                  meio = particao(ini, fim);
                  quicksort(ini, meio);
                  quicksort(meio.getProximo(), fim);
          }
        }
 }

	
	public NoSimpEnc<T> particao(NoSimpEnc<T> ini, NoSimpEnc<T> fim) {
		NoSimpEnc<T> topo = ini;
		NoSimpEnc<T> noAux = ini.getProximo();
		
		  T pivo = ini.getElemento();
		  
		  while(noAux != fim.getProximo()){
			  		
		    if (((Comparable<T>) noAux.getElemento()).compareTo(pivo) < 0) {
		                topo.setElemento(noAux.getElemento());
		                noAux.setElemento(topo.getProximo().getElemento());
		                topo = topo.getProximo(); 
            }
		    noAux = noAux.getProximo();
		  }
		  topo.setElemento(pivo);
		  return topo;
	}

	}
	/*// A PARTE
	public void removerIntervalo(int indiceInicio, int indiceFim)
			throws ArrayIndexOutOfBoundsException {
		if (indiceFim > contElementos + 1 || indiceInicio < 1) {
			throw new ArrayIndexOutOfBoundsException("Posição Invalida!");
		} else {
			for (int i = indiceInicio; i <= indiceFim; i++) {
				this.Remover(indiceInicio);
			}
		}
	}

	// A PARTE
	private NoSimpEnc<T> atual(int pos) {
		NoSimpEnc<T> atual = this.inicio;
		for (int i = 1; i < pos; i++) {
			atual = atual.getProximo();
		}
		return atual;
	}

	// A PARTE
	public void Remover(int pos) {
		if (pos == 1) {
			this.RemoverInicio();
		} else if (pos == this.contElementos) {
			this.RemoverFim();
		} else {
			NoSimpEnc<T> anterior = this.atual(pos - 1);
			NoSimpEnc<T> atual = anterior.getProximo();
			NoSimpEnc<T> proximo = atual.getProximo();
			anterior.setProximo(proximo);
			// proximo.setAnterior(anterior);
			this.contElementos--;
		}
	}

	// A PARTE
	public void InserirLista(int pos, ListaSimpEnc<T> listaE) {
		NoSimpEnc<T> atual = listaE.getInicio();
		while (atual != null) {
			this.Inserir(pos, atual.getElemento());
			pos++;
			atual = atual.getProximo();
		}
	}
	

	@Override
	public void RemoverInicio() {
		if (this.contElementos == 0) {
			this.inicio = this.fim = null;
		} else {
			NoSimpEnc<T> atual = this.inicio;
			this.inicio = this.inicio.getProximo();
			atual.setProximo(null);
			this.contElementos--;
		}
	}

	@Override
	public void RemoverFim() {
		if (this.contElementos == 1) {
			this.RemoverInicio();
		} else {
			NoSimpEnc<T> atual = this.inicio;
			while (atual.getProximo() != this.fim) {
				atual = atual.getProximo();
			}
			this.fim = atual;
			atual.setProximo(null);
			this.contElementos--;
		}
	}

	// A PARTE
	public void RemoverElemento(T elemento) {
		NoSimpEnc<T> atual = this.inicio;
		for (int i = 1; i < contElementos; i++) {
			if (this.inicio.getElemento().equals(elemento)) {
				this.RemoverInicio();
				break;
			} else if (this.fim.getElemento().equals(elemento)) {
				this.RemoverFim();
				break;
			} else if (atual.getElemento().equals(elemento)) {
				this.Remover(i);
			}
			atual = atual.getProximo();
		}
	}

	// A PARTE
	public void RemoverElemento(T[] indices) {
		NoSimpEnc<T> atual = this.inicio;
		int i = (int) indices[0];
		while (atual.getProximo() != null) {
			this.Remover(i);
			atual = atual.getProximo();
			i++;
		}
	}

	// A PARTE
	public void RemoverTodos(T elemento) {
		NoSimpEnc<T> atual = this.inicio;
		for (int i = 1; i < contElementos + 1; i++) {
			if (elemento.equals(inicio.getElemento())) {
				this.RemoverInicio();
				i--;
			} else if (atual.getElemento().equals(elemento)) {
				this.Remover(i);
				i--;
			}
			atual = atual.getProximo();
			if (atual == null) {
				atual = inicio;
			}
		}
	}

	// A PARTE
	public boolean comparaLista(ListaSimpEnc<T> listaE) {
		if (this.toString().equals(listaE.toString())) {
			return true;
		} else {
			return false;
		}
	}

	// A PARTE
	public void inverterLista() {
		NoSimpEnc<T> atual = this.inicio;
		ListaSimpEnc<T> listaE = new ListaSimpEnc<T>();
		int contagem = contElementos;
		for (int i = contagem; i > 0; i--) {
			atual = inicio;
			for (int j = i; j > 1; j--) {
				atual = atual.getProximo();
			}
			listaE.InserirFim(atual.getElemento());
		}
		inicio = listaE.getInicio();
		fim = listaE.getFim();
	}
*/
	
	//filipi acima
	
	
	/*
	/*
	
	
		
	}
	
	
	
	
	
	public void Inserir(int pos, ListaSimpEnc<T> lista) {
		int auxLista = lista.size();

		NoSimpEnc<T> noAnterior = this.AcharPosicao(pos - 1);
		lista.fim.setProximo(noAnterior.getProximo());
		noAnterior.setProximo(lista.inicio);
		this.totalElementos = this.totalElementos + auxLista;

	}
	
	
	
	public void inverterLista() {
		NoSimpEnc<T> noAux1 = this.inicio;
		NoSimpEnc<T> noAux2 = this.fim;
		
		noAux2.setProximo(noAux1);
		
		for (int i = 0; i < this.totalElementos ; i++) {
			
			noAux1 = noAux1.getProximo();
			noAux2 = noAux1;
			noAux1 = noAux2.getProximo();
			

		}
	}

	public boolean comparaLista(ListaSimpEnc<T> lista) {
		NoSimpEnc<T> aux;
		NoSimpEnc<T> aux2;
		aux = this.inicio;
		aux2 = lista.inicio;
		int cont = 0;
		for (int i = 0; i < this.totalElementos; i++) {
			if (aux.getElemento().equals(aux2.getElemento())) {

				cont++;
			}
			aux = aux.getProximo();
			aux2 = aux2.getProximo();
		}
		if (cont == lista.size()) {
			return true;
		}

		return false;

	}
	
	public  void quicksort(NoSimpEnc<T> ini, NoSimpEnc<T> fim) {
        NoSimpEnc meio;
        if ((Integer)ini.getElemento() < (Integer)fim.getElemento()) { 
            meio = particao(ini, fim);
            quicksort(ini, meio);
            quicksort(meio.getProximo(), fim);
    }
  }

	private NoSimpEnc<T> particao(NoSimpEnc<T> ini, NoSimpEnc<T> fim) {
		  NoSimpEnc<T> topo, i;
		  T pivo = null;
		  topo = (NoSimpEnc<T>) ini.getElemento();
		  topo = ini; 
		  for (NoSimpEnc<T> noAux = ini.getProximo(); noAux != fim.getProximo(); noAux = noAux.getProximo()) {
		    if (((Comparable<T>) noAux.getElemento()).compareTo(pivo) < 0) {
		                topo.setProximo(noAux);
		                noAux = topo.getProximo();
		                topo = topo.getProximo(); } }
		        topo.setProximo((NoSimpEnc<T>) pivo);
		        return topo; 

	}
	
	*/



