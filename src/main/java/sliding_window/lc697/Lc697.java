package sliding_window.lc697;

import java.util.HashMap;
import java.util.Map;

public class Lc697 {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int degree = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            degree = Math.max(degree, map.get(num));
        }
        // slide window
        int res = nums.length;
        map.clear();
        int left = 0;
        int right = 0;
        for (; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.get(nums[right]) >= degree) {
                res = Math.min(right - left + 1, res);
                map.put(nums[left] , map.getOrDefault(nums[left], 0) - 1);
                left++;
            }
        }
        return res;
    }
}
