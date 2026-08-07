package org.learn.dsa.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Problem:
Given an integer array nums and a target,
return the indices of two numbers whose sum equals target.

Example:
nums = [2, 7, 11, 15]
target = 9
Output = [0, 1]

Pattern:
HashMap / Complement Lookup

Brute Force:
Try every pair using two loops.
Time: O(n²)
Space: O(1)

Optimal Approach:
For each number:
needed = target - current

Check whether "needed" was already seen.
Store:
number -> index

Time Complexity: O(n)
Space Complexity: O(n)

Key Interview Insight:
Instead of searching the whole array for the second number,
remember previously seen numbers using a HashMap.
*/

public class P003_TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int needed = target - nums[i];

            if (map.containsKey(needed)) {
                return new int[]{map.get(needed), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }
}