package main;

public class Consommable extends Sellable{
    private int bonus;
    private int number_of_use;
    private int stat_id;

    public boolean use(){
        number_of_use--;
        return number_of_use<=0;
    }

    public Consommable(int stat_id, int number_of_use, int bonus, String name, int value) {
        this.stat_id = stat_id;
        this.number_of_use = number_of_use;
        this.bonus = bonus;
        this.name = name;
        this.value = value;
    }
}
