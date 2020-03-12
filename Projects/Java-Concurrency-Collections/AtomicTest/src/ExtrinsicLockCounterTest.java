

 import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExtrinsicLockCounterTest {

	public static void main(String[] args) throws Exception {
		
		IncrementCounterAndVerify();
 
	}
     
    public static void IncrementCounterAndVerify() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExtrinsicLockCounter counter = new ExtrinsicLockCounter();
        Future<Integer> future1 = (Future<Integer>) executorService.submit(new ExtrinsicLockCounterCallable(counter));
        Future<Integer> future2 = (Future<Integer>) executorService.submit(new ExtrinsicLockCounterCallable(counter));

        // Just to make sure both are completed
        future1.get();
        future2.get();

        System.out.println("The counter value is "+counter.getCounter());
    }
}
