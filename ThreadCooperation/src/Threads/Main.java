package Threads;

/**
 * Created by Tanja on 14-3-2015.
 */
public class Main {


    public static void main(String args[]){
        Thread thread1 = new ThreadPrint();
        thread1.setName("1");
        thread1.start();

        Thread thread2 = new ThreadPrint();
        thread2.setName("2");
        thread2.start();

        Thread thread3 = new ThreadPrint();
        thread3.setName("3");
        thread3.start();

        Thread thread4 = new ThreadPrint();
        thread4.setName("4");
        thread4.start();
    }
}
