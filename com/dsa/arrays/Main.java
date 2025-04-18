package com.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dsa.arrays.ArrayProblems.*;

public class Main {

    public static void main(String[] args) {
        // int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
        // int[] arr = {5,4,-1,7,8};
        // maximumSumSubArray(arr).stream().forEach(System.out::println);

//        int[] arr = {-1, 1, 1};
//        System.out.println(getLongestSubarray(arr, 10));

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(6,7, 4, 2, 5, 3));
        findLeaders(list).forEach(System.out::println);
    }
}
