package ca.bcit.comp2522.assignments.a2;

import java.util.Scanner;

public class Driver {

    /**
     * Drives the program.
     * @param args
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Ecosystem e = new Ecosystem();
        e.setupSimulation();
        System.out.println("How many weeks would you like to run?");
        e.simulate(scan.nextInt());
    }
}
