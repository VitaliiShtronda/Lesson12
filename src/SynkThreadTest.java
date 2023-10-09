import java.util.ArrayList;
import java.util.List;

public class SynkThreadTest {

    private  volatile static int counter = 0;

    public static void increment(){
        System.out.println("aaa");
        System.out.println("aaa");
        System.out.println("aaa");
        System.out.println("aaa");
        System.out.println("aaa");
        synchronized (SynkThreadTest.class) {
            counter = counter + 1;
        }
    }

    public static synchronized void increment2(){
                    counter = counter + 1;

    }

    public static void main(String[] args) throws InterruptedException {
//        first();
//        second();
        third();

    }
    public static void second() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i <100; i++){

            Thread thread = new Thread(() -> {
                for(int j = 0; j < 1000; j++) {
                    counter = counter + 1;
                }
            });
            threads.add(thread);
        }

        for (Thread t: threads) {
            t.start();

        }
        for (Thread t: threads) {
            t.join();

        }
        System.out.println(counter);

    }
    public static void third() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i <100; i++){

            Thread thread = new Thread(() -> {
                for(int j = 0; j < 1000; j++) {
                   // increment();
                    synchronized (SynkThreadTest.class){
                        counter = counter + 1;
                    }
                }
            });
            threads.add(thread);
        }

        for (Thread t: threads) {
            t.start();

        }
        for (Thread t: threads) {
            t.join();

        }
        System.out.println(counter);

    }



    public static void first() throws InterruptedException {
        Thread t = new Thread(() -> {
            counter++;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        t.start();

        t.join();
    }

}
