package lista;
import util.ElementoInexistenteException;
import util.IndiceInexistenteException;
import util.NaoHaElementosException;
import util.NaoHaEspacosVaziosException;

public interface TLista {

	public void addFinal(int e) throws NaoHaEspacosVaziosException;
	
	public void addInicio(int e) throws NaoHaEspacosVaziosException;
	
	public void addIndice(int e, int i) throws NaoHaEspacosVaziosException, IndiceInexistenteException;

	public int removerFinal() throws NaoHaElementosException;
	
	public int removerInicio() throws NaoHaElementosException;
	
	public int removerIndice(int i) throws NaoHaElementosException, IndiceInexistenteException;
	
	public void removerElemento(int e) throws NaoHaElementosException, ElementoInexistenteException;

	public boolean existe(int e);
	
	public int indice(int e) throws ElementoInexistenteException;
	
	public int elemento(int i) throws IndiceInexistenteException;
	
	public boolean isVazia();
	
	public boolean isCheia();
	
	public int tamanho();
	
	public void imprimir();
}
