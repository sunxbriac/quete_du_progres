package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public abstract class Reader {
    private static final String merchants_file = "merchants.txt";
    private static final String monsters_file = "monsters.txt";
    private static final String locations_file = "locations.txt";
    private static final String equipements_file = "equipements.txt";
    private static final String consommables_file = "consommables.txt";
    private static final String spells_file = "spells.txt";
    private static final String events_file = "events.txt";

    public static String getStringEquipement() {
        return getLineInFile(equipements_file);
    };

    public static String getStringConsommable(){
        return getLineInFile(consommables_file);
    }

    public static String getStringSpell(){
        return getLineInFile(spells_file);
    }

    public static String getStringMerchant(){
        return getLineInFile(merchants_file);
    }

    public static String getStringLocation(){
        return getLineInFile(locations_file);
    }

    public static String getStringMonsterName(){
        return getLineInFile(monsters_file);
    }

    public static String getStringRandomEvent(){
        return getLineInFile(events_file);
    }

    public static String getLineInFile(String file_input){
        String randomLine = null;
        int lineCount = 0;
        Random random = new Random();

        try (BufferedReader reader = new BufferedReader(new FileReader(file_input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (random.nextInt(lineCount) == 0) {
                    randomLine = line;
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        // If no lines were found, the file is empty
        if (lineCount == 0) {
            throw new IllegalArgumentException("The file is empty.");
        }

        return randomLine;
    }
}
