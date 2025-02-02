package main;

import java.util.ArrayList;
import java.util.Random;

public class Inventory {
  private int gold;
  private ArrayList<ArrayList<Sellable>> sellables;

  public Inventory(){
    sellables = new ArrayList<>();
    sellables.add(new ArrayList<>()); //spells
    sellables.add(new ArrayList<>()); //equipments
    sellables.add(new ArrayList<>()); //consumables
  }

  public void print(){
    System.out.println("You currently have " + gold + " gold");
    ArrayList<Sellable> current = sellables.get(1);
    if(!current.isEmpty()){
      System.out.println("List of equipments");
      for(Sellable s : current)
        s.print();
    }
    else
      System.out.println("You have no equipments for the moment");

    current = sellables.get(0);
    if(!current.isEmpty()){
      System.out.println("List of spells owned");
      for(Sellable s : current)
        s.print();
    }
    else
      System.out.println("You have no spells for the moment");

    current = sellables.get(2);
    if(!current.isEmpty()){
      System.out.println("List of consumables owned");
      for(Sellable s : current)
        s.print();
    }
    else
      System.out.println("You have no consumables for the moment");

  }

  public int sellItems()
  {
    int money_won = 0;

    SingletonHero hero = SingletonHero.getInstance();
    ArrayList<Sellable> to_remove = new ArrayList<>();
    ArrayList<Sellable> current_list = sellables.get(0);

    //we sell only spells that the hero can't use
    for(Sellable s : current_list){
      Spell sp = (Spell) s;
      if(hero.isJob(sp.getClass_restriction())){
        money_won += sp.value;
        sellItem(sp);
        to_remove.add(sp);
      }
    }
    current_list.removeAll(to_remove);
    to_remove.clear();

    //we sell only equipment that the hero can't use either
    current_list = sellables.get(1);
    for(Sellable s : current_list){
      Equipment eq = (Equipment) s;
      if(hero.isJob(eq.getClass_restriction())){
        money_won += eq.value;
        sellItem(eq);
        to_remove.add(eq);
      }
    }
    current_list.removeAll(to_remove);
    to_remove.clear();

    return money_won;
  }


  private void sellItem(Sellable s){
    gold += s.getValue();
  }

  public Sellable getSpell() {
    if(sellables.get(0).isEmpty())
      return null;
    ArrayList<Sellable> spells = sellables.get(0);
    return spells.get(new Random().nextInt(spells.size()));
  }

  public Sellable getConsumable() {
    if(sellables.get(2).isEmpty())
      return null;
    ArrayList<Sellable> consumables = sellables.get(2);
    return consumables.get(new Random().nextInt(consumables.size()));
  }

  public void removeConsumable(Consumable c){
    sellables.get(2).remove(c);
  }


  public void addItem(Sellable s){
    if(s instanceof Spell)
      sellables.get(0).add(s);
    else if(s instanceof Equipment){
      sellables.get(1).add(s);
      Equipment e = (Equipment) s;
      SingletonHero hero = SingletonHero.getInstance();

      if(hero.isJob(e.getClass_restriction()))
        hero.putEquipment(e);
    }

    else if(s instanceof Consumable)
      sellables.get(2).add(s);
  }

  public int getGold() {
    return gold;
  }

  public void buyItem(Sellable s){
    //checked before call if hero has enough money
    this.gold -= s.getValue();
    addItem(s);
  }
}
