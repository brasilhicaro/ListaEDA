package util;

public class IndiceInexistenteException extends Exception{
    public IndiceInexistenteException(){
        super("Este indice não existe.");
    }
}
