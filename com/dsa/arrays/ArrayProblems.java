package com.dsa.arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

    public static int getLongestSubarray(int []nums, int k) {
        int longestSubArray = 0;
        int sum = nums[0];
        int i = 0;
        int j = 0;
        while(j < nums.length) {
            while(sum > k && i <= j) {
                sum -= nums[i];
                i++;
            }
            if(sum == k) {
                longestSubArray = Math.max(longestSubArray, j-i+1);
            }
            j++;
            if(j < nums.length) {
               sum +=nums[j];
            }

        }
        return longestSubArray;
    }

    public static ArrayList<Integer> findLeaders(ArrayList<Integer> elements) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = elements.size();
        int max = elements.get(n - 1);
        list.add(max);
        for(int i = n - 1; i >= 0; i--) {
            if(elements.get(i) > max) {
                list.add(elements.get(i));
                max = elements.get(i);
            }
        }
        // Collections.reverse(list);
        return list;
    }
}
