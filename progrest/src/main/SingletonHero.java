package main;

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
    //TODO print level, class, attributes
  }

  public void levelUp()
  {
    level++;
    //TODO
  }

  public void updateBuffs()
  {
    //TODO change stats accordingly
    ArrayList<Buff> to_remove = new ArrayList<>();
    for(Buff b : buffs){
      if(b.changeDuration()){
        to_remove.add(b);
      }
    }
    buffs.removeAll(to_remove);
  }

  public void useConsumable()
  {
    //TODO
  }

  public String getSpell()
  {
    return inventory.getSpell().getName();
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
}
