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
    private ArrayList<Integer> numbersList;
    private ArrayList<Integer> possibleCircularNumbers;

    public CircularNumberFinderRunnable(ArrayList<Integer> numberList) {
        this.numbersList = numberList;
    }
    
    @Override
    public void run() {
        numbersList = new ArrayList<>();
        for(Integer number : numbersList){
            if(isPossibleToBeCircular(number)){
                numbersList.add(number);
            }
        }
    }
    
    public ArrayList<Integer> getPossibleCircularNumbers() {
        return possibleCircularNumbers;
    }
    
    private static boolean isPossibleToBeCircular(int number) {
        String stringNumber = String.valueOf(number);
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
    
}
