 

  

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

 

public class ReentrantLockCounterTest {

    
public static void main(String[] args) throws Exception {
		
	incrementCounter_thenVerify();
 
	}
    public static void incrementCounter_thenVerify() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ReentrantLockCounter counter = new ReentrantLockCounter();
        Future<Integer> future1 = (Future<Integer>) executorService.submit(new ReentrantLockCounterCallable(counter));
        Future<Integer> future2 = (Future<Integer>) executorService.submit(new ReentrantLockCounterCallable(counter));

        // Just to make sure both are completed
        future1.get();
        future2.get();

        System.out.println("The counter value is "+counter.getCounter());
    }
}
