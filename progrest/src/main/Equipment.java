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

    public int getStat_id() {
        return stat_id;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public void print() {
        System.out.println("--------------------");

        System.out.println("Name: " + name);
        System.out.println("Value: " + value + "g");
        System.out.println("Class Restriction: " + class_restriction);

        TypeAttribute statType = TypeAttribute.values()[stat_id];
        System.out.println("Attribute: " + statType);

        System.out.println("Bonus: " + bonus);

        System.out.println("--------------------");
    }
}
