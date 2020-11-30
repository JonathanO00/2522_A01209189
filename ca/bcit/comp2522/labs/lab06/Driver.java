package ca.bcit.comp2522.labs.lab06;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Driver {
    /**
     * Drives the program.
     * @param args
     * @throws Exception
     */
    public static void main(final String[] args) throws Exception {
        //Writing and reading Sprite
        try {
            BufferedImage img = ImageIO.read(new File("src/megaman.png"));
            Sprite s = new Sprite(0, 0, 50, img);

            FileOutputStream f = new FileOutputStream("sprite.ser");
            ObjectOutput out = new ObjectOutputStream(f);
            System.out.println("Writing sprite to stream.");
            System.out.println("Sprite length at WRITE: "
                    + s.getPixData().length);
            out.writeObject(s);
            out.flush();
            out.close();

            FileInputStream f2 = new FileInputStream("sprite.ser");
            ObjectInputStream in = new ObjectInputStream(f2);
            Sprite spriteRead = (Sprite) in.readObject();
            System.out.println("Sprite successfully read");
            System.out.println("Sprite length at READ: "
                    + spriteRead.getPixData().length);
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Writing and reading Save data
        System.out.println("Writing save data...");
        Resources r = new Resources("Castle", 8, 60, 100, 30, 50, 70);
        DataOutputStream out = null;
        String newSave = new SimpleDateFormat(
                "yyyy-MM-dd_hh-mm-ss'.dat'").format(new Date());

        try {
           out = new DataOutputStream(new BufferedOutputStream(
                   new FileOutputStream(newSave)));

           out.writeUTF(r.getLevName());
           out.writeInt(r.getLevNum());
           out.writeInt(r.getxCord());
           out.writeInt(r.getyCord());
           out.writeFloat(r.getPlayerHealth());
           out.writeInt(r.getLiveEnemies());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }

        DataInputStream in = null;

        try {
            in = new DataInputStream(new
                    BufferedInputStream(new FileInputStream(newSave)));

            try {
                System.out.println("Reading save data...");

                while (true) {
                    System.out.println("Level name: " + in.readUTF());
                    System.out.println("Level number: " + in.readInt());
                    System.out.println("X coord: " + in.readInt());
                    System.out.println("Y coord: " + in.readInt());
                    System.out.println("Health: " + in.readFloat());
                    System.out.println("Live enemies: " + in.readInt());
                }

            } catch (EOFException ignored) { }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }

    }
}
