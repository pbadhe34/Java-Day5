 

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

 

public class ThreadSafeCounterTest {
	
	public static void main(String args[]) throws InterruptedException {
		System.out.println("ThreadSafeCounterTest starting ");
		
		SafeCounterWithLockedIncrement();	
		 
		
		SafeCounterWithoutLockedIncrement();
		
		
	}

     
    public static void SafeCounterWithLockedIncrement() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SafeCounter safeCounter = new SafeCounter();

        IntStream.range(0, 1000)
          .forEach(count -> service.submit(safeCounter::increment));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);
        
        System.out.println("The safe counted value with safeCounter is "+safeCounter.getValue());

       
    }
    
     
    public static void SafeCounterWithoutLockedIncrement() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SafeCounterWithoutLock safeCounterWithoutLock = new SafeCounterWithoutLock();

        IntStream.range(0, 1000)
          .forEach(count -> service.submit(safeCounterWithoutLock::increment));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);         
        
        System.out.println("The safe counted value with safeCounterWithoutLock is "+safeCounterWithoutLock.getValue());
    }
    
}
