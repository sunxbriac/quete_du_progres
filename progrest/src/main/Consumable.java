package main;

public class Consumable extends Sellable{
    private final int bonus;
    private int number_of_use;
    private final int stat_id;

    public boolean use(){
        number_of_use--;
        return number_of_use<=0;
    }

    public Consumable(int stat_id, int number_of_use, int bonus, String name, int value) {
        this.stat_id = stat_id;
        this.number_of_use = number_of_use;
        this.bonus = bonus;
        this.name = name;
        this.value = value;
    }



    @Override
    public void print() {
        //TODO
    }
}
