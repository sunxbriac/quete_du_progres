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
        act_number = 1;
    }

    public void changeAct(){
        act_number++;
        act = new Act(act_number);
    }
}
