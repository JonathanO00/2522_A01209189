package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Ecosystem {
    /**Pools list. */
    private ArrayList<Pool> pools;
    /**Random number generator. */
    private Random randomNumberGenerator;

    /**
     * Ecosystem constructor (zero params).
     */
    public Ecosystem() {
        pools = new ArrayList<Pool>();
    }

    /**
     * Adds pool to pools list.
     * @param newPool
     */
    public void addPool(final Pool newPool) {
        if (newPool != null) {
            pools.add(newPool);
        }
    }

    /**
     * Clears list of pools.
     */
    public void reset() {
        pools.clear();
    }

    /**
     * Gets total population of guppies.
     * @return population as an int.
     */
    public int getGuppyPopulation() {
        int totalGuppies = 0;
        for (Pool p : pools) {
            totalGuppies += p.getPopulation();
        }
        return totalGuppies;
    }

    /**
     * Adjusts crowding in ecosystem.
     * @return removed guppies from ecosystem as an int.
     */
    public int adjustForCrowding() {
        int removedGuppies = 0;
        for (Pool p : pools) {
            removedGuppies += p.adjustForCrowding();
        }
        return removedGuppies;
    }

    /**
     * Sets up a simulation for the ecosystem.
     */
    public void setupSimulation() {
        Pool pool1 = new Pool("Skookumchuk", 3000, 42, 7.9, 0.9);
        Pool pool2 = new Pool("Squamish", 15000, 39, 7.7, 0.85);
        Pool pool3 = new Pool("Semiahmoo", 4500, 37, 7.5, 1.0);
        randomNumberGenerator = new Random();

        for (int i = 0; i < 300; i++) {
            int rollAge = randomNumberGenerator.nextInt(16) + 10;
            double rollHealth = 0.5 + (0.8 - 0.5)
                    * randomNumberGenerator.nextDouble();
            int rollFemaleNum = randomNumberGenerator.nextInt(101);
            boolean rollFemale = false;
            if (rollFemaleNum < 75) {
                rollFemale = true;
            }
            Guppy newGuppy = new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES, rollAge,
                    rollFemale, 1, rollHealth);
            pool1.addGuppy(newGuppy);
        }

        for (int i = 0; i < 100; i++) {
            int rollAge = randomNumberGenerator.nextInt(6) + 10;
            double rollHealth = 0.8 + (1.0 - 0.8)
                    * randomNumberGenerator.nextDouble();
            int rollFemaleNum = randomNumberGenerator.nextInt(101);
            boolean rollFemale = false;
            if (rollFemaleNum < 75) {
                rollFemale = true;
            }
            Guppy newGuppy = new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES, rollAge,
                    rollFemale, 1, rollHealth);
            pool2.addGuppy(newGuppy);
        }

        for (int i = 0; i < 200; i++) {
            int rollAge = randomNumberGenerator.nextInt(35) + 15;
            double rollHealth = randomNumberGenerator.nextDouble();
            int rollFemaleNum = randomNumberGenerator.nextInt(101);
            boolean rollFemale = false;
            if (rollFemaleNum < 35) {
                rollFemale = true;
            }
            Guppy newGuppy = new Guppy(Guppy.DEFAULT_GENUS,
                    Guppy.DEFAULT_SPECIES, rollAge, rollFemale,
                    1, rollHealth);
            pool3.addGuppy(newGuppy);
        }

        addPool(pool1);
        addPool(pool2);
        addPool(pool3);
    }

    /**
     * Simulates a number of weeks in the ecosystem.
     * @param numberOfWeeks
     */
    public void simulate(final int numberOfWeeks) {
        for (int i = 0; i < numberOfWeeks; i++) {
            simulateOneWeek();
        }
    }

    /**
     * Simulates one week in the ecosystem.
     */
    public void simulateOneWeek() {
        int diedOfOldAge = 0;
        int numberRemoved = 0;
        int starvedToDeath = 0;
        int newFry = 0;
        int crowdedOut = 0;

        Iterator<Pool> p = pools.iterator();
        while (p.hasNext()) {
            diedOfOldAge += p.next().incrementAges();
            numberRemoved += p.next().removeDeadGuppies();
            starvedToDeath += p.next().applyNutrientCoefficient();
            numberRemoved += p.next().removeDeadGuppies();
            newFry += p.next().spawn();
            crowdedOut += p.next().adjustForCrowding();
            numberRemoved += p.next().removeDeadGuppies();
        }

        if (!(diedOfOldAge + starvedToDeath + crowdedOut == numberRemoved)) {
            throw new Error(
                    "Logic error: Number of deaths does not add up correctly.");
        }

        System.out.println("Number of deaths this week due to old age: "
                + diedOfOldAge);
        System.out.println("Number of deaths this week due to starvation: "
                + starvedToDeath);
        System.out.println("Number of deaths this week due to overcrowding: "
                + crowdedOut);
        System.out.println("Number of new births this week: "
                + newFry);
        System.out.println("Pool populations:");
        System.out.println("Skookumchuk: " + pools.get(0).getPopulation());
        System.out.println("Squamish: " + pools.get(1).getPopulation());
        System.out.println("Semiahmoo: " + pools.get(2).getPopulation());
        System.out.println("Total population: " + getGuppyPopulation());
    }
}
