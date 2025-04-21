package com.dsa.binarysearch;

import java.util.Arrays;

import static com.dsa.binarysearch.BinarySearchProblems.*;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println(searchInsert(arr, 5));

        int[] arr1 = {3, 4, 4, 7, 8, 10};
        Arrays.stream(getFloorAndCeil(arr, 8)).forEach(System.out::println);

        int[] arr2 = {5,7,7,8,8,10};
        searchRange(arr, 8);

        int[] arr3 = {4,5,6,7,0,1,2};
        search(arr3, 0);
    }
}
