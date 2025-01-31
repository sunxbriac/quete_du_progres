package main;

import utils.Printer;

public class SingletonStory {
    private static SingletonStory instance;
    private int act_number;
    private Act act;

    public static SingletonStory getInstance(){
        if(instance == null){
            synchronized (SingletonStory.class){
                if(instance==null)
                    instance = new SingletonStory();
            }
        }
        return instance;
    }

    private SingletonStory(){
        act_number = 0;
    }

    public void changeAct(){
        act_number++;
        act = new Act(act_number);
    }

    public void start_game(){
        System.out.println("Bienvenu dans la quête du progrès");
        //TODO choix de classe et autres

        play();
    }
    public void play(){
        while(true) {
            changeAct();
            act.solveEvents();
        }
    }
}
