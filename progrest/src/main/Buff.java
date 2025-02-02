package main;

public class Buff {
    private int duration;
    private Sellable source;

    public boolean changeDuration(){
        duration--;
        return duration<=0;
    }

    public Buff(int duration, Sellable source) {
        this.duration = duration;
        this.source = source;
    }

    public Sellable getSource() {
        return source;
    }
}
