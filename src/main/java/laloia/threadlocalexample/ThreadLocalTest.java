/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laloia.threadlocalexample;

/**
 *
 * @author lou
 */
public class ThreadLocalTest implements Runnable {

    private ThreadContext threadCtx;
    private long delayTime;
    private long sleepTime;

    public ThreadLocalTest(ThreadContext value, long delayTime, long sleepTime) {
        this.threadCtx = value;
        this.delayTime = delayTime;
        this.sleepTime = sleepTime;
    }

    public static void main(String[] args) {
        ThreadContext thCtx1 = new ThreadContext();
        thCtx1.setUserId("loua");
        ThreadLocalTest test1 = new ThreadLocalTest(thCtx1, 0, 300);
        System.out.println("Creating test1 : " + test1);
        
        ThreadContext thCtx2 = new ThreadContext();
        thCtx2.setUserId("loub");
        ThreadLocalTest test2 = new ThreadLocalTest(thCtx2, 100, 600);
        System.out.println("Creating test2 : " + test2);
        Thread t1 = new Thread(test1);
        Thread t2 = new Thread(test2);

        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.delayTime);
            System.out.println("[" + this + "] is setting threadLocalContext ["
                    + ThreadLocalManager.threadLocalContext + "] the value : "
                    + this.threadCtx.getUserId());

            ThreadLocalManager.threadLocalContext.set(this.threadCtx);

            Thread.sleep(this.sleepTime);
            System.out.println("[" + this + "] is accessing threadLocalContext ["
                    + ThreadLocalManager.threadLocalContext + "] value : "
                    + ThreadLocalManager.threadLocalContext.get().getUserId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
