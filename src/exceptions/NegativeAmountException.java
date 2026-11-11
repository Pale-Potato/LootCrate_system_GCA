package exceptions;

public class NegativeAmountException extends RuntimeException { //unchecked
    public NegativeAmountException() {
        super("Negative amount not allowed.");
    }
}
