package main;

public class Spell extends Sellable{
    private Job class_restriction;

    public Spell(Job class_restriction, String name, int value) {
        this.class_restriction = class_restriction;
        this.name = name;
        this.value = value;
    }

    public Job getClass_restriction(){
        return class_restriction;
    }
}
