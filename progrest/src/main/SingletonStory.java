package main;

import utils.Printer;

import java.util.Scanner;

public class SingletonStory {
    private static SingletonStory instance;
    private int act_number;
    private Act act;
    public static volatile boolean isPaused = false;
    public static volatile boolean isGameRunning = true;
    private Thread gameThread;

    public static SingletonStory getInstance(){
        if(instance == null){
            synchronized (SingletonStory.class){
                if(instance==null)
                    instance = new SingletonStory();
            }
        }
        return instance;
    }

    private SingletonStory(){
        act_number = 0;
    }

    public void changeAct(){
        act_number++;
        act = new Act(act_number);
    }

    public void start_game(){
        System.out.println("Welcome in progrest quest (not the real one though)");
        System.out.println("Type \"pause\" at any moment to pause the game");
        //TODO choix de classe et autres

        play();
    }
    public void play(){

        gameThread = new Thread(() -> {
            while (isGameRunning) {
                if (!isPaused) {
                    changeAct();
                    act.solveEvents();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    Thread.currentThread().interrupt();
                }
            }
        });

        gameThread.start();

        // Listen for user input to pause the game
        Scanner scanner = new Scanner(System.in);
        while (isGameRunning) {
            if (!scanner.hasNextLine()) {
                break;
            }

            String input = scanner.nextLine();
            if ("pause".equalsIgnoreCase(input)) {
                isPaused = true;
                System.out.println("Game will be paused at the end of the current event. Type 'help' to see commands.");
                handleInputWhilePaused(scanner);
            } else if ("resume".equalsIgnoreCase(input)) {
                isPaused = false;
                System.out.println("Game resumed.");
            }
            else if("stop".equalsIgnoreCase(input)){
                stopGame();
                break;
            }
        }
        scanner.close();
    }

    private void handleInputWhilePaused(Scanner scanner) {
        while (isPaused && isGameRunning) {
            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "help":
                    printHelp();
                    break;
                case "stop":
                    System.out.println("Stopping the game must be called while the game is active (not paused)");
                    break;
                case "resume":
                    isPaused = false;
                    System.out.println("Game resumed.");
                    break;
                default:
                    System.out.println("Unknown command. Type 'help' for options.");
                    break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void printHelp() {
        System.out.println("Available commands while paused:");
        System.out.println("- 'help' : Show this help message");
        System.out.println("- 'stop' : Stop the game to go outside and do something else (call after resume only) ");
        System.out.println("- 'pause : Pause the game at the end of the current event");
        System.out.println("- 'resume' : Resume the game");
    }

    private void stopGame() {
        isGameRunning = false;
        System.out.println("Game stopped. Thanks for (not) playing");

        if (gameThread != null) {
            gameThread.interrupt();
        }
    }
}
