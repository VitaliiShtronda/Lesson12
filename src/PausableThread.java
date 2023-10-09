public class PausableThread extends Thread{

    private volatile boolean isAlive = true;
    private volatile boolean needToRun = false;

    @Override
    public void run() {
        while(isAlive){
            if(needToRun){
                System.out.println("running thread");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }



    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isNeedToRun() {
        return needToRun;
    }

    public void setNeedToRun(boolean needToRun) {
        this.needToRun = needToRun;
    }

    public static void main(String[] args) throws InterruptedException {
        PausableThread pausableThread = new PausableThread();
        pausableThread.start();

        System.out.println("main thread sleep...");
        Thread.sleep(2000);

        System.out.println("pausableThread.setNeedToRun(true)");
        pausableThread.setNeedToRun(true);

        System.out.println("main thread sleep...");

        Thread.sleep(2000);
        System.out.println("pausableThread.setNeedToRun(false)");
        pausableThread.setNeedToRun(false);


        pausableThread.setAlive(false);

        System.out.println("main thread sleep...");
        Thread.sleep(2000);

    }
}
