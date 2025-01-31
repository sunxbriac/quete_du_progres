package main;

public class Equipment extends Sellable {
    private final int bonus;
    private final Job class_restriction;
    private final int stat_id;

    public Equipment(int stat_id, Job class_restriction, int bonus, String name, int value) {
        this.stat_id = stat_id;
        this.class_restriction = class_restriction;
        this.bonus = bonus;
        this.name = name;
        this.value = value;
    }

    public Job getClass_restriction(){
        return class_restriction;
    }

    @Override
    public void print() {
        //TODO
    }
}
