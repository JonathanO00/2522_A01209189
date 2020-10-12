package ca.bcit.comp2522.assignments.a3;

public abstract class AbstractOperation implements Operation {
    /** Operation type. */
    protected char operationType;

    /**
     * Constructor.
     * @param oType
     */
    public AbstractOperation(final char oType) {
        operationType = oType;
    }

    /**
     * operationType getter.
     * @return operationType as a char.
     */
    public final char getSymbol() {
        return operationType;
    }
}
