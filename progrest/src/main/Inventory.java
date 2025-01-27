package main;

import java.util.ArrayList;
import java.util.Random;

public class Inventory {
  private int gold;
  private ArrayList<ArrayList<Sellable>> sellables;
  public void sellItems()
  {
    SingletonHero hero = SingletonHero.getInstance();
    ArrayList<Sellable> to_remove = new ArrayList<>();
    ArrayList<Sellable> current_list = sellables.get(0);

    //we sell only spells that the hero can't use
    for(Sellable s : current_list){
      Spell sp = (Spell) s;
      if(!hero.isJob(sp.getClass_restriction())){
        sellItem(sp);
        to_remove.add(sp);
      }
    }
    current_list.removeAll(to_remove);
    to_remove.clear();

    //we sell only equipement that the hero can't use either
    current_list = sellables.get(1);
    for(Sellable s : current_list){
      Equipement eq = (Equipement) s;
      if(!hero.isJob(eq.getClass_restriction())){
        sellItem(eq);
        to_remove.add(eq);
      }
    }
    current_list.removeAll(to_remove);
    to_remove.clear();

    //consommable are not sold for the moment
  }


  private void sellItem(Sellable s){
    gold += s.getValue();
  }

  public Sellable getSpell() {
    ArrayList<Sellable> spells = sellables.get(0);
    return spells.get(new Random().nextInt(spells.size()));
  }
}
