# Two Sum — LeetCode #1

- Category: Hashing
- Languages practiced: Java and Python
- Problem: [Two Sum](https://leetcode.com/problems/two-sum/)
- Session status: Guided practice. I should not mark this problem as independently mastered yet.

## 1. Problem statement

Given an array of integers and a target, return the indices of two different numbers whose sum equals the target.

Example:

```text
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
Reason: nums[0] + nums[1] = 2 + 7 = 9
```

## 2. My original idea: check every pair

Use two nested loops:

1. Pick one number.
2. Compare it with every number after it.
3. Return the two indices when their sum equals the target.

This works because it checks every possible pair. It becomes slow for large arrays because the number of comparisons grows quickly.

- Time: O(n²)
- Extra space: O(1)

## 3. Improved idea: remember seen numbers

Instead of searching the array again, remember numbers already visited.

Think of a HashMap or dictionary as a notebook:

- number = key
- index = value

For each current number:

```text
needed = target - current number
```

If `needed` is already in the notebook, we found the answer. Otherwise, store the current number and its index.

- Time: O(n)
- Extra space: O(n)

## 4. Dry run: [3, 3], target 6

Start with an empty notebook.

1. Index 0, current number 3
   - needed = 6 - 3 = 3
   - 3 is not in the notebook
   - store `3 -> 0`

2. Index 1, current number 3
   - needed = 6 - 3 = 3
   - 3 is already stored at index 0
   - return `[0, 1]`

## 5. Why check before storing?

We must use two different array positions.

If we store the current number first, the lookup might find the same index that we are currently visiting. Checking first ensures that the matching number came from an earlier index.

## 6. Duplicate keys

A HashMap or dictionary stores one value for each key. Storing the same number again replaces its older index.

For Two Sum, checking before storing often finds the answer before replacement matters. If no match is found yet, keeping the newest index is still enough for later numbers.

## 7. Java and Python comparison

Java:

```java
Map<Integer, Integer> seen = new HashMap<>();
seen.put(number, index);
seen.containsKey(needed);
seen.get(needed);
```

Python:

```python
seen = {}
seen[number] = index
needed in seen
seen[needed]
```

Both store the same information: number to index.

## 8. Complexity comparison

| Approach | Time | Extra space |
|---|---:|---:|
| Two nested loops | O(n²) | O(1) |
| HashMap/dictionary | O(n) | O(n) |

The hashing solution uses more memory to avoid repeated searching.

## 9. Common beginner mistakes

- Returning the numbers instead of their indices.
- Using the same index twice.
- Storing before checking.
- Using `current - target` instead of `target - current`.
- Forgetting that duplicate numbers can be the correct pair.
- Returning too early without finding a match.
- Confusing a HashMap key with its stored index value.

## 10. Key lessons

- Start with a simple brute-force idea.
- Look for repeated work that can be remembered.
- A HashMap gives fast lookup by key.
- The complement is `target - current number`.
- Check first, then store.
- Test duplicate values such as `[3, 3]`.

## 11. Revision checklist

Before calling this problem independently learned, I should be able to:

- [ ] Explain the two-loop solution without hints.
- [ ] Explain why its time complexity is O(n²).
- [ ] Write `needed = target - current`.
- [ ] Explain what the map stores.
- [ ] Explain why checking happens before storing.
- [ ] Handle duplicate values correctly.
- [ ] Write the Java solution from memory.
- [ ] Write the Python solution from memory.
- [ ] State O(n) time and O(n) extra space.
- [ ] Solve it again independently in a later revision session.
