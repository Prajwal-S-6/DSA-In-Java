package com.dsa.sorting.algorithms;

import java.util.Arrays;

import static com.dsa.sorting.algorithms.Sorting.*;

public class Main {

    public static void main(String[] args) {
        int[] arr = {13,46,24,52,20,20,9};  //{5,4,3,2,1};
        // bubbleSort(arr);
        // insertionSort(arr);
        // selectionSort(arr);
        mergeSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
