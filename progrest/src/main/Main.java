package main;

import utils.Printer;

public class Main {
    public static void main(String[] args) {
        SingletonStory story = SingletonStory.getInstance();
        story.start_game();
    }
}
