package main;

import utils.Printer;

import java.util.ArrayList;
import java.util.Random;

public class SingletonHero {
  private static volatile SingletonHero instance;
  private int level;
  private int[] attributes;
  private Inventory inventory;
  private ArrayList<Buff> buffs;
  private Job job;

  
  private SingletonHero()
  {
    Random rand = new Random();
    attributes = new int[6];
    for (int i = 0; i < 6; i++) {
      int var = rand.nextInt(13) - 6;
      attributes[i] = rand.nextInt(12) + var;
    }

    inventory = new Inventory();
    level=1;
    buffs = new ArrayList<>();
  }

  public static SingletonHero getInstance()
  {
    if(instance == null){
      synchronized (SingletonHero.class){
        if(instance==null)
          instance = new SingletonHero();
      }

    }

    return instance;  
  }

  public void printHero(){
    System.out.println("Class: " + job);
    System.out.println("Level: " + level);

    for (int i = 0; i < attributes.length; i++) {
      System.out.println(TypeAttribute.values()[i] + ": " + attributes[i]);
    }


  }

  public void levelUp()
  {
    level++;
    Printer.slow_print("You gained a level !", 1);
    for (int i = 0; i < attributes.length; i++) {
      int randomAddition = (int) (Math.random() * 3);
      attributes[i] += randomAddition;
    }
  }

  public void updateBuffs()
  {
    ArrayList<Buff> to_remove = new ArrayList<>();
    for(Buff b : buffs){
      if(b.changeDuration()){
        to_remove.add(b);
        Sellable source = b.getSource();
        int stat_id = 0;
        int bonus = 0;
        if(source instanceof Consumable){
          Consumable cons = (Consumable) source;
          stat_id = cons.getStat_id();
          bonus = cons.getBonus();
        }
        else if(source instanceof Equipment){
          Equipment eq = (Equipment) source;
          stat_id = eq.getStat_id();
          bonus = eq.getBonus();
        }

        attributes[stat_id] -= bonus;
      }
    }
    buffs.removeAll(to_remove);
  }

  public void useConsumable()
  {
    Sellable c = getInventory().getConsumable();
    if(c != null){
      //should be always true
      if(c instanceof Consumable) {
        Consumable cons = (Consumable) c;
        if(cons.use()){
          //now empty
          getInventory().removeConsumable(cons);
        }
        buffs.add(new Buff((int) (Math.random() * 3)+1, c));
        attributes[cons.getStat_id()] += cons.getBonus();
        Printer.slow_print("Consuming " + cons.getName() + " " + cons.getNumber_of_use() + " uses left", 2);
      }
    }

  }

  public String getSpell()
  {
    String result;
    try{
      result = inventory.getSpell().getName();
    }
    catch(NullPointerException e){
      result = "0";
    }
    return result;
  }

  public Inventory getInventory()
  {
    return inventory;
  }

  public boolean isJob(Job j){
    return j != job;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  public void putEquipment(Equipment equipment) {
    int statId = equipment.getStat_id();
    attributes[statId] += equipment.getBonus();
  }

}
