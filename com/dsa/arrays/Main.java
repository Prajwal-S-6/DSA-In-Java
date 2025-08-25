package com.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dsa.arrays.ArrayProblems.*;

public class Main {

    public static void main(String[] args) {
         int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
         int[] arr1 = {5,4,-1,7,8};
         maximumSumSubArray(arr1).stream().forEach(System.out::println);

        int[] arr2 = {-1, 1, 1};
        System.out.println(getLongestSubarray(arr2, 10));

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(6,7, 4, 2, 5, 3));
        findLeaders(list).forEach(System.out::println);


        int[] arr3 = {2,1,3,4};
        System.out.println(check(arr3));


        String[] s = {"flower","flower","flower","flower"};
        longestCommonPrefix(s);

        int[] height = {1,8,6,2,5,4,8,3,7};
        maxArea(height);

    }
}
