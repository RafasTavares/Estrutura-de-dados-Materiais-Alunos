package Componentes;

import java.awt.List;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collection;

public class ArvoreBinBusca <T extends Comparable<T>> {

	private NoArvoreBinBusca<T> Raiz;
	
	public boolean inserir(T Valor) {
		
		NoArvoreBinBusca<T> NovoNo = new NoArvoreBinBusca<T>(Valor);
		
		if (Raiz == null) {
			Raiz = NovoNo;
			System.out.println("Raiz: " + Raiz.getValor());
			return true;			
			
		} else {
			NoArvoreBinBusca<T> NoAtual = Raiz;
			boolean Adicionar = true;
			
			while (Adicionar) {
				
				if (NoAtual.getValor().compareTo(NovoNo.getValor()) == -1) {
		
					if (NoAtual.getFilho2() == null) {
						NoAtual.setFilho2(NovoNo);
						NovoNo.setPai(NoAtual);
						return true;
						
					} else {
						NoAtual = NoAtual.getFilho2();
					}
					
				} else {
					
					if (NoAtual.getFilho1() == null) {
						NoAtual.setFilho1(NovoNo);
						NovoNo.setPai(NoAtual);
						return true;
						
					} else {
						NoAtual = NoAtual.getFilho1();
					}
				}
			}
			
			return true;
		}
	}
	
	public boolean remover(T Valor) {
		NoArvoreBinBusca<T> NoAtual = Raiz;
		
		if (NoAtual == null) {
			return false;
		}
		
		while (NoAtual != null && NoAtual.getValor().compareTo(Valor) != 0) {
			
			if (Valor.compareTo(NoAtual.getValor()) == -1) {
				NoAtual = NoAtual.getFilho1();
			
			} else {
				NoAtual = NoAtual.getFilho2();
			} 
		}
		
		if (NoAtual.getFilho1() == null && NoAtual.getFilho2() == null) {
			
			if (NoAtual.getValor().compareTo(Raiz.getValor()) == 0) {
				Raiz = null;
				return true;
			}
			
			if (NoAtual.getValor().compareTo(NoAtual.getPai().getValor()) == -1) {
				NoAtual.getPai().setFilho1(null);
				NoAtual.setPai(null);
				return true;
			
			} else {
				NoAtual.getPai().setFilho2(null);
				NoAtual.setPai(null);
				return true;
			}
			
		} 
		
		if (NoAtual.getValor().compareTo(Raiz.getValor()) == 0) {
			
			NoArvoreBinBusca<T> NoSucessor = Sucessor(NoAtual);
			
			if (NoSucessor == null) {
				NoSucessor = Antecessor(NoAtual);
			}
			
			T ValorTemp = NoSucessor.getValor();
			
			remover(ValorTemp);
			NoAtual.setValor(ValorTemp);
			return true;
			
		} else if (NoAtual.getFilho1() != null && NoAtual.getFilho2() == null) {
			
			if (NoAtual.getValor().compareTo(NoAtual.getPai().getValor()) == -1) {
				NoAtual.getPai().setFilho1(NoAtual.getFilho1());
				NoAtual.getFilho1().setPai(NoAtual.getPai());
				NoAtual.setPai(null);
				NoAtual.setFilho1(null);
				return true;
			
			} else {
				
				NoAtual.getPai().setFilho2(NoAtual.getFilho1());
				NoAtual.getFilho1().setPai(NoAtual.getPai());
				NoAtual.setPai(null);
				NoAtual.setFilho1(null);
				return true;				
		
			}
		
		} else if (NoAtual.getFilho1() == null && NoAtual.getFilho2() != null) {
			
			if (NoAtual.getValor().compareTo(NoAtual.getPai().getValor()) == -1) {
				NoAtual.getPai().setFilho1(NoAtual.getFilho2());
				NoAtual.getFilho2().setPai(NoAtual.getPai());
				NoAtual.setPai(null);
				NoAtual.setFilho2(null);
				return true;
			
			} else {
				
				NoAtual.getPai().setFilho2(NoAtual.getFilho2());
				NoAtual.getFilho2().setPai(NoAtual.getPai());
				NoAtual.setPai(null);
				NoAtual.setFilho2(null);
				return true;				
			}
			
		} else if (NoAtual.getFilho1() != null && NoAtual.getFilho2() != null) {
			NoArvoreBinBusca<T> NoSucessor = Sucessor(NoAtual);
			
			if (NoSucessor == null) {
				NoSucessor = Antecessor(NoAtual);
			}
			
			T ValorTemp = NoSucessor.getValor();
			
			remover(ValorTemp);
			NoAtual.setValor(ValorTemp);
			return true;
		}		
		
		return false;
	}
	
	public NoArvoreBinBusca<T> Sucessor(NoArvoreBinBusca<T> NoAtual) {
		
		NoArvoreBinBusca<T> NoSucessor = NoAtual;
		
		if (NoSucessor.getFilho2() != null) {
			NoSucessor = NoSucessor.getFilho2();
			
			while (NoSucessor.getFilho1() != null) {
				NoSucessor = NoSucessor.getFilho1();
			}			
			
			return NoSucessor;
		
		} else {
			
			while (NoSucessor.getPai() != null) {
				
				if (NoSucessor.getValor().compareTo(NoAtual.getValor()) == 1) {
					return NoSucessor;
					
				} else {
					NoSucessor = NoSucessor.getPai();
				}
			}
		}
		
		
		return null;
	}
	
    public NoArvoreBinBusca<T> Antecessor(NoArvoreBinBusca<T> NoAtual) {
		
		NoArvoreBinBusca<T> NoAntecessor = NoAtual;
		
		if (NoAntecessor.getFilho1() != null) {
			NoAntecessor = NoAntecessor.getFilho1();
			
			while (NoAntecessor.getFilho2() != null) {
				NoAntecessor = NoAntecessor.getFilho2();
			}			
			
			return NoAntecessor;
		
		} else {
			
			while (NoAntecessor.getPai() != null) {
				
				if (NoAntecessor.getValor().compareTo(NoAtual.getValor()) == -1) {
					return NoAntecessor;
					
				} else {
					NoAntecessor = NoAntecessor.getPai();
				}
			}
		}
		
		
		return null;
	}
	
	public boolean buscar(T Valor) {
		return false;
	}
	
	public void limpar() {
		
		while (Raiz != null) {
			remover(Raiz.getValor());
		}
	}
	
	@Override
	public String toString() {
		
		String S = "";
		
		ArrayList<T> StringList = new ArrayList<T>();
		emOrdem(Raiz, StringList);
		
		if (StringList.size() > 0) {
			S = "[";
		}
		
		for (int i = 0; i < StringList.size(); i++) {
			S += StringList.get(i);
			
			if (StringList.size() < i-1) {
				S += ", ";
			}
		}
		
		if (StringList.size() > 0) {
			S = "]";
		}
		
		return S;
	}
	
	private void emOrdem(NoArvoreBinBusca<T> NoNav, ArrayList<T> Imprimir) {
		
		if (NoNav != null) {
			emOrdem(NoNav.getFilho1(), Imprimir);
			Imprimir.add(NoNav.getValor());
			emOrdem(NoNav.getFilho2(), Imprimir);
		}
				
	}
	
	public void preOrdem(NoArvoreBinBusca<T> NoNav, ArrayList<T> Imprimir) {
		
		if (NoNav != null) {
			Imprimir.add(NoNav.getValor());
			preOrdem(NoNav.getFilho1(), Imprimir);
		    preOrdem(NoNav.getFilho2(), Imprimir);
		}		
	}
	
	public void posOrdem(NoArvoreBinBusca<T> NoNav, ArrayList<T> Imprimir) {
		
		if (NoNav != null) {
			posOrdem(NoNav.getFilho1(), Imprimir);
			posOrdem(NoNav.getFilho2(), Imprimir);
			Imprimir.add(NoNav.getValor());
		}		
	}
	
    public Collection<T> emLargura() {

    	ArrayList<T> Imprimir = new ArrayList<T>();
    	Queue<NoArvoreBinBusca<T>> FilaAtual;
    	FilaAtual = new ArrayDeque<NoArvoreBinBusca<T>>();
    	
    	FilaAtual.add(Raiz);
    	NoArvoreBinBusca<T> NoAtual;
    	
    	while (FilaAtual.size() > 0) {    		
    		NoAtual = FilaAtual.poll();
    		
    		if (NoAtual != null) {
    			Imprimir.add(NoAtual.getValor());
    			
    			if (NoAtual.getFilho1() != null) 
    				FilaAtual.add(NoAtual.getFilho1());	
    			
    			if (NoAtual.getFilho2() != null) 
    				FilaAtual.add(NoAtual.getFilho2());
    		}
    	}
    	
    	return Imprimir;
    }
    
    public void balancearArvore() {
    	
    	NoArvoreBinBusca<T> NoMenor;
    	ArrayList<T> VetorBalanceado = new ArrayList<T>();
    	
    	if (Raiz == null) {
    		return;
    	}
    	
    	for (NoMenor = Raiz; NoMenor.getFilho1() != null; NoMenor = NoMenor.getFilho1()); 
    	VetorBalanceado.add(NoMenor.getValor());
    	
    	while (Sucessor(NoMenor) != null) {
    		NoMenor = Sucessor(NoMenor);
    		VetorBalanceado.add(NoMenor.getValor()); 
    	}
    	
    	limpar();
    	balancearVetor(0, VetorBalanceado.size()-1, VetorBalanceado);
    }

    private void balancearVetor(int Inicio, int Final, ArrayList<T> Lista) {
    	
    	int Meio = (Inicio + Final)/2;
    	inserir(Lista.get(Meio));
    	
    	if (Final - Inicio == 1){
    		inserir(Lista.get(Meio+1));
    	}
    	
    	else if (Meio-1 >= Inicio && Meio+1 <= Final) {
    		balancearVetor(Inicio, Meio-1, Lista);
        	balancearVetor(Meio+1, Final, Lista);
    	}
    }
    	
    public int altura (NoArvoreBinBusca<T> NoAltura) {
    	
    	if (NoAltura != null) {
	    
    		int AlturaE = altura(NoAltura.getFilho1());
	    	int AlturaD = altura(NoAltura.getFilho2());

	    	NoAltura.setFB(AlturaE - AlturaD);
	    	
	    	if (AlturaE < AlturaD) {
	    		return AlturaD+1;
	    	
	    	} else 
	    		return AlturaE+1;

    	} else
    		return -1;
    	
    }
    
    public NoArvoreBinBusca<T> pivo (NoArvoreBinBusca<T> NoPivo) {
    	
    	if (NoPivo != null && (NoPivo.getFB() == 2 || NoPivo.getFB() == -2)) {
    		return NoPivo;
    	
    	} else  if (NoPivo != null)
    		return pivo(NoPivo.getPai());
    	
    	
    	return null;
    }
    
    public void rotacionarDD (NoArvoreBinBusca<T> NoPivo) {
    	
    	NoArvoreBinBusca<T> NoAux = NoPivo.getFilho1();
    	
    	if (NoPivo.getPai() != null && NoPivo.getPai().getValor().compareTo(NoPivo.getValor()) < 0) {
    		
    		NoPivo.getPai().setFilho2(NoAux);
    		NoAux.setPai(NoPivo.getPai());
    		
    	} else if (NoPivo.getPai() != null) {
    		NoPivo.getPai().setFilho1(NoAux);
    		NoAux.setPai(NoPivo.getPai());
    	}
    	
    	NoPivo.setPai(NoAux);
    	
    	if (NoAux.getFilho2() != null) {    		
    		
    		NoAux.getFilho2().setPai(NoPivo);
    		NoPivo.setFilho1(NoAux.getFilho2());
    	}
    	
    	NoAux.setFilho2(NoPivo);
    	
    }
    	
    public void rotacionarEE (NoArvoreBinBusca<T> NoPivo) {
    	
    	NoArvoreBinBusca<T> NoAux = NoPivo.getFilho2();
    	
    	if (NoPivo.getPai() != null && NoPivo.getPai().getValor().compareTo(NoPivo.getValor()) > 0) {
    		
    		NoPivo.getPai().setFilho1(NoAux);
    		NoAux.setPai(NoPivo.getPai());
    		
    	} else if (NoPivo.getPai() != null) {
    		NoPivo.getPai().setFilho2(NoAux);
    		NoAux.setPai(NoPivo.getPai());
    	}
    	
    	NoPivo.setPai(NoAux);
    	
    	if (NoAux.getFilho1() != null) {    		
    		
    		NoAux.getFilho1().setPai(NoPivo);
    		NoPivo.setFilho2(NoAux.getFilho1());
    	}
    	
    	NoAux.setFilho1(NoPivo);
    	
    }
    
    public void rotacionarDE (NoArvoreBinBusca<T> NoPivo) {
    
    	rotacionarDD(NoPivo.getFilho2());
    	rotacionarEE(NoPivo);
    }
    
    public void rotacionarED (NoArvoreBinBusca<T> NoPivo) {
    	
    	rotacionarEE(NoPivo.getFilho1());
    	rotacionarDD(NoPivo);
    }
    
}
