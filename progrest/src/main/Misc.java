package main;

import utils.Printer;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
        Printer.slow_print(what, ThreadLocalRandom.current().nextInt(2, 6));
    }


}
