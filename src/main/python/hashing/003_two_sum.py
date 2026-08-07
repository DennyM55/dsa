"""
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
remember previously seen numbers using a dictionary.
"""


def two_sum(nums, target):

    seen = {}

    for i in range(len(nums)):

        needed = target - nums[i]

        if needed in seen:
            return [seen[needed], i]

        seen[nums[i]] = i

    return []


if __name__ == "__main__":

    nums = [2, 7, 11, 15]
    target = 9

    result = two_sum(nums, target)

    print(result)