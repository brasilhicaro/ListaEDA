package lista;

import java.util.Objects;

import util.ElementoInexistenteException;
import util.IndiceInexistenteException;
import util.NaoHaElementosException;
import util.NaoHaEspacosVaziosException;

public class TListaSequencial implements TLista {

	private int[] array;
	private int quantidade;

	public TListaSequencial(int MAX) {
		array = new int[MAX];
		quantidade = 0;
	}

	public void addFinal(int e) throws NaoHaEspacosVaziosException {
		if (isCheia()) {
			throw new NaoHaEspacosVaziosException();
		}

		array[quantidade++] = e;
	}

	public void addInicio(int e) throws NaoHaEspacosVaziosException {
		if (isCheia())
			throw new NaoHaEspacosVaziosException();

		for (int i = quantidade; i > 0; i--)
			array[i] = array[i - 1];

		array[0] = e;
		quantidade++;
	}

	/**
	 * @author alunos
	 */
	public void addIndice(int e, int i) throws NaoHaEspacosVaziosException, IndiceInexistenteException {
		int tamanho = this.array.length;

		if (i > tamanho || i < 0) {
			throw new IndiceInexistenteException();
		} else if (this.isCheia()) {
			throw new NaoHaEspacosVaziosException();
		}
		if (this.isVazia() || i == 0) {
			addInicio(e);
			return;
		}
		if (i == tamanho - 1) {
			addFinal(e);
			return;
		}
		int quantArray = this.tamanho();
		for (int cont = quantArray; i <= quantidade; cont--) {
			this.array[cont] = this.array[cont - 1];
		}

	}

	public int removerFinal() throws NaoHaElementosException {

		if (isVazia())
			throw new NaoHaElementosException();

		int lixo = array[quantidade - 1];
		quantidade--;
		return lixo;
	}

	/**
	 * @author alunos
	 */
	public int removerInicio() throws NaoHaElementosException {
		if(isVazia())
			throw new NaoHaElementosException();
		boolean umNumero = quantidade == 1;
		int lixo = 0;
		if(!umNumero){
			lixo = array[0];
			for(int i = 1;i <= quantidade-1 ;i++){
				array[i-1] = array[i] ;
			}	
		}
		else{
			lixo= array[0];
			quantidade--;
			return lixo;
		}

		quantidade--;
		return lixo;
	}

	/**
	 * @author alunos
	 */
	public int removerIndice(int i) throws NaoHaElementosException, IndiceInexistenteException {
		if(quantidade < i || i <= 0 )
			throw new IndiceInexistenteException();
		else if(Objects.isNull(array[i]) || isVazia())
			throw new NaoHaElementosException();
		
		if(quantidade == i ){
			int lixo = array[i];
			--quantidade;
			return lixo;

		}
		int lixo = array[i];
		for(int cont = i-1;cont < quantidade ;cont++){
			array[cont] = array[cont+1];
		}
		--quantidade;
		return lixo;
	}

	/**
	 * @author alunos
	 */
	public void removerElemento(int e) throws NaoHaElementosException, ElementoInexistenteException {
		if(isVazia())
			throw new NaoHaElementosException();		
		if(!existe(e))
			throw new ElementoInexistenteException();

		try {
			for(int i = 0;i < quantidade;i++){
				if(Objects.isNull(array[i]))
					continue;
				if(array[i] == e){
					removerIndice(i+1);
					return;
				}
			}
		} catch (NaoHaElementosException | IndiceInexistenteException e1) {
			System.out.println(e1.getMessage());
		}
	}

	public boolean existe(int e) {

		for (int i = 0; i < quantidade; i++)
			if (array[i] == e)
				return true;

		return false;
	}

	/**
	 * @author alunos
	 */
	public int indice(int e) throws ElementoInexistenteException {
		return 0;
	}

	public int elemento(int i) throws IndiceInexistenteException {
		if (i < 0 || i >= quantidade) {
			throw new IndiceInexistenteException();
		}
		return array[i];
	}

	public boolean isVazia() {
		return quantidade == 0;
	}

	public boolean isCheia() {
		return quantidade == array.length;
	}

	public int tamanho() {
		return quantidade;
	}

	public void imprimir() {
		System.out.print("In�cio -> ");
		for (int i = 0; i < quantidade; i++)
			System.out.print(array[i] + " -> ");
		System.out.println("Fim");
	}

}
