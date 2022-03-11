package com.jsm.datastructuresandalgorithms.array;

public class MinArray {

    private static int minArray(int[] arr) {
        // edge cases
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }

        int min = arr[0]; // min will hold the minimum of array
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 3, 15, 1, 2};
        System.out.println(minArray(arr));
    }
}
