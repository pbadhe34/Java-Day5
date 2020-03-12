 

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CountdownLatchAtomicUsage{

    private int count;
    private int threadCount;
    private final AtomicInteger updateCount;

    CountdownLatchAtomicUsage(int count, int threadCount) {
        updateCount = new AtomicInteger(0);
        this.count = count;
        this.threadCount = threadCount;
    }

    public int countWaits() {
        CountDownLatch countDownLatch = new CountDownLatch(count);
        ExecutorService es = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i < threadCount; i++) {
            es.execute(() -> {
                long prevValue = countDownLatch.getCount();
                countDownLatch.countDown();
                if (countDownLatch.getCount() != prevValue) {
                    updateCount.incrementAndGet();
                }               
            });
        }
        
        es.shutdown();
        return updateCount.get();
    }

    public static void main(String[] args) {
    	CountdownLatchAtomicUsage ex = new CountdownLatchAtomicUsage(5, 20);
        System.out.println("Final Count : " + ex.countWaits());
    }
}
