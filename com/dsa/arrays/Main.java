package com.dsa.arrays;

import static com.dsa.arrays.ArrayProblems.maximumSumSubArray;

public class Main {

    public static void main(String[] args) {
        // int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr = {5,4,-1,7,8};
        maximumSumSubArray(arr).stream().forEach(System.out::println);
    }
}
