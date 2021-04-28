package vop;

import java.util.Arrays;
import java.util.Random;

/**
 * OOP test eksamen f09 opg 1
 *
 * @author erso
 */
public class ArrayManipulation {

    public int[] evenOdd(int[] array) {
        int odd = 0;
        int even = array.length - 1;
        int[] temp = new int[array.length];

        for (int j : array) {
            if (isEven(j)) {
                temp[even] = j;
                even--;
            } else {
                temp[odd] = j;
                odd++;
            }
        }
        System.out.println("odd: " + odd + " even: " + even);
        System.out.println("EvenOdd: " +
                Arrays.toString(temp));

        sort(temp, odd);
        return temp;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    private void sort(int[] array, int splitIndex) {
        Arrays.sort(array, 0, splitIndex);

        negate(array, splitIndex);
        Arrays.sort(array, splitIndex, array.length);
        negate(array, splitIndex);
    }

    private void negate(int[] array, int splitIndex) {
        for (int i = splitIndex; i < array.length; i++) {
            array[i] = -array[i];
        }
    }

    public static void main(String[] arg) {
        Random generator = new Random(222);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(100);
        }
        System.out.println("Input:  " + Arrays.toString(array));

        ArrayManipulation arrMani = new ArrayManipulation();

        int[] result = arrMani.evenOdd(array);
        System.out.println("Output: " + Arrays.toString(result));

    }
}

    
