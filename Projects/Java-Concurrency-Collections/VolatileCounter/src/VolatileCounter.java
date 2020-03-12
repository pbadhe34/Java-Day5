 

public class VolatileCounter {
    
    private volatile int counter;
    
    public VolatileCounter() {
        this.counter = 0;
    }
    
    public synchronized void incrementCounter() {
        counter += 1;
    }
    
    public int getCounter() {
        return counter;
    }
}
