
package _02_hashing._0001_two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class Solution2WithStreams {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))
        );
    }

    private static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> seen = new HashMap<>();

        return IntStream.range(0, nums.length)
                .mapToObj(index -> {

                    int needed = target - nums[index];

                    if (seen.containsKey(needed)) {
                        return new int[]{seen.get(needed), index};
                    }

                    seen.put(nums[index], index);
                    return (int[]) null;
                })
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("No pair found")
                );
    }
}
