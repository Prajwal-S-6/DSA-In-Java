package com.dsa.sorting.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Sorting {

    // worst case, average case: 0(n^2)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean isSwapped = false;    //best case O(n)
        for(int i=0; i < n; i++) {
            for(int j = 0; j <= n-2; j++) {
                if(arr[j+1] < arr[j]) {
                    swap(arr, j, j+1);
                    isSwapped = true;
                }
            }
            if(!isSwapped) {
                return;
            }
            // System.out.println("Bubble Sort");
        }
    }

    // worst case, average case: 0(n^2)
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {                //best case O(n)
            int j = i;
            while(j >=1 && arr[j] < arr[j-1]) {
                swap(arr, j , j-1);
                j--;
                // System.out.println("Insertion Sort");
            }
        }
    }

    // worst case, average case, best case: 0(n^2)
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i=0; i < n; i++) {
            int j = i;
            int minIndex = i;
            while(j < n) {
                if(arr[j] <= arr[minIndex]) {
                    minIndex = j;
                }
                j++;
                // System.out.println("Selection Sort");
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void mergeSort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        divideArray(arr, low, high);
    }

    public static void divideArray(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }
        int mid = (low + high)/2;
        divideArray(arr, low, mid);
        divideArray(arr, mid+1, high);
        mergeArray(arr, low, mid, high);
    }

    private static void mergeArray(int[] arr, int low, int mid, int high) {
        List<Integer> resultList = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                resultList.add(arr[left]);
                left++;
            } else {
                resultList.add(arr[right]);
                right++;
            }
        }

        while(left <= mid) {
            resultList.add(arr[left]);
            left++;
        }

        while(right <= high) {
            resultList.add(arr[right]);
            right++;
        }

        for(int i = low; i <= high; i++) {
            arr[i] = resultList.get(i-low);
        }

    }

}
