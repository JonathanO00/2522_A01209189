package ca.bcit.comp2522.assignments.a3;

public interface Operation {
    /**
     * Gets symbol.
     * @return symbol.
     */
    char getSymbol();

    /**
     * Performs operation.
     * @param operandA
     * @param operandB
     * @return
     */
    int perform(int operandA, int operandB);
}
