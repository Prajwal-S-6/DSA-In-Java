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


    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;
        while(low < high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }


    public static int[] getFloorAndCeil(int[] nums, int x) {
        int[] result = {-1, -1};

        int fLow = 0;
        int fHigh = nums.length - 1;
        while (fLow <= fHigh) {
            int fMid = (fLow + fHigh) / 2;
            if (nums[fMid] <= x) {
                result[0] = nums[fMid];
                fLow = fMid + 1;
            } else {
                fHigh = fMid - 1;
            }
        }

        int cLow = 0;
        int cHigh = nums.length - 1;
        while (cLow <= cHigh) {
            int cMid = (cLow + cHigh) / 2;
            if (nums[cMid] >= x) {
                result[1] = nums[cMid];
                cHigh = cMid - 1;
            } else {
                cLow = cMid + 1;
            }
        }

        return result;
    }
}
