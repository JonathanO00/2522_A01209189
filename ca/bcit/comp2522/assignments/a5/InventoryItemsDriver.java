package ca.bcit.comp2522.assignments.a5;

import java.util.ArrayList;
import java.util.Date;

public class InventoryItemsDriver {
    public static void main(String[] args) {
        SalesItem s1 = new SalesItem(new Date(), 33, "Brand new dog",
                "Dog", 200, "Labrador", 350.00,
                01, true, true);
        SalesItem s1copy = new SalesItem(new Date(), 31, "Brand new dog",
                "Dog", 200, "Labrador", 350.00,
                01, true, true);
        SalesItem s2 = new SalesItem(new Date(), 111, "Wooden towel",
                "Towel", 10, "Towel", 3.00,
                21, true, false);

        Rental re1 = new Rental("No visible damage", Condition.AVERAGE, Condition.AVERAGE,
                new Date(), 334);
        Rental re2 = new Rental("Chip in metal", Condition.GREAT, Condition.AVERAGE,
                new Date(), 209);
        Rental re3 = new Rental("Refurbished", Condition.EXCELLENT, Condition.AVERAGE,
                new Date(), 119);
        Rental re4 = new Rental("No visible damage", Condition.GREAT, Condition.GREAT,
                new Date(), 904);

        Rental[] rentalArray1 = {re1, re2, re3};
        Rental[] rentalArray2 = {re4};

        RentalItem r1 = new RentalItem(new Date(), 323, "Cool cat", "Bob",
                20, "Cat", Condition.GREAT, 33,
                25, true, false, rentalArray1);
        RentalItem r2 = new RentalItem(new Date(), 203, "Refurbished pencil", "Pencil",
                300, "Pencil", Condition.AVERAGE, 10,
                405, true, false, rentalArray1);
        RentalItem r3 = new RentalItem(new Date(), 115, "Big boat", "Boat",
                120, "Sailboat", Condition.POOR,22,
                253, false, false, rentalArray2);

        ArrayList<InventoryItem> items = new ArrayList<>();
        items.add(s1);
        items.add(s1copy);
        items.add(s2);
        items.add(r1);
        items.add(r2);
        items.add(r3);

        System.out.println("Inventory:");

        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getName());
        }

        items.remove(3);

        System.out.println("After deletion:");

        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getName());
        }

        System.out.println("Item 1 and item 2 equal:");
        System.out.println(items.get(0).equals(items.get(1)));


    }
}
