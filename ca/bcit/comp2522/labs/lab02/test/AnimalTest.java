package ca.bcit.comp2522.labs.lab02.test;

import ca.bcit.comp2522.labs.lab02.Cat;
import ca.bcit.comp2522.labs.lab02.Dog;
import ca.bcit.comp2522.labs.lab02.IncessantSpeakable;
import ca.bcit.comp2522.labs.lab02.Aibo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AnimalTest {
    /**
     * Tests Incessant Speakable of the Cat class.
     */
    @Test
    public void testIncessantSpeakableOfCat() {
        Cat c = new Cat();

        assertEquals(false, (c instanceof IncessantSpeakable));
    }

    /**
     * Tests Incessant Speakable of the Dog class.
     */
    @Test
    public void testIncessantSpeakableOfDog() {
        Dog d = new Dog();

        assertEquals(false, (d instanceof IncessantSpeakable));
    }

    /**
     * Tests Incessant Speakable of the Aibo class.
     */
    @Test
    public void testIncessantSpeakableOfAiBot() {
        Aibo a = new Aibo();

        assertEquals(false, (a instanceof IncessantSpeakable));
    }

    /**
     * Tests speak method of the Dog class.
     */
    @Test
    public void testDogSpeak() {
        Dog d1 = new Dog();

        assertEquals("Woof woof!", (d1.getSpeak()));
    }
}


