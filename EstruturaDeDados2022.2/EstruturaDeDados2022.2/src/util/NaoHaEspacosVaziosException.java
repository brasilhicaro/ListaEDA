package util;

public class NaoHaEspacosVaziosException extends Exception{
    
    public NaoHaEspacosVaziosException(){
        super("Não há espaços existe.");
    }
}
