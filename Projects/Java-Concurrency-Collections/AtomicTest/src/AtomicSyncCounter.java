 

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicSyncCounter {
    
    private final AtomicInteger counter; // = new AtomicInteger();
    
    public AtomicSyncCounter(AtomicInteger base) {
    	counter = base;
    }
    
  //Not necessary with synchronized access
    public synchronized void incrementCounter() {
        counter.incrementAndGet();
    }
    
    //Not necessary with synchronized access
    public synchronized int getCounter() {
        return counter.get();
    }
}
