package main;

public class Equipement extends Sellable {
    private int bonus;
    private Job class_restriction;
    private int stat_id;

    public Equipement(int stat_id, Job class_restriction, int bonus, String name, int value) {
        this.stat_id = stat_id;
        this.class_restriction = class_restriction;
        this.bonus = bonus;
        this.name = name;
        this.value = value;
    }

    public Job getClass_restriction(){
        return class_restriction;
    }
}
