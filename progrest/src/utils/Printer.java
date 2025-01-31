package utils;

public abstract class Printer {
    private final static int SLEEP_TIME = 400; //ms
    public static void slow_print(String s, int slowness){
        System.out.print(s);
        for(int i=0; i!=slowness; i++){
            try {
                Thread.sleep(SLEEP_TIME);
                System.out.print(".");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();

    }
}
