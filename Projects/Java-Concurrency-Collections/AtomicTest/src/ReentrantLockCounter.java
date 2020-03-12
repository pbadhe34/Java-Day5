 

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter {

    private int counter;
    
    //lock should use a fair ordering policy for locks
    private final ReentrantLock reLock = new ReentrantLock(true);

    public ReentrantLockCounter() {
        this.counter = 0;
    }

    public void incrementCounter() {
        reLock.lock();
        try {
            counter += 1;
        } finally {
            reLock.unlock();
        }
    }

    public int getCounter() {
        return counter;
    }
}
