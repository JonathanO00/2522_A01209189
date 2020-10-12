package ca.bcit.comp2522.assignments.a3;

public class MultiplicationOperation extends AbstractOperation {
    /** Multiplication symbol. */
    static final char MULTIPLICATION_CODE = '*';

    /**
     * Multiplication operation constructor.
     */
    public MultiplicationOperation() {
        super(MULTIPLICATION_CODE);
    }

    /**
     * Performs operation.
     * @param operandA
     * @param operandB
     * @return A * B.
     */
    public int perform(final int operandA, final int operandB) {
        return operandA * operandB;
    }
}
