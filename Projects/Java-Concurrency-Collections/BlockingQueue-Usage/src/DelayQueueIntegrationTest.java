 

 

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*DelayQueue is an unbounded blocking queue of Delayed elements, in which an element can only be taken when 
its delay has expired. 
The head of the queue is that Delayed element whose delay expired furthest in the past.
If no delay has expired there is no head and poll will return null. 
Expiration occurs when an element's getDelay(TimeUnit.NANOSECONDS) method returns a value less than or equal to zero. 
Even though unexpired elements cannot be removed using take or poll, they are otherwise treated as normal elements. 
For example, the size method returns the count of both expired and unexpired elements.
This queue does not permit null elements.*/

 
public class DelayQueueIntegrationTest {
	
	public static void main(String[] args) throws InterruptedException {
		
	  System.out.println("DelayQueueIntegrationTest starting");
	  
	  whenProducedElementThenShouldConsumeAfterGivenDelay();
	  
	  whenProduceElementWithHugeDelayThenConsumerNotAbleToConsumeMessageInGivenTime();
	  
	  whenProduceElementWithNegativeDelayThenConsumeMessageImmediately();
	  
	  
	}
   
    public static void whenProducedElementThenShouldConsumeAfterGivenDelay() throws InterruptedException {
        //given
        ExecutorService executor = Executors.newFixedThreadPool(2);
        BlockingQueue<DelayObject> queue = new DelayQueue<>();
        int numberOfElementsToProduce = 2;
        int delayOfEachProducedMessageMilliseconds = 500;
        DelayQueueConsumer consumer = new DelayQueueConsumer(queue, numberOfElementsToProduce);
        DelayQueueProducer producer
          = new DelayQueueProducer(queue, numberOfElementsToProduce, delayOfEachProducedMessageMilliseconds);

        //when
        executor.submit(producer);
        executor.submit(consumer);

        //then
        executor.awaitTermination(5, TimeUnit.SECONDS);
        executor.shutdown();
        System.out.println("The numberOfConsumedElements are "+consumer.numberOfConsumedElements.get());
        System.out.println("The numberOfElementsToProduce are "+ numberOfElementsToProduce);

    }

 
    public static void whenProduceElementWithHugeDelayThenConsumerNotAbleToConsumeMessageInGivenTime() throws InterruptedException {
        //given
        ExecutorService executor = Executors.newFixedThreadPool(2);
        BlockingQueue<DelayObject> queue = new DelayQueue<>();
        int numberOfElementsToProduce = 1;
        int delayOfEachProducedMessageMilliseconds = 10_000;
        DelayQueueConsumer consumer = new DelayQueueConsumer(queue, numberOfElementsToProduce);
        DelayQueueProducer producer
          = new DelayQueueProducer(queue, numberOfElementsToProduce, delayOfEachProducedMessageMilliseconds);

        //when
        executor.submit(producer);
        executor.submit(consumer);

        //then
        executor.awaitTermination(5, TimeUnit.SECONDS);
        executor.shutdown();
        
        System.out.println("The numberOfConsumedElements after delayed produce shoud be zero  "+consumer.numberOfConsumedElements.get());
       

      

    }

   
    public static void whenProduceElementWithNegativeDelayThenConsumeMessageImmediately() throws InterruptedException {
        //given
        ExecutorService executor = Executors.newFixedThreadPool(2);
        BlockingQueue<DelayObject> queue = new DelayQueue<>();
        int numberOfElementsToProduce = 1;
        int delayOfEachProducedMessageMilliseconds = -10_000;
        DelayQueueConsumer consumer = new DelayQueueConsumer(queue, numberOfElementsToProduce);
        DelayQueueProducer producer
          = new DelayQueueProducer(queue, numberOfElementsToProduce, delayOfEachProducedMessageMilliseconds);

        //when
        executor.submit(producer);
        executor.submit(consumer);

        //then
        executor.awaitTermination(1, TimeUnit.SECONDS);
        executor.shutdown();
        
        System.out.println("The numberOfConsumedElements after negative prodice delay  shoud be immediate and One   "+consumer.numberOfConsumedElements.get());
        
     
    }
}