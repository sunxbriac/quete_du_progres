package main;

public class SingletonStory {
    private static SingletonStory instance;
    private int act_number;
    private Act act;

    public static SingletonStory getInstance(){
        if(instance==null)
            instance = new SingletonStory();
        return instance;
    }

    private SingletonStory(){
        act_number = 0;
    }

    public void changeAct(){
        act_number++;
        act = new Act(act_number);
        System.out.println("Act : " + act_number);
    }

    public void play(){
        while(true) {
            act.solveEvents();
            changeAct();
        }
    }
}
