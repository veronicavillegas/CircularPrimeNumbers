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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ArrayList<Integer> primeNumbers = getPrimeNumbersBefore(1000000);
        /*Hilos*/
        FinderThread threadFinder_2 = new FinderThread("buscador_2", 2)
        thread.start();
        
        //removeNumbersWith(0, primeNumbers.subList(0, 10));
        //removeNumbersWith(0, primeNumbers.subList(10, 20));
        
        //ArrayList<Integer> possibleCircularNumbers = primeNumbers;
        /*Hilos*/
        //getCircularNumbers(possibleCircularNumbers);
        getRotations(1234567);
    }
    
    
    /**
     Metodo Criba de Eratóstenes: http://es.wikipedia.org/wiki/Criba_de_Erat%C3%B3stenes
     */   
    public static ArrayList<Integer> getPrimeNumbersBefore(int number) 
    {
        //Marco todos los números de la serie como primos
        boolean[] isPrimeNumber = new boolean[number + 1];
        for (int i = 2; i <= number; i++) 
        {
            isPrimeNumber[i] = true;
        }
        //Tomo el primer numero como primo. 
        //Si elevado al cuadrado es mayor o igual al numero dado, el algoritmo termina,
        //sino, evaluo el arreglo buscando los múltiplos
        for (int i = 2; i*i <= number; i++)
        {
            for (int j = i; i*j <= number; j++) 
            {
                isPrimeNumber[i*j] = false;
            }
        }
        ArrayList<Integer> primos = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (isPrimeNumber[i])
            {
                primos.add(i);
            }
        }
        return primos;
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

    private static void getCircularNumbers(ArrayList<Integer> possibleCircularNumbers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static int[] getRotations(int number){
        String stringNumber = String.valueOf(number);
        int totalRotations = stringNumber.length();
        int[] rotations = new int[totalRotations];
        String word = stringNumber;
        for(int i = 0; i < totalRotations; i++){
            word = word.substring(1, word.length()) + word.charAt(0);
            rotations[i] = Integer.parseInt(word);
        }
        return rotations;
    }
}
