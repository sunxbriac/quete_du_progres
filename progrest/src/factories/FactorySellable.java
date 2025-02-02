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
                result = generateConsumable(act_id, value);
                break;
            case 1:
                result = generateSpell(value);
                break;
            default:
                result = generateEquipment(act_id, value);
                break;
        }

        return result;
    }

    private int calculateValue(int act_id) {
        int baseValue = (int) (50 * Math.log(1 + act_id) * 10);
        int randomFactor = (int) (Math.random() * baseValue * 0.4) - (int) (baseValue * 0.2);

        return baseValue + randomFactor;
    }

    private int calculateBonus(int act_id){
        int baseValue = (int) (10 * Math.log(1 + act_id) * 5);
        int randomFactor = (int) (Math.random() * baseValue * 0.3) - (int) (baseValue * 0.15);

        return baseValue + randomFactor;
    }

    public Equipment generateEquipment(int act_id, int val){
        int stat_id = getRandomStatId();
        Job class_rest = getRandomJob();
        int bonus = calculateBonus(act_id);
        return new Equipment(stat_id, class_rest, bonus, Reader.getStringEquipment(), val);
    }

    public Spell generateSpell(int val){
        Job class_rest = getRandomJob();
        return new Spell(class_rest, Reader.getStringSpell(), val);
    }

    public Consumable generateConsumable(int act_id, int val){
        int stat_id = getRandomStatId();
        int number_of_use = (int) (Math.random() * 5) + 1;
        int bonus = calculateBonus(act_id);
        return new Consumable(stat_id, number_of_use, bonus, Reader.getStringConsumable(), val);
    }

    private static Job getRandomJob() {
        Random random = new Random();
        Job[] jobs = Job.values(); // Get all the enum values
        return jobs[random.nextInt(jobs.length)]; // Return a random job
    }

    private static int getRandomStatId() {
        Random random = new Random();
        return random.nextInt(TypeAttribute.values().length);
    }
}
