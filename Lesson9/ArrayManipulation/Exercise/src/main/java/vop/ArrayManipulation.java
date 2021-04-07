package vop;

import java.util.Arrays;
import java.util.Random;

/**
 * OOP test eksamen f09 opg 1
 * @author erso
 */
public class ArrayManipulation {

    public int[] evenOdd(int[] array) {
        evenOdd(array, 0);
        int splitIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                splitIndex = i;
                break;
            }
        }
        sort(array, splitIndex);
        return array;
    }

    public void evenOdd(int[] array, int n) {
        int switchIndex = 0;
        int switchValue = 0;
        if (array[n] % 2 != 0) {
            for (int i = 0; i < n; i++) {
                if (array[i] % 2 == 0) {
                    switchIndex = i;
                    switchValue = array[i];
                    break;
                }
            }
            if (switchValue != 0) {
                array[switchIndex] = array[n];
                array[n] = switchValue;
            }
            if (n + 1 != array.length) {
                evenOdd(array, n + 1);
            }
        } else {
            if (n + 1 != array.length) {
                evenOdd(array, n + 1);
            }
        }
    }

    private void sort(int[] array, int splitIndex){
        for (int i = 0; i < splitIndex - 1; i++) {
            int currentMin = array[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < splitIndex; j++) {
                if (currentMin > array[j]) {
                    currentMin = array[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                array[currentMinIndex] = array[i];
                array[i] = currentMin;
            }
        }

        for (int i = splitIndex; i < array.length - 1; i++) {
            int currentMax = array[i];
            int currentMaxIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (currentMax < array[j]) {
                    currentMax = array[j];
                    currentMaxIndex = j;
                }
            }

            if (currentMaxIndex != i) {
                array[currentMaxIndex] = array[i];
                array[i] = currentMax;
            }
        }
    }

    public static void main(String [] arg){
        Random generator = new Random(222);
        int[] array = new int [10];
        for(int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(100);
        }
        System.out.println("Input:  "+Arrays.toString(array));

        ArrayManipulation arrMani = new ArrayManipulation();
    
        int[] result = arrMani.evenOdd(array);
        System.out.println("Output: " +Arrays.toString(result));
    }
}

    
