package factories;

import main.*;
import utils.Reader;

import java.util.concurrent.ThreadLocalRandom;

public class FactorySellable {
    public Sellable generateSellable(int act_id){

        Sellable result;
        int value = calculateValue(act_id);

        switch(ThreadLocalRandom.current().nextInt(0, 5)){
            case 0:
                result = generateConsommable(act_id, value);
                break;
            case 1:
                result = generateSpell(act_id, value);
                break;
            default:
                result = generateEquipement(act_id, value);
                break;
        };

        return result;
    }

    private int calculateValue(int act_id){
        return 0; //TODO
    }

    public Equipement generateEquipement(int act_id, int val){
        int stat_id = 0; //TODO
        Job class_rest = Job.PALADIN; //TODO
        int bonus = 1; //TODO
        return new Equipement(stat_id, class_rest, bonus, Reader.getStringEquipement(), val);
    }

    public Spell generateSpell(int act_id, int val){
        Job class_rest = Job.PALADIN;
        return new Spell(class_rest, Reader.getStringSpell(), val);
    }

    public Consommable generateConsommable(int act_id, int val){
        int stat_id = 0; //TODO
        int number_of_use = 1; //TODO
        int bonus = 1; //TODO
        return new Consommable(stat_id, number_of_use, bonus, Reader.getStringConsommable(), val);
    }
}
