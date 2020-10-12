package ca.bcit.comp2522.assignments.a3;

public class StackOverflowException extends Exception {
    /**
     * Default stackoverflow exception.
     */
    public StackOverflowException() {
        super("This stack is full!");
    }

    /**
     * Alternate stackoverflow exception.
     * @param message
     */
    public StackOverflowException(final String message) {
        super(message);
    }
}
