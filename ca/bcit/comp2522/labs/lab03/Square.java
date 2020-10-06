package ca.bcit.comp2522.labs.lab03;

public class Square extends Rectangle {

    /**
     * Square constructor.
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     */
    public Square(final Point p1, final Point p2,
                  final Point p3, final Point p4) {
        super(p1, p2, p3, p4);
        point1 = p1;
        point2 = p2;
        point3 = p3;
        point4 = p4;
        base = p2.getX() - p1.getX();
        height = p1.getY() - p3.getY();
    }

    /**
     * Gets area of square.
     */
    public void area() {
        System.out.println("Area: " + Math.pow(base, 2));
    }
}
