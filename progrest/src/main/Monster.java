package main;


public class Monster{
    private final String name;
    private final String how_to_kill;

    public Monster(String name, String how_to_kill){
        this.name =name;
        this.how_to_kill=how_to_kill;
    }

    public String getName() {
        return name;
    }

    public String getHow_to_kill() {
        return how_to_kill;
    }
}
