package main;

import java.util.List;

public class Misc implements Event{

    String what;

    public Misc(String what){
        this.what = what;
    }

    @Override
    public void resolveEvent() {
        printMessage();
    }

    @Override
    public void printMessage() {
        System.out.println(what);
    }


}
