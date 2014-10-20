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
public class CircularNumberFinderRunnable implements Runnable {

    private ArrayList<Integer> possibleCircularNumbers = new ArrayList<>();
    private int from;
    private int until;

    public CircularNumberFinderRunnable(int from, int until) {
        this.from = from;
        this.until = until;
    }

    @Override
    public void run() {
        for (int i = from; i < until; i++) {
            if (isPrime(i) && isPossibleToBeCircular(i)) {
                possibleCircularNumbers.add(i);
            }
        }
        PrimosCirculares.addPossiblePrimeCircular(possibleCircularNumbers);
    }

    private static boolean isPossibleToBeCircular(int number) {
        String stringNumber = String.valueOf(number);
        if (number < 10) {
            return false;
        }
        boolean isPossibleToBeCircular = true;
        if (stringNumber.contains("0")
                || stringNumber.contains("2")
                || stringNumber.contains("4")
                || stringNumber.contains("5")
                || stringNumber.contains("6")
                || stringNumber.contains("8")) {
            isPossibleToBeCircular = false;
        }
        return isPossibleToBeCircular;
    }

    private static boolean isPrime(int n) {
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
