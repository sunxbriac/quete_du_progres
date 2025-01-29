package factories;

import main.Event;
import main.Fight;
import main.MerchantEncounter;

import main.Misc;
import utils.Reader;

import java.util.concurrent.ThreadLocalRandom;

public class FactoryEvent {
    public Event generateEvent(int act_id){
        Event result;
        switch(ThreadLocalRandom.current().nextInt(0, 6)){
            case 0:
                result = new MerchantEncounter(Reader.getStringMerchant(), Reader.getStringLocation());
                break;
            case 1:
                result = new Misc(Reader.getStringRandomEvent());
                break;
            default:
                result = new Fight(calculateNumberOfMonsters(act_id));
                break;
        };

        return result;
    }

    private int calculateNumberOfMonsters(int act_id){
        return act_id/5+1;
    }
}
