package main;

import factories.FactoryMonster;

import java.util.ArrayList;
import java.util.List;

public class Fight implements Event{
    private ArrayList<Monster> monsters;

    public Fight(int number_of_monsters){
        monsters = new ArrayList<>();
        for(int i=0; i!=number_of_monsters; i++){
            FactoryMonster fm = new FactoryMonster();
            monsters.add(fm.generateMonster());
        }
    }

    @Override
    public void resolveEvent() {

    }

    @Override
    public void printMessage() {

    }

    public void fightNextMonster(){

    }
}
