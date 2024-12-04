package main;

import java.util.ArrayList;
import java.util.List;

public class MerchantEncounter implements Event{
    private int gold;
    private ArrayList<Sellable> sellables;
    private String name;
    private String location;


    @Override
    public void resolveEvent() {
        SingletonHero hero = SingletonHero.getInstance();
        hero.getInventory().sellItems();
    }

    @Override
    public void printMessage() {

    }

    public MerchantEncounter(String name, String loc){
        this.name=name;
        this.location=loc;
    }

}
