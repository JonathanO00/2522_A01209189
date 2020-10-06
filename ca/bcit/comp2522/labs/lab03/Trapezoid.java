package ca.bcit.comp2522.labs.lab03;

public class Trapezoid extends Quadrilateral {
    /** Top base variable. */
    private double baseTop;
    /** Bottom base variable. */
    private double baseBottom;

    /**
     * Trapezoid constructor.
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     */
    public Trapezoid(final Point p1, final Point p2,
                     final Point p3, final Point p4) {
        baseTop = p2.getX() - p1.getX();
        baseBottom = p4.getX() - p3.getX();
        height = p1.getY() - p3.getY();
    }

    /**
     * Gets area of trapezoid.
     */
    public void area() {
        System.out.println("Area: " + ((baseTop + baseBottom) / 2) * height);
    };

}
