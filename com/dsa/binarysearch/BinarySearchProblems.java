package com.dsa.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.dsa.arrays.ArrayProblems.reverse;

public class BinarySearchProblems {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) {
                int idx = mid;
                while(idx > low && nums[idx - 1] == target) {
                    idx--;
                }
                result[0] = idx;

                idx = mid;
                while(idx < high && nums[idx + 1] == target) {
                    idx++;
                }
                result[1] = idx;
                return result;
            } else if(nums[mid] > target) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return result;
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

    // 81. Search in Rotated Sorted Array II with duplicates  ~~~~~ O(3n) + O(log n)
    public static boolean search2(int[] nums, int target) {

        // solution1
//        int low = 0;
//        int high = nums.length - 1;
//        int rotatePoint = -1;
//        boolean result = false;
//        for(int i=0; i < nums.length - 1; i++) {  //O(n) to find rotate point
//            if(nums[i+1] < nums[i]) {
//                rotatePoint = i+1;
//                break;
//            }
//        }
//        if(rotatePoint != -1) {                     //0(2n) to bring it back to sorted order
//            reverse(nums, 0, rotatePoint-1);
//            reverse(nums, rotatePoint, high);
//            reverse(nums, low, high);
//        }
//
//        while(low <= high) {            //O(log n)  to binary search
//            int mid = (low+high)/2;
//            if(nums[mid] == target) {
//                return true;
//            }
//            else if(nums[mid] > target) {
//                high = mid -1;
//            } else {
//                low = mid+1;
//            }
//        }
//        return result;


        // solution2: if(nums[low] == nums[mid] && nums[mid]== nums[high]) then increment low and decrement high
        // First by find the sorted part of the array:
        // if left part is sorted then check if(arr[low] <=target <=arr[mid])
        // if right part is sorted then check if(arr[mid] <=target <=arr[high])
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[low] == nums[mid] && nums[mid]== nums[high]) {
                low++;
                high--;
                continue;
            }
            if(nums[mid] >= nums[low]) {
                if(nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid +1;
                }
            } else {
                if(nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }


    //33. Search in Rotated Sorted Array  ~~~~~ O(3n) + O(log n)
    public static int search1(int[] nums, int target) {
        // solution 1
//        int low = 0;
//        int high = nums.length - 1;
//        int rotatePoint = -1;
//        int result = -1;
//        for(int i=0; i < nums.length - 1; i++) {   //O(n) to find rotate point
//            if(nums[i+1] < nums[i]) {
//                rotatePoint = i+1;
//                break;
//            }
//        }
//        if(rotatePoint != -1) {                         //0(2n) to bring it back to sorted order
//            reverse(nums, 0, rotatePoint-1);
//            reverse(nums, rotatePoint, high);
//            reverse(nums, low, high);
//            rotatePoint = nums.length - rotatePoint;
//        }
//
//        while(low <= high) {                //O(log n)  to binary search
//            int mid = (low+high)/2;
//            if(nums[mid] == target) {
//                result = mid;
//                break;
//            }
//            else if(nums[mid] > target) {
//                high = mid -1;
//            } else {
//                low = mid+1;
//            }
//        }
//
//        if(rotatePoint != -1 && result != -1) {
//            return result-rotatePoint < 0 ? result-rotatePoint+nums.length : result-rotatePoint;
//        } else {
//            return result;
//        }


        // solution 2: First by find the sorted part of the array:
            // if left part is sorted then check if(arr[low] <=target <=arr[mid])
            // if right part is sorted then check if(arr[mid] <=target <=arr[high])
        int low = 0;
        int high = nums.length - 1;
        int result = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] >= nums[low]) {
                if(nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid +1;
                }
            } else {
                if(nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return result;
    }


    // 153. Find Minimum in Rotated Sorted Array
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = nums[low];

        while(low<=high) {
            int mid = (low+high)/2;
            // min = Math.min(min, nums[mid]);
            if(nums[low] <= nums[mid]) {
                min = Math.min(min, nums[low]);
                low = mid+1;
            } else {
                min = Math.min(min, nums[mid]);
                high = mid-1;
            }
        }
        return min;
    }

    // 540. Single Element in a Sorted Array
    public static int singleNonDuplicate(int[] nums) {
        // O(n)
        // int result = 0;
        // for(int i=0; i < nums.length; i++) {
        //     result ^= nums[i];
        // }
        // return result;

        if(nums.length == 1) {
            return nums[0];
        }
        else if(nums[0] != nums[1]) {
            return nums[0];
        } else if(nums[nums.length-1] != nums[nums.length-2]) {
            return nums[nums.length-1];
        }
        int low = 1;
        int high = nums.length - 2;
        // intuition is to observe the index of the elements and observe the left half & right half after single element
        while(low<=high) {
            int mid = (low+high)/2;
            if(nums[mid] != nums[mid+1] && nums[mid-1] != nums[mid]) {
                return nums[mid];
            } else if((mid%2 == 0 && nums[mid] == nums[mid-1]) || (mid%2 == 1 && nums[mid] == nums[mid+1])) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }


    // 162. Find Peak Element
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        if(nums[0] > nums[1]) {
            return 0;
        } else if(nums[nums.length - 1] > nums[nums.length-2]) {
            return nums.length-1;
        }
        int low = 1;
        int high = nums.length - 2;

        // intuition is that put a graph on the given elements, if mid comes on the increasing half then peak is on right side; else left side
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return mid;
            } else if(nums[mid] > nums[mid-1]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return -1;
    }

//---------------------------------------------------------------------------------------------------
    public static int findKRotation(int[] nums) {
        int numOfRotations = 0;
        int low = 0;
        int high =  nums.length -1;
        int minValue = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[low] < nums[mid]) {
                if(nums[low] < minValue) {
                    minValue = nums[low];
                    numOfRotations = low;
                }
                low = mid+1;
            } else {
                if(nums[mid] < minValue) {
                    minValue = nums[mid];
                    numOfRotations = mid;
                }
                high = mid-1;
            }
        }
        return numOfRotations;
    }

    //875. Koko Eating Bananas
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);

        while(low <=high) {
            int mid = (low+high)/2;
            if(hoursToFinish(piles, mid, h) <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int hoursToFinish(int[] arr, int rate, int maxHours) {
        int noOfHours = 0;
        for(int i=0; i < arr.length; i++) {
            if(noOfHours > maxHours) {
                return maxHours+1;
            }
            noOfHours += (int) Math.ceil((double) arr[i]/(double) rate);
        }
        return noOfHours;
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for(int i=1; i< arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }


    // 1482. Minimum Number of Days to Make m Bouquets
    public static int minDays(int[] bloomDay, int m, int k) {
        int max = bloomDay[0];
        for(int i=1; i< bloomDay.length; i++) {
            max = Math.max(max, bloomDay[i]);
        }
        int low = 1;
        int high = max;
        while(low <=high) {
            int mid = (low+high)/2;
            if(numOfBoqCreated(bloomDay, mid, m, k) >= m) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low > max ? -1 : low;
    }

    private static int numOfBoqCreated(int nums[], int days, int m, int k) {
        int noOfBoq = 0;
        int consecutiveFlowers = 0;
        for(int i=0; i < nums.length; i++) {
            if(nums[i] <= days) {
                consecutiveFlowers++;
                if(consecutiveFlowers == k) {
                    consecutiveFlowers = 0;
                    noOfBoq++;
                }
            } else {
                consecutiveFlowers = 0;
            }
        }
        return noOfBoq;
    }


    // 1283. Find the Smallest Divisor Given a Threshold
    public static int smallestDivisor(int[] nums, int threshold) {
        int max = nums[0];
        for(int i=1; i< nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int low = 1;
        int high = max;

        while(low <=high) {
            int mid = (low+high)/2;
            if(smallestDivisorSum(nums, mid, threshold) <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int smallestDivisorSum(int[] arr, int divisor, int threshold) {
        int sum = 0;
        for(int i=0; i < arr.length; i++) {
            if(sum > threshold) {
                return threshold+1;
            }
            sum += (int) Math.ceil((double) arr[i]/(double) divisor);

        }
        return sum;
    }


    //1539. Kth Missing Positive Number
    public static int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while(low <=high) {
            int mid = (low+high)/2;
            if(arr[mid] - (mid+1) > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low+k;


    }


    // 1011. Capacity To Ship Packages Within D Days
    public static int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for(int value: weights) {
            sum+=value;
        }
        int low = 1;
        int high = sum;

        while(low <= high) {
            int mid = (low+high)/2;
            if(totalDaysToShip(weights, mid, days) <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static int totalDaysToShip(int[] arr, int capacity, int days) {
        int totaldays = 1;
        int weight = 0;
        for(int value: arr) {
            if(value > capacity) {
                return days+1;
            }
            weight+=value;
            if(weight > capacity) {
                totaldays++;
                weight = value;
            }
        }
        return totaldays;
    }


    public static long floorSqrt(long n) {
        long low = 1;
        long high = n;
        while(low <= high) {
            long mid = (low+high)/2;
            if(mid*mid == n) {
                return mid;
            }
            else if(mid*mid > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static int NthRoot(int N, int M) {
        int low = 1;
        int high = M;

        while(low <= high) {
            int mid = (low+high)/2;
            if(power(mid, N) == M) {
                return mid;
            } else if(power(mid, N) > M) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int power(int num, int n) {
        int value = 1;
        for(int i=1; i <= n; i++) {
            value*=num;
        }
        return value;
    }



    // 410. Split Array Largest Sum
    public static int splitArray(int[] nums, int k) {
        int max = nums[0];
        for(int i =1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        if(k== nums.length) {
            return max;
        }
        int sum = 0;
        for(int i =0; i < nums.length; i++) {
            sum+=nums[i];
        }

        int low = 0;
        int high = sum;
        while(low <= high) {
            int mid = (low+high)/2;
            if(numOfSubArraysRequired(nums, mid, k) <= k) {
                high = mid-1;
            } else {
                low =  mid+1;
            }
        }
        return low;
    }

    private static int numOfSubArraysRequired(int[] nums, int maxSum, int maxSubArray) {
        int sum = 0;
        int numOfSubArray = 1;
        for(int i=0; i < nums.length; i++) {
            if(sum > maxSum) {
                return maxSubArray + 1;
            }
            if(sum+nums[i] > maxSum) {
                numOfSubArray++;
                sum=nums[i];
            } else {
                sum+=nums[i];
            }
        }
        return numOfSubArray;
    }

    //4. Median of Two Sorted Arrays
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int left = (n1+n2+1)/2;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = n1;

        while(low <= high) {
            int mid1 = (low+high)/2;
            int mid2 = left - mid1;

            int l1 = mid1 > 0? nums1[mid1-1] : Integer.MIN_VALUE;
            int l2 = mid2 > 0 ? nums2[mid2-1]: Integer.MIN_VALUE;
            int r1 = mid1 < n1 ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n2 ? nums2[mid2]: Integer.MAX_VALUE;
            if(l1 <= r2 && l2 <= r1) {
                if(n/2 == 0) {
                    return ((double)Math.max(l1, l2) + (double)Math.min(r1, r2))/2;
                } else {
                    return (double) Math.max(l1, l2);
                }

            }
            if(l2 > r1) {
                low = mid1+1;
            } else if(l1 > r2) {
                high = mid1-1;
            }
        }
        return 0;
    }

    //---------------------------------------------------------------------------------------------
    public static int aggressiveCows(int[] arr, int noOfCows) {
        Arrays.sort(arr);
        int max = 0;
        for(int i=0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int min = 0;
        for(int i=0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        int low = 1;
        int high = max-min;

        while(low <= high) {
            int mid = (low+high)/2;
            if(numOfCowsPlaced(arr, mid) >= noOfCows) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high;
    }

    private static int numOfCowsPlaced(int[] arr, int minDistance) {
        int numOfCows = 1;
        int i=0;
        int j = 1;
        while(j < arr.length && i < arr.length) {
            if(arr[j] - arr[i] >= minDistance) {
                numOfCows++;
                i = j;
                j++;
            } else {
                j++;
            }
        }
        return numOfCows;
    }


    //------------------------------------------------------------------------------------------
    public static int allocateMinPages(int[] arr, int numOfStudents) {
        int max = 0;
        for(int i=0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int sum = 0;
        for(int i=0; i < arr.length; i++) {
            sum += arr[i];
        }

        int low = max;
        int high = sum;

        while(low <=high) {
            int mid = (low+high)/2;
            if(numOfStudentsNeeded(arr, mid) > numOfStudents) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }

    private static int numOfStudentsNeeded(int[] arr, int maxPages) {
        int sum = 0;
        int numOfStudents = 1;
        for(int i=0; i < arr.length; i++) {
            if(sum+arr[i] > maxPages) {
                numOfStudents++;
                sum = arr[i];
            } else {
                sum+=arr[i];
            }
        }
        return numOfStudents;
    }

    public static double maxDistanceBetweenGasStations(int[] arr, int newStations) {
        int max = 0;
        for(int i=0; i < arr.length - 1; i++) {
            max = Math.max((arr[i+1] - arr[i]), max);
        }
        double low = 0;
        double high = max;

        while(low <=high) {
            double mid = (low+high)/2;
            if(numOfStationsPossible(arr, mid, newStations) == (newStations+arr.length)) {
                return mid;
            }
            else if(numOfStationsPossible(arr, mid, newStations) > (newStations+arr.length)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static double numOfStationsPossible(int[] arr, double distance, int newStations) {
        int max = 0;
        for(int i=0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        double sum = arr[0];
        int numOfStations = 1;
        double maxDistance = 0;
        for(int i=1; i < arr.length; i++) {
            if(numOfStations <= newStations) {
                maxDistance = Math.max(sum, sum+distance);
                sum+=distance;
                numOfStations++;
            }
            else {
                maxDistance = Math.max(arr[i+1], arr[i]);
            }
        }

        return maxDistance;
    }


    // 74. Search a 2D Matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        int low1 = 0;
        int high1 = matrix.length - 1;
        int low2 = 0;
        int high2 = matrix[0].length - 1;
        while(low1<=high1 && low2 <=high2) {
            int mid1 = (low1+high1)/2;
            int mid2 = (low2+high2)/2;
            if(matrix[mid1][mid2] == target) {
                return true;
            } else if(matrix[mid1][mid2] > target) {
                if(mid1 != 0 && target <= matrix[mid1-1][matrix[0].length - 1]) {
                    high1 = mid1 - 1;
                } else {
                    high2 = mid2 - 1;
                }

            } else {
                if(mid1 < matrix.length - 1 && target >= matrix[mid1+1][0]) {
                    low1 = mid1 + 1;
                } else {
                    low2 = mid2 + 1;
                }

            }
        }
        return false;
    }

}
