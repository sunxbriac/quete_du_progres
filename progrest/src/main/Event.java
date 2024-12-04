package main;

public interface Event extends Generable {
    void resolveEvent();
    void printMessage();
}
