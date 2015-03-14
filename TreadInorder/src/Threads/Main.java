package Threads;

/**
 * Created by Tanja on 14-3-2015.
 */
public class Main {


    public static void main(String args[]){
        Thread thread1 = new ThreadPrintInorder(1);
        thread1.setName("1");
        thread1.start();

        Thread thread2 = new ThreadPrintInorder(2);
        thread2.setName("2");
        thread2.start();

        Thread thread3 = new ThreadPrintInorder(3);
        thread3.setName("3");
        thread3.start();

        Thread thread4 = new ThreadPrintInorder(4);
        thread4.setName("4");
        thread4.start();
    }
}
