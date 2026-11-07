import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }

            seen.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two-sum solution exists");
    }

    public static void main(String[] args) {
        runExample(new int[]{2, 7, 11, 15}, 9);
        runExample(new int[]{3, 2, 4}, 6);
        runExample(new int[]{3, 3}, 6);
    }

    private static void runExample(int[] nums, int target) {
        System.out.printf(
                "nums=%s, target=%d -> %s%n",
                Arrays.toString(nums),
                target,
                Arrays.toString(twoSum(nums, target))
        );
    }
}
