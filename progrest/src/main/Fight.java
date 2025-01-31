package main;

import factories.FactoryMonster;
import factories.FactorySellable;
import utils.Printer;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Fight implements Event{
    private ArrayList<Monster> monsters;
    private final String location;

    public Fight(int number_of_monsters, String location){
        monsters = new ArrayList<>();
        for(int i=0; i!=number_of_monsters; i++){
            FactoryMonster fm = new FactoryMonster();
            monsters.add(fm.generateMonster());
        }
        this.location = location;
    }

    @Override
    public void resolveEvent() {
        printMessage();
        fightMonsters();
        Printer.slow_print("Leaving " + location + " safely", 2);
    }

    @Override
    public void printMessage() {
        Printer.slow_print("Battling monsters at " + location, 2);
    }



    private void fightMonsters(){
        FactorySellable factorySellable = new FactorySellable();

        for(Monster m : monsters){
            Printer.slow_print(m.getHow_to_kill() + " a " + m.getName(), ThreadLocalRandom.current().nextInt(3, 11));
            if (Math.random() <= 0.7) {
                Sellable s = factorySellable.generateSellable(SingletonStory.getInstance().getAct_number());
                System.out.println("You found a " + s.toString() + " on his body");
            }
        }
    }
}
