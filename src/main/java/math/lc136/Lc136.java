package math.lc136;

public class Lc136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int len = nums.length;
        for (int num : nums) ans ^= num;
        return ans;
    }
}
