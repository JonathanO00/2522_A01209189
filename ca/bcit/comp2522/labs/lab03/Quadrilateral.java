package ca.bcit.comp2522.labs.lab03;

public abstract class Quadrilateral {
    /** Point 1. */
    Point point1;
    /** Point 2. */
    Point point2;
    /** Point 3. */
    Point point3;
    /** Point 4. */
    Point point4;
    /** Height variable. */
    double height;

    /**
     * Gets area of quadrilateral.
     */
    public abstract void area();
}
