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
    System.out.println("List of equipments");
    for(Sellable s : sellables.get(1))
      s.print();

    System.out.println("List of spells owned");
    for(Sellable s : sellables.get(0))
      s.print();

    System.out.println("List of consumables owned");
    for(Sellable s : sellables.get(2))
      s.print();
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

    //TODO consumables are not sold for the moment
    return money_won;
  }


  private void sellItem(Sellable s){
    gold += s.getValue();
  }

  public Sellable getSpell() {
    ArrayList<Sellable> spells = sellables.get(0);
    return spells.get(new Random().nextInt(spells.size()));
  }
}
