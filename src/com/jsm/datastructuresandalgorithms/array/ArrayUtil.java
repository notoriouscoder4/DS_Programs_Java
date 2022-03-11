package com.jsm.datastructuresandalgorithms.array;

public class ArrayUtil {

    private static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] resizeArray(int[] arr, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    private static int[] removeEven(int[] arr) {
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                oddCount++;
            }
        }

        int[] resultOdd = new int[oddCount];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                resultOdd[idx] = arr[i];
                idx++;
            }
        }
        return resultOdd;
    }

    private static int[] removeOdd(int[] arr) {
        int evenCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            }
        }

        int[] resultEven = new int[evenCount];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                resultEven[idx] = arr[i];
                idx++;
            }
        }
        return resultEven;
    }


    public static void main(String[] args) {
        /*int[] arr = {3, 2, 4, 7, 10, 6, 5};
        printArray(arr);
        int[] resultOdd = removeEven(arr);
        printArray(resultOdd);

        int[] resultEven = removeOdd(arr);
        printArray(resultEven);*/

        int[] original = new int[]{5, 1, 2, 9, 10};
        System.out.println("The size of original array - " + original.length);
        original = resizeArray(original, original.length * 2);
        System.out.println("The size of original array after resize - " + original.length);
    }
}
