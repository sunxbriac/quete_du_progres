package main;

public class Spell extends Sellable{
    private final Job class_restriction;

    public Spell(Job class_restriction, String name, int value) {
        this.class_restriction = class_restriction;
        this.name = name;
        this.value = value;
    }

    public Job getClass_restriction(){
        return class_restriction;
    }

    @Override
    public void print() {
        System.out.println("--------------------");

        System.out.println("Name: " + name);
        System.out.println("Value: " + value + "g");
        System.out.println("Class Restriction: " + class_restriction);

        System.out.println("--------------------");
    }
}
