/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primoscirculares;

/**
 *
 * @author vvillegas
 */
public class CircularPrimeCommon {
    
    public static boolean isPrime(int n) {
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
    
    public static boolean isPossibleToBeCircular(int number) {
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
    
    public static boolean isCircularNumber(int number) {
        boolean isCircularNumber = false;
        int[] rotations = getRotations(number);
        for (int n : rotations) {
            if (CircularPrimeCommon.isPrime(n)) {
                isCircularNumber = true;
            } else {
                isCircularNumber = false;
                break;
            }
        }
        return isCircularNumber;
    }
    
    public static int[] getRotations(int number) {
        String stringNumber = String.valueOf(number);
        int totalRotations = stringNumber.length();
        int[] rotations = new int[totalRotations];
        String word = stringNumber;
        for (int i = 0; i < totalRotations; i++) {
            word = word.substring(1, word.length()) + word.charAt(0);
            rotations[i] = Integer.parseInt(word);
        }
        return rotations;
    }
}
