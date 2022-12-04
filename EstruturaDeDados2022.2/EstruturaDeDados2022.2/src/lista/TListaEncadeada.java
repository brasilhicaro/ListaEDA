package lista;

import util.ElementoInexistenteException;
import util.IndiceInexistenteException;
import util.NaoHaElementosException;
import util.NaoHaEspacosVaziosException;

public class TListaEncadeada implements TLista{

	private No inicio;
	
	
	public void addFinal(int e)  {
		No novo = new No(e);
		
		
		if (isVazia()) {
			inicio = novo;
			return;
		}

		No auxiliar = inicio;
		
		while (auxiliar.proximo != null) {
			auxiliar = auxiliar.proximo;
		}
		
		auxiliar.proximo = novo;
	}

	public void addInicio(int e) {
		No novo = new No(e);
		novo.proximo = inicio;
		inicio = novo;
	}

	public void addIndice(int e, int i) throws IndiceInexistenteException {

		No novo = new No(e);
		
		int tam = tamanho();
		
		if (i < 0 && i > tam) {
			throw new IndiceInexistenteException();
		}
		
		if (i == 0) {
			addInicio(e);
			return;
		}
		
		No auxiliar = inicio;
		
		for(int contador = 1; contador < i; contador++) {
			auxiliar = auxiliar.proximo;
		}
		
		novo.proximo = auxiliar.proximo;
		auxiliar.proximo = novo;
		
		
	}

	public int removerFinal() throws NaoHaElementosException {
		
		if (isVazia())
			throw new NaoHaElementosException();
		
		No anterior = null;
		No auxiliar = inicio;
		
		while (auxiliar.proximo != null) {
			anterior = auxiliar;
			auxiliar = auxiliar.proximo;
		}
		
		if (anterior == null) {
			inicio = null;
		} else {
			anterior.proximo = null;
		}
		
		
		return auxiliar.dado;
	}

	public int removerInicio() throws NaoHaElementosException{
		if (!isVazia()) {
			No lixo = inicio;
			inicio = inicio.proximo;
			lixo.proximo = null;
			return lixo.dado;
		}
		
		throw new NaoHaElementosException();
	}

	/**
	 * @author alunos
	 */
	public int removerIndice(int i) throws NaoHaElementosException, IndiceInexistenteException {
		return 0;
	}

	public void removerElemento(int e) throws NaoHaElementosException, ElementoInexistenteException {
		
		if (isVazia())
			throw new NaoHaElementosException();
		
		
		No anterior = null;
		No auxiliar = inicio;
		
		while (auxiliar != null) {
			if (auxiliar.dado == e) {
				if (anterior == null) {//remoção no início
					inicio = inicio.proximo;
				} else {//remoção no meio ou no fim
					anterior.proximo = auxiliar.proximo;
				}
				auxiliar.proximo = null;
				return;
			}
			anterior = auxiliar;
			auxiliar = auxiliar.proximo;
		}
		
		throw new ElementoInexistenteException();
		
		
		
	}

	public boolean existe(int e) {
		return false;
	}

	/**
	 * @author alunos
	 */
	public int indice(int e) throws ElementoInexistenteException {
		return 0;
	}

	
	public int elemento(int i) throws IndiceInexistenteException {
		
		int tam = tamanho();
		
		if (i < 0 || i >= tam)
			throw new IndiceInexistenteException();

		No auxiliar = inicio;
		

		int cont = 0;
		while(cont != i){
			auxiliar = auxiliar.proximo;
			cont++;
		}
		
		return auxiliar.dado;
	}

	public boolean isVazia() {
		return (inicio == null);
	}

	public boolean isCheia() {
		return false;
	}

	public int tamanho() {
		int tamanho = 0;
		
		No auxiliar = inicio;
		
		while (auxiliar != null) {
			tamanho++;
			auxiliar = auxiliar.proximo;
		}
		
		return tamanho;
	}

	public void imprimir() {
		No auxiliar = inicio;
		System.out.print("Início -> ");
		while (auxiliar != null) {
			System.out.print(auxiliar.dado + " -> ");
		}
		System.out.println("Fim");
	}

}
