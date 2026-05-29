package org.learn.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 13 - Array Coding Problems  
 * Master array fundamentals: second largest, max subarray, missing number, two sum, duplicates
 * 
 * Study after: Stream fundamentals (P01-P05)
 */
public class P13_ArrayCodingProblems {

    public static void main(String[] args) {
        System.out.println("=== 13 | ARRAY CODING PROBLEMS ===\n");

        // Problem 1: Find second largest number
        System.out.println("1. Find Second Largest Number:");
        int[] arr1 = {10, 20, 50, 40, 30};
        Integer secondLargest = Arrays.stream(arr1)
                .boxed()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1);
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Second largest: " + secondLargest + "\n");

        // Problem 2: Largest element in array
        System.out.println("2. Largest Element in Array:");
        int[] arr2 = {15, 28, 5, 42, 19};
        int largest = Arrays.stream(arr2).max().orElse(-1);
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("Largest: " + largest + "\n");

        // Problem 3: Maximum subarray sum (Kadane's)
        System.out.println("3. Maximum Subarray Sum:");
        int[] arr3 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubarraySum(arr3);
        System.out.println("Array: " + Arrays.toString(arr3));
        System.out.println("Maximum subarray sum: " + maxSum + "\n");

        // Problem 4: Missing number from 1-9
        System.out.println("4. Missing Number from 1 to 9:");
        int[] arr4 = {1, 2, 3, 5, 6, 7, 8, 9};
        int missing = findMissingNumber(arr4);
        System.out.println("Array: " + Arrays.toString(arr4));
        System.out.println("Missing number: " + missing + "\n");

        // Problem 5: Remove duplicates from sorted array
        System.out.println("5. Remove Duplicates from Sorted Array:");
        int[] arr5 = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        int[] noDups = Arrays.stream(arr5).distinct().toArray();
        System.out.println("Original: " + Arrays.toString(arr5));
        System.out.println("Without duplicates: " + Arrays.toString(noDups) + "\n");

        // Problem 6: Find pair with given sum (Two Sum)
        System.out.println("6. Find Pair with Given Sum:");
        int[] arr6 = {2, 7, 11, 15};
        int target = 9;
        findTwoSum(arr6, target);
        System.out.println();

        // Problem 7: Product of array except self
        System.out.println("7. Product of Array Except Self:");
        int[] arr7 = {1, 2, 3, 4};
        int[] product = productExceptSelf(arr7);
        System.out.println("Array: " + Arrays.toString(arr7));
        System.out.println("Product of others: " + Arrays.toString(product) + "\n");

        // Problem 8: Join two arrays and remove duplicates
        System.out.println("8. Join Two Arrays and Remove Duplicates:");
        int[] arr8a = {1, 2, 3, 4, 5};
        int[] arr8b = {4, 5, 6, 7, 8};
        int[] joined = mergeDeduplicate(arr8a, arr8b);
        System.out.println("Array 1: " + Arrays.toString(arr8a));
        System.out.println("Array 2: " + Arrays.toString(arr8b));
        System.out.println("Merged (no dups): " + Arrays.toString(joined) + "\n");

        // Problem 9: Array sum and average
        System.out.println("9. Array Sum and Average:");
        int[] arr9 = {10, 20, 30, 40, 50};
        int sum = Arrays.stream(arr9).sum();
        double avg = Arrays.stream(arr9).average().orElse(0);
        System.out.println("Array: " + Arrays.toString(arr9));
        System.out.println("Sum: " + sum + ", Average: " + avg + "\n");

        // Problem 10: Rotate array by k positions
        System.out.println("10. Rotate Array by K Positions:");
        int[] arr10 = {1, 2, 3, 4, 5};
        int k = 2;
        rotateArray(arr10, k);
        System.out.println("Original: [1, 2, 3, 4, 5]");
        System.out.println("Rotated by " + k + ": " + Arrays.toString(arr10) + "\n");
    }

    static int maxSubarraySum(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        long expectedSum = (n * (n + 1)) / 2;
        long actualSum = Arrays.stream(arr).sum();
        return (int) (expectedSum - actualSum);
    }

    static void findTwoSum(int[] arr, int target) {
        System.out.println("Array: " + Arrays.toString(arr) + ", Target: " + target);
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                System.out.println("Pair found: [" + complement + ", " + num + "]");
                return;
            }
            seen.add(num);
        }
        System.out.println("No pair found");
    }

    static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * arr[i - 1];
        }
        
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * arr[i + 1];
        }
        
        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    static int[] mergeDeduplicate(int[] arr1, int[] arr2) {
        return Arrays.stream(IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .distinct()
                .toArray())
                .sorted()
                .toArray();
    }

    static void rotateArray(int[] arr, int k) {
        k %= arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

