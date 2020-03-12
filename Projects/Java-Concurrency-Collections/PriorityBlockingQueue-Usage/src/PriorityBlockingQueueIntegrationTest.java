 

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import java.util.Arrays;

 

public class PriorityBlockingQueueIntegrationTest {

    private static final Logger LOG = LoggerFactory.getLogger(PriorityBlockingQueueIntegrationTest.class);

    
    public static void main(String[] args) throws InterruptedException {
    	
    	addUonorderedValuesPollingShouldOrderQueue();
    	
    	pollingEmptyQueueShouldBlockThread();
    }

   
    public static void addUonorderedValuesPollingShouldOrderQueue() throws InterruptedException {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
        
        ArrayList<Integer> polledElements = new ArrayList<>();

        queue.add(1);
        queue.add(5);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        queue.drainTo(polledElements);

       System.out.println("The polledElements (a s ordered )are "+polledElements);//1,2,3,4,5
    }

     
    public static void pollingEmptyQueueShouldBlockThread() throws InterruptedException {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        final Thread thread = new Thread(() -> {
            LOG.debug("Polling the empty Queue...");
            System.out.println("Polling the empty Queue...");
            while (true) {
                try {
                    Integer poll = queue.take();
                    System.out.println("Polled with : " + poll);
                } catch (InterruptedException ignored) {
                }
            }
        });
        thread.start();

        Thread.sleep(TimeUnit.SECONDS.toMillis(10));        
        
        Integer [] array = {1, 5, 6, 1, 2, 6, 7 };

        
        List<Integer> list = Arrays.asList(array);      
         
       
        queue.addAll(list);
        System.out.println("Added the elements from "+list);
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
    }
}
