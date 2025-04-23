package com.dsa.binarysearch;

import java.util.ArrayList;
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


    //
    public static int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] - (mid + 1) < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high+k+1;   //or low+k because low = (high+1)

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
            if(Math.pow(mid, N) == M) {
                return mid;
            } else if(Math.pow(mid, N) > M) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

}
