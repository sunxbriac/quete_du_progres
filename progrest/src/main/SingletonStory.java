package main;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome in progress quest (not the real one though)");
        System.out.println("Type \"pause\" at any moment to pause the game");

        setJobByUser(scanner);

        play(scanner);
    }
    public void play(Scanner scanner){

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

        while (isGameRunning) {

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
                case "inventory":
                    SingletonHero.getInstance().getInventory().print();
                    break;
                case "hero":
                    SingletonHero.getInstance().printHero();
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
        System.out.println("- 'hero' : To display information on your hero");
        System.out.println("- 'inventory' : To display all of your inventory");
        System.out.println("- 'resume' : Resume the game");
    }

    private void stopGame() {
        isGameRunning = false;
        System.out.println("Game stopped. Thanks for (not) playing");

        if (gameThread != null) {
            gameThread.interrupt();
        }
    }

    private void setJobByUser(Scanner scanner){
        Job job = null;

        while(job==null){
            System.out.println("Enter your job (Paladin, Warrior, Mage, Thief, Trapper): ");
            String input = scanner.nextLine().toUpperCase(); // Convert to upper case to match enum values



            try {
                job = Job.valueOf(input);
                System.out.println("Your selected class is: " + job);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid class selected. Please choose one of the following: (Paladin, Warrior, Mage, Thief, Trapper)");
            }
        }

        SingletonHero.getInstance().setJob(job);

    }

    public int getAct_number() {
        return act_number;
    }
}
