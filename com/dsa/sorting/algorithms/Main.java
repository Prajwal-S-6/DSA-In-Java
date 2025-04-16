package com.dsa.sorting.algorithms;

import java.util.Arrays;

import static com.dsa.sorting.algorithms.Sorting.*;

public class Main {

    public static void main(String[] args) {
        int[] arr = {13,46,24,52,20,20,9,1,2,3};
        // int[] arr = {4,6,2,5,7,9,1,3};
        // int[] arr = {5,4,3,2,1};
        // bubbleSort(arr);
        // insertionSort(arr);
        // selectionSort(arr);
        // mergeSort(arr);
        // recursiveBubbleSort(arr, 0, arr.length - 1);
        // recursiveInsertionSort(arr, 0, 0);
        quickSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
