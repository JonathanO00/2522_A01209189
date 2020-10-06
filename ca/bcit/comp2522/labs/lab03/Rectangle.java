package ca.bcit.comp2522.labs.lab03;

public class Rectangle extends Parallelogram {

    /**
     * Rectangle constructor.
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     */
    public Rectangle(final Point p1, final Point p2,
                     final Point p3, final Point p4) {
        super(p1, p2, p3, p4);
        base = p2.getX() - p1.getX();
        height = p1.getY() - p3.getY();
    }

    /**
     * Gets area of rectangle.
     */
    public void area() {
        System.out.println("Area: " + (base * height));
    }
}
