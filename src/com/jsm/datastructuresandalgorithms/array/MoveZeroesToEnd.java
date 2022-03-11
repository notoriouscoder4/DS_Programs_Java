package com.jsm.datastructuresandalgorithms.array;

public class MoveZeroesToEnd {

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void moveZeroes(int[] arr) {
        int j = 0; // focus on zeroth elements
        for (int i = 0; i < arr.length; i++) { // i will focus non-zero elements
            if (arr[i] != 0 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (arr[j] != 0) {
                j++;
            }
        }
    }

    public static void arrayDemo() {
        int[] arr = {8, 1, 0, 2, 1, 0, 3};
        printArray(arr);
        moveZeroes(arr);
        printArray(arr);
    }

    public static void main(String[] args) {
        arrayDemo();
    }
}
