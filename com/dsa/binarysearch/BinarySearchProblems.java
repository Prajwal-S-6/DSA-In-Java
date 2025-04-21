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

    // 81. Search in Rotated Sorted Array II  ~~~~~ O(3n) + O(log n)
    public static boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int dip = -1;
        boolean result = false;
        for(int i=0; i < nums.length - 1; i++) {  //O(n) to find rotate point
            if(nums[i+1] < nums[i]) {
                dip = i+1;
                break;
            }
        }
        if(dip != -1) {                     //0(2n) to bring it back to sorted order
            reverse(nums, 0, dip-1);
            reverse(nums, dip, high);
            reverse(nums, low, high);
        }

        while(low <= high) {            //O(log n)  to binary search
            int mid = (low+high)/2;
            if(nums[mid] == target) {
                return true;
            }
            else if(nums[mid] > target) {
                high = mid -1;
            } else {
                low = mid+1;
            }
        }
        return result;
    }
}
