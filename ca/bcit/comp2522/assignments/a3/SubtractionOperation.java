package ca.bcit.comp2522.assignments.a3;

public class SubtractionOperation extends AbstractOperation {
    /** Subtraction symbol. */
    static final char SUBTRACTION_CODE = '-';

    /**
     * Subtraction operation constructor.
     */
    public SubtractionOperation() {
        super(SUBTRACTION_CODE);
    }

    /**
     * Performs operation.
     * @param operandA
     * @param operandB
     * @return A - B.
     */
    public int perform(final int operandA, final int operandB) {
        return operandA - operandB;
    }
}
