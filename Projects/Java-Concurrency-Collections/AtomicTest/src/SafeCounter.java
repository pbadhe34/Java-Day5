 

public class SafeCounter {
    private volatile int counter;
    
    int getValue() {
        return counter;
    }
    
    synchronized void increment() {
        counter++;
    }
}
