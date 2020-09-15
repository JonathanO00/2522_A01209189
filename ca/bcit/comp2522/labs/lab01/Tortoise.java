package ca.bcit.comp2522.labs.lab01;

public class Tortoise {
    int position;

    public Tortoise() {
        position = 0;
    }

    public int move() {
        double positionRoll = Math.random();
        if (positionRoll < 0.5) {
            position += 3;
        } else if (positionRoll >= 0.5 && positionRoll < 0.7) {
            position -= 6;
        } else if (positionRoll >= 0.7 && positionRoll < 1) {
            position++;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tortoise tortoise = (Tortoise) o;
        return position == tortoise.position;
    }

    public String toString() {
        return "Tortoise position: " + position;
    }
}
