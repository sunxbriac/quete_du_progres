package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public abstract class Reader {
    private static final String directory = "files/";

    private static final String merchants_file = directory+"merchants.txt";
    private static final String monsters_file = directory+"monsters.txt";
    private static final String locations_file = directory+"locations.txt";
    private static final String equipements_file = directory+"equipements.txt";
    private static final String consommables_file = directory+"consommables.txt";
    private static final String spells_file = directory+"spells.txt";
    private static final String events_file = directory+"events.txt";
    private static final String synonyms_file = directory+"killing_synonyms.txt";

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

    public static String getStringSynonym(){ return getLineInFile(synonyms_file); }

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

        if (lineCount == 0) {
            throw new IllegalArgumentException("The file is empty.");
        }

        return randomLine;
    }
}
