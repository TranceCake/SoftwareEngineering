package Threads;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Tanja on 14-3-2015.
 */
public class ThreadPrint extends Thread {

    public int num;
    public static int howMany = 4;

    public static Lock lock = new ReentrantLock();
    public static Condition enough = lock.newCondition();

    @Override
    public void run() {

        num = Integer.parseInt(this.getName());

        try{
            show(num);
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

    }

    public void show(int number) throws InterruptedException{
        lock.lock();
        try {
            while (number < howMany) {
                enough.await();
            }

            for(int i = 0 ; i < 1 ; i++) {
                System.out.println(number +this.getName());
            }
            howMany --;
            enough.signalAll();
        }
        finally{
            lock.unlock();
        }

    }

}