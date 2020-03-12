 

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

 

public class AtomicCounterTest {
	
	public static void main(String args[]) throws InterruptedException {
		System.out.println("AtomicCounterTest starting ");
		
		SafeCounterWithAtomicCounterThread();	
		 
		
		SafeCounterWithCallableCounter();
		
		
	}

     
    public static void SafeCounterWithAtomicCounterThread() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        
        AtomicInteger commonValue = new AtomicInteger(1000);
        
        AtomicCounterThread atomicThread1 = new AtomicCounterThread(commonValue);
        
        AtomicCounterThread atomicThread2 = new AtomicCounterThread(commonValue);
        AtomicCounterThread atomicThread3 = new AtomicCounterThread(commonValue);
        
        service.submit(atomicThread1);
        service.submit(atomicThread2);
        service.submit(atomicThread3);       

        
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        
        System.out.println("The safe counted value with AtomicCounterThread is "+commonValue.get());

       
    }
    
     
    public static void SafeCounterWithCallableCounter() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        
        AtomicSyncCounter commonCount = new AtomicSyncCounter(new AtomicInteger(1000));
        
        AtomicCounterCallable callableThread1 = new AtomicCounterCallable(commonCount);
        AtomicCounterCallable callableThread2 = new AtomicCounterCallable(commonCount);
        AtomicCounterCallable callableThread3 = new AtomicCounterCallable(commonCount);

         service.submit(callableThread1);
         service.submit(callableThread2);
         service.submit(callableThread3);
         
         
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);         
        
        System.out.println("The safe counted value with safeCounterWithCallable  is "+commonCount.getCounter());
    }
    
}
