import lista.TLista;
import lista.TListaEncadeada;
import lista.TListaSequencial;
import util.NaoHaEspacosVaziosException;

public class Programa {

	public static void main(String[] args) throws Exception {
		TLista lista = new TListaEncadeada();
		lista.addFinal(10);
		lista.addFinal(20);
		lista.addFinal(30);
		lista.imprimir();
		lista.addInicio(50);
		lista.imprimir();
		lista.removerFinal();
		lista.imprimir();
	}
	
}
