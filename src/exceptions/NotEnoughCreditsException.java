package exceptions;

public class NotEnoughCreditsException extends Exception {
    public NotEnoughCreditsException() {
        super("You don't have enough credits for this loot crate");
    }
}
