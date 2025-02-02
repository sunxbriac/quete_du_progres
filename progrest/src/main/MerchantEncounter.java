package main;

import factories.FactorySellable;
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

        for(Sellable s : sellables){
            if(s.value <= hero.getInventory().getGold()) {
                hero.getInventory().buyItem(s);
                Printer.slow_print("Bought " + s.getName(), 1);
            }
        }

    }

    @Override
    public void printMessage() {
        Printer.slow_print("Meeting " + name + "at " + location,4);
    }

    public MerchantEncounter(String name, String loc, int act_id){
        this.name=name;
        this.location=loc;

        this.sellables = new ArrayList<>();
        int randomNumber = 2 + (int) (Math.random() * 5);
        FactorySellable fs = new FactorySellable();
        for(int i=0; i!= randomNumber; i++){
            sellables.add(fs.generateSellable(act_id));
        }
    }

}
