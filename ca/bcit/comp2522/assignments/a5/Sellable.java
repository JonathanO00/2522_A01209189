package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;

public interface Sellable extends Serializable {
    /**
     * Getter for sellable.
     * @return sellable.
     */
    boolean isSellable();

    /**
     * Setter for sellable.
     */
    void setSellable();
}
