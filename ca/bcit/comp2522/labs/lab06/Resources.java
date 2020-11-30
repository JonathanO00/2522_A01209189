package ca.bcit.comp2522.labs.lab06;

public class Resources {
    private String levName;
    private int levNum;
    private int xCord;
    private int yCord;
    private float playerHealth;
    private int health;
    private int liveEnemies;

    public Resources(final String lname, final int lnum, final int xc,
                     final int yc, final float ph, final int h,
                     final int lenemies) throws Exception {
        if (h < 0 || h > 100) {
            throw new Exception("Health must be between 0 and 100.");
        } else {
            health = h;
        }

        if (lenemies < 0 || lenemies > 100) {
            throw new Exception("Enemies must be between 0 and 100.");
        } else {
            liveEnemies = lenemies;
        }

        levName = lname;
        levNum = lnum;
        xCord = xc;
        yCord = yc;
        playerHealth = ph;
    }

    public String getLevName() {
        return levName;
    }

    public int getLevNum() {
        return levNum;
    }

    public int getxCord() {
        return xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public float getPlayerHealth() {
        return playerHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getLiveEnemies() {
        return liveEnemies;
    }
}
