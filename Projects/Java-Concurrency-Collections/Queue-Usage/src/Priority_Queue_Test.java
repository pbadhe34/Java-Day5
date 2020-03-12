


	import java.util.Comparator;
	import java.util.PriorityQueue;
	import java.util.Queue;

	public class Priority_Queue_Test {
		/*
		 * The PriorityQueue orders elements according to an order specified at construction time, 
		 * which is specified either according to their natural order 
            or according to a Comparator, depending on which constructor is used. 
            A priority queue does not permit null elements. 
            A priority queue relying on natural ordering also does not permit insertion of
             non-comparable objects
             
             PriorityQueue stores its elements internally according to their natural order 
             (if they implement Comparable), or according to a Comparator passed to the PriorityQueue.
		 */

	  public static void main(String[] args) {
       //Create the PriorityQueue with 20 elements and comparator
		  
		  Comparator compareAsc =  new Comparator<Integer>() {
	          public int compare(Integer i, Integer j) {
	            int result = i%2 - j%2;
	            if (result == 0)
	              result = i-j;
	            //System.out.println("Ordering the element on  "+result);
	            //System.out.println("Comparing the elements as   "+i +" and "+j);
	            return result;
	          }
	        };
	        
	        Comparator compareDsc =  new Comparator<Integer>() {
		          public int compare(Integer i, Integer j) {
		            int result = i%2 - j%2;
		            if (result == 0)
		              result = j -i;
		            //System.out.println("Ordering the element on  "+result);
		            //System.out.println("Comparing the elements as   "+i +" and "+j);
		            return result;
		          }
		        };
		  
	   /* PriorityQueue<Integer> pq =
	      new PriorityQueue<Integer>(20, compareAsc);
	         */
	    
	    
	    /*PriorityQueue<Integer> pq =
	  	      new PriorityQueue<Integer>(20, compareDsc);*/
		        
	    //Default natural order of comparioson
		        
	    PriorityQueue<Integer> pq =
		  	      new PriorityQueue<Integer>(20);
		      
	      

	    // Fill up with data, in an odd order
	    for (int i=0; i<20; i++) {
	    	int elemment = 20 - i;
	    	System.out.println("Adding the element "+elemment);
	        pq.offer(elemment);
	    }

	    // Print out and check ordering
	    
	    System.out.println("Getting the elements from PriorityQueue");
	    for (int i=0; i<20; i++) {
	    	 
	      System.out.println(pq.poll());
	    }
	  }
	}

	           
	         