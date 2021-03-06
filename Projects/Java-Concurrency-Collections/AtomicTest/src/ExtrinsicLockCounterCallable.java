 
 import java.util.concurrent.Callable;

public class ExtrinsicLockCounterCallable implements Callable<Integer> {

    private final ExtrinsicLockCounter counter;
    
    public ExtrinsicLockCounterCallable(ExtrinsicLockCounter counter) {
        this.counter = counter;
    }
    
    @Override
    public Integer call() throws Exception {
        counter.incrementCounter();
        return counter.getCounter();
    }
}
