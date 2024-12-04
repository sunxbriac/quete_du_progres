package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public abstract class Reader {
    private static final String merchants_file = "merchants.txt";
    private static final String monsters_file = "monsters.txt";
    private static final String location_file = "locations.txt";

    public static String getStringEquipement() {
        return null;
    };

    public static String getStringConsommable(){
        return null;
    }

    public static String getStringSpell(){
        return null;
    }

    public static String getStringMerchant(){
        return getLineInFile(merchants_file);
    }

    public static String getStringLocation(){
        return getLineInFile(location_file);
    }

    public static String getStringMonsterName(){
        return getLineInFile(monsters_file);
    }

    public static String getStringRandomEvent(){
        return null;
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
