package main;

public class SingletonStory {
    private SingletonStory instance;
    private int act_number;
    private Act act;

    public SingletonStory getInstance(){
        if(instance==null)
            instance = new SingletonStory();
        return instance;
    }

    private SingletonStory(){

    }

    public void changeAct(){

    }
}
