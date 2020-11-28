package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class SalesItem extends InventoryItem implements Serializable {
    /** Sale price. */
    private double salePrice;
    /** sales ID. */
    private static long salesID;
    /** Sellable. */
    private boolean sellable;
    /** Serial version UID. */
    private final long serialVersionUID = 3;
    /** Sold. */
    private boolean sold;

    /**
     * SalesItem constructor.
     * @param newIpd IPD.
     * @param newSku SKU.
     * @param newDesc Description.
     * @param newName Name,
     * @param newPurchasePrice Purchase price.
     * @param newType Type.
     * @param newSalePrice Sale price.
     * @param newSalesID Sales ID.
     * @param newSellable Sellable.
     * @param newSold Sold.
     */
    public SalesItem(final Date newIpd, final long newSku, final String newDesc,
                     final String newName, final double newPurchasePrice,
                     final String newType, final double newSalePrice,
                     final long newSalesID, final boolean newSellable,
                     final boolean newSold) {
        super(newIpd, newSku, newDesc, newName, newPurchasePrice, newType);
        salePrice = newSalePrice;
        salesID = newSalesID;
        sellable = newSellable;
        sold = newSold;
    }

    /**
     * Getter for sales price.
     * @return sales price.
     */
    public double getSalePrice() {
        return salePrice;
    }

    /**
     * Setter for sales price.
     * @param salePrice
     */
    public void setSalePrice(final double salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * Getter for sales ID.
     * @return sales ID.
     */
    public long getSalesID() {
        return salesID;
    }

    /**
     * Setter for sales ID.
     * @param salesID
     */
    public void setSalesID(final long salesID) {
        this.salesID = salesID;
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
     * @param s Sales item.
     * @return Sales item equals.
     */
    public boolean equals(SalesItem s) {
        if (this == s) return true;
        if (s == null || getClass() != s.getClass()) return false;
        if (!super.equals(s)) return false;
        return Double.compare(s.salePrice, salePrice) == 0 &&
                salesID == s.salesID;
    }

    /**
     * Hashcode method.
     * @return Hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salePrice, salesID, sellable, serialVersionUID, sold);
    }

    /**
     * ToString method.
     * @return Sales item as a string.
     */
    public String toString() {
        return "Sale price: " + salePrice;
    }
}
