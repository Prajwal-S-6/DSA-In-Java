package com.dsa.binarysearch;

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
}
