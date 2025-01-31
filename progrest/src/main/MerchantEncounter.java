package main;

import utils.Printer;

import java.util.ArrayList;
import java.util.List;

public class MerchantEncounter implements Event{
    private int gold;
    private ArrayList<Sellable> sellables;
    private String name;
    private String location;


    @Override
    public void resolveEvent() {
        printMessage();
        SingletonHero hero = SingletonHero.getInstance();
        int money_gained = hero.getInventory().sellItems();
        Printer.slow_print("Sold items for " + money_gained + " gold", 3);
        //TODO buy some random items depending of gold and class restriction
    }

    @Override
    public void printMessage() {
        Printer.slow_print("Meeting " + name + "at " + location,4);
    }

    public MerchantEncounter(String name, String loc){
        this.name=name;
        this.location=loc;
    }

}
