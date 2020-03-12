import java.util.concurrent.BlockingQueue;

/*
 * The BlockingQueue is a  Queue that  supports operations that wait for the queue 
 * to become non-empty when retrieving an element, and wait for space to become 
 * available in the queue when storing an element. 
 */
public class Producer implements Runnable {
	   private final BlockingQueue queue;
	   int number = 0;
	   Producer(BlockingQueue q,int num) { queue = q; number = num ;}
	   int count = 0;
	   public void run() {
		   System.out.println("Producer Number  "+ number+" started..");
	     try {
	       while(true) 
	       {  
	    	   count++;
	    	   Thread.sleep(1000);
	    	   queue.put(produce(count));
	       }
	     } catch (InterruptedException ex) 
	     { 
			System.out.println("Producer interrupted..");
		}
	   }
	   String produce(int seed) 
	   { 	
		   System.out.println("Producer Number  "+ number+"  producing the object");
		    
		   return new String("ProducerData "+seed);
		}
	 }
