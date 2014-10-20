/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primoscirculares;

import java.util.ArrayList;

/**
 *
 * @author Veronica
 */
public class FinderThread extends Thread{
    private String threadName;
    private int findFor;
    FinderThread(String name, int i) {
        threadName = name;
        findFor=i;
    }

     public void run() {
	new ManagePrimeNumbers().next
     }
     
    private static void getPossibleCircularNumbers(ArrayList<Integer> primeNumbers) {

      for (Integer primeNumber : primeNumbers) {
          String wordToCheck = String.valueOf(primeNumber);
          if (wordToCheck.contains("0")
                  || wordToCheck.contains("2")
                  || wordToCheck.contains("4")
                  || wordToCheck.contains("5")
                  || wordToCheck.contains("6")
                  || wordToCheck.contains("8")) {
              primeNumber.
          }
      }
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   public void run() {
     synchronized(PD) {
        PD.printCount();
     }
     System.out.println("Thread " +  threadName + " exiting.");
   }

   public void start ()
   {
      System.out.println("Starting " +  threadName );
      if (t == null)
      {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
   
}
