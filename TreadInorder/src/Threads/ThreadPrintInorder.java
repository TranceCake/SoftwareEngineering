package Threads;


/**
 * Created by Tanja on 14-3-2015.
 */
public class ThreadPrintInorder extends Thread {

    public int num;


    public ThreadPrintInorder(int i) {
        num = i;
    }

    @Override
    public void run() {
        print(num);
    }

    private void print(int a) {
        synchronized (System.out) {
            for (int i = 0; i < 2; i++) {
                System.out.println(num +this.getName());
            }
            System.out.println("");
        }
    }
}