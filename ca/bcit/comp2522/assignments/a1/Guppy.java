package ca.bcit.comp2522.assignments.a1;

import java.util.Objects;

public class Guppy {

    /**Young guppy's age in weeks. */
    static final int YOUNG_FISH_AGE_IN_WEEKS = 10;
    /**Mature guppy's age in weeks. */
    static final int MATURE_FISH_AGE_IN_WEEKS = 30;
    /**Guppy's maximum age in weeks. */
    static final int MAXIMUM_AGE_IN_WEEKS = 50;
    /**Minimum water volume in mL. */
    static final double MINIMUM_WATER_VOLUME_ML = 250.0;
    /**Default genus as a string. */
    static final String DEFAULT_GENUS = "Poecilia";
    /**Default species as a string. */
    static final String DEFAULT_SPECIES = "reticulata";
    /**Default health coefficient. */
    static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;
    /**Minimum health coefficient. */
    static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;
    /**Maximum health coefficient. */
    static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;
    /** Genus instance variable. */
    private String genus;
    /** Genus instance variable. */
    private String species;
    /** Genus instance variable. */
    private int ageInWeeks;
    /** Genus instance variable. */
    private boolean isFemale;
    /** Genus instance variable. */
    private int generationNumber;
    /** Genus instance variable. */
    private boolean isAlive;
    /** Genus instance variable. */
    private double healthCoefficient;
    /** Genus instance variable. */
    private int identificationNumber;
    /**Number of guppies born as an int. */
    private static int numberOfGuppiesBorn = 0;

    /**
     * Guppy constructor (no params).
     */
    public Guppy() {
        ageInWeeks = 0;
        generationNumber = 0;
        genus = DEFAULT_GENUS;
        species = DEFAULT_SPECIES;
        isFemale = true;
        isAlive = true;
        healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
        numberOfGuppiesBorn += 1;
        identificationNumber = numberOfGuppiesBorn;
    }

    /**
     * Guppy constructor with params.
     * @param newGenus A string.
     * @param newSpecies A string.
     * @param newAgeInWeeks An int.
     * @param newIsFemale A boolean.
     * @param newGenerationNumber An int.
     * @param newHealthCoefficient A double.
     */
    public Guppy(final String newGenus, final String newSpecies,
                  final int newAgeInWeeks, final boolean newIsFemale,
                  final int newGenerationNumber,
                  final double newHealthCoefficient) {
        genus = newGenus.substring(0, 1).toUpperCase() + newGenus.substring(1);
        species = newSpecies.toLowerCase();
        if (newAgeInWeeks < 0) {
            ageInWeeks = 0;
        } else {
            ageInWeeks = newAgeInWeeks;
        }
        isFemale = newIsFemale;
        if (newGenerationNumber < 0) {
            generationNumber = 1;
        } else {
            generationNumber = newGenerationNumber;
        }
        if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = MINIMUM_HEALTH_COEFFICIENT;
        } else if (newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        } else {
            healthCoefficient = newHealthCoefficient;
        }
        isAlive = true;
        numberOfGuppiesBorn += 1;
        identificationNumber = numberOfGuppiesBorn;
    }

    /**
     * Method to increment age.
     */
    public void incrementAge() {
        ageInWeeks += 1;
        if (ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            isAlive = false;
        }
    }

    /**
     * Genus getter.
     * @return Genus as a string.
     */
    public String getGenus() {
        return genus;
    }

    /**
     * Species getter.
     * @return Species as a string.
     */
    public String getSpecies() {
        return species;
    }

    /**
     * ID number getter.
     * @return ID number as an int.
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Health coefficient getter.
     * @return Health coefficient as a double.
     */
    public double getHealthCoefficient() {
        return healthCoefficient;
    }

    /**
     * isAlive getter.
     * @return isAlive as a boolean.
     */
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * Generation number getter.
     * @return generation number as an int.
     */
    public int getGenerationNumber() {
        return generationNumber;
    }

    /**
     * isFemale getter.
     * @return isFemale as a boolean.
     */
    public boolean getIsFemale() {
        return isFemale;
    }

    /**
     * Age in weeks getter.
     * @return Age in weeks as an int.
     */
    public int getAgeInWeeks() {
        return ageInWeeks;
    }

    /**
     * Age in weeks setter.
     * @param ageWeeks
     */
    public void setAgeInWeeks(final int ageWeeks) {
        if (ageWeeks >= 0 && ageWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            this.ageInWeeks = ageWeeks;
        }
    }

    /**
     * isAlive setter.
     * @param alive
     */
    public void setIsAlive(final boolean alive) {
        isAlive = alive;
    }

    /**
     * Health coefficient setter.
     * @param healthCoef
     */
    public void setHealthCoefficient(final double healthCoef) {
        if (healthCoef >= MINIMUM_HEALTH_COEFFICIENT
                && healthCoef <= MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = healthCoef;
        }
    }

    /**
     * Guppies born getter.
     * @return Number of guppies born as an int.
     */
    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }

    /**
     * Gets volume of water needed for guppy as a double.
     * @return necessary volume as a double (in mL).
     */
    public double getVolumeNeeded() {
        double volNeeded;
        if (ageInWeeks < YOUNG_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML;
        } else if (ageInWeeks >= YOUNG_FISH_AGE_IN_WEEKS
                && ageInWeeks < MATURE_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * ageInWeeks
                    / YOUNG_FISH_AGE_IN_WEEKS;
        } else if (ageInWeeks > MATURE_FISH_AGE_IN_WEEKS
                && ageInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * 1.5;
        } else {
            return 0.0;
        }
    }

    /**
     * Changes health coefficient.
     * @param delta
     */
    public void changeHealthCoefficient(final double delta) {
        if (healthCoefficient + delta <= MINIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = 0.0;
            isAlive = false;
        } else if (healthCoefficient + delta > MAXIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = MAXIMUM_HEALTH_COEFFICIENT;
        } else {
            healthCoefficient += delta;
        }
    }

    /**
     * toString method.
     * @return Guppy as a string.
     */
    @Override
    public String toString() {
        return "Guppy{"
                + "genus='" + genus + '\''
                + ", species='" + species + '\''
                + ", ageInWeeks=" + ageInWeeks
                + ", isFemale=" + isFemale
                + ", generationNumber=" + generationNumber
                + ", isAlive=" + isAlive
                + ", healthCoefficient=" + healthCoefficient
                + ", identificationNumber=" + identificationNumber
                + '}';
    }

    /**
     * Equals method override.
     * @param obj
     * @return Equal guppies as a boolean.
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj.getClass() == this.getClass())) {
            return false;
        }
        Guppy guppy = (Guppy) obj;
        return ageInWeeks == guppy.ageInWeeks
                && isFemale == guppy.isFemale
                && generationNumber == guppy.generationNumber
                && isAlive == guppy.isAlive
                && Double.compare(guppy.healthCoefficient,
                healthCoefficient) == 0
                && identificationNumber == guppy.identificationNumber
                && Objects.equals(genus, guppy.genus)
                && Objects.equals(species, guppy.species);
    }

    /**
     * hash code Override.
     * @return hashes
     */
    @Override
    public int hashCode() {
        return Objects.hash(genus, species, ageInWeeks, isFemale,
                generationNumber, isAlive, healthCoefficient,
                identificationNumber);
    }
}
