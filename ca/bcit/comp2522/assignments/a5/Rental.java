package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Rental implements Serializable {
    /** Comments. */
    private String comments;
    /** Condition after. */
    private Condition conditionAfter;
    /** Condition before. */
    private Condition conditionBefore;
    /** Date. */
    private Date date;
    /** Rental ID. */
    private long rentalID;
    /** Serial version UID. */
    private final long serialVersionUID = 1;

    /**
     * Rental constructor.
     * @param newComments Comments.
     * @param conditionA Condition After.
     * @param conditionB Condition Before.
     * @param newDate Date.
     * @param newRentalId Rental ID.
     */
    public Rental(final String newComments, final Condition conditionA,
                  final Condition conditionB, final Date newDate,
                  final long newRentalId) {
        comments = newComments;
        conditionAfter = conditionA;
        conditionBefore = conditionB;
        date = newDate;
        rentalID = newRentalId;
    }

    /**
     * Getter for comments.
     * @return comments.
     */
    public String getComments() {
        return comments;
    }

    /**
     * Setter for comments.
     * @param comments
     */
    public void setComments(final String comments) {
        this.comments = comments;
    }

    /**
     * Getter for conditionAfter.
     * @return conditionAfter.
     */
    public Condition getConditionAfter() {
        return conditionAfter;
    }

    /**
     * Setter for conditionAfter.
     * @param conditionAfter
     */
    public void setConditionAfter(final Condition conditionAfter) {
        this.conditionAfter = conditionAfter;
    }

    /**
     * Getter for conditionBefore.
     * @return conditionBefore.
     */
    public Condition getConditionBefore() {
        return conditionBefore;
    }

    /**
     * Setter for conditionBefore.
     * @param conditionBefore
     */
    public void setConditionBefore(final Condition conditionBefore) {
        this.conditionBefore = conditionBefore;
    }

    /**
     * Getter for date.
     * @return date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for date.
     * @param date
     */
    public void setDate(final Date date) {
        this.date = date;
    }

    /**
     * Getter for Rental ID.
     * @return rental ID.
     */
    public long getRentalID() {
        return rentalID;
    }

    /**
     * Setter for Rental ID.
     * @param rentalID
     */
    public void setRentalID(final long rentalID) {
        this.rentalID = rentalID;
    }

    /**
     * Equals method.
     * @param r rental
     * @return
     */
    public boolean equals(Rental r) {
        if (this == r) return true;
        if (r == null || getClass() != r.getClass()) return false;
        return rentalID == r.rentalID &&
                serialVersionUID == r.serialVersionUID;
    }

    /**
     * Hashcode method.
     * @return Hash.
     */
    @Override
    public int hashCode() {
        return Objects.hash(comments, conditionAfter, conditionBefore, date, rentalID, serialVersionUID);
    }

    /**
     * ToString method.
     * @return Rental as a string.
     */
    public String toString() {
        return "Comments: " + comments + " Condition before: "
                + conditionBefore + " Condition after: " + conditionAfter;
    }
}
