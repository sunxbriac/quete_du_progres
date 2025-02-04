package main;

import factories.FactoryEvent;
import utils.Printer;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Act {
    private final int act_id;
    private final ArrayList<Event> events;

    public Act(int act_id){
        this.act_id = act_id;
        events = new ArrayList<>();

        int number_of_events = ThreadLocalRandom.current().nextInt(act_id, act_id + 4);
        FactoryEvent fe = new FactoryEvent();

        for(int i=0; i!=number_of_events; i++){
            events.add(fe.generateEvent(act_id));
        }

    }

    public void solveEvents(){
        Printer.slow_print("Start of Act " + act_id,1);

        for(Event e : events){
            e.resolveEvent();
            SingletonHero.getInstance().updateBuffs();

            int randomValue = ThreadLocalRandom.current().nextInt(10); // consume something every 10 events randomly

            if (randomValue == 0) {
                SingletonHero.getInstance().useConsumable();
            }

            while (SingletonStory.isPaused) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        Printer.slow_print("End of Act " + act_id,1);
    }
}
