import lista.TLista;
import lista.TListaEncadeada;
import lista.TListaSequencial;
import util.NaoHaEspacosVaziosException;

public class Programa {

	public static void main(String[] args) throws Exception {
		TLista lista = new TListaEncadeada();
		try {

			lista.addFinal(10);
			lista.addFinal(20);
			lista.addFinal(30);
			lista.imprimir();
			lista.addInicio(50);
			lista.imprimir();
			System.out.println(lista.removerIndice(3));
			lista.imprimir();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
