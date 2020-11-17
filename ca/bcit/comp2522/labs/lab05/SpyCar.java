package ca.bcit.comp2522.labs.lab05;

public class SpyCar extends Vehicle implements Submersible {

    private int maxDepth;

    public SpyCar() {
        super();
    }

    public SpyCar(final String make, final String model,
                  final int topSpeed, final int numPassengers,
                  final int maxDepth) {
        super(make, model, numPassengers, topSpeed);
        this.maxDepth = maxDepth;
    }


    @Override
    public void setDepth(final int depth) {
        this.maxDepth = depth;
    }

    @Override
    public int getDepth() {
        return maxDepth;
    }
}
