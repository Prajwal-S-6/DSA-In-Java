package com.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayProblems {

    public static List<Integer> maximumSumSubArray(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int maxSum =  Integer.MIN_VALUE;
        int sum = 0;
        int subArrayStart = 0;
        int subArrayEnd = 0;
        for(int i=0; i < arr.length; i++) {
            sum += arr[i];

            if(sum > maxSum) {
                maxSum = sum;
                subArrayEnd = i;
            }

            if(sum < 0) {
                sum = 0;
                subArrayStart = i+1;
            }
        }

        for(int i=subArrayStart; i <= subArrayEnd; i++) {
            list.add(arr[i]);
        }

        return list;
    }
}
