import java.util.ArrayList;
import java.util.List;

public class SyncThreadObjTest {

    static volatile int counter= 0;

    public static void main(String[] args) throws InterruptedException {
        SyncThreadObjTest syncThreadObjTest = new SyncThreadObjTest();
        SyncThreadObjTest syncThreadObjTest2 = new SyncThreadObjTest();

            List<Thread> threads = new ArrayList<>();

            for (int i = 0; i <100; i++){

                Thread thread = new Thread(() -> {
                    for(int j = 0; j < 1000; j++) {
                        // increment();
                        synchronized (syncThreadObjTest){
                            syncThreadObjTest.counter = syncThreadObjTest.counter + 1;
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

    }

