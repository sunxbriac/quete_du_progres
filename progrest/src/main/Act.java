package main;

import factories.FactoryEvent;
import utils.Printer;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Act {
    private int act_id;
    private ArrayList<Event> events;

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
        }

        Printer.slow_print("End of Act " + act_id,1);
    }
}
