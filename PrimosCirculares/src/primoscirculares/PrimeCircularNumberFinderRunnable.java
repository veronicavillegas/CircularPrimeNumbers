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
public class PrimeCircularNumberFinderRunnable implements Runnable {

    private ArrayList<Integer> possibleCircularNumbers = new ArrayList<>();
    private int from;
    private int until;

    public PrimeCircularNumberFinderRunnable(int from, int until) {
        this.from = from;
        this.until = until;
    }

    @Override
    public void run() {
        for (int i = from; i < until; i++) {
            if (PrimeCircularCommon.isPrime(i) && PrimeCircularCommon.isPossibleToBeCircular(i)) {
                possibleCircularNumbers.add(i);
            }
        }
        PrimosCirculares.addPossiblePrimeCircular(possibleCircularNumbers);
    }

    

    

}
