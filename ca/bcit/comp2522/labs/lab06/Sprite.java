package ca.bcit.comp2522.labs.lab06;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.Serializable;
import java.util.ArrayList;

public class Sprite implements Serializable {
    private int xCord;
    private int yCord;
    private int health;
    private transient float gravity;
    private ArrayList<String> weapons;
    private byte[] pixData;

    public Sprite(final int xC, final int yC, final int newHealth,
                  final BufferedImage img) throws Exception {

        if (newHealth < 0 || newHealth > 100) {
            throw new Exception("Health must be between 0 and 100!");
        } else {
            health = newHealth;
        }

        xCord = xC;
        yCord = yC;
        weapons = new ArrayList<String>();
        weapons.add("Default weapon");
        pixData = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
    }

    public byte[] getPixData() {
        return pixData;
    }
}
