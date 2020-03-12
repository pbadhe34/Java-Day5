import java.util.concurrent.BlockingQueue;

/*
 * The BlockingQueue is a  Queue that  supports operations that wait for the queue 
 * to become non-empty when retrieving an element, and wait for space to become 
 * available in the queue when storing an element. 
 */
public class Producer implements Runnable {
	   private final BlockingQueue queue;
	   Producer(BlockingQueue q) { queue = q; }
	   
	   int count =0;
	   public void run() {
	     try {
	       while(true) 
	       { 
	    	   Thread.sleep(500);
	    	   queue.put(produce(count));
	    	   count++;
	       }
	     } catch (InterruptedException ex) 
	     { 
			System.out.println("Producer interrupted..");
		}
	   }
	   String produce(int seed) 
	   { 		   
		   System.out.println("Producing the message to queue with "+seed);
		   return new String("Message "+seed);
		}
	 }
