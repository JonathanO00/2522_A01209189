package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class InventoryItem implements Serializable {
    /** IPD. */
    private Date ipd;
    /** SKU. */
    private long sku;
    /** Description. */
    private String desc;
    /** Item name. */
    private String name;
    /** Purchase price. */
    private double purchasePrice;
    /** Serial version UID. */
    private final long serialVersionUID = 2;
    /** Type. */
    private String type;

    /**
     * InventoryItem constructor.
     * @param newIpd IPD.
     * @param newSku SKU.
     * @param newDesc Description.
     * @param newName Name.
     * @param newPurchasePrice Purchase Price.
     * @param newType Type.
     */
    public InventoryItem(final Date newIpd, final long newSku,
                         final String newDesc, final String newName,
                         final double newPurchasePrice, final String newType) {
        ipd = newIpd;
        sku = newSku;
        desc = newDesc;
        name = newName;
        purchasePrice = newPurchasePrice;
        type = newType;
    }

    /**
     * Getter for description.
     * @return description.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Setter for description.
     * @param desc
     */
    public void setDesc(final String desc) {
        this.desc = desc;
    }

    /**
     * Getter for IPD.
     * @return IPD.
     */
    public Date getIpd() {
        return ipd;
    }

    /**
     * Setter for IPD.
     * @param ipd
     */
    public void setIpd(final Date ipd) {
        this.ipd = ipd;
    }

    /**
     * Getter for SKU.
     * @return SKU.
     */
    public long getSku() {
        return sku;
    }

    /**
     * Setter for SKU.
     * @param sku
     */
    public void setSku(final long sku) {
        this.sku = sku;
    }

    /**
     * Getter for name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Getter for purchase price.
     * @return purchase price.
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Setter for purchase price.
     * @param purchasePrice
     */
    public void setPurchasePrice(final double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * Getter for type.
     * @return type.
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for type.
     * @param type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * Tostring method.
     * @return Item as a string.
     */
    public String toString() {
        return "Name: " + name + " Desc: " + desc
                + " Purchase price: " + purchasePrice;
    }

    /**
     * Equals method.
     * @param o
     * @return equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryItem that = (InventoryItem) o;
        return Double.compare(that.purchasePrice, purchasePrice) == 0 &&
                name.equals(that.name);
    }

    /**
     * Hash code method.
     * @return Hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(ipd, sku, desc, name, purchasePrice, serialVersionUID, type);
    }
}
