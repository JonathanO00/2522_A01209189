package ca.bcit.comp2522.assignments.a2;

import java.util.*;

public class Pool {
    /**Default pool name. */
    static final String DEFAULT_POOL_NAME = "Unnamed";
    /**Default pool temperature in celsius. */
    static final double DEFAULT_POOL_TEMP_CELSIUS = 40.0;
    /**Minimum pool temperature in celsius. */
    static final double MINIMUM_POOL_TEMP_CELSIUS = 0.0;
    /**Maximum pool temperature in celsius. */
    static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;
    /**Netural pH level. */
    static final double NEUTRAL_PH = 7.0;
    /**Default nutrient coefficient. */
    static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;
    /**Minimum nutrient coefficient. */
    static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;
    /**Maximum nutrient coefficient. */
    static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;
    /**Name as a string. */
    private final String name;
    /**Litres in volume as a double. */
    private double volumeLitres;
    /**Temperature in celsius. */
    private double temperatureCelsius;
    /**pH level as a double. */
    private double pH;
    /**Nutrient coefficient as a double. */
    private double nutrientCoefficient;
    /**id number as an int. */
    private int identificationNumber;
    /**Guppies in pool. */
    private ArrayList<Guppy> guppiesInPool;
    /**Random number generator. */
    private Random randomNumberGenerator;
    /**Default number of pools. */
    private static int numberOfPools = 0;

    /**
     * Pool constructor (Zero params).
     */
    public Pool() {
        volumeLitres = 0.0;
        name = DEFAULT_POOL_NAME;
        temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
        pH = NEUTRAL_PH;
        nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
        guppiesInPool = new ArrayList<Guppy>();
        randomNumberGenerator = new Random();
        numberOfPools += 1;
        identificationNumber = numberOfPools;
    }

    /**
     * Pool constructor (multiple params).
     * @param newName
     * @param newVolume
     * @param newTemp
     * @param newpH
     * @param newNutrient
     */
    public Pool(final String newName, final double newVolume,
                final double newTemp, final double newpH,
                final double newNutrient) {
        if (newName == null || newName.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            String trimmedName = newName.trim();
            name = trimmedName.substring(0, 1).toUpperCase()
                    + trimmedName.substring(1);
        }

        if (newVolume < 0.0) {
            volumeLitres = 0.0;
        } else {
            volumeLitres = newVolume;
        }

        if (newTemp < MINIMUM_POOL_TEMP_CELSIUS
                || newTemp > MAXIMUM_POOL_TEMP_CELSIUS) {
            temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
        } else {
            temperatureCelsius = newTemp;
        }

        if (newpH < 0.0 || newpH > 14.0) {
            pH = NEUTRAL_PH;
        } else {
            pH = newpH;
        }

        if (newNutrient < MINIMUM_NUTRIENT_COEFFICIENT
                || newNutrient > MAXIMUM_NUTRIENT_COEFFICIENT) {
            nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
        } else {
            nutrientCoefficient = newNutrient;
        }
        guppiesInPool = new ArrayList<Guppy>();
        randomNumberGenerator = new Random();
        numberOfPools += 1;
        identificationNumber = numberOfPools;
    }

    /**
     * Name getter.
     * @return name as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * Volume getter.
     * @return volume as a double.
     */
    public double getVolumeLitres() {
        return volumeLitres;
    }

    /**
     * Temperature getter.
     * @return temperature as a double.
     */
    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    /**
     * pH getter.
     * @return pH as a double.
     */
    public double getpH() {
        return pH;
    }

    /**
     * Nutrient coefficient getter.
     * @return nutrient coefficient as a double.
     */
    public double getNutrientCoefficient() {
        return nutrientCoefficient;
    }

    /**
     * ID number getter.
     * @return ID number as an int.
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Volume setter.
     * @param newVolume
     */
    public void setVolumeLitres(final double newVolume) {
        this.volumeLitres = newVolume;
    }

    /**
     * Temperature setter.
     * @param newTemp
     */
    public void setTemperatureCelsius(final double newTemp) {
        this.temperatureCelsius = newTemp;
    }

    /**
     * pH setter.
     * @param newpH
     */
    public void setpH(final double newpH) {
        if (newpH >= 0.0 && newpH <= 14.0) {
            this.pH = newpH;
        }
    }

    /**
     * Nutrient coefficient setter.
     * @param newNutrient
     */
    public void setNutrientCoefficient(final double newNutrient) {
        if (newNutrient >= 0 && newNutrient <= 1.0) {
            this.nutrientCoefficient = newNutrient;
        }
    }

    /**
     * Change nutrient coefficient method.
     * @param delta
     */
    public void changeNutrientCoefficient(final double delta) {
        if (nutrientCoefficient + delta < MINIMUM_NUTRIENT_COEFFICIENT) {
            nutrientCoefficient  = MINIMUM_NUTRIENT_COEFFICIENT;
        } else if (nutrientCoefficient + delta > MAXIMUM_NUTRIENT_COEFFICIENT) {
            nutrientCoefficient = MAXIMUM_NUTRIENT_COEFFICIENT;
        }
    }

    /**
     * Change temperature method.
     * @param delta
     */
    public void changeTemperature(final double delta) {
        if (temperatureCelsius + delta < MINIMUM_POOL_TEMP_CELSIUS) {
            temperatureCelsius  = MINIMUM_POOL_TEMP_CELSIUS;
        } else if (temperatureCelsius + delta > MAXIMUM_POOL_TEMP_CELSIUS) {
            temperatureCelsius = MAXIMUM_POOL_TEMP_CELSIUS;
        }
    }

    /**
     * Gets number of pools.
     * @return number of pools as an int.
     */
    public static int getNumberCreated() {
        return numberOfPools;
    }

    /**
     * Add guppy to pool method.
     * @param guppy
     * @return successful add.
     */
    public boolean addGuppy(final Guppy guppy) {
        if (guppy == null) {
            return false;
        } else {
            guppiesInPool.add(guppy);
            return true;
        }
    }

    /**
     * Gets number of guppies in pool.
     * @return Pool population as an int.
     */
    public int getPopulation() {
        return guppiesInPool.size();
    }

    /**
     * Applies nutrient coefficient.
     * @return number of deaths as an int.
     */
    public int applyNutrientCoefficient() {
        int numberOfDeaths = 0;
        double rollDeath;
        Iterator<Guppy> iter = guppiesInPool.iterator();
        while (iter.hasNext()) {
            rollDeath = randomNumberGenerator.nextDouble();
            if (rollDeath > getNutrientCoefficient()) {
                iter.next().setIsAlive(false);
                numberOfDeaths++;
            } else {
                iter.next().setIsAlive(true);
            }
        }
        return numberOfDeaths;
    }

    /**
     * Removes dead gupppies.
     * @return dead guppies removed as an int.
     */
    public int removeDeadGuppies() {
        int deadGuppiesRemoved = 0;
        Iterator<Guppy> iter = guppiesInPool.iterator();
        while (iter.hasNext()) {
            if (!iter.next().getIsAlive()) {
                guppiesInPool.remove(iter.next());
                deadGuppiesRemoved++;
            }
        }
        return deadGuppiesRemoved;
    }

    /**
     * Gets volume requirement.
     * @return volume requirement in litres as a double.
     */
    public double getGuppyVolumeRequirementInLitres() {
        double volumeReq = 0;
        Iterator<Guppy> iter = guppiesInPool.iterator();
        while (iter.hasNext()) {
            volumeReq += (iter.next().getVolumeNeeded() / 1000);
        }
        return volumeReq;
    }

    /**
     * Gets average age of guppies.
     * @return average age of guppies as a double.
     */
    public double getAverageAgeInWeeks() {
        double totalAge = 0;
        Iterator<Guppy> iter = guppiesInPool.iterator();
        while (iter.hasNext()) {
            totalAge += iter.next().getAgeInWeeks();
        }
        return totalAge / guppiesInPool.size();
    }

    /**
     * Gets average health of guppies.
     * @return average coefficient of guppies as a double.
     */
    public double getAverageHealthCoefficient() {
        double totalHealth = 0;
        Iterator<Guppy> iter = guppiesInPool.iterator();
        while (iter.hasNext()) {
            totalHealth += iter.next().getHealthCoefficient();
        }
        return totalHealth / guppiesInPool.size();
    }

    /**
     * Gets average health of guppies.
     * @return average coefficient of guppies as a double.
     */
    public double getFemalePercentage() {
        double totalFemales = 0;
        Iterator<Guppy> iter = guppiesInPool.iterator();
        while (iter.hasNext()) {
            if (iter.next().getIsFemale()) {
                totalFemales++;
            }
        }
        return (totalFemales / guppiesInPool.size()) * 100;
    }

    /**
     * Gets median age.
     * @return median age as a double.
     */
    public double getMedianAge() {
        ArrayList<Integer> ageList = new ArrayList<Integer>();
        double median;
        Iterator<Guppy> iter = guppiesInPool.iterator();
        while (iter.hasNext()) {
            ageList.add(iter.next().getAgeInWeeks());
        }
        Collections.sort(ageList);
        if (guppiesInPool.size() % 2 == 1) {
            median = guppiesInPool.get(guppiesInPool.size()
                    / 2).getAgeInWeeks();
        } else {
            median = guppiesInPool.get(guppiesInPool.size() / 2).getAgeInWeeks()
                    + guppiesInPool.get(guppiesInPool.size() / 2 - 1)
                    .getAgeInWeeks() / 2.0;
        }
        return median;
    }

    /**
     * toString method.
     * @return Pool as a string.
     */
    @Override
    public String toString() {
        return "Pool{"
                + "name='" + name + '\''
                + ", volumeLitres=" + volumeLitres
                + ", temperatureCelsius=" + temperatureCelsius
                + ", pH=" + pH
                + ", nutrientCoefficient=" + nutrientCoefficient
                + ", identificationNumber=" + identificationNumber
                + ", guppiesInPool=" + guppiesInPool
                + ", randomNumberGenerator=" + randomNumberGenerator
                + '}';
    }

    /**
     * Spawns new guppies.
     * @return total new guppies as an int.
     */
    public int spawn() {
        int totalNewGuppies = 0;
        Iterator<Guppy> iter = guppiesInPool.iterator();
        while (iter.hasNext()) {
            if (iter.next().spawn() != null) {
                guppiesInPool.addAll(iter.next().spawn());
                totalNewGuppies += iter.next().spawn().size();
            }
        }
        return totalNewGuppies;
    }

    /**
     * Increments ages of guppies.
     * @return deaths of old age as an int.
     */
    public int incrementAges() {
        int oldAgeDeaths = 0;
        Iterator<Guppy> iter = guppiesInPool.iterator();
        while (iter.hasNext()) {
            iter.next().incrementAge();
            if (!iter.next().getIsAlive()) {
                oldAgeDeaths++;
            }
        }
        return oldAgeDeaths;
    }

    /**
     * Adjusts crowding in pool.
     * @return number of guppies that died due to overcrowding as an int.
     */
    public int adjustForCrowding() {
        int totalDeaths = 0;
        Collections.sort(guppiesInPool, new Comparator<Guppy>() {
            @Override
            public int compare(final Guppy o1, final Guppy o2) {
                return Double.compare(o1.getHealthCoefficient(),
                        o2.getHealthCoefficient());
            }
        });
        Iterator<Guppy> iter = guppiesInPool.iterator();
        while (getGuppyVolumeRequirementInLitres() > volumeLitres) {
            if (iter.hasNext()) {
                guppiesInPool.get(0).setIsAlive(false);
                totalDeaths++;
            }
        }

        return totalDeaths;
    }
}
