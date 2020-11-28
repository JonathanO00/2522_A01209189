package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class RentalItem extends InventoryItem implements Serializable {
    /** Current condition. */
    private Condition currentCondition;
    /** Items. */
    private Rental[] items;
    /** Rental ID. */
    private static long rentalID;
    /** Rental price. */
    private double rentalPrice;
    /** Sellable. */
    private boolean sellable;
    /** Serial version UID. */
    private final long serialVersionUID = 4;
    /** Sold. */
    private boolean sold;

    /**
     * Rental item constructor.
     * @param newIpd IPD.
     * @param newSku SKU.
     * @param newDesc Description.
     * @param newName Name.
     * @param newPurchasePrice Purchase price.
     * @param newType Type.
     * @param newCondition Condition.
     * @param newRentalId Rental ID.
     * @param newRentalPrice Rental price.
     * @param newSellable Sellable.
     * @param newSold Sold.
     * @param newItems Items.
     */
    public RentalItem(final Date newIpd, final long newSku, final String newDesc,
                      final String newName, final double newPurchasePrice,
                      final String newType, final Condition newCondition,
                      final long newRentalId, final double newRentalPrice,
                      final boolean newSellable, final boolean newSold,
                      final Rental[] newItems) {
        super(newIpd, newSku, newDesc, newName, newPurchasePrice, newType);
        currentCondition = newCondition;
        rentalID = newRentalId;
        rentalPrice = newRentalPrice;
        sellable = newSellable;
        sold = newSold;
    }

    /**
     * Getter for currentCondition.
     * @return currentCondition.
     */
    public Condition getCurrentCondition() {
        return currentCondition;
    }

    /**
     * Setter for current condition.
     * @param currentCondition
     */
    public void setCurrentCondition(final Condition currentCondition) {
        this.currentCondition = currentCondition;
    }

    /**
     * Getter for items.
     * @return items.
     */
    public Rental[] getItems() {
        return items;
    }

    /**
     * Setter for items.
     * @param items
     */
    public void setItems(final Rental[] items) {
        this.items = items;
    }

    /**
     * Getter for rental ID.
     * @return rental ID.
     */
    public long getRentalID() {
        return rentalID;
    }

    /**
     * Setter for rental ID.
     * @param rentalID
     */
    public void setRentalID(final long rentalID) {
        this.rentalID = rentalID;
    }

    /**
     * Getter for rental price.
     * @return rental price.
     */
    public double getRentalPrice() {
        return rentalPrice;
    }

    /**
     * Setter for rental price.
     * @param rentalPrice
     */
    public void setRentalPrice(final double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    /**
     * Getter for sellable.
     * @return sellable.
     */
    public boolean isSellable() {
        return sellable;
    }

    /**
     * Setter for sellable.
     * @param sellable
     */
    public void setSellable(final boolean sellable) {
        this.sellable = sellable;
    }

    /**
     * Getter for sold.
     * @return sold.
     */
    public boolean isSold() {
        return sold;
    }

    /**
     * Setter for sold.
     * @param sold
     */
    public void setSold(final boolean sold) {
        this.sold = sold;
    }

    /**
     * Equals method.
     * @param r Rental item.
     * @return Rental item equals.
     */
    public boolean equals(RentalItem r) {
        if (this == r) return true;
        if (r == null || getClass() != r.getClass()) return false;
        if (!super.equals(r)) return false;
        return rentalID == r.rentalID &&
                Double.compare(r.rentalPrice, rentalPrice) == 0;
    }

    /**
     * Hashcode method.
     * @return Hashcode.
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), currentCondition, rentalID,
                rentalPrice, sellable, serialVersionUID, sold);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    /**
     * Tostring method.
     * @return Item as a string.
     */
    public String toString() {
        return "Condition: " + currentCondition + " Price: " + rentalPrice;
    }
}
