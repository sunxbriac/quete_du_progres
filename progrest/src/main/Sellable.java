package main;

public abstract class Sellable {
    protected int value;
    protected String name;

    public int getValue()
    {
        return value;
    }

    public String getName()
    {
        return name;
    }

    public abstract void print();
}
