package factories;

import main.*;
import utils.Reader;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FactorySellable {
    public Sellable generateSellable(int act_id){

        Sellable result;
        int value = calculateValue(act_id);

        switch(ThreadLocalRandom.current().nextInt(0, 5)){
            case 0:
                result = generateConsommable(value);
                break;
            case 1:
                result = generateSpell(value);
                break;
            default:
                result = generateEquipement(value);
                break;
        }

        return result;
    }

    private int calculateValue(int act_id){
        return 0; //TODO
    }

    public Equipment generateEquipement(int val){
        int stat_id = 0; //TODO
        Job class_rest = getRandomJob();
        int bonus = 1; //TODO
        return new Equipment(stat_id, class_rest, bonus, Reader.getStringEquipment(), val);
    }

    public Spell generateSpell(int val){
        Job class_rest = getRandomJob();
        return new Spell(class_rest, Reader.getStringSpell(), val);
    }

    public Consumables generateConsommable(int val){
        int stat_id = 0; //TODO
        int number_of_use = 1; //TODO
        int bonus = 1; //TODO
        return new Consumables(stat_id, number_of_use, bonus, Reader.getStringConsumable(), val);
    }

    private static Job getRandomJob() {
        Random random = new Random();
        Job[] jobs = Job.values(); // Get all the enum values
        return jobs[random.nextInt(jobs.length)]; // Return a random job
    }
}
