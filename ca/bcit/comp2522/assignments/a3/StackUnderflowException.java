package ca.bcit.comp2522.assignments.a3;

public class StackUnderflowException extends Exception {
    /**
     * Default stackunderflow exception.
     */
    public StackUnderflowException() {
        super("Stack is empty!");
    }

    /**
     * Alternate stackunderflow exception.
     * @param message
     */
    public StackUnderflowException(final String message) {
        super(message);
    }
}
