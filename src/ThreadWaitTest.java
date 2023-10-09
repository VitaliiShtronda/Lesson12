public class ThreadWaitTest {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
                synchronized (Thread.currentThread()){
                    Thread.currentThread().wait();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("aaa");

        });

        t.start();

    }
}
