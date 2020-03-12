


	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Iterator;
	import java.util.List;

	public class Sync_Iteration {
	  public static void main(String[] args) {
	    List wordList = Collections.synchronizedList(new ArrayList());
	    
	    /*
	     * Returns a synchronized (thread-safe) list backed by the specified list.
	     * In order to guarantee serial access, it is critical that all access to
	     *  the backing list is accomplished through the returned list.
	     */

	    wordList.add("Customers");
	    wordList.add("require");
	    wordList.add("special");
	    wordList.add("attention");
	    
	    //It is imperative that the user manually synchronize on the
	    //returned list when iterating over it


	    synchronized (wordList) {
	      Iterator iter = wordList.iterator();
	      while (iter.hasNext()) {
	        String s = (String) iter.next();
	        System.out.println("found string: " + s + ", length="
	            + s.length());
	      }
	    }
	  }
	}
