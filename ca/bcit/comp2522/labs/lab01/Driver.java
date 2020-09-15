package ca.bcit.comp2522.labs.lab01;

/** Driver class tests the Race, Tortoise, and Hare
 *  classes.
 *
 *  For reporting:
 *  4a) The tortoise wins.
 *  4b) The tortoise won 100/100 times (length 100).
 *  4c) The tortoise won 100/100 times (length 1000).
 *  The ultimate winner is the tortoise!
 *
 *  */
public class Driver {

    public static void main(String[] args) {
        System.out.println(simulateRaces(100, 1000));
    }

    public static String simulateRaces(final int races, final int raceLength) {
        int tortoiseWins = 0;
        int hareWins = 0;
        Race race = new Race(raceLength);
        for (int i = 0; i < races; i++) {
            race.simulateRace();
            if (race.tortoise.position >= race.length) {
                tortoiseWins++;
            } else if (race.hare.position >= race.length) {
                hareWins++;
            }
        }

        return ("Tortoise wins: " + tortoiseWins + "\nHare wins: " + hareWins);
    }

}
