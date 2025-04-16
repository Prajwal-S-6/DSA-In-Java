package com.dsa.sorting.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Sorting {

    // worst case, average case: O(n^2)
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

    public static void recursiveBubbleSort(int[] arr, int start, int end) {
        if(start == end) {
            return;
        }
        int n = arr.length;
        for(int i = start; i < end; i++) {
            if(arr[i+1] < arr[i]) {
                swap(arr, i, i+1);
            }
        }
        recursiveBubbleSort(arr, 0, end-1);
    }


    public static void recursiveInsertionSort(int[] arr, int start, int end) {
        int n = arr.length;
        if(end >= n) {
            return;
        }
        int j = end;
        while(j >=1 && arr[j] < arr[j-1]) {
            swap(arr, j, j-1);
            j--;
        }
        recursiveInsertionSort(arr, start, end+1);
    }

    // worst case, average case: O(n^2)
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

    // worst case, average case, best case: O(n^2)
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

    // worst case, average case, best case: O(nlogn), O(n)
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

    // worst case, average case, best case: O(nlogn), O(1)(excluding recursive stack space)
    public static void quickSort(int[] arr) {
        int n = arr.length;
        recursiveQuickSort(arr, 0, n-1);
    }

    private static void recursiveQuickSort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }
        int pivot = arr[high];
        int i = low;
        int j = high;
        while(i < j) {
            if(arr[i] > pivot) {           //interchange this for sorting in descending order
                if(arr[j] < pivot) {       //interchange this for sorting in descending order
                    swap(arr, i, j);
                } else {
                    j--;
                }
            } else{
                i++;
            }
        }
        swap(arr, i, high);

        recursiveQuickSort(arr, low, i-1);
        recursiveQuickSort(arr, i+1, high);


    }

}
