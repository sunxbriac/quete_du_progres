package main;

import java.util.ArrayList;
import java.util.Random;

public class Inventory {
  private int gold;
  private ArrayList<ArrayList<Sellable>> sellables;
  public void sellItems()
  {
    
  }
  public Sellable getSpell() {
    ArrayList<Sellable> spells = sellables.get(0);
    return spells.get(new Random().nextInt(spells.size()));
  }
}
