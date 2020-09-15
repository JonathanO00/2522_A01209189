package ca.bcit.comp2522.labs.lab01;

public class Race {
    int length;
    int ticks;
    String winner;
    Tortoise tortoise;
    Hare hare;

    public Race(final int length) {
        this.length = length;
        hare = new Hare();
        tortoise = new Tortoise();
    }

    public void reset() {
        ticks = 0;
        hare.setPosition(0);
        tortoise.setPosition(0);
    }

    public String simulateRace() {
        reset();
        race();
        return winner;
    }

    private String race() {
        do {
            double turnOrder = Math.random();
            if (turnOrder < 0.5) {
                hare.move();
                tortoise.move();
            } else if (turnOrder >= 0.5) {
                tortoise.move();
                hare.move();
            }
            ticks++;
        } while (hare.position < length && tortoise.position < length);

        if (tortoise.position >= length) {
            winner = "The tortoise won!";
        } else if (hare.position >= length) {
            winner = "The hare won!";
        }

        return winner;
    }

}
