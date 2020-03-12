 

 
import java.util.concurrent.Callable;

public class AtomicCounterCallable implements Callable<Integer> {

    private final AtomicSyncCounter counter;
    
    public AtomicCounterCallable(AtomicSyncCounter counter) {
        this.counter = counter;
    }

     public Integer call() throws Exception {
        counter.incrementCounter();
        return counter.getCounter();
    }
}
