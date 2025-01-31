package main;

import java.util.List;

public class Monster{
    private String nom;
    private String how_to_kill;

    public Monster(String name, String how_to_kill){
        nom=name;
        this.how_to_kill=how_to_kill;
    }

    public String getNom() {
        return nom;
    }

    public String getHow_to_kill() {
        return how_to_kill;
    }
}
