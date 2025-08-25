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


    // ----------------------------------------------------------------------------------------------------------------------------------------------
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k > nums.length) {
            return;
        }
        k = nums.length - k;
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    public static void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean check(int[] nums) {
        int dip = -1;
        for(int i=0; i < nums.length - 1; i++) {
            if(nums[i+1] < nums[i]) {
                dip = i;
                break;
            }
        }

        if(dip != -1) {
            reverse(nums, 0, dip);
            reverse(nums, dip+1, nums.length - 1);
            reverse(nums, 0, nums.length - 1);
            return arraySortedOrNot(nums);
        } else {
            return true;
        }

    }

    private static boolean arraySortedOrNot(int[] arr) {
        for(int i=0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

        String prefix = "";
        String intialVal = strs[0];
        int i = 1;
        if(strs.length == 1) {
            return intialVal;
        }
}
