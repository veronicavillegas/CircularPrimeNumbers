/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primoscirculares;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Veronica
 */
public class PrimosCirculares {

    private static ArrayList<Integer> possiblePrimeCircular = new ArrayList<>();

    public static synchronized void addPossiblePrimeCircular(ArrayList<Integer> numbers) {
        possiblePrimeCircular.addAll(numbers);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        PrimeCircularCommon.isPrime(111);
        checkThreadsForFinalization(getThreads());
        getCircularNumbers();
    }

    private static void checkThreadsForFinalization(ArrayList<Thread> threads) throws InterruptedException {
        boolean isThereThreadRunning = true;
        while (isThereThreadRunning) {
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    isThereThreadRunning = true;
                    break;
                } else {
                    isThereThreadRunning = false;
                }
            }
            if (isThereThreadRunning) {
                Thread.sleep(10);
            } else {
                break;
            }
        }
    }

    private static ArrayList<Thread> getThreads() {
        ArrayList<Thread> threads = new ArrayList<>();
        int j = 0;
        for (int i = 0; i <= 20; i++) {
            Runnable task = new PrimeCircularNumberFinderRunnable(j, j += 50000);
            Thread worker = new Thread(task);
            worker.setName("Task_" + i);
            worker.start();
            threads.add(worker);
        }
        return threads;
    }

    private static ArrayList<Integer> getCircularNumbers() {
        Map<Integer, Boolean> numbersToCheck = GetDictionaryWithPossibleCircularPrimes();
        ArrayList<Integer> circularPrimes = new ArrayList<>();
        
        for (Map.Entry<Integer, Boolean> element : numbersToCheck.entrySet()) {
            if(element.getValue() ) continue;
            int numberToCheck = (int)element.getKey();
            if(isAllDigitsEquals(numberToCheck) ) {
                circularPrimes.add(numberToCheck);
                element.setValue(Boolean.TRUE);
                continue;
            }
            int[] rotations = PrimeCircularCommon.getRotations(numberToCheck);
            if (PrimeCircularCommon.isCircularNumber(numberToCheck)) {
                for (int n : rotations) {
                    circularPrimes.add(n);
                }
            }
            markAsChecked(numbersToCheck, rotations);
        }
        return circularPrimes;
    }

    private static Map<Integer, Boolean> GetDictionaryWithPossibleCircularPrimes() {
        Map<Integer, Boolean> dictionary = new HashMap<Integer, Boolean>();
        for(int i = 0; i < possiblePrimeCircular.size(); i++){
            dictionary.put(possiblePrimeCircular.get(i), Boolean.FALSE);
        }
        return dictionary;
    }

    private static void markAsChecked(Map<Integer, Boolean> numbersToCheck, int[] rotations) {
        for (Map.Entry<Integer, Boolean> element : numbersToCheck.entrySet()) {
            for(int number : rotations){
                if(element.getKey() == number){
                    element.setValue(Boolean.TRUE);
                }
            }
            
        }
    }

    private static boolean isAllDigitsEquals(Integer key) {
        String stringNumber = Integer.toString(key);
        int[] newGuess = new int[stringNumber.length()];
        for (int i = 0; i < stringNumber.length(); i++) {
            newGuess[i] = stringNumber.charAt(i) - '0';
        }
        
        for(int i=1; i<newGuess.length; i++){
            if(newGuess[0] != newGuess[i]){
                return false;
            }
        }
        return true;
    }
}
