package ca.bcit.comp2522.labs.lab03;

public class Point {
    /** X coordinate. */
    private double x;
    /** Y coordinate. */
    private double y;

    /**
     * Constructor for points.
     * @param xc
     * @param yc
     */
    public Point(final int xc, final int yc) {
        this.x = xc;
        this.y = yc;
    }

    /**
     * Getter for Y coordinate.
     * @return Y.
     */
    public double getY() {
        return y;
    }

    /**
     * Getter for X coordinate.
     * @return X.
     */
    public double getX() {
        return x;
    }
}
