package exceptions;

public class EmptyDeckException extends Exception  {
    public EmptyDeckException(String errorMessage){
        super(errorMessage);
    }
}
