package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Phase2 extends Simulation {

    File phase2 = new File("phase-2.txt");
    Scanner scanner;

    {
        try {
            scanner = new Scanner(phase2).useDelimiter("[=\\n]");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Item> loadItems() {
        ArrayList<Item> ItemsList = new ArrayList<>();
        while (scanner.hasNext()) {
            Item item = new Item(scanner.next(), scanner.nextInt());
            ItemsList.add(item);
        }
        scanner.close();
        return ItemsList;
    }
}


