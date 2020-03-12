 

 
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

 
public class VolatileCounterUnitTest {
	
	public static void main(String args[]) throws Exception {
		IncrementCounter_WithCallable();
		
		
	}

   
    public static   void IncrementCounter_WithCallable() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        VolatileCounter counter = new VolatileCounter();
        Future<Integer> future1 = (Future<Integer>) executorService.submit(new VolatileCounterCallable(counter));
        Future<Integer> future2 = (Future<Integer>) executorService.submit(new VolatileCounterCallable(counter));

        // Just to make sure both are completed
        future1.get();
        future2.get();

         System.out.println("The counter value is "+counter.getCounter());
    }
}
