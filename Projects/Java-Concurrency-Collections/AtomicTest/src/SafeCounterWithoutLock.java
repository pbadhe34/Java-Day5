 

import java.util.concurrent.atomic.AtomicInteger;

public class SafeCounterWithoutLock {
    private final AtomicInteger counter = new AtomicInteger(0);
    
   /*  The java.util.concurrent.atomic package is a small toolkit of classes that support lock-free
    *  thread-safe programming on single variables.
    *  AtomicInteger is thread-safe.
    * AtomicInteger class is a wrapper class for an int value that allows it to be updated atomically.
    * The AtomicInteger class provides with a int variable which can be read and written atomically, 
    and which also contains advanced atomic operations like compareAndSet(). 
    The AtomicInteger class is located in the java.util.concurrent.atomic package, 
    The most common use of the AtomicInteger is to handle a counter that is accessed by different threads simultaneously
    */
    
      
    
    int getValue() {
        return counter.get();
    }
    
    void increment() {
        while(true) {
            int existingValue = getValue();
            int newValue = existingValue + 1;
            if(counter.compareAndSet(existingValue, newValue)) {
                return;
            }
        }
    }
}
