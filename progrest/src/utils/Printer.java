package utils;

public abstract class Printer {
    public static void slow_print(String s, int slowness){
        System.out.print(s);
        for(int i=0; i!=slowness; i++){
            try {
                Thread.sleep(300);
                System.out.print(".");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();

    }
}
