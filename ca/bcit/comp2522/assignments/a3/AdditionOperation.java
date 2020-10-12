package ca.bcit.comp2522.assignments.a3;

public class AdditionOperation extends AbstractOperation {
    /** Addition symbol. */
    static final char ADDITION_CODE = '+';

    /**
     * Addition Operation constructor.
     */
    public AdditionOperation() {
        super(ADDITION_CODE);
    }

    /**
     * Performs operation.
     * @param operandA
     * @param operandB
     * @return A + B.
     */
    public int perform(final int operandA, final int operandB) {
        return operandA + operandB;
    }
}
