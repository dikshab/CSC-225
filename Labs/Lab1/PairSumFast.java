/* PairSum.java
   CSC 225 - Summer 2014

   B. Bird - 04/30/2014
*/

import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;

public class PairSumFast{
  /* PairSum225()
    Search the array A for a pair of elements which sum to 225.
    If such a pair is found, return true. Otherwise, return false.
    The function may modify the array A.
    Do not change the function signature (name/parameters).
  */
  public static boolean PairSum225(int[] A){
    
    //Sort the array A      
    Arrays.sort(A);
    
    //For each element x of A, use binary search to check
    //whether A contains the value (225-x). If so, return true.
    for (int i = 0; i < A.length; i++){
      int x = A[i];
      int y = 225-x;
      //Get the index of y in A
      int j = Arrays.binarySearch(A,y);
      //If j is negative, y was not found.
      //Otherwise, both x and y are in A.
      if (j >= 0)
        return true;
    }
    
    return false;
  }

  /* main()
     Contains code to test the PairSum225 function. Nothing in this function will be marked.
     You are free to change the provided code to test your implementation, but only the contents
     of the PairSum225() function above will be considered during marking.
  */
  public static void main(String[] args){
    Scanner s;
    if (args.length > 0){
      try{
        s = new Scanner(new File(args[0]));
      } catch(java.io.FileNotFoundException e){
        System.out.printf("Unable to open %s\n",args[0]);
        return;
      }
      System.out.printf("Reading input values from %s.\n",args[0]);
    }else{
      s = new Scanner(System.in);
      System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
    }
    Vector<Integer> inputVector = new Vector<Integer>();
    
    int v;
    while(s.hasNextInt() && (v = s.nextInt()) >= 0)
      inputVector.add(v);
    
    int[] array = new int[inputVector.size()];
    
    for (int i = 0; i < array.length; i++)
      array[i] = inputVector.get(i);

    System.out.printf("Read %d values.\n",array.length);
    
    
    long startTime = System.currentTimeMillis();
    
    boolean pairExists = PairSum225(array);
    
    long endTime = System.currentTimeMillis();
    
    double totalTimeSeconds = (endTime-startTime)/1000.0;
    
    System.out.printf("Array %s a pair of values which add to 225.\n",pairExists? "contains":"does not contain");
    System.out.printf("Total Time (seconds): %.4f\n",totalTimeSeconds);
  }
}