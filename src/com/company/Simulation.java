package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    private File phase1 = new File("phase-1.txt");
    private File phase2 = new File("phase-2.txt");
    private Scanner scanner1;

    {
        try {
            scanner1 = new Scanner(phase1).useDelimiter("=|\\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Scanner scanner2;

    {
        try {
            scanner2 = new Scanner(phase2).useDelimiter("=");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    ArrayList<String> FleetList = new ArrayList<>();

    public ArrayList<Item> loadItems() {
        ArrayList<Item> ItemsList = new ArrayList<Item>();
        while (scanner1.hasNextLine()) {
            Item item = new Item(scanner1.next(),scanner1 .nextInt());//
            ItemsList.add(item);
           }
//        while (scanner2.hasNextLine()) {
//            Item item = new Item(scanner2.next(),scanner2 .nextInt());//
//            ItemsList.add(item);
//        }
        return ItemsList;
    }


}
