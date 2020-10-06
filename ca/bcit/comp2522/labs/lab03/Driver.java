package ca.bcit.comp2522.labs.lab03;

public class Driver {
    /**
     * Main method.
     * @param args
     */
    public static void main(final String[] args) {

        Trapezoid t = new Trapezoid(new Point(2, 0), new Point(5, 0),
                                    new Point(0, -5), new Point(7, -5));

        Parallelogram p = new Parallelogram(new Point(3, 0), new Point(8, 0),
                                           new Point(0, -5), new Point(5, -5));

        Rectangle r = new Rectangle(new Point(0, 0), new Point(5, 0),
                                    new Point(0, -3), new Point(5, -3));

        Square s = new Square(new Point(0, 0), new Point(5, 0),
                              new Point(0, -5), new Point(5, -5));

        t.area();
        p.area();
        r.area();
        s.area();
    }
}
