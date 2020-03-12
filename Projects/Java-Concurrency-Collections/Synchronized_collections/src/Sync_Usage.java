


	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;

	public class Sync_Usage {
	  public static void printWords(String[] word) {
	    System.out.println("word.length=" + word.length);
	    for (int i = 0; i < word.length; i++) {
	      System.out.println("word[" + i + "]=" + word[i]);
	    }
	  }

	  public static void main(String[] args) {
		//First technique
		  //Define a synchronized list
	    List wordList = Collections.synchronizedList(new ArrayList());

	    wordList.add("java");
	    wordList.add("is");
	    wordList.add("sync");
	    wordList.add("User");
	    wordList.add("word");

	     
	    String[] wordA = (String[]) wordList.toArray(new String[0]);

	    printWords(wordA);
	    System.out.println();

	    //second technique
	    String[] wordB;
	   //Make a copy of list and operate
	    synchronized (wordList) {
	      int size = wordList.size();
	      wordB = new String[size];
	      wordList.toArray(wordB);
	    }

	    printWords(wordB);
	    System.out.println();

	    // Third technique  
	    //operate on synchronized block around the list object
	    String[] wordC;
	    synchronized (wordList) {
	    	//Make the only part of list that is needed
	      wordC = (String[]) wordList.toArray(new String[wordList.size()]);
	    }

	    printWords(wordC);
	  }
	}

