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
public class PrimosCirculares {

    private static boolean[] isPrimeNumber;
    private static ArrayList<Integer> possiblePrimeCircular = new ArrayList<>();

    public static synchronized void addPossiblePrimeCircular(ArrayList<Integer> numbers) {
        possiblePrimeCircular.addAll(numbers);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        GetPossibleCircularPrimes();
    }

    private static void GetPossibleCircularPrimes() throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<Thread>();
        int j = 0;
        for (int i = 0; i <= 20; i++) {
            Runnable task = new CircularNumberFinderRunnable(j, j += 50000);
            Thread worker = new Thread(task);
            worker.setName("Task_" + i);
            worker.start();
            threads.add(worker);
        }
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

    /**
     * Metodo Criba de Eratóstenes:
     * http://es.wikipedia.org/wiki/Criba_de_Erat%C3%B3stenes
     */
    public static ArrayList<Integer> getPossibleCircularPrimeNumbersUnder(int number) {
        //Marco todos los números de la serie como primos
        isPrimeNumber = new boolean[number + 1];
        for (int i = 2; i <= number; i++) {
            isPrimeNumber[i] = true;
        }
        //Tomo el primer numero como primo. 
        //Si elevado al cuadrado es mayor o igual al numero dado, el algoritmo termina,
        //sino, evaluo el arreglo buscando los múltiplos
        for (int i = 2; i * i <= number; i++) {
            for (int j = i; i * j <= number; j++) {
                isPrimeNumber[i * j] = false;
            }
        }
        ArrayList<Integer> primos = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (isPrimeNumber[i]) {
                primos.add(i);
            }
        }
        return primos;
    }

    private static ArrayList<Integer> getCircularNumbers(ArrayList<Integer> possibleCircularPrimeNumbers) {
        ArrayList<Integer> circularPrimeNumbers = new ArrayList<>();

        for (Integer number : possibleCircularPrimeNumbers) {
            boolean isCircularNumber = false;

            int[] rotations = getRotations(number);
            for (int n : rotations) {
                if (isPrimeNumber[n]) {
                    isCircularNumber = true;
                } else {
                    isCircularNumber = false;
                    break;
                }
            }
            if (isCircularNumber) {
                for (int n : rotations) {
                    circularPrimeNumbers.add(n);
                }
            }
        }
        return circularPrimeNumbers;
    }

    private static int[] getRotations(int number) {
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
