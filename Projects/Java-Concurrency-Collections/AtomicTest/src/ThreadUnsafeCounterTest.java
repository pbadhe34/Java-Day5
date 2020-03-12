 

 

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

 

/**
 * This test shows the behaviour of a thread-unsafe class in a multithreaded scenario. Here calling
 * the increment methods 1000 times from a pool of 3 threads. In most of the cases, the counter will 
 * less than 1000, because of lost updates, however, occasionally it may reach 1000, when no threads
 * called the method simultaneously.  
 */
public class ThreadUnsafeCounterTest {
	
	public static void main(String args[]) {
		System.out.println("ThreadUnsafeCounterTest starting ");
		ExecutorService service = Executors.newFixedThreadPool(4);
        UnsafeCounter unsafeCounter = new UnsafeCounter();

        //Use IntegerStream with Stream expresssions
        IntStream.range(0, 1000)
          .forEach(count -> service.submit(unsafeCounter::increment));
        
        try {
			service.awaitTermination(1000, TimeUnit.MILLISECONDS);//timout of 1000 ms
		} catch (InterruptedException e) {
			 
			e.printStackTrace();
		}
        System.out.println("The unsafe counted value is "+unsafeCounter.getValue());

        
	}

     
}