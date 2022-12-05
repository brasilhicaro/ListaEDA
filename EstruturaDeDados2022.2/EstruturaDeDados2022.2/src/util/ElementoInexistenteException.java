package util;

public class ElementoInexistenteException extends Exception{
    
    public ElementoInexistenteException(){
        super("Este elemento não existe.");
    }
}
