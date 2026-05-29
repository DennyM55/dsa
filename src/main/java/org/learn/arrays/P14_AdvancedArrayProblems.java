package org.learn.arrays;

import java.util.Arrays;

/**
 * 14 - Advanced Array Problems
 * Master advanced algorithms: binary search, rotated arrays, peak element, median, etc.
 * 
 * Study after: Array fundamentals (P13)
 */
public class P14_AdvancedArrayProblems {

    public static void main(String[] args) {
        System.out.println("=== 14 | ADVANCED ARRAY PROBLEMS ===\n");

        // Problem 1: Binary Search
        System.out.println("1. Binary Search:");
        int[] arr1 = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target1 = 7;
        int result1 = binarySearch(arr1, target1);
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Target: " + target1);
        System.out.println("Index: " + (result1 >= 0 ? result1 : "Not found") + "\n");

        // Problem 2: Search in rotated sorted array
        System.out.println("2. Search in Rotated Sorted Array:");
        int[] arr2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 0;
        int result2 = searchInRotatedArray(arr2, target2);
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("Target: " + target2);
        System.out.println("Index: " + (result2 >= 0 ? result2 : "Not found") + "\n");

        // Problem 3: First and last position of element
        System.out.println("3. Find First and Last Position of Element:");
        int[] arr3 = {5, 7, 7, 8, 8, 10};
        int target3 = 8;
        int[] positions = findFirstAndLast(arr3, target3);
        System.out.println("Array: " + Arrays.toString(arr3));
        System.out.println("Target: " + target3);
        System.out.println("Positions: [" + positions[0] + ", " + positions[1] + "]\n");

        // Problem 4: Integer square root
        System.out.println("4. Integer Square Root:");
        int[] nums = {8, 16, 25, 36, 100};
        for (int n : nums) {
            System.out.println("sqrt(" + n + ") = " + mysqrt(n));
        }
        System.out.println();

        // Problem 5: Find peak element
        System.out.println("5. Find Peak Element:");
        int[] arr5 = {1, 2, 3, 1};
        int peak = findPeak(arr5);
        System.out.println("Array: " + Arrays.toString(arr5));
        System.out.println("Peak index: " + peak + ", Value: " + arr5[peak] + "\n");

        // Problem 6: Median of two sorted arrays
        System.out.println("6. Median of Two Sorted Arrays:");
        int[] arr6a = {1, 3};
        int[] arr6b = {2};
        double median = findMedianSortedArrays(arr6a, arr6b);
        System.out.println("Array 1: " + Arrays.toString(arr6a));
        System.out.println("Array 2: " + Arrays.toString(arr6b));
        System.out.println("Median: " + median + "\n");

        // Problem 7: Smallest missing positive
        System.out.println("7. Smallest Missing Positive:");
        int[] arr7 = {3, 4, -1, 1};
        int missing = findMissingPositive(arr7);
        System.out.println("Array: " + Arrays.toString(arr7));
        System.out.println("Smallest missing positive: " + missing + "\n");

        // Problem 8: Find duplicate number
        System.out.println("8. Find Duplicate Number:");
        int[] arr8 = {1, 3, 4, 2, 2};
        int dup = findDuplicate(arr8);
        System.out.println("Array: " + Arrays.toString(arr8));
        System.out.println("Duplicate: " + dup + "\n");

        // Problem 9: Single number (XOR trick)
        System.out.println("9. Single Number (All Appear Twice Except One):");
        int[] arr9 = {2, 2, 1, 1, 4};
        int single = findSingleNumber(arr9);
        System.out.println("Array: " + Arrays.toString(arr9));
        System.out.println("Single number: " + single + "\n");
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    static int searchInRotatedArray(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    static int[] findFirstAndLast(int[] arr, int target) {
        int[] result = {-1, -1};
        result[0] = findFirst(arr, target);
        result[1] = findLast(arr, target);
        return result;
    }

    static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    static int mysqrt(int x) {
        if (x == 0) return 0;
        long left = 1, right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) return (int) mid;
            if (mid * mid < x) left = mid + 1;
            else right = mid - 1;
        }
        return (int) right;
    }

    static int findPeak(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) merged[k++] = arr1[i++];
        while (j < arr2.length) merged[k++] = arr2[j++];
        
        int n = merged.length;
        if (n % 2 == 0) {
            return (merged[n / 2 - 1] + merged[n / 2]) / 2.0;
        } else {
            return merged[n / 2];
        }
    }

    static int findMissingPositive(int[] arr) {
        for (int i = 1; i <= arr.length; i++) {
            boolean found = false;
            for (int num : arr) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) return i;
        }
        return arr.length + 1;
    }

    static int findDuplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) return arr[i];
            }
        }
        return -1;
    }

    static int findSingleNumber(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }
}

