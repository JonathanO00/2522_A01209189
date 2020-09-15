package ca.bcit.comp2522.labs.lab01;

public class Hare {
    int position;

    public Hare() {
        position = 0;
    }

    public int move() {
        double positionRoll = Math.random();
        if (positionRoll < 0.2) {
            position = position;
        } else if (positionRoll >= 0.2 && positionRoll < 0.3) {
            position += 9;
        } else if (positionRoll >= 0.3 && positionRoll < 0.4) {
            position -= 12;
        } else if (positionRoll >= 0.4 && positionRoll < 0.7) {
            position++;
        } else if (positionRoll >= 0.7 && positionRoll < 1) {
            position -= 2;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(final int position) {
        this.position = position;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hare hare = (Hare) o;
        return position == hare.position;
    }

    public String toString() {
        return "Hare position: " + position;
    }
}
