package hash_table.lc219;

import java.util.HashMap;
import java.util.HashSet;

public class Lc219 {
    /**
     * Using HashSet to maintain the sliding window.
     *
     * Time Complexity: O(N)
     *
     * Space Complexity: O(min(N, K+1))
     *
     * N = Length of input array. K = Input window size.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || k < 0) {
            throw new IllegalArgumentException("Input array is null");
        }
        if (nums.length <= 1 || k == 0) {
            return false;
        }

        HashSet<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }
            if (!window.add(nums[i])) {
                return true;
            }
        }

        return false;
    }

    /**
     * Using HashMap to store the number and its index.
     *
     * Time Complexity: O(N)
     *
     * Space Complexity: O(N)
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 1) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
