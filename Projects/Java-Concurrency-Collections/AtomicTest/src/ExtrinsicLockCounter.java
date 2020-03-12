 
public class ExtrinsicLockCounter {

	//uses synchronized blocks with object
    private int counter;
    private final Object lock = new Object();

    public ExtrinsicLockCounter() {
        this.counter = 0;
    }

    public void incrementCounter() {
        synchronized (lock) {
            counter += 1;
        }
    }

    public int getCounter() {
        synchronized (lock) {
            return counter;
        }
    }
}
