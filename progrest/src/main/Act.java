package main;

import factories.FactoryEvent;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Act {
    private int number_of_events;
    private int act_id;
    private ArrayList<Event> events;

    public Act(int act_id){
        this.act_id = act_id;
        events = new ArrayList<Event>();

        int number_of_events = ThreadLocalRandom.current().nextInt(act_id, act_id + 4);
        FactoryEvent fe = new FactoryEvent();

        for(int i=0; i!=number_of_events; i++){
            events.add(fe.generateEvent(act_id));
        }
    }

    public void solveEvents(){
        System.out.println("Start of Act " + act_id);

        for(Event e : events){
            e.resolveEvent();
            e.printMessage();
        }

        System.out.println("End of Act " + act_id);
    }
}
