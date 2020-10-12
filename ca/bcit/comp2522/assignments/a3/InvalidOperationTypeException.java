package ca.bcit.comp2522.assignments.a3;

public class InvalidOperationTypeException extends Exception {
    /**
     * Default invalid type exception.
     */
    public InvalidOperationTypeException() {
        super("Invalid Operation Type!");
    }

    /**
     * Alternate invalid type exception.
     * @param message
     */
    public InvalidOperationTypeException(final String message) {
        super(message);
    }

    /**
     * Alternate invalid type exception.
     * @param o
     */
    public InvalidOperationTypeException(final char c) {
        super("Invalid operation type!");
    }
}
