package ca.bcit.comp2522.assignments.a3;

public class DivisionOperation extends AbstractOperation {
    /** Division symbol. */
    static final char DIVISION_CODE = '/';

    /**
     * Division operation constructor.
     */
    public DivisionOperation() {
        super(DIVISION_CODE);
    }

    /**
     * Performs operation.
     * @param operandA
     * @param operandB
     * @return A / B.
     */
    public int perform(final int operandA, final int operandB) {
        return operandA / operandB;
    }
}
