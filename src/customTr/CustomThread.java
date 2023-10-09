package customTr;

public class CustomThread extends Thread{


    @Override
    public void run() {
        System.out.println("in newthread class");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
    }
}
