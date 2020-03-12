  
import java.util.concurrent.Callable;

public class VolatileCounterCallable implements Callable<Integer> {

    private final VolatileCounter counter;
    
    public VolatileCounterCallable(VolatileCounter counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
        counter.incrementCounter();
        return counter.getCounter();
    }
}
